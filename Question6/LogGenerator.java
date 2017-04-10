

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

        /**
	 * Generates log file of commitments ,gifting and breakups.
	 * @author AnkitSingh Bisen
	 *
	 */


// ------- THIS CLASS GENERATES LOG FILE OF COMMITMENTS AND GIFTING.
public class LogGenerator {

    public void GenerateLog(String[][] Logdata, int allocations[][], gift[] gifts, int a, int loglength) {
        try {
            //Whatever the file path is.
            File statText = new File("log.txt");
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);

            int i;
            int j;

            for (i = 0; i < a; i++) {

                w.write(Logdata[i][0]);
                w.write("Gift Basket Details :");
                w.write("\n");

                for (j = 0; j < Integer.parseInt(Logdata[i][1]); j++) {
                    w.write("\t" + "boy" + allocations[i][0] + " gives " + gifts[j].name + " to " + "girl" + allocations[i][1]);
                    w.write("\n");
                }

                w.write("\n");
                w.write("\n");
            }

            for (i = a; i < loglength; i++) {
                w.write("\n"+Logdata[i][0] + "\n");

            }
            w.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file log.txt");
        }

    }
}
