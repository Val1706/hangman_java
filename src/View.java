import java.util.Scanner;

public class View {

    public static void show_hint_country(String country) {

        String msg = "This is capital of " + country;
        System.out.println(msg);
    }

    public static String get_question() {

        System.out.println("Please type a letter: ");
        Scanner scan = new Scanner(System.in);
        String quess = scan.nextLine().toUpperCase();
        return quess;
    }

    public static void no_letter_msg() {

        System.out.println("No such letter in word");
    }

    public static void repeat_letter() {

        System.out.println("You have already provided this word/letter");
    }

    public static void show_country(String country) {

        System.out.println(country);
    }
}