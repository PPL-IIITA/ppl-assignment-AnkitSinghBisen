
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// ----- THIS CLASS FETCHES DATA FROM CSV FILE AND STORES IT INTO ARRAY FOR COMPUTATION AND MANIPULATION.

public class GetDataFromCsv {

    public static void getdata(boy[] boys, girl[] girls, gift[] gifts) {

        //Variable to calculate no. of boys and girls from csv File.
        int b = 0;
        int g = 0;
        int gif = 0;

        //Storing data from csv files to arrays.
        String csvFileb = "newCsvFileboys.csv";
        BufferedReader brb = null;
        String lineb = "";
        String cvsSplitByb = ",";

        //For boys
        try {

            brb = new BufferedReader(new FileReader(csvFileb));
            while ((lineb = brb.readLine()) != null) {

                String[] table = lineb.split(cvsSplitByb);

                boys[b] = new boy();

                boys[b].name = table[0];
                boys[b].attractiveness = Float.parseFloat(table[1]);
                boys[b].budget = Integer.parseInt(table[2]);
                boys[b].intelligence = Float.parseFloat(table[3]);
                boys[b].minatreq = Float.parseFloat(table[4]);
                boys[b].relstat = 's';//s-single ; c-committed

                b++;

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (brb != null) {
                try {
                    brb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
       //For Girls.
        String csvFileg = "newCsvFilegirls.csv";
        BufferedReader brg = null;
        String lineg = "";
        String cvsSplitByg = ",";

        try {

            brg = new BufferedReader(new FileReader(csvFileg));
            while ((lineg = brg.readLine()) != null) {

                String[] table = lineg.split(cvsSplitByg);

                girls[g] = new girl();

                girls[g].name = table[0];
                girls[g].attractiveness = Float.parseFloat(table[1]);
                girls[g].Maintbudget = Integer.parseInt(table[2]);
                girls[g].intlevel = Float.parseFloat(table[3]);
                girls[g].relstat = 's';//s-single c-committed

                g++;

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (brg != null) {
                try {
                    brg.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //For Gifts.
        String csvFilegif = "gifts.csv";
        BufferedReader brgif = null;
        String linegif = "";
        String cvsSplitBygif = ",";

        try {

            brgif = new BufferedReader(new FileReader(csvFilegif));
            while ((linegif = brgif.readLine()) != null) {

                String[] table = linegif.split(cvsSplitBygif);

                gifts[gif] = new gift();

                gifts[gif].name = table[0];
                gifts[gif].price = Integer.parseInt(table[1]);
                gifts[gif].value = Float.parseFloat(table[2]);

                gif++;

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (brg != null) {
                try {
                    brg.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
