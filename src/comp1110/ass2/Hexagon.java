package comp1110.ass2;

import javafx.scene.shape.Polygon;

public class Hexagon extends Polygon {
    // Written by Linsheng
    // Creates a hexagon shape, later used in the Viewer and Game classes to create the board image
    double x;
    double y;
    double side;

    public Hexagon(double x,double y, double side){
        this.x=x;
        this.y=y;
        this.side=side;
        setLayoutX(x);
        setLayoutY(y);
        getPoints().addAll((double)0,-side,
                (side/2)*Math.sqrt(3),-side/2,
                (side/2)*Math.sqrt(3),side/2,
                (double)0,side,
                -(side/2)*Math.sqrt(3),side/2,
                -(side/2)*Math.sqrt(3),-side/2
        );
    }

}
