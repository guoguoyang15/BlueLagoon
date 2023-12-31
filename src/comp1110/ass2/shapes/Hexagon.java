package comp1110.ass2.shapes;

import javafx.scene.input.MouseButton;
import javafx.scene.shape.Polygon;

/**
 * @author Zhou Linsheng
 */
public class Hexagon extends Polygon {
    // Creates a hexagon shape, later used in the Viewer class to create primitive board image
    public double x;
    public double y;
    public double side;


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
        setOnMousePressed(event -> {
            double cx=event.getX();
            double cy=event.getY();
            if(event.getButton()== MouseButton.PRIMARY){
                String str="S "+cx+","+cy;


            }
        });
    }

}
