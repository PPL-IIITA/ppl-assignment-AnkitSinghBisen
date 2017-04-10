

import java.util.Random;
        /**
	 * Contains Characteristics of a girl.
	 * @author AnkitSingh Bisen
	 *
	 */

public class girl {

    String name;
    float attractiveness;
    int Maintbudget;
    float intlevel;
    char relstat;
    int exboyfriend;

    String[] gifttypes = {"Choosy", "Normal", "Desperate"};

    Random rand = new Random();

    String type = gifttypes[rand.nextInt(1000) % 3];

    int giftstakentotalprice=0;
    int happiness;
    int couplehappiness;
    float couplecompat;
}
