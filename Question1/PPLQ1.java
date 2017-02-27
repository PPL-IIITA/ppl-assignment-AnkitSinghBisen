
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PPLQ1 {

    public static void main(String[] args) {

        int b = 20;                   //Number of boys to be created in CSV file.
        int g = 8;                  //Number of girls to be created in CSV file.

        //Generating CSV files for boys and girls.
        String location = "newCsvFileboys.csv";
        CSVGenerator.generateCsvFile(location, "male", b, g);
        location = "newCsvFilegirls.csv";
        CSVGenerator.generateCsvFile(location, "female", b, g);

        //Arrays to store data about boys and girls from csv files.
        Boy[] boys = new Boy[1000];
        Girl[] girls = new Girl[500];

        //Fetching data from CSV files And storing it into Arrays.
        GetDataFromCsv.getdata(boys, girls);

        
        String allocations[] = new String[500];      //Holds information about Commitments.

        int i, j;
        int a = 0;        //Number of commitments made.

        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");     //For date and time stamp purposes. 
        Date dateobj = new Date();
        

        //Allocating boyfriends to all girls.

        for (i = 0; i < g; i++) {

            for (j = 0; j < b; j++) {

                if ((boys[j].budget > girls[i].Maintbudget) && (girls[i].attractiveness > boys[j].minatreq) && (boys[j].relstat == 's')) {

                    boys[j].relstat = 'c';
                    girls[i].relstat = 'c';
                    allocations[a] = df.format(dateobj) + "\n" + boys[j].name + " and " + girls[i].name + " get committed.";
                    a++;
                    break;
                }

            }

        }
        
        //Generating Logs about the commitments.
        LogGenerator log = new LogGenerator();
        log.GenerateLog(allocations, a);

        //Printing Commitments and logs.
        for (i = 0; i < a; i++) {
            System.out.println(allocations[i] + "\n");

        }

    }

}
