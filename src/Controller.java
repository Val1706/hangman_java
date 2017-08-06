import java.util.*;


public class Controller {

    public static void start_controller() {

        while (true) {

            Hangman hangman = Database.get_hangman_object();

            List country_with_dash = hangman.make_dashboard(hangman.capital);
            showing_dashboard(hangman, country_with_dash);

            List<String> used_letters = new ArrayList<String>();

            int bad_quesses = 0;

            boolean success = false;
            boolean finish_game = true;

            System.out.println(hangman.capital);

            while (finish_game) {

                String quess = View.get_question();

                if (quess.matches("[A-Za-z]{1}") && !used_letters.contains(quess)) {
                    // check if user provided appropriate letter

                    if (hangman.capital.contains(quess)) {
                        // check if user provided letter which is in word

                        List added_letters_to_country = hangman.set_new_letters(country_with_dash, quess, hangman.capital);
                        String country_with_new_letters = showing_dashboard(hangman, added_letters_to_country);

                        if (country_with_new_letters.equals(hangman.capital)) {
                            // check if user provided all letters and quessed country
                            success = true;
                        }
                    } else {
                        View.no_letter_msg();
                        bad_quesses++;
                    }
                    used_letters.add(quess);

                } else {

                    if (used_letters.contains(quess)) {
                        // check if user has already provided the same letter
                        View.repeat_letter();
                    } else if (quess.equals(hangman.capital)) {
                        success = true;
                    } else {
                        View.no_letter_msg();
                        bad_quesses++;
                    }
                }
                if (success) {
                    System.out.println("You won");
                    finish_game = false;

                } else if (bad_quesses == 3) {
                    View.show_hint_country(hangman.country);

                } else if (bad_quesses == 5) {

                    System.out.println("You lost");
                    boolean answer = View.play_again();

                    if (answer) {
                        finish_game = false;
                    } else {
                        System.exit(0);

                    }
                }
            }
        }
    }

    private static String showing_dashboard(Hangman hangman, List added_letters_to_country) {

        String country_with_new_letters = hangman.show_dash_word(added_letters_to_country);
        View.show_country(country_with_new_letters);

        return country_with_new_letters;
    }
}


