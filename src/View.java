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

        while(!quess.matches("[A-Za-z ]*")){
            System.out.println("Please type only letters: ");
            quess = scan.nextLine().toUpperCase();

        }
        return quess;
    }

    public static boolean play_again() {

        System.out.println("Would you like play again? ");
        Scanner scan = new Scanner(System.in);
        String answer = scan.nextLine().toUpperCase();
        if (answer.startsWith("Y")) {
            return false;
        }

        return true;
    }

    public static String get_name() {

        System.out.println("Please type your name: ");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();

        return name;
    }


    public static void no_letter_msg() {

        System.out.println("No such letter in word");
    }

    public static void show_score(int score) {
        System.out.println("Your score is " + score);

    }

    public static void repeat_letter() {

        System.out.println("You have already provided this word/letter");
    }

    public static void show_country(String country) {

        System.out.println(country);
    }

    public static void win_message() {

        System.out.println("You won");

    }

    public static void no_time_msg() {

        System.out.println("Your time is over");

    }

    public static void lost_message() {

        System.out.println("You lost");
    }

    public static void show_quesses(int lifes) {

        String result = String.format("You have %1$d lifes", lifes);
        System.out.println(result);
    }

    public static void show_hangman(int lifes) {

        show_quesses(lifes);

        if (lifes == 6) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("___|___");
            System.out.println();
        }
        if (lifes == 5) {
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (lifes == 4) {
            System.out.println("   ____________");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   | ");
            System.out.println("___|___");
        }
        if (lifes == 3) {

            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (lifes == 2) {
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (lifes == 1) {

            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }
        if (lifes == 0) {
            lost_message();

            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }
    }

    public static void show_welcome_msg() {

        System.out.println("\nWelcome to Hangman! A word will be chosen at random and");
        System.out.println("you must try to guess the word correctly letter by letter");
        System.out.println("before you run out of attempts. Remember that you have only 2 minutes to quess word,");
        System.out.println( "so try quess as fast as you can. Good luck!\n");
    }
}

