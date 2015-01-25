package pl.radoszewski.doscars.entity.components;

import com.artemis.Component;

public class Controlls extends Component {
    public int forwardKey;
    public int backwardKey;
    public int leftKey;
    public int rightKey;
    public int shootKey;

    public Controlls(int forwardKey, int backwardKey, int leftKey, int rightKey, int shootKey) {
        this.forwardKey = forwardKey;
        this.backwardKey = backwardKey;
        this.leftKey = leftKey;
        this.rightKey = rightKey;
        this.shootKey = shootKey;
    }
}
