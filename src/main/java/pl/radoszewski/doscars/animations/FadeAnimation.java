package pl.radoszewski.doscars.animations;

public abstract class FadeAnimation implements Animation {
    protected FadeCallback callback;
    protected long start;
    protected long end;

    public FadeAnimation(FadeCallback fadeCallback, int time) {
        this.callback = fadeCallback;
        this.start = System.currentTimeMillis();
        this.end = start + time;
    }

    @Override
    public boolean isDone() {
        return end < System.currentTimeMillis();
    }

    @Override
    public void restart() {
        long time = end - start;
        this.start = System.currentTimeMillis();
        this.end = start + time;
    }

    @Override
    public void finish() {
        long time = end - start;
        end = System.currentTimeMillis();
        start = end - time;
        update();
    }

    public static interface FadeCallback {
        public void run(float value);
    }
}
