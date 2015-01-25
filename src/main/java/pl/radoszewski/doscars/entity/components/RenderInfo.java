package pl.radoszewski.doscars.entity.components;

import com.artemis.Component;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

public class RenderInfo extends Component {
    public Image image;
    public Color color = Color.white;

    public RenderInfo(Image image) {
        this.image = image;
    }

    public RenderInfo(Image image, Color color) {
        this.image = image;
        this.color = color;
    }
}
