import java.util.*;


public class Controller {

    public static void start_controller() {

        Hangman hangman = Database.get_hangman_object();

        List country_with_dash = hangman.make_dashboard(hangman.capital);

        List<String> used_letters = new ArrayList<String>();

        int bad_quesses = 0;
        boolean success = false;


        while (!success && bad_quesses < 6) {

            String quess = View.get_question();

            if (quess.equals(hangman.capital)) {
                // check if user quessed country at once
                success = true;

            } else {
                if (bad_quesses == 4) {
                    View.show_hint_country(hangman.country);
                }
                if (quess.matches("[A-Za-z]{1}") && !used_letters.contains(quess)) {
                    // check if user provided appropriate letter

                    if (hangman.capital.contains(quess)) {
                        // check if user provided letter which is in word

                        List added_letters_to_country = hangman.set_new_letters(country_with_dash, quess, hangman.capital);

                        String country_with_new_letters = hangman.show_updated_dash_word(added_letters_to_country);
                        View.show_country(country_with_new_letters);

                        if (country_with_new_letters.equals(hangman.capital)) {
                            // check if user provided all letters and quessed country
                            success = true;
                        }
                    }else{
                        View.no_letter_msg();
                        bad_quesses++;
                    }
                    used_letters.add(quess);
                }else {
                    if (used_letters.contains(quess)) {
                        // check if user has already provided the same letter
                        View.repeat_letter();
                    }else{
                        View.no_letter_msg();
                        bad_quesses ++;
                        }
                    }

                }

            }
        }
    }

