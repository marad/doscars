package pl.radoszewski.doscars.animations;

public class CompositeAnimation implements Animation {
    private Animation[] animations;
    private int currentIndex = 0;
    private boolean done = false;

    public CompositeAnimation(Animation... animations) {
        this.animations = animations;
        if (animations.length <= 0) {
            throw new RuntimeException("No animations passed.");
        }
    }

    @Override
    public boolean isDone() {
        return done;
    }

    @Override
    public void update() {
        if (animations[currentIndex].isDone()) {
            if (currentIndex < animations.length - 1) {
                currentIndex += 1;
                animations[currentIndex].restart();
            } else {
                done = true;
            }
        }
        animations[currentIndex].update();
    }

    @Override
    public void restart() {
        done = false;
        currentIndex = 0;
        animations[currentIndex].restart();
    }

    @Override
    public void finish() {
        done = true;
        currentIndex = animations.length - 1;
        for(Animation animation : animations) {
            animation.finish();
        }
    }
}
