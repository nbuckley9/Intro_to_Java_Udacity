//class that is responsible for reading item data and filling up the rockets.


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    String rocketType;

    public Simulation(){


    }
// this method loads all items from a text file and returns an ArrayList of Items:
    ArrayList<Item> loadItems(String filename) {
        String itemInput[]=new String[]{};
        ArrayList<Item> loadedItems= new ArrayList<>();
        File file = new File("Phase-1.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                itemInput = line.split("=");
                String item=itemInput[0];
                int weight= Integer.parseInt(itemInput[1]);
                Item newItem= new Item(item,weight);
                loadedItems.add(newItem);
            }
        }catch(FileNotFoundException ex){
            System.out.println("Filenotfound");
        }
        return loadedItems;
        }

    //
    ArrayList<Rocket> loadRockets(ArrayList loadedItems, String rocketType){
        ArrayList<Rocket> Rockets= new ArrayList<>();
        this.rocketType = rocketType;
        while (loadedItems.size()>0){
            //if there is a rocket at end of U1Rockets that can hold item, add it to that rocket,
            //else create new rocket
            Item nextItem=(Item)loadedItems.remove(0);

            if(Rockets.size()<=0){
                Rocket newRocket= new Rocket(rocketType);
                Rockets.add(newRocket);
                newRocket.carry(nextItem);
            }
            else{
                if(Rockets.get(Rockets.size()-1).canCarry(nextItem)){
                    Rockets.get(Rockets.size()-1).carry(nextItem);
                    //System.out.println(U1Rockets.get(U1Rockets.size()-1).getRocketWeight());
                }
                else{
                    Rocket newRocket= new Rocket(rocketType);
                    Rockets.add(newRocket);
                    newRocket.carry(nextItem);
                }
            }
        }
    return Rockets;
    }

    public double runSimulation(ArrayList<Rocket> rockets){
        double budget=0.0;
        for(Rocket rocket:rockets){
            budget+=rocket.getRocketCost();
            while(!((rocket.launch() && rocket.land()))){
                budget+=rocket.getRocketCost();
            }

        }
        return budget;
    }
}
