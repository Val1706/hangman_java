import java.util.ArrayList;
import java.util.List;

public class Player {

    Integer score = 0;
    Integer lifes = 5;
    Integer trials = 0;

    String name;
    String quess;

    List<String> used_letters = new ArrayList<String>();

    public void add_score() {

        this.score += 10;
    }

    public void add_score_if_full_word_is_quessed() {
        if (this.trials == 1) {
            this.score += 300;
        } else if (this.trials == 2) {
            this.score += 200;
        } else if (this.trials == 3) {
            this.score += 150;
        } else if (this.trials == 4) {
            this.score += 100;
        } else {
            this.score += 5;
        }
        this.trials = 0;
    }


    public void add_trials() {

        this.trials++;
    }



    public void minus_score_and_lifes() {

        this.score -= 10;
        this.lifes--;
    }

    public void add_used_letters() {

        this.used_letters.add(this.quess);
    }
    public void set_life_and_score_for_new_game() {

        this.score = 0;
        this.lifes = 5;
        this.trials = 0;
    }


}
