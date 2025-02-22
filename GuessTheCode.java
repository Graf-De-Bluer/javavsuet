import java.util.Random;
import java.util.Scanner;

public class GuessTheCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Генерация кода из 4 случайных цифр (0-9)
        int[] secretCode = new int[4];
        for (int i = 0; i < 4; i++) {
            secretCode[i] = random.nextInt(10);
        }

        int attempts = 0;
        boolean isGuessed = false;

        System.out.println("Игра: Угадайте 4-значный код. У вас есть 20 попыток!");

        while (attempts < 20) {
            System.out.print("Введите 4 цифры: ");
            String input = scanner.next();

            if (input.length() != 4 || !input.matches("\\d{4}")) {
                System.out.println("Ошибка ввода! Введите ровно 4 цифры.");
                continue;
            }

            int[] guess = new int[4];
            for (int i = 0; i < 4; i++) {
                guess[i] = Character.getNumericValue(input.charAt(i));
            }

            // Подсчет совпадений
            int matches = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (guess[i] == secretCode[j]) {
                        matches++;
                        break; // Чтобы не засчитывать одну цифру дважды
                    }
                }
            }

            attempts++;

            if (matches == 4 && guess[0] == secretCode[0] && guess[1] == secretCode[1] && guess[2] == secretCode[2] && guess[3] == secretCode[3]) {
                System.out.println("Поздравляем! Вы угадали код за " + attempts + " попыток!");
                isGuessed = true;
                break;
            } else {
                System.out.println("Количество совпадений: " + matches);
            }
        }

        if (!isGuessed) {
            System.out.print("Вы исчерпали 20 попыток! Загаданный код был: ");
            for (int num : secretCode) {
                System.out.print(num);
            }
            System.out.println();
        }

        scanner.close();
    }
}
