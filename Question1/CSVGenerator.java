
import java.io.*;
import java.util.Random;

// ----- THIS CLASS IS USED TO GENERATE CSV FILES FOR BOYS AND GIRLS.

public class CSVGenerator {

    public static void generateCsvFile(String fileName, String gender, int b, int g) {

        int i;

        Random rand = new Random();

        FileWriter writer = null;
        
        //Generating CSV file for boys.
        if ((gender).equals("male")) {

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
        } else {                    //Generating CSV file for Girls.

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
        }
    }

}
