

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

        /**
	 * Generates Log file.
	 * @author AnkitSingh Bisen
	 *
	 */

public class LogGenerator {

    public void GenerateLog(String[][] Logdata, int allocations[][], gift[] gifts, int a) {
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
                    w.write("\t" + "boy" + (allocations[i][0]+1) + " gives " + gifts[j].name + " to " + "girl" + (allocations[i][1]+1));
                    w.write("\n");
                }

                w.write("\n");
                w.write("\n");
            }
            w.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file log.txt");
        }

    }
}
