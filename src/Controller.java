import java.util.*;


public class Controller {

    public static void start_controller() {

        Player player = new Player();

        while (true) {

            Hangman hangman = Database.get_hangman_object();

            List country_with_dash = hangman.make_dashboard(hangman.capital);
            showing_dashboard(hangman, country_with_dash);

            boolean success = false;
            boolean current_game = true;

            System.out.println(hangman.capital);

            while (current_game) {

                System.out.println("Yous score " + player.score);

                player.quess = View.get_question();

                player.add_trials();

                if (player.quess.matches("[A-Za-z]{1}") && !player.used_letters.contains(player.quess)) {
                    // check if user provided appropriate letter

                    if (hangman.capital.contains(player.quess)) {
                        // check if user provided letter which is in word

                        List added_letters_to_country = hangman.set_new_letters(country_with_dash, player.quess, hangman.capital);
                        String country_with_new_letters = showing_dashboard(hangman, added_letters_to_country);

                        if (country_with_new_letters.equals(hangman.capital)) {
                            // check if user provided all letters and quessed country
                            success = true;

                        }
                        player.add_score();

                    } else {
                        View.show_hangman(player.lifes);
                        player.minus_score_and_lifes();

                    }
                    player.add_used_letters();

                } else {

                    if (player.used_letters.contains(player.quess)) {
                        // check if user has already provided the same letter
                        View.repeat_letter();
                    } else if (player.quess.equals(hangman.capital)) {
                        player.add_score_if_full_word_is_quessed();
                        success = true;
                    } else {
                        View.show_hangman(player.lifes);
                        player.minus_score_and_lifes();
                    }
                }
                View.show_hangman(player.lifes);

                if (success) {

                    View.win_message();
                    current_game = false;

                } else if (player.lifes == 1) {

                    View.show_hint_country(hangman.country);

                } else if (player.lifes == 0) {

                    player.name = View.get_name();
                    Database.write_record(player.name, player.score);

                    current_game = View.play_again();

                    if (current_game) {
                        Database.read_record();
                        System.exit(0);
                    }else{
                        player.set_life_and_score_for_new_game();
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




