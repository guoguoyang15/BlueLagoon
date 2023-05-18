package comp1110.ass2.shapes;

import javafx.scene.shape.Polygon;

/**
 * @author Zhou Linsheng
 */
public class Square extends Polygon {
    // Creates a square shape, later used in the Viewer class to create primitive board image
    double x;
    double y;
    double side;
    public Square(double x,double y, double side){
        this.x=x;
        this.y=y;
        this.side=side;
        setLayoutX(x);
        setLayoutY(y);
        getPoints().addAll(x-side,y-side,
                x+side,y-side,
                x+side,y+side,
                x-side,y+side
        );
    }
}
