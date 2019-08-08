import java.util.Random;

public class Rocket implements SpaceShip {
    int rocketWeight;
    int maxWeight;
    boolean isU1Rocket;
    static int baseU1Weight=10;
    static int baseU2Weight=18;
    static int maxU1Weight=18;
    static int maxU2Weight=29;
    public static int U1Cost=100;
    public static int U2Cost=120;
    public int rocketCost;

    public Rocket(String rocketType){
        if(rocketType.equals("U1")){
            rocketWeight=baseU1Weight;
            isU1Rocket=true;
            maxWeight=maxU1Weight;
        }
        if(rocketType.equals("U2")){
            rocketWeight=baseU2Weight;
            isU1Rocket=false;
            maxWeight=maxU2Weight;
        }


    }

    public boolean launch(){
        if(isU1Rocket){
            return !(new Random().nextInt(20)==0); //5% chance of exploding
        }
        else{
            return !(new Random().nextInt(25)==0); //4%chance of U2 exploding
        }
    }

    public boolean land(){
        if(isU1Rocket){
            return !(new Random().nextInt(100)==0); //1% chance of crashing
        }
        else{
            int val=new Random().nextInt(25);
            return !(val==0||val==1); //8% chance of crashing
        }
    }

    public boolean isU1Rocket(){
        return isU1Rocket;
    }

    public boolean canCarry(Item item){
        return ((this.rocketWeight+item.getItemWeight())<maxWeight);
        }

    public void carry(Item item){
        //update current weight of rocket
        this.rocketWeight+=item.getItemWeight();
    }

    public int getRocketWeight(){
        return this.rocketWeight;
    }

    public int getRocketCost(){
        if (this.isU1Rocket){
            rocketCost=U1Cost;
        }
        else{
            rocketCost=U2Cost;
        }
        return rocketCost;
    }



}
