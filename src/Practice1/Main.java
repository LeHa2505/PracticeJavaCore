package Practice1;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape(5, 6);
        Rectangle rectangle = new Rectangle(7, 8);
        Circle circle = new Circle(3);

        System.out.println("Shape");
        System.out.println("Width: " + shape.width + "\n" + "Height: " + shape.height);

        System.out.println("Rectangle");
        System.out.println("Width: " + rectangle.width +"\nHeight: " + rectangle.height);
        System.out.println("Area: " + Rectangle.getArea(rectangle.width, rectangle.height));
        System.out.println("Perimeter: " + Rectangle.getPerimeter(rectangle.width, rectangle.height));

        System.out.println("Circle");
        System.out.println("Radius: " + circle.width);
        System.out.println("Area: " + Circle.getArea(rectangle.width));
        System.out.println("Circumference: " + Circle.getCircumference(rectangle.width));

    }
}
