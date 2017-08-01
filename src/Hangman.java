import java.io.IOException;
import java.util.*;
import java.util.Scanner;




public class Hangman {

    public static void main(String[] args) throws IOException {

        String country = "Poland".toUpperCase();
        List country_with_dash = make_dashboard(country);

        while(true) {

            System.out.println("Please type a letter: ");
            Scanner scan = new Scanner(System.in);
            String quess = scan.next().toUpperCase();

            if (quess.equals(country)) {
                break;

            }else {
                if (quess.matches("[A-Za-z]{1}")){

                    List added_letters_to_country = set_new_letters(country_with_dash, quess, country);

                    String country_with_new_letters = show_updated_dash_word(added_letters_to_country);
                    System.out.println(country_with_new_letters);

                    if (country_with_new_letters.equals(country)) {
                        break;
                    }

                }
            }
        }
    }

    private static List make_dashboard(String country){

        List<String> dash_list = new ArrayList<String>();
        for (int i = 0; i < country.length(); i++) {
            if (country.charAt(i) == ' ') {
                dash_list.add(" ");
            } else {
                dash_list.add("-");
            }

        }return dash_list;
    }

    private static List set_new_letters(List dash_word, String quess, String country){

        for(int i=0; i<country.length();i++) {
            if(quess.charAt(0) == country.charAt(i)){
                dash_word.set(i, quess);

            }
        }return dash_word;

    }

    private static String show_updated_dash_word(List dash_word){

        String new_dash = String.join("", dash_word);

        return new_dash.toUpperCase();
    }

}
