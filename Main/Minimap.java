package Main;
import java.io.IOException;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Minimap {
    public BufferedImage mapbis1, mapbis2, mapbis3, mapbis4, mapbis5, mapbis6, map1, map2, map3, map4, map5, map6;

    public Minimap() {
        
        this.getTexture();

    }

    public void getTexture() {
        try {
            map1 = ImageIO.read(getClass().getResource("/ressources/1.png"));
            map2 = ImageIO.read(getClass().getResource("/ressources/2.png"));
            map3 = ImageIO.read(getClass().getResource("/ressources/3.png"));
            map4 = ImageIO.read(getClass().getResource("/ressources/4.png"));
            map5 = ImageIO.read(getClass().getResource("/ressources/5.png"));
            map6 = ImageIO.read(getClass().getResource("/ressources/6.png"));

            mapbis1 = ImageIO.read(getClass().getResource("/ressources/1bis.png"));
            mapbis2 = ImageIO.read(getClass().getResource("/ressources/2bis.png"));
            mapbis3 = ImageIO.read(getClass().getResource("/ressources/3bis.png"));
            mapbis4 = ImageIO.read(getClass().getResource("/ressources/4bis.png"));
            mapbis5 = ImageIO.read(getClass().getResource("/ressources/5bis.png"));
            mapbis6 = ImageIO.read(getClass().getResource("/ressources/6bis.png"));

        } catch (IOException e) {

        }
    }
}