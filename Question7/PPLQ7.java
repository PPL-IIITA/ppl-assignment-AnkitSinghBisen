

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
        /**
	 * handles classes and decides method to find if a boy is committed or not.
	 * @author AnkitSingh Bisen
	 *
	 */


public class PPLQ7 {

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
        int[][] couples = new int[500][2];
        int i, j;
        int a = 0;        //Number of commitments made.

        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");     //For date and time stamp purposes. 
        Date dateobj = new Date();

        System.out.println("Commitments are being made ...");

        //Allocating boyfriends to all girls.
        for (i = 0; i < g; i++) {

            for (j = 0; j < b; j++) {

                if ((boys[j].budget > girls[i].Maintbudget) && (girls[i].attractiveness > boys[j].minatreq) && (boys[j].relstat == 's')) {

                    boys[j].relstat = 'c';
                    girls[i].relstat = 'c';
                    allocations[a] = df.format(dateobj) + "\n" + boys[j].name + " and " + girls[i].name + " get committed.";
                    System.out.println(allocations[a]);
                    couples[a][0] = j;
                    couples[a][1] = i;
                    a++;
                    break;
                }

            }

        }

        //Generating Logs about the commitments.
        LogGenerator log = new LogGenerator();
        log.GenerateLog(allocations, a);

        System.out.println("We create a random list of boys and check whether a boy has a girlfriend or not.\n");
        int[] list = {3, 18, 15, 4, 7, 10, 2, 17, 6, 9};                 //creating a random list . ex boy0,boy19,boy15 etc

        System.out.println("The random list of boys is :");
        for (i = 0; i < list.length; i++) {
            System.out.println("boy" + list[i]);
        }
        int temp;

        while (true) {
            System.out.println("Whether a boy has a girlfriend or not can be found in three ways .  \n 1.For simple array method - Press a \n 2.For Binary Search - Press b \n 3.For Hash table method - Press c\n4.if You dont want to choose(default method)-press d \n 5. To quit - press q ");
            Scanner reader = new Scanner(System.in);
            //   searchtype=scan.next().charAt(0);
            char searchtype = reader.next().charAt(0);

            if (searchtype == 'a' || searchtype == 'd') {
                Boy.FindGfArray(list, couples, a);
                break;
            } else if (searchtype == 'b') {

                for (i = 0; i < a; i++) {

                    for (j = i; j < a; j++) {
                        if (couples[j][0] < couples[i][0]) {
                            temp = couples[j][0];
                            couples[j][0] = couples[i][0];
                            couples[i][0] = temp;

                            temp = couples[j][1];
                            couples[j][1] = couples[i][1];
                            couples[i][1] = temp;

                        }
                    }
                }

                for (i = 0; i < list.length; i++) {
                    Boy.FindGfBinarySearch(couples, list[i], 0, a - 1);
                }
                break;
            } else if (searchtype == 'c') {
                Boy.FindGfHashTable(list, couples, a);
                break;
            } else {
                if(searchtype!='q'){
                System.out.println("Invalid Input. ");
                }
                System.out.println("Quitting program..");

                break;
            }
        }
    }
}
