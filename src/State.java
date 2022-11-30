import java.util.Scanner;
import java.util.ArrayList;
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
    // Here I ccould have created a Map with State and its capitols, but
    // I chose this instead. Two arraylists the first will contain states, and
    // the second capitol names.
    private ArrayList<String> states = new ArrayList<>();
    private ArrayList<String> capitols = new ArrayList<>();

    // this will return an arraylist containing all 50 state's capitol names
    public ArrayList<String> getCapitolName(){

        capitols.add("Montgomery");
        capitols.add("Juneau");
        capitols.add("Phoenix");
        capitols.add("Little Rock");
        capitols.add("Sacramento");
        capitols.add("Denver");
        capitols.add("Hartford");
        capitols.add("Dover");
        capitols.add("Tallahassee");
        capitols.add("Atlanta");

        capitols.add("Honolulu");
        capitols.add("Boise");
        capitols.add("Springfield");
        capitols.add("Indianapolis");
        capitols.add("Des Moines");
        capitols.add("Topeka");
        capitols.add("Frankfort");
        capitols.add("Baton Rouge");
        capitols.add("Augusta");
        capitols.add("Annapolis");

        capitols.add("Boston");
        capitols.add("Lansing");
        capitols.add("St. Paul");
        capitols.add("Jackson");
        capitols.add("Jefferson City");
        capitols.add("Helena");
        capitols.add("Lincoln");
        capitols.add("Carson City");
        capitols.add("Concord");
        capitols.add("Trenton");
        capitols.add("Santa Fe");

        capitols.add("Albany");
        capitols.add("Raleigh");
        capitols.add("Bismarck");
        capitols.add("Columbus");
        capitols.add("Oklahoma City");
        capitols.add("Salem");
        capitols.add("Harrisburg");
        capitols.add("Providence");
        capitols.add("Columbia");
        capitols.add("Pierre");
        capitols.add("Nashville");
        capitols.add("Austin");
        capitols.add("Salt Lake City");
        capitols.add("Montpelier");
        capitols.add("Richmond");
        capitols.add("Olympia");
        capitols.add("Charleston");
        capitols.add("Madison");
        capitols.add("Cheyenne");

        return capitols;

    }
    // this will return state names, this also returns an arraylist.

    public ArrayList<String> getStateName(){

        states.add("Alabama");
        states.add("Alaska");
        states.add("Arizona");
        states.add("Arkansas");
        states.add("California");
        states.add("Colorado");
        states.add("Connecticut");
        states.add("Delaware");
        states.add("Florida");
        states.add("Georgia");
        states.add("Hawaii");
        states.add("Idaho");
        states.add("Illinois");
        states.add("Indiana");
        states.add("Iowa");
        states.add("Kansas");
        states.add("Kentucky");
        states.add("Louisiana");
        states.add("Maine");
        states.add("Maryland");
        states.add("Massachusetts");
        states.add("Michigan");
        states.add("Minnesota");
        states.add("Mississippi");
        states.add("Missouri");
        states.add("Montana");
        states.add("Nebraska");
        states.add("Nevada");
        states.add("New Hampshire");
        states.add("New Jersey");
        states.add("New Mexico");
        states.add("New York");
        states.add("North Carolina");
        states.add("North Dakota");
        states.add("Ohio");
        states.add("Oklahoma");
        states.add("Oregon");
        states.add("Pennsylvania");
        states.add("Rhode Island");
        states.add("South Carolina");
        states.add("South Dakota");
        states.add("Tennessee");
        states.add("Texas");
        states.add("Utah");
        states.add("Vermont");
        states.add("Virginia");
        states.add("Washington");
        states.add("West Virginia");
        states.add("Wisconsin");
        states.add("Wyoming");


        return states;
    }
}