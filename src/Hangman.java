import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hangman {

    public static void main(String[] args) throws IOException {
        // write your code here

        String country = "Africa lalala";
        String big_country = country.toUpperCase();
        String secret_word = make_dashboard(big_country);
        System.out.println(secret_word);




    }

    private static String make_dashboard(String x){

        List<String> dash_list = new ArrayList<String>();
        for (int i = 0; i < x.length(); i++) {
            if(x.charAt(i) == ' '){
                dash_list.add(" ");
            }else{
                dash_list.add("-");
            }
        }
        String listString = String.join(" ", dash_list);

        return listString;
    }
}


