package JavaProject.src.com.example.abstraction.abstract_class;

public class TestShape {
    public static void main(String[] args) {
        Circle circle = new Circle(4.5);
        Square square = new Square(8.8);

        System.out.println("Area of circle is : " + circle.calculateArea());
        System.out.println("Area of square is : " + square.calculateArea());
    }
}
