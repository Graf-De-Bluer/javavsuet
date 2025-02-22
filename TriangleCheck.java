import java.util.Scanner;

public class TriangleCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод длин сторон треугольника
        System.out.print("Введите длину первой стороны: ");
        int a = scanner.nextInt();
        System.out.print("Введите длину второй стороны: ");
        int b = scanner.nextInt();
        System.out.print("Введите длину третьей стороны: ");
        int c = scanner.nextInt();

        // Проверка условия существования треугольника
        if (a + b > c && a + c > b && b + c > a) {
            System.out.println("Треугольник возможен.");

            // Определяем наибольший внешний угол
            double maxAngle = calculateLargestExternalAngle(a, b, c);
            System.out.printf("Наибольший внешний угол: %.2f градусов\n", maxAngle);
        } else {
            System.out.println("Треугольник невозможен.");
        }

        scanner.close();
    }

    private static double calculateLargestExternalAngle(int a, int b, int c) {
        // Определяем наибольший внутренний угол по формуле косинусов
        int maxSide = Math.max(a, Math.max(b, c));
        int other1, other2;

        if (maxSide == a) {
            other1 = b;
            other2 = c;
        } else if (maxSide == b) {
            other1 = a;
            other2 = c;
        } else {
            other1 = a;
            other2 = b;
        }

        // Косинус угла напротив наибольшей стороны
        double cosLargestAngle = (other1 * other1 + other2 * other2 - maxSide * maxSide) / (2.0 * other1 * other2);

        // Внутренний угол в радианах
        double largestInternalAngle = Math.acos(cosLargestAngle);

        // Преобразуем в градусы
        double largestInternalAngleDegrees = Math.toDegrees(largestInternalAngle);

        // Внешний угол = 180° - внутренний угол
        return 180 - largestInternalAngleDegrees;
    }
}
