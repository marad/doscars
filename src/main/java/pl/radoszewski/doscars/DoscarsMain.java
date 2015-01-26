package pl.radoszewski.doscars;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
import pl.radoszewski.slick.utils.NativeExtractor;

import java.io.IOException;

public class DoscarsMain {
    public static void main(String[] args) throws IOException {

        NativeExtractor.extractLwjglNatives();

        try {
            AppGameContainer container;
            container = new AppGameContainer(new Game());
            container.setDisplayMode(768, 768, false);
            container.start();
        } catch (SlickException ex) {
            ex.printStackTrace();
        }
    }
}
