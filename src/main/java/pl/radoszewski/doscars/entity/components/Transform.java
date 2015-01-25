package pl.radoszewski.doscars.entity.components;

import com.artemis.Component;

public class Transform extends Component {
    public float x = 0f;
    public float y = 0f;

    public float rotation = 0f;
    public float scale = 1f;

    public Transform() {
    }

    public Transform(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Transform(float x, float y, float rotation) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
    }

    public Transform(float x, float y, float rotation, float scale) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.scale = scale;
    }
}
