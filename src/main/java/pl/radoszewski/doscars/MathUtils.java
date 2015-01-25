package pl.radoszewski.doscars;

import com.artemis.utils.FastMath;
import org.newdawn.slick.geom.Vector2f;

public class MathUtils {
    public static Vector2f rotateVector(Vector2f vector, float angle) {
        return rotateVector(vector.x, vector.y, angle);
    }

    public static Vector2f rotateVector(final float x, final float y, final float angle) {
        float sin = (float)Math.sin(angle * FastMath.PI / 180);
        float cos = (float)Math.cos(angle * FastMath.PI / 180);
        return new Vector2f(
                ((x * cos) - (y * sin)),
                ((x * sin) + (y * cos))
        ).normalise();
    }
}
