import java.util.*;


public class Controller {

    public static void main(String[] args) {

        Database.get_country();

        Hangman hangman = new Hangman("Poland", "Warsaw");

        String country = hangman.game_country.toUpperCase();
        String capital = hangman.game_capital.toUpperCase();

        List country_with_dash = hangman.make_dashboard(country);

        int bad_quess = 0;
        int all_quesses = 6;

        List<String> used_letters = new ArrayList<String>();

        boolean success = false;


        while (!success && bad_quess < all_quesses) {

            System.out.println("Please type a letter: ");
            Scanner scan = new Scanner(System.in);
            String quess = scan.next().toUpperCase();


            if (quess.equals(country)) {
                // check if user quessed country at once
                success = true;
            }

            if (quess.matches("[A-Za-z]{1}") && !used_letters.contains(quess)) {
                // check if user provided appropriate letter

                if (country.contains(quess)) {
                    // check if user provided letter which is in word

                    List added_letters_to_country = hangman.set_new_letters(country_with_dash, quess, country);

                    String country_with_new_letters = hangman.show_updated_dash_word(added_letters_to_country);
                    System.out.println(country_with_new_letters);

                    if (country_with_new_letters.equals(country)) {
                        // check if user provided all letters and quessed country
                        success = true;
                    }

                } else {

                    bad_quess++;
                    System.out.println("Wrong!");
                }

            } else {
                if (used_letters.contains(quess)) {
                    // check if user has already provided the same letter
                    System.out.println("You have already used this word");

                }
            }
            used_letters.add(quess);
        }
    }
}
