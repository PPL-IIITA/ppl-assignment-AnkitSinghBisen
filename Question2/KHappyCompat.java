
//--------- THIS CLASS HELPS TO FIND OUT K MOST HAPPY AND COMPATIBLE COUPLES.

public class KHappyCompat {
 
    public static void sortcouples(int[][] happiness,int[][] compatibility,girl[] girls,int a){
    
        //THIS FUNCTION SORTS COUPLES IN INCREASING ORDER OF HAPPINESS AND COMPATIBILITY.
        
               int maxh, temph;
        int maxc, tempc;
        int i,j;
        for (i = 0; i < a; i++) {
            maxh = happiness[i][1];
            maxc = compatibility[i][1];
            for (j = i; j < a; j++) {
                if (girls[happiness[j][1]].couplehappiness > girls[maxh].couplehappiness) {
                    temph = maxh;
                    maxh = happiness[j][1];
                    happiness[j][1] = temph;

                    temph = happiness[i][0];
                    happiness[i][0] = happiness[j][0];
                    happiness[j][0] = temph;

                }
                if (girls[compatibility[j][1]].couplecompat > girls[maxc].couplecompat) {
                    tempc = maxc;
                    maxc = compatibility[j][1];
                    compatibility[j][1] = tempc;

                    tempc = compatibility[i][0];
                    compatibility[i][0] = compatibility[j][0];
                    compatibility[j][0] = tempc;

                }

            }
            happiness[i][1] = maxh;
            compatibility[i][1] = maxc;
        }

    }
}
