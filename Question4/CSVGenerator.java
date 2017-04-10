

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

        /**
	 *Creates Boys, Girls and Creates CSV of their characterstics. 
	 * @author AnkitSingh Bisen
	 *
	 */

public class CSVGenerator {

    public static void generateCsvFile(String fileName, String type, int b, int g, int gifts) {

        int i;

        Random rand = new Random();

        FileWriter writer = null;

        //Creating CSV file for boys.
        if ((type).equals("boys")) {

            try {

                writer = new FileWriter(fileName);

                for (i = 1; i <= b; i++) {
                    writer.append("Boy" + i);
                    writer.append(',');
                    writer.append(Float.toString(rand.nextFloat() * 10.0f + 0.0f));
                    writer.append(',');
                    writer.append(Integer.toString(rand.nextInt(10000) + 1000));
                    writer.append(',');
                    writer.append(Float.toString(rand.nextFloat() * 10.0f + 0.0f));
                    writer.append(',');
                    writer.append(Float.toString(rand.nextFloat() * 10.0f + 0.0f));

                    writer.append('\n');
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if ((type).equals("girls")) {      //Creating CSV file for Girls.

            try {

                writer = new FileWriter(fileName);

                for (i = 1; i <= g; i++) {

                    writer.append("Girl" + i);
                    writer.append(',');
                    writer.append(Float.toString(rand.nextFloat() * 10.0f + 0.0f));
                    writer.append(',');
                    writer.append(Integer.toString(rand.nextInt(10000) + 1000));
                    writer.append(',');
                    writer.append(Float.toString(rand.nextFloat() * 10.0f + 0.0f));

                    writer.append('\n');
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {                //Creating CSV file for Gifts.

            try {

                writer = new FileWriter(fileName);

                for (i = 1; i <= gifts; i++) {

                    writer.append("Gift" + i);
                    writer.append(',');
                    writer.append(Integer.toString(rand.nextInt(10000) + 1000));
                    writer.append(',');
                    writer.append(Float.toString(rand.nextFloat() * 10.0f + 0.0f));

                    writer.append('\n');
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}
