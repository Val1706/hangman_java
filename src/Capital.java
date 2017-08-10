import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;






public class Capital {

    public static Hangman get_hangman_object() {

        List<String> countries = new ArrayList<String>();




        try {

            String userHome = System.getProperty("user.home");

            //creating File instance to reference text file in Java
            File text = new File(userHome + "/Desktop/hangman_project/src/countries_and_capitals.txt");

            //Creating Scanner instnace to read File in Java
            Scanner scnr = new Scanner(text);

            //Reading each line of file using Scanner class
            while (scnr.hasNextLine()) {
                String line = scnr.nextLine();
                countries.add(line);
            }
            int randomNum = ThreadLocalRandom.current().nextInt(countries.size() + 1);
            String country_capital = countries.get(randomNum);

            String[] country_and_capital = country_capital.split(Pattern.quote(" | "));

            Hangman hangman = new Hangman(country_and_capital[0], country_and_capital[1]);
            return hangman;

        } catch (FileNotFoundException e) {
            System.err.println("Cannot find the file");

        }
        return null;
    }
    }

