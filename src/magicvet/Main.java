package magicvet;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    // додав поля з паролем та сканером для зчитування;
    static String PASSWORD = "speedclimbing";
    static Scanner SCANNER = new Scanner(System.in);

    // додав патерн;
    static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    static String NAME_PATTERN = "^[a-zA-Z]{3,}$"; // Мінімум 3 символи латиницею

    public static void main(String[] args) {
        run();
    }


    // додав метод run();
    static void run() {
        // використовую метод auth();
        if (auth()) {
            registerNewClient();
        }
    }


    // створив метод auth(), який показує чи пройшла аутенфікація вдало;
    static boolean auth() {
        // оголосив змінну буліан для індекатора пароля;
        boolean accepted = false;
        int attempts = 3;
        for (int i = 0; i < attempts; i++) {
            System.out.print("Password: ");
            String input = SCANNER.nextLine();

            if (PASSWORD.equals(input)) {
                accepted = true;
                break;
            } else {
                System.out.println("Access denied. Please check your password.");
            }
        }
        System.out.println(accepted ? "Access granted. Welcome to the Magic-Vet-Clinic!" : "Application was blocked!");
        return accepted;
    }

    static void registerNewClient() {
        System.out.println("Please provide client details: ");
        System.out.print("Email: ");
        String email = SCANNER.nextLine();

        if (isEmailValid(email)) {
            Client client = buildClient(email);
            System.out.println("New client: " + client.firstName + " " + client.lastName + " (" + client.email + ")");
            if (isNameValid(client.firstName) && isNameValid(client.lastName)) {
                System.out.println("New client: " + client.firstName + " " + client.lastName + " (" + client.email + ")");
            } else {
                System.out.println("Invalid first name or last name.");
            }
        } else {
            System.out.println("Provided Email is invalid.");
        }
    }

    static Client buildClient(String email) {
        Client client = new Client();
        client.email = email;

        System.out.print("Fist name: ");
        client.firstName = SCANNER.nextLine();

        System.out.print("Last name: ");
        client.lastName = SCANNER.nextLine();

        return client;
    }

    static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    static boolean isNameValid(String name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}

