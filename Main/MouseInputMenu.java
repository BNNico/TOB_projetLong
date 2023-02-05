package Main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInputMenu implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        int mx = e.getX();
        int my = e.getY();

        /**
         * public Rectangle playButton = new Rectangle(NewMenuPrincipal.WIDTH / 2 - 70,
         * 150, 140, 50);
         * public Rectangle helpButton = new Rectangle(NewMenuPrincipal.WIDTH / 2 - 70,
         * 250, 140, 50);
         * public Rectangle quitButton = new Rectangle(NewMenuPrincipal.WIDTH / 2 - 70,
         * 350, 140, 50);
         */

         
        // PlayButton
        if (mx >= NewMenuPrincipal.playButton.getMinX() && mx <= NewMenuPrincipal.playButton.getMaxX()) {
            if (my >= NewMenuPrincipal.playButton.getMinY()  && my <= NewMenuPrincipal.playButton.getMaxY() ) {
                if (NewMenuPrincipal.State == NewMenuPrincipal.STATE.MENU) {
                    NewMenuPrincipal.ActionJouer();
                }
            }
        }

        // HelpButton
        if (mx >= NewMenuPrincipal.helpButton.getMinX()&& mx <= NewMenuPrincipal.helpButton.getMaxX()) {
            if (my >= NewMenuPrincipal.helpButton.getMinY()  && my <= NewMenuPrincipal.helpButton.getMaxY()) {
                if (NewMenuPrincipal.State == NewMenuPrincipal.STATE.MENU) {
                    NewMenuPrincipal.ActionHelp();
                }
                
            }
        }

        //Sauvegarde 
        if (mx >= NewMenuPrincipal.SaveButton.getMinX() && mx <= NewMenuPrincipal.SaveButton.getMaxX()) {
            if (my >= NewMenuPrincipal.SaveButton.getMinY()  && my <= NewMenuPrincipal.SaveButton.getMaxY()) {
                if (NewMenuPrincipal.State == NewMenuPrincipal.STATE.MENU) {
                    NewMenuPrincipal.ActionSauvegarder();
                }
            }
        }

        // QuitButton
        if (mx >= NewMenuPrincipal.quitButton.getMinX()&& mx <= NewMenuPrincipal.quitButton.getMaxX()) {
            if (my >= NewMenuPrincipal.quitButton.getMinY() && my <= NewMenuPrincipal.quitButton.getMaxY()) {
                if (NewMenuPrincipal.State == NewMenuPrincipal.STATE.MENU) {
                    NewMenuPrincipal.ActionQuitter();
                }
            }
        }
        
        
        // Passer
        if (mx >= NewMenuPrincipal.boutonPasser.getMinX() && mx <= NewMenuPrincipal.boutonPasser.getMaxX() ) {
            if (my >= NewMenuPrincipal.boutonPasser.getMinY() && my <= NewMenuPrincipal.boutonPasser.getMaxY()) {
                if (NewMenuPrincipal.State == NewMenuPrincipal.STATE.INSTRUCTION) {
                    NewMenuPrincipal.ActionPasser();
                }
            	
            }
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}