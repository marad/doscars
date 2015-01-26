package pl.radoszewski.doscars;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MapRenderer {

    private Image background;
    private Image crate;

    public MapRenderer(Image background, Image crate) {
        this.background = background;
        this.crate = crate;
    }

    public Image renderMap(Map map) throws SlickException {
        Image result = new Image(
                crate.getWidth() * map.getWidth(),
                crate.getHeight() * map.getHeight()
        );

        Graphics g = result.getGraphics();

        // draw background
        for(float y=0; y <= result.getHeight(); y += background.getHeight()) {
            for(float x=0; x <= result.getWidth(); x += background.getWidth()) {
                g.drawImage(background, x, y);
            }
        }

        g.drawImage(crate, 128, 128);

        g.flush();
        return result;
    }
}
