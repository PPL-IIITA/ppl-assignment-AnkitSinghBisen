
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

// ------ THIS CLASS IS USED FOR GENERATING LOG FILE.

public class LogGenerator {

    public void GenerateLog(String allocations[], int a) {
        try {
            //Whatever the file path is.
            File statText = new File("log.txt");
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);

            int i;

            for (i = 0; i < a; i++) {
                w.write(allocations[i]);
                w.write("\n");
                w.write("\n");
            }
            w.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file log.txt");
        }

    }
}
