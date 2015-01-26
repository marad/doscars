package pl.radoszewski.doscars;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import pl.radoszewski.doscars.states.GameState;
import pl.radoszewski.doscars.states.MenuState;
import pl.radoszewski.doscars.states.SplashScreenState;

public class Game extends StateBasedGame {

    public Game() {
        super("Dos Cars 2");
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.addState(new SplashScreenState());
        this.addState(new MenuState());
        this.addState(new GameState());

        this.enterState(SPLASHSCREEN);
//        this.enterState(GAME);
    }

    public static final int SPLASHSCREEN = 0;
    public static final int MAINMENU = 1;
    public static final int GAME = 2;
}
