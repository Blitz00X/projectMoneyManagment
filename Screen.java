import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Screen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter total money: ");
        double total = scanner.nextDouble();
        scanner.nextLine();

        List<Day> days = new ArrayList<>();

        while (true) {
            System.out.print("Enter date (or 'done' to finish): ");
            String date = scanner.nextLine();
            if (date.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("Enter category A: ");
            double a = scanner.nextDouble();
            System.out.print("Enter category B: ");
            double b = scanner.nextDouble();
            System.out.print("Enter category C: ");
            double c = scanner.nextDouble();
            System.out.print("Enter category D: ");
            double d = scanner.nextDouble();
            System.out.print("Enter category E: ");
            double e = scanner.nextDouble();
            scanner.nextLine();


        }

        System.out.printf("%-10s %8s %8s %8s %8s %8s %8s %8s%n", "Date", "A", "B", "C", "D", "E", "Sum", "Left");
        for (Day day : days) {
            System.out.printf(
                "%-10s %8.2f %8.2f %8.2f %8.2f %8.2f %8.2f %8.2f%n",
                day.getDate(),
                day.getCategoryA(),
                day.getCategoryB(),
                day.getCategoryC(),
                day.getCategoryD(),
                day.getCategoryE(),
                day.getSum(),
                day.getLeft());
        }
    }
}
