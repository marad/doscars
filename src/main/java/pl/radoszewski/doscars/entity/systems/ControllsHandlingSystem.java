package pl.radoszewski.doscars.entity.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import pl.radoszewski.doscars.MathUtils;
import pl.radoszewski.doscars.entity.components.Controlls;
import pl.radoszewski.doscars.entity.components.Transform;

public class ControllsHandlingSystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Controlls> cm;

    @Mapper
    ComponentMapper<Transform> tm;

    private Input input;

    public ControllsHandlingSystem(Input input) {
        super(Aspect.getAspectForAll(Controlls.class, Transform.class));
        this.input = input;
    }

    @Override
    protected void process(Entity entity) {
        Controlls controlls = cm.get(entity);
        Transform transform = tm.get(entity);

        float delta = world.getDelta() * 0.001f;

        float speed = 450f;
        float rotationSpeed = 250f;
        Vector2f vector = MathUtils.rotateVector(0, -1, transform.rotation);

        if(input.isKeyDown(controlls.forwardKey)) {
            transform.x += vector.x * speed * delta;
            transform.y += vector.y * speed * delta;
        }

        if (input.isKeyDown(controlls.backwardKey)) {
            transform.x -= vector.x * speed * delta;
            transform.y -= vector.y * speed * delta;
        }

        if (input.isKeyDown(controlls.leftKey)) {
            transform.rotation -= rotationSpeed * delta;
            if (transform.rotation < 0) {
                transform.rotation += 360;
            }
        }

        if (input.isKeyDown(controlls.rightKey)) {
            transform.rotation += rotationSpeed * delta;
            if (transform.rotation > 360) {
                transform.rotation -= 360;
            }
        }

        if (input.isKeyPressed(controlls.shootKey)) {
            System.out.println("SHOOTING!");
        }
    }
}
