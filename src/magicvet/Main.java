package magicvet;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


public class Main {

    // додав поля з паролем та сканером для зчитування;
    static String PASSWORD = "speedclimbing";
    static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        run();
    }


    // додав метод run();
    static void run() {
        // оголосив змінну буліан для індекатора пароля;
        boolean accepted = false;
        int attempts = 3;
        for (int i = 0; i < attempts; i++) {
            System.out.print("Password: ");
            String input = SCANNER.nextLine();

            if (PASSWORD.equals(input)) {
                accepted = true;
                System.out.println("Access granted. Welcome to the Magic-Vet-Clinic! Please wait...");
                Timer timer = new Timer();
                int delayMilliseconds = 3000; // Задержка в миллисекундах (3000 миллисекунд = 3 секунды)
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("You have been successfully authorized.");
                    }
                }, delayMilliseconds);
                break;
            } else {
                accepted = false;
                System.out.println("Access denied. Please check your password.");
            }
        }
        if (accepted == false) {
            System.out.println("Application has been blocked!");
        }
    }
}


