import java.util.Scanner;

public class kalkulyator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("a-ni daxil edin: ");
        double a = sc.nextDouble();

        System.out.println("b-ni daxil edin: ");
        double b = sc.nextDouble();

        System.out.println("emeliyyati daxil edin: +1; -2; *3; /4");
        double emeliyyat = sc.nextInt();

        double netice = 0;

        if (emeliyyat == 1) {

            netice = a + b;
        }
        if (emeliyyat == 2) {

            netice = a - b;
        }
        if (emeliyyat == 3) {

            netice = a * b;
        }
        if (emeliyyat == 4) {

            netice = a / b;
        }

        System.out.println("Netice: " + netice);

    }
}