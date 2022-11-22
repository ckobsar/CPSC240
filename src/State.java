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
}
