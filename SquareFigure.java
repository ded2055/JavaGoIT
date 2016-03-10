import java.util.Scanner;

/*
Создать класс, вычисляющий площадь простых геометрических фигур: треугольника, прямоугольника и круга.
 */

class Figure{
    double square;
    double findSquare(){
        return square;
    }
}
class Rectangle extends Figure {
    double sideA;
    double sideB;

    Rectangle(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Side A: ");
        sideA = in.nextDouble();
        System.out.println("Enter Side B: ");
        sideB = in.nextDouble();
    }

    double findSquare(){
        double square = sideA * sideB;
        return square;
    }

}
class Triangle extends Figure{
    double heightTriangle;
    double baseTriangle;

    Triangle(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter height Triangle: ");
        heightTriangle = in.nextDouble();
        System.out.println("Enter base Triangle: ");
        baseTriangle = in.nextDouble();
    }

    double findSquare() {
        double square = 0.5 * (heightTriangle * baseTriangle);
        return square;
    }
}
class Circle extends Figure{
        double radius;

        Circle(){
            Scanner in = new Scanner(System.in);
            System.out.println("Enter radius Circle: ");
            radius = in.nextDouble();
        }

        double findSquare() {
        double square = Math.PI * Math.pow(radius, 2);
        return square;
    }
}
public class SquareFigure {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Select shape figure (Triangle/Rectangle/Circle)");
        String readShape = in.next();

        if ((readShape.compareTo("R") == 0)) {
            Rectangle rect = new Rectangle();
            System.out.println("Square of Rectangle = " + rect.findSquare());
        } else if ((readShape.compareTo("T") == 0)) {
            Triangle tri = new Triangle();
            System.out.println("Square of Triangle = " + tri.findSquare());
        } else if ((readShape.compareTo("C") == 0)) {
            Circle circle = new Circle();
            System.out.println("Square of Circle = " + circle.findSquare());
        } else System.out.println("Enter R or T or C");
    }
}
