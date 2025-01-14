package org.example.materialfx.animations;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shaker {
    private TranslateTransition translateTransition;

    public Shaker(Node node) {
        this.translateTransition = new TranslateTransition(Duration.millis(50), node);
        translateTransition.setFromX(0);
        translateTransition.setByX(15);
        translateTransition.setByY(15);
        translateTransition.setCycleCount(4);
        translateTransition.setAutoReverse(true);
    }
    public void shake() {
        translateTransition.playFromStart();
    }
}
