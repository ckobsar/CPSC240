import java.util.Scanner;

public class State {
    private String stateName;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private int correctAns;

    public State(Scanner in) {
        this.stateName = in.nextLine();
        this.choice1 = in.nextLine();
        this.choice2 = in.nextLine();
        this.choice3 = in.nextLine();
        this.choice4 = in.nextLine();
        this.correctAns = in.nextInt();
    }
    public String getStateName() {
        return stateName;
    }

    public String getChoice2() {
        return choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public int getCorrectAns() {
        return correctAns;
    }

    public String getChoice4() {
        return choice4;
    }

    public String getChoice1() {
        return choice1;
    }
}
