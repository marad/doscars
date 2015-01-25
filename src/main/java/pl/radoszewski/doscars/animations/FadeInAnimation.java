package pl.radoszewski.doscars.animations;

public class FadeInAnimation extends FadeAnimation {

    public FadeInAnimation(FadeCallback fadeCallback, int time) {
        super(fadeCallback, time);
    }

    public void update() {
        long time = System.currentTimeMillis();
        float value = (float)(time - start) / (end - start);
        callback.run(value);
    }
}
