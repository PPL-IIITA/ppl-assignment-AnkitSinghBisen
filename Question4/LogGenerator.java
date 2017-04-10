

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
        /**
	 * GENERATES LOG FILE OF COMMITMENTS GIFTING AND BREAKUP.
	 * @author AnkitSingh Bisen
	 *
	 */


public class LogGenerator {

    public void GenerateLog(String[][] Logdata, int allocations[][], int[][] happiness, int k, gift[] gifts, int a,int counter) {
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
                w.write("\t" + "boy" + allocations[i][0] + " gives ");

                for (j = 0; j < Integer.parseInt(Logdata[i][1]); j++) {
                    w.write(gifts[j].name + " , ");
                }

                w.write(" to " + "girl" + allocations[i][1]);

                w.write("\n");
                w.write("\n");

            }

            DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            Date dateobj = new Date();

            w.write("\nBREAK UP DETAILS: \n ");
            i = a-1;
            while (i != a-1-k) {
                w.write( "\n" +df.format(dateobj)+  "\n  \t Boy" + happiness[i][0] + " and " + "girl" + happiness[i][1] + " BREAK UP");
                i--;
            }

            w.write("\n \nRECOMMITMENT DETAILS OF GIRLS WHO BROKE UP: \n");
            
            for(i=0;i<=counter;i++){
                  w.write(Logdata[a+i][0]);
            }
            
            w.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file log.txt");
        }

    }
}
