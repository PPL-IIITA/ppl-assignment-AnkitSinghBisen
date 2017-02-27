
import java.util.Random;

// ----- THIS CLASS CONTAINS ATTRIBUTES OF A BOY.


public class boy {

    String name;
    float attractiveness;
    int budget;
    float intelligence;
    float minatreq;
    char relstat;

    String[] gifttypes = {"Miser", "Generous", "Geeks"};

    Random rand = new Random();

    String type = gifttypes[rand.nextInt(1000) % 3];   //RANDOMLY ASSIGNING A TYPE TO A BOY. 
    
    int numberofgiftsgiven;
    int giftsgiventotalprice=0;
    int happiness;
}
