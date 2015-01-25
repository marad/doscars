package pl.radoszewski.doscars.animations;

public class ActionAnimation implements Animation {

    private boolean alreadyRun = false;
    private ActionCallback actionCallback;

    public ActionAnimation(ActionCallback actionCallback) {
        this.actionCallback = actionCallback;
    }

    @Override
    public boolean isDone() {
        return alreadyRun;
    }

    @Override
    public void update() {
        if (!alreadyRun) {
            actionCallback.perform();
            alreadyRun = true;
        }
    }

    @Override
    public void restart() {
        alreadyRun = false;
    }

    @Override
    public void finish() {
        update();
    }

    public static interface ActionCallback {
        public void perform();
    }
}
