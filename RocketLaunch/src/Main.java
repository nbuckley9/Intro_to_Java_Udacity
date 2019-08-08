import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        double budgetSpentU1P1= fullSimulation("U1","Phase-1.txt");

        double budgetSpentU1P2= fullSimulation("U1","Phase-2.txt");

        double budgetSpentU2P1= fullSimulation("U2","Phase-1.txt");

        double budgetSpentU2P2= fullSimulation("U2","Phase-2.txt");

        double totalU1=budgetSpentU1P1+budgetSpentU1P2;
        System.out.println("Total budget spent Phase 1 & 2 for U1: " + totalU1);

        double totalU2=budgetSpentU2P1+budgetSpentU2P2;
        System.out.println("Total budget spent Phase 1 & 2 for U2: " + totalU2);
    }

    public static double fullSimulation(String rocketType, String textFile){
        //create simulation object
        Simulation simulation= new Simulation();

        //create item list for simulation object
        ArrayList<Item> loadedItems= simulation.loadItems(textFile);

        //fill the rockets in simulation object:
        ArrayList<Rocket> loadedRockets=simulation.loadRockets(loadedItems, rocketType);

        double budgetSpent=simulation.runSimulation(loadedRockets);

        System.out.println("Total amount spent on simulation for " + rocketType + " for "+ textFile +" was "+ budgetSpent);

        return budgetSpent;
    }
}
