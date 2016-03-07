import java.util.Scanner;

/*
 Создать класс вычисляющий расстояние между двумя точками, представленными координатами в двумерном пространстве (x1, y1), (x2, y2)
 */
public class Distance2FlatPoints {
    public double distance (double x1, double y1, double x2, double y2){
        double dist = Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
        return dist;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Distance2FlatPoints d = new Distance2FlatPoints();

        System.out.println("Enter x1: ");
        double x1 = in.nextDouble();
        System.out.println("Enter y1: ");
        double y1 = in.nextDouble();
        System.out.println("Enter x2: ");
        double x2 = in.nextDouble();
        System.out.println("Enter y2: ");
        double y2 = in.nextDouble();
        System.out.println("Distance between (x1,y1), (x2,y2)  = " + d.distance(x1,y1,x2,y2));
    }
}
