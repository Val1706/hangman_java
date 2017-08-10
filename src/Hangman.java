import java.util.ArrayList;
import java.util.List;

public class Hangman {
    // Declare the fields that you plan to assign in the constructor
    private String country;
    private String capital;

    public Hangman(String game_country, String game_capital) {
    // Assignments should not re-declare the fields
        this.country = game_country.toUpperCase();
        this.capital = game_capital.toUpperCase();

    }

    public String getCapital(){
        return this.capital;
    }

    public String getCountry(){
        return this.country;
    }


    public List make_dashboard(){

        List<String> dash_list = new ArrayList<String>();
        for (int i = 0; i < this.capital.length(); i++) {
            if (this.capital.charAt(i) == ' ') {
                dash_list.add(" ");
            } else {
                dash_list.add("-");
            }

        }return dash_list;
    }
    
    public List set_new_letters(List dash_word, String quess){

        for(int i=0; i<this.capital.length();i++) {
            if(quess.charAt(0) == this.capital.charAt(i)){
                dash_word.set(i, quess);

            }
        }return dash_word;

    }

    public String show_dash_word(List dash_word){

        String new_dash = String.join("", dash_word);

        return new_dash;
    }
}
