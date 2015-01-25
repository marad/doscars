package pl.radoszewski.doscars.states;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import pl.radoszewski.doscars.Game;
import pl.radoszewski.doscars.animations.*;
import pl.radoszewski.doscars.animations.Animation;

public class SplashScreenState extends BasicGameState {

    public static final int SCREEN_DELAY = 10000;

    private Image productionsImage;
    private Image nameImage;
    private Animation textAnimation;
    private StateBasedGame stateBasedGame;
    private long startTime;

    @Override
    public int getID() {
        return Game.SPLASHSCREEN;
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        textAnimation.restart();
        startTime = System.currentTimeMillis();
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.stateBasedGame = stateBasedGame;
        productionsImage = new Image("splash/splash_text.png");
        nameImage = new Image("splash/splash_name.png");

        productionsImage.setAlpha(0);
        nameImage.setAlpha(0);

        Animation productionsIn = new FadeInAnimation(productionsImage::setAlpha, 2000);
        Animation productionsOut = new FadeOutAnimation(productionsImage::setAlpha, 1000);
        Animation nameIn = new FadeInAnimation(nameImage::setAlpha, 2000);

        textAnimation = new CompositeAnimation(
                productionsIn,
                productionsOut,
                nameIn
                );
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        int width = gameContainer.getWidth();
        int height = gameContainer.getHeight();
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, width, height);

        productionsImage.draw(
                (width / 2f) - (productionsImage.getWidth() / 2f),
                (height / 2f) - (productionsImage.getHeight() / 2f)
        );
        nameImage.draw(
                (width / 2f) - (nameImage.getWidth() / 2f),
                (height / 2f) - (nameImage.getHeight() / 2f)
        );
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        textAnimation.update();

        if (startTime + SCREEN_DELAY < System.currentTimeMillis()) {
            goToMainMenu();
        }
    }

    @Override
    public void keyPressed(int key, char c) {
        if(textAnimation.isDone()) {
            goToMainMenu();
        } else {
            textAnimation.finish();
        }
    }

    public void goToMainMenu() {
        stateBasedGame.enterState(Game.MAINMENU, new FadeOutTransition(), new FadeInTransition());
    }

}
