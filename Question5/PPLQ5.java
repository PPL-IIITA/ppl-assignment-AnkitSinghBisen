

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
        /**
	 * Handles other classes , Prints K most happy couples.
	 * @author AnkitSingh Bisen
	 *
	 */

public class PPLQ5 {

    public static void main(String[] args) {

        //Number of boys, girls and gifts to be created in CSV file.
        int b = 20;
        int g = 8;
        int gif = 50;

        //Generating csv files for boys, girls and gifts.
        String location = "newCsvFileboys.csv";
        CSVGenerator.generateCsvFile(location, "boys", b, g, gif);

        location = "newCsvFilegirls.csv";
        CSVGenerator.generateCsvFile(location, "girls", b, g, gif);

        location = "gifts.csv";
        CSVGenerator.generateCsvFile(location, "gifts", b, g, gif);

        //Arrays to store data about boys ,girls and gifts from CSV files.
        boy[] boys = new boy[1000];
        girl[] girls = new girl[500];
        gift[] gifts = new gift[50];

        GetDataFromCsv.getdata(boys, girls, gifts);                      //Fetching data from CSV files.

        int allocations[][] = new int[500][2];                           //Holds information about commitments.
        String[][] Logdata = new String[500][2];                          //Holds information of date and time for LOG.
        int i = 0;
        int j = 0;

        int a;                                                              //Number of commitments made.

        a = Commitments.MatchMaker(boys, b, girls, g, gifts, gif, allocations, Logdata);         //Commitments

        int[][] happiness = new int[500][500];
        int[][] compatibility = new int[500][500];

        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");           //For date and time stamp.
        Date dateobj = new Date();

        //Printing Commitment and Gifting details.
        for (i = 0; i < a; i++) {
            System.out.println("\n"+df.format(dateobj) + "\n" + "Commitment Details:" + "\n" + "\t" + "boy" + (allocations[i][0] + 1) + " and " + "girl" + (allocations[i][1] + 1) + " get committed.");
            System.out.println("Gift Basket Details :");
            j = 0;
            while (j < boys[allocations[i][0]].numberofgiftsgiven) {

                System.out.println("\t" + "boy" + (allocations[i][0] + 1) + " gives " + gifts[j].name + " to " + "girl" + (allocations[i][1] + 1)+".");
                j++;

            }
            System.out.print("\n");

            happiness[i][0] = allocations[i][0];
            happiness[i][1] = allocations[i][1];
            compatibility[i][0] = allocations[i][0];
            compatibility[i][1] = allocations[i][1];
        }

        //Generating Log file.
        LogGenerator log = new LogGenerator();
        log.GenerateLog(Logdata, allocations, gifts, a);

        //Sorting couples in Ascending order of happiness and compatibility.
        KHappyCompat.sortcouples(happiness, compatibility, girls, a);

        Random rand = new Random();
        int k = 2 + rand.nextInt(a - 2);          // Set k for any given value(here a random number is taken, k=2 minimum).

        System.out.println("list of K most happy couples in descending order of Happiness is :");
        for (i = 0; i < k; i++) {
            System.out.println("\t"+ (i+1) + ". Boy" + happiness[i][0] + " and " + "girl" + happiness[i][1] +".");
        }


    }

}
