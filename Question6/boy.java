

import java.util.Random;
        /**
	 * Contains Characteristics of a boy.
	 * @author AnkitSingh Bisen
	 *
	 */

public class boy {

    String name;
    float attractiveness;
    int budget;
    float intelligence;
    float minatreq;
    char relstat;
    int exgirlfriend;

    String[] gifttypes = {"Miser", "Generous", "Geeks"};

    Random rand = new Random();

    String type = gifttypes[rand.nextInt(1000) % 3];
    
    int numberofgiftsgiven;
    int giftsgiventotalprice=0;
    int happiness;
}
