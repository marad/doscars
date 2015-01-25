package pl.radoszewski.doscars.animations;

public class FadeOutAnimation extends FadeAnimation {
    public FadeOutAnimation(FadeCallback fadeCallback, int time) {
        super(fadeCallback, time);
    }

    public void update() {
        long time = System.currentTimeMillis();
        float value = 1f - (float)(time - start) / (end - start);
        callback.run(value);
    }
}
