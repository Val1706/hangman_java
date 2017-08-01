import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;




public class Hangman {

    public static void main(String[] args) throws IOException {
        // write your code here

        String country = "Africa";
        String big_country = country.toUpperCase();

        List secret_word = make_dashboard(big_country);
        List updated_word = set_new_letters(secret_word,"A", big_country);

        String new_word = show_updated_dash_word(updated_word);
        System.out.println(new_word);
        

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
            if(quess.charAt(0)== country.charAt(i)){
                dash_word.set(i, quess);

            }
        }return dash_word;

    }

    private static String show_updated_dash_word(List dash_word){

        String new_dash = String.join(" ", dash_word);

        return new_dash;
    }

}
