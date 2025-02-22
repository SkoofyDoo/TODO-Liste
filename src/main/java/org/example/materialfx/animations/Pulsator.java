package org.example.materialfx.animations;

import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Pulsator {
    private final ScaleTransition scaleTransition;

    public Pulsator(Node node) {
        this.scaleTransition = new ScaleTransition(Duration.millis(200), node);
        scaleTransition.setFromX(1.0);
        scaleTransition.setFromY(1.0);
        scaleTransition.setToX(1.5);
        scaleTransition.setToY(1.5);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);
    }

    public void start() {
        scaleTransition.play();
    }

    public void stop() {
        scaleTransition.stop();
    }
}