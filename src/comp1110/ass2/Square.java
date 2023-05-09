package comp1110.ass2;

import javafx.scene.shape.Polygon;

public class Square extends Polygon {
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
