package sample.animation;

import javafx.animation.Animation;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class AnimationImage {

    private static final int COLUMNS = 2;
    private static final int COUNT = 2;
    private static final int OFFSET_X = 0;
    private static final int OFFSET_Y = 0;
    private static final int WIDTH = 150;
    private static final int HEIGHT = 150;

    public Animation animationPokemon(ImageView pokemon){
        Animation animationPokemon = new SpriteAnimation(pokemon,
                Duration.millis(800),
                COUNT, COLUMNS,
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT);
        return animationPokemon;
    }
}
