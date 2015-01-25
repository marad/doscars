package pl.radoszewski.doscars.animations;

public interface Animation {
    public boolean isDone();

    public void update();

    public void restart();

    public void finish();
}
