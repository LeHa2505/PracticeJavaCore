package Practice1;

import java.security.PublicKey;

public class Circle extends Shape{
    public Circle(double radius) {
        super(radius, radius);
    }

    public static double getArea(double r) {
        return Math.PI*r*2;
    }

    public static double getCircumference(double r) {
        return r*2*Math.PI;
    }

}
