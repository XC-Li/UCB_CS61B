/** Array based list.
 *  @author Josh Hug
 */

/**Invariants
 * addLast: the next item we want to add, will go into position size
 * size: the number of items in the AList
 * the last item in the list is always in position size - 1
 */

public class AList {
    private int [] items;
    private int size;

    /** Creates an empty list. */
    public AList() {
        items = new int[100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if (size == items.length){
            int[] newItems = new int[size + 1];
            System.arraycopy(items, 0 , newItems, 0, size);
            items = newItems;
        }
        items[size] = x;
        size += 1;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return items[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return 0;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public int removeLast() {
        int x = getLast();
        size -= 1;
        return x;
    }
} 