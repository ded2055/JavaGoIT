import java.util.Scanner;

/*
Создать класс, вычисляющий площадь простых геометрических фигур: треугольника, прямоугольника и круга.
 */
public class SquareFigure {

    public double squareRect(double sideA, double sideB){
        double square = sideA * sideB;
        return square;
    }

    public double squareTriangle(double heightTriangle, double baseTriangle){
        double square = 0.5 * (heightTriangle*baseTriangle);
        return square;
    }

    public double squareCircle(double radius){
        double square = Math.PI * Math.pow(radius,2);
        return square;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SquareFigure s = new SquareFigure();

        System.out.println("Select shape figure (Triangle/Rectangle/Circle)");
        String readShape = in.next();

        if ((readShape.compareTo("R")==0)){
            System.out.println("Enter Side A: ");
            double sideA = in.nextDouble();
            System.out.println("Enter Side B: ");
            double sideB = in.nextDouble();
            System.out.println("Square of Rectangle = " + s.squareRect(sideA, sideB));
        }
        else if((readShape.compareTo("T")==0)){
            System.out.println("Enter height Triangle: ");
            double heightTriangle = in.nextDouble();
            System.out.println("Enter base Triangle: ");
            double baseTriangle = in.nextDouble();
            System.out.println("Square of Rectangle = " + s.squareRect(heightTriangle, heightTriangle));
        }
        else if((readShape.compareTo("C")==0)){
            System.out.println("Enter radius Circle: ");
            double radius = in.nextDouble();
            System.out.println("Square of Rectangle = " + s.squareCircle(radius));
        }else System.out.println("Enter R or T or C");
    }
}
