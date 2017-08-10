import java.util.List;


public class Game {

    public static void start_controller() {

        View.show_welcome_msg();

        long startTime = System.currentTimeMillis();
        long all_time = 120;

        Player player = new Player(0,10);

        while (true) {

            Hangman hangman = Capital.get_hangman_object();
            System.out.println(hangman.getCapital());

            List country_with_dash = hangman.make_dashboard();
            showing_dashboard(hangman, country_with_dash);

            boolean success = false;
            boolean current_game = true;

            while (current_game) {

                View.show_score(player.getScore());
                View.show_hangman(player.getLifes());
                player.setQuess(View.get_question());

                if (!player.getUsedLetters().contains(player.getQuess())) {

                    if (hangman.getCapital().contains(player.getQuess()) && player.getQuess().matches("[A-Za-z]{1}")) {

                        List added_letters_to_country = hangman.set_new_letters(country_with_dash, player.getQuess());
                        String country_with_new_letters = showing_dashboard(hangman, added_letters_to_country);
                        player.setScore(30);

                        if (country_with_new_letters.equals(hangman.getCapital())) {
                            success = true;
                        }
                    } else {
                        if (player.getQuess().equals(hangman.getCapital())) {
                            success = true;
                        } else {
                            View.no_letter_msg();
                            player.setLifes(-2);
                        }
                    }
                } else{
                    View.repeat_letter();
                }

                player.addUsedLetters(player.getQuess());
                player.addTrials(1);

                long endTime = System.currentTimeMillis();
                player.setTime((endTime - startTime)/1000);

                if (success) {
                    current_game = win_and_continue(player);

                } else if (player.getLifes() == 1) {
                    View.show_hint_country(hangman.getCountry());

                } else if (player.getLifes() == 0 || (player.getTime() > all_time)) {
                    if (player.getTime() > all_time) {
                        View.no_time_msg();
                        View.show_hangman(0);
                    }
                    current_game = restart_or_finish_game(player);
                    }
                }
            }
        }

    private static String showing_dashboard(Hangman hangman, List added_letters_to_country) {

        String country_with_new_letters = hangman.show_dash_word(added_letters_to_country);
        View.show_country(country_with_new_letters);

        return country_with_new_letters;
    }

    private static boolean restart_or_finish_game(Player player) {


        player.setName(View.get_name());
        //System.out.println(player.getGuessedWords());
        LeaderBoard.write_record(player.getName(), player.getScore(), player.getGuessedWords(), player.getTime());

        boolean answer = View.play_again();

        if (answer) {

            LeaderBoard.read_record();
            System.exit(0);

        } else {

            player.clearUsedLetters();
            player.set_life_and_score_for_new_game();
        }
        return answer;
    }

    private static boolean win_and_continue(Player player) {

        View.win_message();

        player.add_score_if_full_word_is_quessed();
        player.clearUsedLetters();

        player.setQuessedWords(1);
        player.setTrials(0);

        boolean finish_game = false;

        return finish_game;
    }
}



