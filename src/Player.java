import java.util.ArrayList;
import java.util.List;


public class Player {

    private int score;
    private int lifes;

    private int quessed_words = 0;
    private int trials = 0;

    private long time;

    private String name;
    private String quess;

    private List<String> used_letters = new ArrayList<String>();

    public Player(int score, int life) {
        // Assignments should not re-declare the fields
        this.score = score;
        this.lifes = life;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int points) {
        this.score += points;

        if(this.score < 0){
            this.score = 0;
        }
    }

    public void add_score_if_full_word_is_quessed() {

        if (this.trials == 1) {
            setScore(300);
        } else if (this.trials == 2) {
            setScore(200);
        } else if (this.trials == 3) {
            setScore(150);
        } else if (this.trials == 4) {
            setScore(100);
        } else {
            setScore(5);
        }
        this.trials = 0;
    }

    public String getQuess(){
        return this.quess;
    }

    public void setQuess(String word){
        this.quess = word;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTrials(int trials) {
        this.trials = trials;
    }

    public void addTrials(int trials) {
        this.trials += trials;
    }

    public int getGuessedWords(){
        return this.quessed_words;
    }

    public void setQuessedWords(int number){
        this.quessed_words += number;
    }

    public int getLifes(){
        return this.lifes;
    }

    public void setLifes(int life){
        this.lifes += life;
    }

    public long getTime(){
        return this.time;
    }

    public void setTime(long time){
        this.time = time;
    }

    public List<String> getUsedLetters(){
        return this.used_letters;
    }

    public void addUsedLetters(String quess){
        this.used_letters.add(quess);
    }

    public void clearUsedLetters(){

        this.used_letters.clear();
    }
    public void set_life_and_score_for_new_game() {

        this.score = 0;
        this.lifes = 5;
        this.trials = 1;
        this.quessed_words = 0;
    }


}
