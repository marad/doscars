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
        Image result = prepareImage(map);
        drawMap(map, result);
        return result;
    }

    private Image prepareImage(Map map) throws SlickException {
        return new Image(
                crate.getWidth() * map.getWidth(),
                crate.getHeight() * map.getHeight()
        );
    }

    private void drawMap(Map map, Image result) throws SlickException {
        Graphics g = result.getGraphics();
        drawBackground(result, g);
        drawCrates(map, g);
        g.flush();
    }

    private void drawBackground(Image result, Graphics g) {
        for(float y=0; y <= result.getHeight(); y += background.getHeight()) {
            for(float x=0; x <= result.getWidth(); x += background.getWidth()) {
                g.drawImage(background, x, y);
            }
        }
    }

    private void drawCrates(Map map, Graphics g) {
        for(int y=0; y < map.getHeight(); y++) {
            for(int x=0; x < map.getWidth(); x++) {
                if (map.get(x, y) == 1) {
                    g.drawImage(crate, x*crate.getWidth(), y*crate.getHeight());
                }
            }
        }
    }
}
