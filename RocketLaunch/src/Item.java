

public class Item {
    String name="";
    int weight=0;

    public Item(String name, int weight){
        this.name=name;
        this.weight=weight/1000;
    }

    public String getItemName(){
        return name;
    }

    public int getItemWeight(){
        return weight;
    }
}
