package Main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import Entite.Joueur;
import Main.Minimap;
import Map.*;
/*
 * Interface Graphique Utilisateur
 */
public class GUI {
	public Jeu jeu;
	Font a40;
    public Joueur joueur;
    public Inventaire inv;
    public int clavier = 0;
    public int entrer = 1;
    public int quitter = 1;
    public int sousetat = 0;
    public boolean coeur, bouclier, epee = false;
	public Minimap minimap;
    
    /*
     * Definir l'interface graphique lie au joueur
     */
	public GUI(Jeu jeu, Joueur joueur) {
		this.jeu = jeu;
		this.joueur = joueur;
		a40 = new Font("Arial", Font.ITALIC, 20);
		this.inv = joueur.inv;
		this.minimap = new Minimap();
	}

	/*
	 * Afficher la carte en entière
	 */
	public void afficherCarte(Graphics2D g) {
		int x = 30;
		int y = 30;
		Salle salle = jeu.salle.getSalle();
		afficherFenetre(x, y, 6*jeu.tailleCaseReelle, 5*jeu.tailleCaseReelle - 35, g);
		g.setFont(a40);
		g.setColor(Color.black);
		g.drawString("Map", x + 2 *jeu.tailleCaseReelle , y + 30);
		
		if (salle instanceof Magasin) {
			g.drawImage(minimap.mapbis1, x+ jeu.tailleCaseReelle - 50, y + 40, 2*jeu.tailleCaseReelle, jeu.tailleCaseReelle, null);
		} else {
			g.drawImage(minimap.map1, x+ jeu.tailleCaseReelle - 50, y + 40, 2*jeu.tailleCaseReelle, jeu.tailleCaseReelle, null);
		}
		
		if (salle instanceof SalleClassique3) {
			g.drawImage(minimap.mapbis3, x+ jeu.tailleCaseReelle - 50, y + 40 + jeu.tailleCaseReelle, 2*jeu.tailleCaseReelle, jeu.tailleCaseReelle, null);
		} else {
			g.drawImage(minimap.map3, x+ jeu.tailleCaseReelle - 50, y + 40 + jeu.tailleCaseReelle, 2*jeu.tailleCaseReelle, jeu.tailleCaseReelle, null);
		}
		
		if (salle instanceof SalleClassiquepassage) {
			g.drawImage(minimap.mapbis2, x+ jeu.tailleCaseReelle - 50, y + 40 + 2 * jeu.tailleCaseReelle, 2*jeu.tailleCaseReelle, jeu.tailleCaseReelle, null);
		} else {
			g.drawImage(minimap.map2, x+ jeu.tailleCaseReelle - 50, y + 40 + 2 * jeu.tailleCaseReelle, 2*jeu.tailleCaseReelle, jeu.tailleCaseReelle, null);
		}
		
		if (salle instanceof SalleClassique) {
			g.drawImage(minimap.mapbis4, x+ jeu.tailleCaseReelle - 50, y + 40 + 3 * jeu.tailleCaseReelle, 2*jeu.tailleCaseReelle, jeu.tailleCaseReelle, null);
		} else {
			g.drawImage(minimap.map4, x+ jeu.tailleCaseReelle - 50, y + 40 + 3 * jeu.tailleCaseReelle, 2*jeu.tailleCaseReelle, jeu.tailleCaseReelle, null);
		}
	
		if (salle instanceof SallePrincesse) {
			g.drawImage(minimap.mapbis5, x+ 3*jeu.tailleCaseReelle - 50, y + 40 + 3 * jeu.tailleCaseReelle, 2*jeu.tailleCaseReelle, jeu.tailleCaseReelle, null);
		} else {
			g.drawImage(minimap.map5, x+ 3*jeu.tailleCaseReelle - 50, y + 40 + 3 * jeu.tailleCaseReelle, 2*jeu.tailleCaseReelle, jeu.tailleCaseReelle, null);
		}
		
		if (salle instanceof Salleboss) {
			g.drawImage(minimap.mapbis6, x+ jeu.tailleCaseReelle - 50, y + 40 + 4* jeu.tailleCaseReelle, 2*jeu.tailleCaseReelle, jeu.tailleCaseReelle, null);
		} else {
			g.drawImage(minimap.map6, x+ jeu.tailleCaseReelle - 50, y + 40 + 4* jeu.tailleCaseReelle, 2*jeu.tailleCaseReelle, jeu.tailleCaseReelle, null);
		}
		
		
		
		
	}
	
	/*
	 * Afficher les elements de l'interface graphique
	 */
	public void afficher(Graphics2D g) {
		g.setFont(a40);
		g.setColor(Color.YELLOW);
		g.drawString("NICOBAHARAYE", joueur.getX()  - 37, joueur.getY());
		if(joueur.vie.getVie()<= 0) {
			joueur.vitesse = 0;
			joueur.deplacement ="bas";
			int largeur = jeu.largeurEcran - (jeu.tailleCaseReelle*5);
			int hauteur = jeu.hauteurEcran -(jeu.tailleCaseReelle*10);
			
			g.setColor(Color.black);
			g.fillRoundRect(280, 320, largeur+20, hauteur+20, 40, 40);
			
			//Definir un contour blanc dans le rectangle
			g.setColor(Color.white);
			g.setStroke(new BasicStroke(5));
			g.drawRoundRect(280, 320, largeur+20, hauteur+20, 25, 25);
			this.entrer = 0;
			if(this.entrer == 0) {
				g.drawString(">", 420, 390+50);
				g.drawString("Quitter la partie", 500, 390+50);
				
				
			}
			g.setColor(Color.white); 
			g.setFont(g.getFont().deriveFont(Font.PLAIN, 80F));
			g.drawString("Game Over", 380, 390);
		    g.dispose();
		}
	}
	
	/*
	 * Definir la fenetre d'un dialogue
	 */
	public void DessinerFenetreDialogue(Graphics2D g, String texte) {
		//Creer un rectangle pour afficher le dialogue
		int x = jeu.tailleCaseReelle*jeu.echelle;
		int y = jeu.tailleCaseReelle/jeu.echelle;
		int largeur = jeu.largeurEcran - (jeu.tailleCaseReelle*5);
		int hauteur = jeu.hauteurEcran -(jeu.tailleCaseReelle*10);
		
		//Definir la couleur du rectangle
		g.setColor(Color.black);
		g.fillRoundRect(x, y, largeur +40, hauteur, 40, 40);
		
		//Definir un contour blanc dans le rectangle
		g.setColor(Color.white);
		g.setStroke(new BasicStroke(5));
		g.drawRoundRect(x+5, y+5, largeur-10, hauteur-10, 25, 25);
		
		
		x+= jeu.tailleCaseReelle-15;
		y+= jeu.tailleCaseReelle;
		g.drawString(texte, x, y);
		
		this.quitter = 0;
		g.drawString(">", x, y+20 );
		g.drawString("Quitter le jeu", x+20, y+20);
		
	}
	
	/* Afficher la cle de la princesse
	 * */
	public void afficherCle(Graphics2D g) {
		g.drawImage(jeu.listeObj.listeObjet[5][0].image, 33*15+11, 33*4, jeu.tailleCaseReelle/2, jeu.tailleCaseReelle/2, null);
	}
	
	/*
	 * Afficher le compteur des pieces
	 */
	public void afficherPiece(Graphics2D g) {
		g.drawImage(jeu.listeObj.listeObjet[4][0].image, 950, 32, jeu.tailleCaseReelle/2, jeu.tailleCaseReelle/2, null);
		String a = String.valueOf(joueur.comptPiece);
		if (joueur.comptPiece > 9) {
			g.drawString(a, 950 - 25, 62);
		} else {
			g.drawString(a, 950 - 15, 62);
		}
		
	}

	/*
	 * Definir l'interface graphique du magasin
	 */
	public void dessinerMagasin(Graphics2D g) {

		//Creer un rectangle pour afficher le dialogue
				int x = jeu.tailleCaseReelle*jeu.echelle;
				int y = jeu.tailleCaseReelle/jeu.echelle;
				int largeur = jeu.largeurEcran - (jeu.tailleCaseReelle*5);
				int hauteur = jeu.hauteurEcran -(jeu.tailleCaseReelle*10);
				
				//Definir la couleur du rectangle
				g.setColor(Color.black);
				g.fillRoundRect(x, y, largeur, hauteur+50, 50, 150);
				
				//Definir un contour blanc dans le rectangle
				g.setColor(Color.white);
				g.setStroke(new BasicStroke(5));
				g.drawRoundRect(x+5, y+5, largeur-10, hauteur+40, 25, 25);
				
				x+= jeu.tailleCaseReelle-15;
				y+= jeu.tailleCaseReelle;
				g.drawString("Que voulez vous acheter ?", x, y);
				
				g.drawString("Epee                  x1 piece ", x, y+25);
				if(this.clavier == 0) {
					g.drawString(">", x-25, y+25);
				}
				g.drawString("Coeur                 x1 piece ", x, y+50);
				if(this.clavier == 1) {
					g.drawString(">", x-25, y+50);
				}
				g.drawString("Bouclier              x1 piece ", x, y+75);
				if(this.clavier == 2) {
					g.drawString(">", x-25, y+75);
				}
				
				
	}
	/*
	 * Dessiner l'interface graphique de l'inventaire du joueur
	 */
	public void afficherInventaire(Graphics2D g, Inventaire inv) {
		
		int posX = 10;
		int posY = 10;
		int hauteur = jeu.tailleCaseReelle * 5 + 15;
		int largeur = jeu.tailleCaseReelle * 4;
		afficherFenetre(posX, posY, hauteur, largeur, g);
		
		int posXCase = 27;
		int posYCase = 25;
		int compt = 0;
		
		for (int k = 0; k < 4; k++) {
			for (int i = 0; i < 3; i++) {
				afficherCase(posXCase, posYCase, jeu.tailleCaseReelle, jeu.tailleCaseReelle, g);
				g.drawImage(inv.listeObjet[compt].image, posXCase, posYCase, jeu.tailleCaseReelle, jeu.tailleCaseReelle, null);
				if (inv.listeObjet[compt].image == inv.tousLesObjets.listeObjet[2][0].image) {
					int nb = inv.listeObjet[compt].nb;
					String a = String.valueOf(nb);
					g.setColor(Color.WHITE);
					if (nb < 10) {
						g.drawString(a, posXCase + jeu.tailleCaseReelle - 18, posYCase + jeu.tailleCaseReelle - 5);
					} else {
						g.drawString(a, posXCase + jeu.tailleCaseReelle - 25, posYCase + jeu.tailleCaseReelle - 5);
					}
				}
				posXCase += jeu.tailleCaseReelle + 15;
				compt++;
			}
			posXCase = 27;
			posYCase += jeu.tailleCaseReelle + 15;
		}
	}
	
	/*
	 * Afficher a l'ecran une fenetre 
	 */
	public void afficherFenetre(int x, int y, int largeur, int hauteur, Graphics2D g) {
		g.setColor(Color.black);
		g.fillRoundRect(x, y, hauteur, largeur, 20, 20);
		g.setColor(Color.gray);
		g.fillRoundRect(x + 5, y + 5, hauteur - 10, largeur - 10, 20, 20);
	}
	
	/*
	 * Afficher a l'ecran une case 
	 */
	public void  afficherCase(int x, int y, int largeur, int hauteur, Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRoundRect(x, y, hauteur, largeur, 20, 20);
		g.setColor(Color.GRAY);
		g.fillRoundRect(x + 5, y + 5, hauteur - 10, largeur - 10, 20, 20);
	}
	/*
	 * Affiche tous les element de la liste d'entite
	 */
	public void afficherEntite(Graphics2D g) {
		int k = 0;
			while(jeu.listeEntite[k] != null) {
				jeu.listeEntite[k].afficher(g);
				k++;
			}
	}

	public void viderEntite() {
		int k = 0;
			while(jeu.listeEntite[k] != null) {
				jeu.listeEntite[k] = null;
				k++;
			}
	}
	
}