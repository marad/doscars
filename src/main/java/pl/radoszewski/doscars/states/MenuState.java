package pl.radoszewski.doscars.states;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import pl.radoszewski.doscars.Game;

public class MenuState extends BasicGameState {

    private Image backgroundImage;
    private Image newGameImage;
    private Image optionsImage;
    private Image exitImage;

    private Image[] options;
    private ActionCallback[] actionCallbacks;
    private int selectedOption = 0;

    private GameContainer gameContainer;
    private StateBasedGame stateBasedGame;

    @Override
    public int getID() {
        return Game.MAINMENU;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.gameContainer = gameContainer;
        this.stateBasedGame = stateBasedGame;

        backgroundImage = new Image("menu/background.png");
        newGameImage = new Image("menu/new-game.png");
        optionsImage = new Image("menu/options.png");
        exitImage = new Image("menu/exit.png");

        options = new Image[] { newGameImage, optionsImage, exitImage };

        actionCallbacks = new ActionCallback[] {
            this::newGame,
            this::options,
            gameContainer::exit
        };

        newGameImage.setImageColor(0, 0, 0);
        optionsImage.setImageColor(0, 0, 0);
        exitImage.setImageColor(0, 0, 0);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        float center = gameContainer.getWidth() / 2f;
        float top = 200;

        backgroundImage.draw();
        newGameImage.draw(
                center - (newGameImage.getWidth() / 2f),
                top
        );
        optionsImage.draw(
                center - (optionsImage.getWidth() / 2f),
                top + 80
        );
        exitImage.draw(
                center - (exitImage.getWidth() / 2f),
                top + 160
        );
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        for(Image option : options) {
            option.setImageColor(0, 0, 0);
        }
        options[selectedOption].setImageColor(1, 1, 1);
    }

    @Override
    public void keyReleased(int key, char c) {
        if (key == Keyboard.KEY_RETURN) {
            actionCallbacks[selectedOption].run();
        }

        if (key == Keyboard.KEY_UP) selectedOption -= 1;
        if (key == Keyboard.KEY_DOWN) selectedOption += 1;

        if (selectedOption < 0) selectedOption = 2;
        selectedOption %= 3;
    }


    public void newGame() {
        stateBasedGame.enterState(Game.GAME);
    }

    public void options() {
        System.out.println("NOT IMPLEMENTED YET");
    }

    public static interface ActionCallback {
        public void run();
    }
}
