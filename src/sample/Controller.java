package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Controller {
    @FXML private Canvas canvas;
    @FXML private ColorPicker colorPicker;
    @FXML private Slider sizeSlider;
    private Color currentColor = Color.ALICEBLUE;

    private static class Point {
        private double x,y;
        void draw(GraphicsContext gc, Color drawColor, double size) {
            gc.setFill(drawColor);
            gc.fillArc(x, y, size, size, 0, 360, ArcType.ROUND);
        }
    }

    public void changeColor() {
        currentColor = colorPicker.getValue();
    }

    public void click(MouseEvent event) {
        Point p = new Point();
        double size = sizeSlider.getValue();
        p.x = event.getX() - size / 2;
        p.y = event.getY() - size / 2;
        GraphicsContext gc = canvas.getGraphicsContext2D();
        p.draw(gc, currentColor, size);
    }
}
