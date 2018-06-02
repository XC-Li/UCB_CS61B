public class SLList {
    public class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode first;
    private int size;

    public SLList(int x) {
//        first = new IntNode(x, null);
//        size = 1;
        first = null;
        size = 0;
    }

    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        first = new IntNode(x, first);
        size ++;
    }

    /** Retrieves the front item from the list. */
    public int getFirst() {
        return first.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int x) {
        /* Your Code Here! */
        IntNode pointer = first;
        while (pointer.next != null){
            pointer = pointer.next;
        }
        pointer.next = new IntNode(x, null);
    }

    /** a private method that "speaks the language of god" recursive way to find the size
     *
     * @param p the IntNode
     * @return size of IntNode
     */
    private static int size(IntNode p){
        if (p.next == null){
            return 1;
        }else{
            return 1 + size(p.next);
        }
    }
    /** Returns the number of items in the list using recursion. */
    public int size() {
        return size;
//        return size(first); // recursive
        /* Your Code Here! */
        // iterative way to find the size
//        IntNode pointer = first;
//        int size = 1;
//        while(pointer.next != null){
//            pointer = pointer.next;
//            size ++;
//        }
//        return size;
    }

    public static void main(String[] args){
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        System.out.println(L.getFirst());
        System.out.println(L.size());
    }
}