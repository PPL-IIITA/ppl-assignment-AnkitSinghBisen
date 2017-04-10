

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

         /**
	 * Handles the program.
         * @author AnkitSingh Bisen
	 *
	 */


public class PPLQ4 {

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
        int i;
        int j;

        int a;                                                              //Number of commitments made.

        //Allocating boyfriends to all girls and generating gift basket.
        a = CommitmentsGifts.CommitandGift(boys, girls, gifts, allocations, b, g, gif, Logdata);

        int[][] happiness = new int[500][500];
        int[][] compatibility = new int[500][500];

        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");           //For date and time stamp.
        Date dateobj = new Date();

        //Printing Commitment and Gifting details.
        for (i = 0; i < a; i++) {
            System.out.println(df.format(dateobj) + "\n" + "Commitment Details:" + "\n" + "\t" + "boy" + allocations[i][0] + " and " + "girl" + allocations[i][1] + " get committed.");
            System.out.println("Gift Basket Details :");
            j = 0;

            System.out.print("\t" + "boy" + allocations[i][0] + " gives ");

            while (j < boys[allocations[i][0]].numberofgiftsgiven) {

                System.out.print(gifts[j].name + ",");
                j++;

            }

            System.out.println(" to " + "girl" + allocations[i][1]);

            System.out.println("\n");

            happiness[i][0] = allocations[i][0];
            happiness[i][1] = allocations[i][1];
            compatibility[i][0] = allocations[i][0];
            compatibility[i][1] = allocations[i][1];
        }

        //Sorting couples in Ascending order of happiness and compatibility.
        KHappyCompat.sortcouples(happiness, compatibility, girls, a);

        Random rand = new Random();
        int k = 2 + rand.nextInt(a - 2);          // Set k for any given value(here a random number is taken, k=2 minimum).

        //Printing k least happy and compatible couples.
        System.out.println("list of " + k + " least happy couples in descending order of Happiness is :");

        i = a - 1;                         //Array happiness is sorted in ascending order so we start from the end.
        int counter = -1;       //to count number of girls who broke up and again got committed.
        while (i != a - 1 - k) {
            System.out.println("\t" + "Boy" + happiness[i][0] + " and " + "girl" + happiness[i][1]);
            System.out.println("\t \t -" + "Boy" + happiness[i][0] + " and " + "girl" + happiness[i][1] + " BREAK UP");
            for (j = 0; j < b; j++) {
                if ((boys[j].budget > girls[i].Maintbudget) && (girls[i].attractiveness > boys[j].minatreq) && (boys[j].relstat == 's') && (j != happiness[i][0])) {

                    counter++;
                    boys[j].relstat = 'c';
                    girls[i].relstat = 'c';
                    allocations[a][0] = j;
                    allocations[a][1] = i;

                    Logdata[a + counter][0] = (df.format(dateobj) + "\n" + "Commitment Details:" + "\n" + "\t" + "boy" + j + " and " + "girl" + happiness[i][1] + " get committed." + "\n");
                    break;
                }
            }

            i--;
        }
        //Generating Log file.
        LogGenerator log = new LogGenerator();
        log.GenerateLog(Logdata, allocations, happiness, k, gifts, a, counter);

        //printing newly formed couples.
        for(i=0;i<=counter;i++){
            System.out.println(Logdata[a+i][0]);
        }
        
    }

}
