

import java.util.Random;

        /**
	 * Contains attributes  of a gift.
	 * @author AnkitSingh Bisen
	 *
	 */

public class gift {

    String name;
    int price;
    Float value;
    
    
   String[] gifttypes = {"Essential","Utility","Luxury"};
        
    Random rand = new Random();

    String type = gifttypes[rand.nextInt(1000) % 3]; //RANDOMLY ASSIGNING A TYPE TO A GIFT. 

    
}
