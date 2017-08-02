import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Database {

    public static void get_country(){

        try {

            //creating File instance to reference text file in Java
            File text = new File("/Users/valik/Desktop/hangman_project/src/countries_and_capitals.txt");

            //Creating Scanner instnace to read File in Java
            Scanner scnr = new Scanner(text);

            //Reading each line of file using Scanner class
            while (scnr.hasNextLine()) {
                String line = scnr.nextLine();
                System.out.println(line);

            }

        } catch (FileNotFoundException e) {
            System.err.println("Cannot find the file");
        }
    }
}



