

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

        /**
	 * Handles other classes , makes new couples if possible after t days.
	 * @author AnkitSingh Bisen
	 *
	 */

public class PPLQ6 {

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

                System.out.print(gifts[j].name + ", ");
                j++;

            }
            System.out.println(" to " + "girl" + allocations[i][1]);

            System.out.println("\n");

            happiness[i][0] = allocations[i][0];
            happiness[i][1] = allocations[i][1];
            compatibility[i][0] = allocations[i][0];
            compatibility[i][1] = allocations[i][1];
        }

        int loglength = a;

        //Sorting couples in Ascending order of happiness and compatibility.
        KHappyCompat.sortcouples(happiness, compatibility, girls, a);

        int k = a;          // Set k for any given value.

        Random rand = new Random();
        int t = 1 + rand.nextInt(15);          // Set k for any given value(here a random number is taken, k=2 minimum).
        System.out.println("Now t is chosen randomly to be " + t);

        int giftexchangespermonth, count = 0;

        for (giftexchangespermonth = 0; giftexchangespermonth <= 31; giftexchangespermonth = giftexchangespermonth + t) {

            if (giftexchangespermonth + t >= 31) {
                break;
            }

            for (i = 0; i < a; i++) {
                girls[allocations[i][1]].couplehappiness = (Math.abs(girls[allocations[i][1]].couplehappiness)) % 30;
            }

            System.out.println("Couples having happiness less than t are :");
            for (i = 0; i < a; i++) {
                if (girls[allocations[i][1]].couplehappiness < t) {
                    System.out.println("boy" + allocations[i][0] + " and " + "girl" + allocations[i][1] + " - happiness :" + girls[allocations[i][1]].couplehappiness);
                    System.out.println("\t\t -They BREAK UP");
                    Logdata[loglength][0] = (df.format(dateobj) + "\n" + "boy" + allocations[i][0] + " and " + "girl" + allocations[i][1] + " BREAK UP");
                    loglength++;
                    boys[allocations[i][0]].relstat = 's';
                    girls[allocations[i][1]].relstat = 's';
                    boys[allocations[i][0]].exgirlfriend = allocations[i][1];
                    girls[allocations[i][1]].exboyfriend = allocations[i][0];
                    boys[allocations[i][0]].giftsgiventotalprice = 0;
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("No couples have happiness less than t . Therefore , program terminates");
                break;
            } else {
                System.out.println("Newlyformed set of couples are :");

                a = CommitmentsGifts.CommitandGift(boys, girls, gifts, allocations, b, g, gif, Logdata);

                for (i = 0; i < a; i++) {
                    System.out.println(df.format(dateobj) + "\n" + "Commitment Details:" + "\n" + "\t" + "boy" + allocations[i][0] + " and " + "girl" + allocations[i][1] + " get committed.");
                    Logdata[loglength][0] = (df.format(dateobj) + "\n" + "Commitment Details:" + "\n" + "\t" + "boy" + allocations[i][0] + " and " + "girl" + allocations[i][1] + " get committed." + "\n");
                    loglength++;

                    System.out.println("Gift Basket Details :");
                    j = 0;

                    System.out.print("\t" + "boy" + allocations[i][0] + " gives ");

                    while (j < boys[allocations[i][0]].numberofgiftsgiven) {

                        System.out.print(gifts[j].name + ", ");
                        j++;

                    }
                    System.out.println(" to " + "girl" + allocations[i][1]);

                    System.out.println("\n");

                    happiness[i][0] = allocations[i][0];
                    happiness[i][1] = allocations[i][1];
                    compatibility[i][0] = allocations[i][0];
                    compatibility[i][1] = allocations[i][1];
                    count = 0;
                }
            }
        }

                //Generating Log file.
        LogGenerator log = new LogGenerator();
        log.GenerateLog(Logdata, allocations, gifts, a,loglength);

    }
}
