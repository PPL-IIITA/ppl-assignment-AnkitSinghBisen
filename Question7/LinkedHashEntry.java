

        /**
	 * For collision resolution in hashing.
	 * @author AnkitSingh Bisen
	 *
	 */

public class LinkedHashEntry {

    String key;

    int value;

    LinkedHashEntry next;

    /* Constructor */
    LinkedHashEntry(String key, int value) {

        this.key = key;

        this.value = value;

        this.next = null;

    }
}
