/**Double Ended Queue implemented in Linked List
 * Project for CS 61B 2018 spring
 * Implemented by XC-Li **/

public class LinkedListDeque <GenericType>{
    int size;
    private DLNode sentinel;

    private class DLNode{ // double linked node is the basic element
        DLNode prev;
        DLNode next;
        GenericType item;
        public DLNode(GenericType i, DLNode previousNode, DLNode nextNode){
            item = i;
            prev = previousNode;
            next = nextNode;
        }
    }
    public LinkedListDeque(){
        size = 0;
        sentinel = new DLNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        }else {
            return false;
        }
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        DLNode p = sentinel.next;
        for(int i=0; i<size; i++){
            System.out.print(p.item);
            System.out.print(" ");
            p = p.next;
        }
    }

    public void addFirst(GenericType item){
        DLNode newNode = new DLNode(item,sentinel,sentinel.next);
        sentinel.next.prev = newNode; // make the old first one point prev to new first one
        sentinel.next = newNode;
        size ++;
    }

    public void addLast(GenericType item){
        DLNode newNode = new DLNode(item, sentinel.prev, sentinel.next);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size ++;
    }

    public void removeFirst(){
        System.out.print(sentinel.next.item);
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size --;
    }

    public void removeLast(){
        System.out.print(sentinel.prev.item);
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size --;
    }

    public GenericType get(int index){
        DLNode p = sentinel.next;
        for(int i =0; i<size;i++){
            if(i == index){
                return p.item;
            }else {
                p = p.next;
            }
        }
        return null;
    }

    private GenericType getRecursiveHelper(DLNode p, int i){
        if(i == 0){
            return p.item;
        }else{
            return getRecursiveHelper(p.next, i-1); // use i-1 instead of i--
        }
    }

    public GenericType getRecursive(int index){
        if (index >= size){
            return null;
        }else {
            return getRecursiveHelper(sentinel.next, index);
        }
    }

    public static void main(String[] args){
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addFirst(1);
        L.addFirst(2);
        L.printDeque();
//        System.out.println(L.get(2));
        System.out.println(L.getRecursive(1));
    }
}
