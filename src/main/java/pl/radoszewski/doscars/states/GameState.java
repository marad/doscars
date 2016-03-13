package pl.radoszewski.doscars.states;

import com.artemis.Entity;
import com.artemis.World;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import pl.radoszewski.doscars.Game;
import pl.radoszewski.doscars.Map;
import pl.radoszewski.doscars.MapRenderer;
import pl.radoszewski.doscars.entity.components.Controlls;
import pl.radoszewski.doscars.entity.components.RenderInfo;
import pl.radoszewski.doscars.entity.components.Transform;
import pl.radoszewski.doscars.entity.systems.ControllsHandlingSystem;
import pl.radoszewski.doscars.entity.systems.RenderingSystem;

public class GameState extends BasicGameState {

    private World world;

    private String[] mapTemplate = new String[] {
            "########################",
            "#  #                   #",
            "#  #                   #",
            "#  #                   #",
            "#                      #",
            "#                      #",
            "#                      #",
            "#                      #",
            "#                      #",
            "#                      #",
            "#                      #",
            "#                      #",
            "#                      #",
            "#                      #",
            "#                      #",
            "#                      #",
            "#                      #",
            "#                      #",
            "#                      #",
            "#                      #",
            "#                   #  #",
            "#                   #  #",
            "#                   #  #",
            "########################",
    };

    @Override
    public int getID() {
        return Game.GAME;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        createWorld(gameContainer);
        createMap(gameContainer);
        float carScale = 0.4f;
        initFirstPlayer(carScale, "vehicle/audi.png");
        initSecondPlayer(carScale, "vehicle/black_viper.png");
    }

    private void createWorld(GameContainer gameContainer) {
        world = new World();
        world.setSystem(new ControllsHandlingSystem(gameContainer.getInput()));
        world.setSystem(new RenderingSystem());
        world.initialize();
    }

    private void createMap(GameContainer gameContainer) throws SlickException {
        Image crate = new Image("crate32.png");
        Image asphalt = new Image("asphalt256.png");

        Map map = new Map(mapTemplate);
        Image background = new MapRenderer(asphalt, crate).renderMap(map);

        Entity mapEntity = world.createEntity();
        mapEntity.addComponent(new RenderInfo(background));
        mapEntity.addToWorld();
    }

    private void initFirstPlayer(float carScale, String carImagePath) throws SlickException {
        Image carImage = new Image(carImagePath);
        carImage.setCenterOfRotation(carImage.getWidth()/2 * carScale, carImage.getHeight()/2 * carScale);
        Entity entity = world.createEntity();
        entity.addComponent(new RenderInfo(carImage));
        entity.addComponent(new Transform(100, 100, 90, carScale));
        entity.addComponent(new Controlls(
                Input.KEY_UP, Input.KEY_DOWN,
                Input.KEY_LEFT, Input.KEY_RIGHT,
                Input.KEY_SPACE
        ));
        entity.addToWorld();
    }

    private void initSecondPlayer(float carScale, String carImagePath) throws SlickException {
        Image carImage = new Image(carImagePath);
        carImage.setCenterOfRotation(carImage.getWidth()/2 * carScale, carImage.getHeight()/2 * carScale);
        Entity viperEntity = world.createEntity();
        viperEntity.addComponent(new RenderInfo(carImage));
        viperEntity.addComponent(new Transform(200, 200, 0, carScale));
        viperEntity.addComponent(new Controlls(
                Input.KEY_W, Input.KEY_S,
                Input.KEY_A, Input.KEY_D,
                Input.KEY_LSHIFT
        ));
        viperEntity.addToWorld();
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        world.process();
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        world.setDelta(delta);
    }
}
