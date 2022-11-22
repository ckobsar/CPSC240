import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    private String fileName;
    private ArrayList<State> quiz;

    public Quiz(String fileName){
        File file = new File("stateslist.txt");
        this.fileName = fileName;
        try{
            Scanner in = new Scanner(file);
            quiz = new ArrayList<>();
            while (in.hasNextLine()){
                quiz.add(new State(in));
                in.nextLine();
            }
        }
        catch (Exception stateReadError){
            stateReadError.printStackTrace();
        }
    }
}





