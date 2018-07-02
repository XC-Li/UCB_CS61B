/**Double Ended Queue implemented in Linked List
 * Project for CS 61B 2018 spring
 * Implemented by XC-Li **/

public class LinkedListDeque1b<T> implements Deque<T>{
    int size;
    private DLNode sentinel;

    private class DLNode{ // double linked node is the basic element
        DLNode prev;
        DLNode next;
        T item;
        public DLNode(T i, DLNode previousNode, DLNode nextNode){
            item = i;
            prev = previousNode;
            next = nextNode;
        }
    }
    public LinkedListDeque1b(){
        size = 0;
        sentinel = new DLNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    @Override
    public boolean isEmpty(){
        if (size == 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){
        DLNode p = sentinel.next;
        for(int i=0; i<size; i++){
            System.out.print(p.item);
            System.out.print(" ");
            p = p.next;
        }
    }

    @Override
    public void addFirst(T item){
        DLNode newNode = new DLNode(item,sentinel,sentinel.next);
        sentinel.next.prev = newNode; // make the old first one point prev to new first one
        sentinel.next = newNode;
        size ++;
    }

    @Override
    public void addLast(T item){
        DLNode newNode = new DLNode(item, sentinel.prev, sentinel.next);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size ++;
    }

    @Override
    public T removeFirst(){
        T result = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size --;
        return result;
    }

    @Override
    public T removeLast(){
        T result = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size --;
        return result;
    }

    @Override
    public T get(int index){
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

    private T getRecursiveHelper(DLNode p, int i){
        if(i == 0){
            return p.item;
        }else{
            return getRecursiveHelper(p.next, i-1); // use i-1 instead of i--
        }
    }

    public T getRecursive(int index){
        if (index >= size){
            return null;
        }else {
            return getRecursiveHelper(sentinel.next, index);
        }
    }

    public static void main(String[] args){
        LinkedListDeque1b<Integer> L = new LinkedListDeque1b<>();
        L.addFirst(1);
        L.addFirst(2);
        L.printDeque();
//        System.out.println(L.get(2));
        System.out.println(L.getRecursive(1));
    }
}
