import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a: ");
            int a = getValidInput(scanner);

            System.out.print("Enter b: ");
            int b = getValidInput(scanner);

            System.out.print("Enter c: ");
            int c = getValidInput(scanner);

            checkTriangle(a, b, c);
        } catch (Exception e) {
            System.out.println("Ошибка ввода или треугольник не существует");
        }
    }

    static int getValidInput(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();

            try {

                int value = Integer.parseInt(input);


                if (value < 0) {
                    System.out.println("Стороны треугольника должны быть неотрицательными числами. Попробуйте снова.");
                    continue;
                }


                return value;

            } catch (NumberFormatException e) {
                System.out.println("Введённое число превышает Integer.MAX_VALUE[" + Integer.MAX_VALUE + "]. Попробуйте снова.");
            }
        }
    }

    static void checkTriangle(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0 || (long) a + (long) b <= (long) c || (long) a + (long) c <= (long) b || (long) b + (long) c <= (long) a) {
            System.out.println("Треугольник не существует");
            return;
        }

        String triangleType = getTriangleType(a, b, c);
        System.out.println(triangleType);
    }

    static String getTriangleType(int a, int b, int c) {
        if (a == b && b == c) {
            return "Равносторонний треугольник";
        }
        if (a == b || b == c || a == c) {
            return "Равнобедренный треугольник";
        }
        return "Разносторонний треугольник";
    }
}
