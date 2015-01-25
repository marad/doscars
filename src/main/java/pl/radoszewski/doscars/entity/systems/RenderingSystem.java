package pl.radoszewski.doscars.entity.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import pl.radoszewski.doscars.entity.components.Transform;
import pl.radoszewski.doscars.entity.components.RenderInfo;

public class RenderingSystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<RenderInfo> vm;

    @Mapper
    ComponentMapper<Transform> tm;

    public RenderingSystem() {
        super(Aspect.getAspectForAll(RenderInfo.class));
    }

    @Override
    protected void process(Entity entity) {
        RenderInfo renderInfo = vm.get(entity);
        Transform transform = tm.get(entity);

        if (transform != null) {
            renderInfo.image.setRotation(transform.rotation);
            renderInfo.image.draw(
                    transform.x,
                    transform.y,
                    transform.scale,
                    renderInfo.color);
        } else {
            renderInfo.image.draw(0, 0, renderInfo.color);
        }
    }
}
