package Practice1;

public class Rectangle  extends Shape{
    public Rectangle(double width, double height) {
        super(width, height);
    }
    public static double getArea(double w, double h) {
        return w*h;
    }

    public static double getPerimeter(double w, double h) {
        return 2*(w+h);
    }
}
