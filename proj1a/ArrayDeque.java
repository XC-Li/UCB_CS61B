/**Double Ended Queue implemented in Array
 * Project for CS 61B 2018 spring
 * Implemented by XC-Li **/

public class ArrayDeque<T> {


    private int maxSize;
    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(int maxSize){
        this.maxSize = maxSize;
        items = (T[]) new Object[maxSize]; //grammar
        nextFirst = 4;
        nextLast = 5;
        size = 0;
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
        int currentFirst = addOne(nextFirst);
        while (currentFirst != nextLast){
            System.out.print(items[currentFirst] + " ");
            currentFirst = addOne(currentFirst);
        }
        System.out.println(" ");
    }


    public T get(int index){
        if(index>size-1){
            return null; // out of boundary
        }
        int resultIndex = (nextFirst + 1 + index) % maxSize;
        return items[resultIndex];
    }

    private int addOne(int index){
        if (index + 1 < maxSize){
            return index + 1;
        }else { // the end of array
            return 0;
        }
    }

    private int minusOne(int index){
        if (index - 1 > -1){
            return index - 1;
        }else { //the begin of array
            return maxSize - 1;
        }

    }

    private void reSize(int reSizeFactor){
        int newSize;
        if (reSizeFactor > 0) {
            newSize = maxSize * reSizeFactor;
        }else{
            newSize = -1 * maxSize / reSizeFactor;
        }
        ArrayDeque<T> newL = new ArrayDeque<>(newSize);
        int currentItem = addOne(nextFirst);
        for(int i = 0; i<size; i++){
            newL.addLast(items[currentItem]);
            currentItem = addOne(currentItem);
        }
        this.items = newL.items;
        this.maxSize = newL.maxSize;
        this.nextLast = newL.nextLast;
        this.nextFirst = newL.nextFirst;
        this.size = newL.size;
    }



    public void addFirst(T item){
        if(size + 1 > maxSize){
            reSize(2);
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }

    public T removeFirst(){
        int currentFirst = addOne(nextFirst);
        T result = items[currentFirst];
        if(result == null){ // the deque is empty
            return result;
        }
        items[currentFirst] = null;
        size --;
        nextFirst = currentFirst;

        if(size < maxSize * 0.25){
            reSize(-2);
        }
        return result;
    }

    public T removeLast(){
        int currentLast = minusOne(nextLast);
        T result = items[currentLast];
        if(result == null){
            return result;
        }
        items[currentLast] = null;
        size --;
        nextLast = currentLast;
        if(size < maxSize * 0.25){
            reSize(-2);
        }
        return result;
    }

    public void addLast(T item){
        if(size + 1 > maxSize){
            reSize(2);
        }
        items[nextLast] = item;
        nextLast = addOne(nextLast);
        size += 1;
    }
    // the main method is used for test
    public static void main(String[] args){
        ArrayDeque<String> L = new ArrayDeque<>(8);
        System.out.println(L.removeFirst());
        L.addLast("a");
        L.addLast("b");
        L.addFirst("c");
        L.addLast("d");
        L.addLast("e");
        L.addFirst("f");
        L.addLast("g");
        L.addLast("h");
        L.addFirst("i");
        System.out.println(L.get(5));
        L.printDeque();
        System.out.println(L.removeFirst());
        System.out.println(L.removeLast());
        System.out.println(L.removeLast());
        System.out.println(L.removeLast());
        System.out.println(L.removeLast());
        System.out.println(L.removeLast());
        System.out.println(L.removeFirst());
    }
}
