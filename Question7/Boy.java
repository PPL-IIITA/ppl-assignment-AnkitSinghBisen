
        /**
	 * Contains Characteristics of a boy.
	 * @author AnkitSingh Bisen
	 *
	 */

public class Boy {

    String name;
    float attractiveness;       //On a scale of 1-10
    int budget;
    float intelligence;         //On a scale of 1-10
    float minatreq;             //On a scale of 1-10
    char relstat;               //Relationship Status. S-SINGLE , C-COMMITTED

    static void FindGfArray(int[] list, int[][] allocations, int a) {
        int i, j;
        int flag = 0;
        for (i = 0; i < list.length; i++) {
            for (j = 0; j < a; j++) {
                if (list[i] == allocations[j][0]) {
                    System.out.println("Boy" + list[i] + " is committed to Girl" + allocations[j][1] + ".");
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println("Boy" + list[i] + "is single.");
            }
            flag = 0;
        }

    }

    static void FindGfBinarySearch(int[][] couples, int boyno, int start, int end) {
        int mid;
        while (start <= end) {
            mid = (end + start) / 2;
            if (couples[mid][0] == boyno) {
                System.out.println("boy" + boyno + " is committed with girl" + couples[mid][1]);
                return;
            }

            if (boyno < couples[mid][0]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println("boy" + boyno + "is single");

    }

    static void FindGfHashTable(int[] list, int[][] couples, int a) {

        int key, i, j;
        HashTable ht = new HashTable(10);

        for (i = 0; i < a; i++) {
            key = (couples[i][0]) % 10;
            ht.insert(Integer.toString(key), couples[i][0]);

        }

        for (i = 0; i < list.length; i++) {
            if (ht.get(Integer.toString(list[i] % 10)) == -1) {

                System.out.println("Boy" + list[i] + " is single");

            } else {

                for (j = 0; j < a; j++) {
                    if (list[i] == couples[j][0]) {
                        System.out.println("Boy" + list[i] + " is committed to Girl" + couples[j][1] + ".");
                        break;
                    }
                }
            }

        }

    }

}
