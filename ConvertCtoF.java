import java.util.Scanner;

/*
  Создать класс преобразующий значение температуры по шкале Цельсия в значение по шкале Фаренгейта и в обратном направлении.
 */
public class ConvertCtoF {

    public double cToF(double c){
        double f = 1.8*c + 32;
        return f;
    }
    public double fToC(double f){
        double c = (f - 32)/1.8;
        return c;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ConvertCtoF conv = new ConvertCtoF();
        System.out.println("What degrees you have, Celsius or Fahrenheit: ");
        String reaDegree = in.next();

        if ((reaDegree.compareTo("C")==0)){
            System.out.println("Enter degrees in Celsius: ");
            double c = in.nextDouble();
            System.out.println("Degrees in Fahrenheit = " + conv.cToF(c));
        }
        else if((reaDegree.compareTo("F")==0)){
            System.out.println("Enter degrees in Fahrenheit: ");
            double f = in.nextDouble();
            System.out.println("Degrees in Celsius = " + conv.fToC(f));
        }else System.out.println("Enter F or C");
    }
}
