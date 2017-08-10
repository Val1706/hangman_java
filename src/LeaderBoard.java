import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LeaderBoard {
    public static void write_record(String name, Integer score, Integer quessed_words, long time) {

        try {


            FileWriter fw = new FileWriter("/Users/valik/Desktop/hangman_project/src/records.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(score.toString());
            bw.write(","+name);
            bw.write(","+ time);
            bw.write("," + quessed_words);
            bw.newLine();
            bw.close();

        } catch (IOException e) {
            System.err.println("Cannot find the file");
        }
    }

    public static void read_record() {

        List<Player> all_records = new ArrayList<Player>();


        try {
            File text = new File("/Users/valik/Desktop/hangman_project/src/records.txt");
            Scanner scnr = new Scanner(text);

            String format = "|%1$-10s|%2$-10s|%3$-10s|%4$-20s\n";
            String format_2 = "%1$-11s%2$-12s%3$-9s%4$-8s\n";

            System.out.format(format_2, "Score", "Name", "Time", "Quessed words");

            while (scnr.hasNextLine()) {

                String line = scnr.nextLine();
                String [] new_line = line.split(",");
                String score = new_line[0];
                String name = new_line[1];
                String time = new_line[2];
                String quessed_words = new_line[3];

                int score_number = Integer.parseInt(score);
                int quessed_words_number = Integer.parseInt(quessed_words);
                long time_long = Long.parseLong(time, 10);


                Player player = new Player(score_number, 0);

                player.setName(name);
                player.setTime(time_long);
                player.setQuessedWords(quessed_words_number);

                all_records.add(player);


            }
            all_records.sort((Player o1, Player o2)->o1.getScore()-o2.getScore());
            Collections.reverse(all_records);

            for (Player player: all_records) {
                System.out.format(format, player.getScore(), player.getName(), player.getTime()+"s", player.getGuessedWords());
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("Cannot find the file");
        }
    }
}


