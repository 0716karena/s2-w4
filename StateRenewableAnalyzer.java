import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;

/**
 * Analyzer for U.S. state renewable electricity data using ArrayList + Scanner
 * + File I/O.
 * CSV expected:
 * Location,TotalGenTWh,PercentRenewable,RenewableGenTWh,PercentOfUSRenewable,CO2MtPerTWh
 */
public class StateRenewableAnalyzer {
    private ArrayList<StateRenewable> states;

    /**
     * Constructor initializes an empty ArrayList.
     */
    public StateRenewableAnalyzer() {
        states = new ArrayList<StateRenewable>();
    }

    /**
     * Reads state data from a CSV file and populates the ArrayList.
     * Assumes the first line is a header.
     * 
     * @param filename path to the CSV file
     * @throws IOException if the file is not found
     */
    public void readFromFile(String filename) throws IOException {


Scanner s = new Scanner(new java.io.File(filename));
        s.nextLine();
        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] items = line.split(",");
            StateRenewable temp = new StateRenewable(
                    items[0],
                    Double.parseDouble(items[1]),
                    Double.parseDouble(items[2]),
                    Double.parseDouble(items[3]),
                    Double.parseDouble(items[4]),
                    Double.parseDouble(items[5]));
            states.add(temp);
        }
    s.close();

    }

    /**
     * Display all states in the list.
     */
    public void displayAllStates() {
        for (StateRenewable s : states) {
            System.out.println(s);
        }

    }

    /**
     * Display states at or above a renewable percent threshold.
     * 
     * @param threshold minimum percent renewable to include
     * @return ArrayList of StateRenewable objects meeting the threshold
     */
    public ArrayList<StateRenewable> displayAbovePercent(double threshold) {
        ArrayList<StateRenewable> temp = new ArrayList<StateRenewable>();
        for (StateRenewable s : states) {
            if (s.isAboveRenewableThreshold(threshold)) {
                temp.add(s);
            }
        }
        return temp;
    }

    /**
     * Find the state with the highest renewable percent.
     * 
     * @return StateRenewable with highest percent, or null if list is empty
     */
    public StateRenewable findHighestPercentRenewable() {
        if (states.size() == 0) {
            return null;
        }
        StateRenewable x = states.get(0);
        for (int i = 1; i < states.size(); i++) {
            StateRenewable a = states.get(i);
            if (a.getPercentRenewable() > x.getPercentRenewable()) {
                x = a;
            }

        }
        return x;
    }

    /**
     * Find the state with the lowest renewable percent.
     * 
     * @return StateRenewable with lowest percent, or null if list is empty
     */
    public StateRenewable findLowestPercentRenewable() {
if (states.size() == 0) {
            return null;
        }
        StateRenewable x = states.get(0);
        for (int i = 1; i < states.size(); i++) {
            StateRenewable a = states.get(i);
            if (a.getPercentRenewable() < x.getPercentRenewable()) {
                x = a;
            }

        }
        return x;    }

    /**
     * Calculate the average renewable percent across all states.
     * 
     * @return average percent, or 0 if list is empty
     */
    public double calculateAveragePercentRenewable() {
                if(states.size()==0){
            return 0;
        }
        double x=0;
        for(StateRenewable s:states){
            x+=s.getPercentRenewable();
        }
        return x/states.size();    }

    /**
     * Calculate total renewable generation (TWh) across all states.
     * 
     * @return sum of renewableGenTWh values
     */
    public double totalRenewableGenTWh() {
        double d = 0;
        for(StateRenewable s:states){
            d+=s.getRenewableGenTWh();
        }return d;
    }

    /**
     * Find the state with the highest renewable generation (TWh).
     * 
     * @return StateRenewable with highest renewableGenTWh, or null if list is empty
     */
    public StateRenewable findHighestRenewableGen() {
if (states.size() == 0) {
            return null;
        }
        StateRenewable x = states.get(0);
        for (int i = 1; i < states.size(); i++) {
            StateRenewable a = states.get(i);
            if (a.getRenewableGenTWh() > x.getRenewableGenTWh()) {
                x = a;
            }

        }
        return x;    }

    /**
     * Display summary statistics.
     */
    public void displayStatistics() {
        displayAllStates();
        System.out.println(displayAbovePercent(15));
        System.out.println(findHighestPercentRenewable());
        System.out.println(findLowestPercentRenewable());
        System.out.println( calculateAveragePercentRenewable());
        System.out.println(totalRenewableGenTWh());
        System.out.println(findHighestRenewableGen());


    }

    /**
     * Helper method to get total number of states (for testing).
     * 
     * @return size of the ArrayList
     */
    public int getTotalStates() {
        return states.size();
    }
}
