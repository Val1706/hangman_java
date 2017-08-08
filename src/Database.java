import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;


public class Database {

    public static Hangman get_hangman_object() {

        List<String> countries = new ArrayList<String>();

        try {

            //creating File instance to reference text file in Java
            File text = new File("/Users/valik/Desktop/hangman_project/src/countries_and_capitals.txt");

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

    public static void write_record(String name, Integer score) {

        try {


            FileWriter fw = new FileWriter("/Users/valik/Desktop/hangman_project/src/records.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(score.toString());
            bw.write(" " + name);
            bw.newLine();
            bw.close();

        } catch (IOException e) {
            System.err.println("Cannot find the file");
        }
    }

    public static void read_record() {

        List<String> all_records = new ArrayList<String>();

        try {
            File text = new File("/Users/valik/Desktop/hangman_project/src/records.txt");
            Scanner scnr = new Scanner(text);
            while (scnr.hasNextLine()) {
                String line = scnr.nextLine();
                all_records.add(line);
            }
            Collections.sort(all_records);
            Collections.reverse(all_records);

            for (int i = 0; i < all_records.size(); i++) {

                Integer num = i + 1;
                System.out.println(num +". " + all_records.get(i));

            }

        } catch (FileNotFoundException e) {
            System.err.println("Cannot find the file");
        }
    }
}




