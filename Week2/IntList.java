public class IntList {
    public int first;
    public IntList rest;
    public IntList(int f, IntList r){
        first = f;
        rest = r;
    }

    /** recursion to find the size
     *
     * @return size
     */
    public int size1(){
        if (rest == null){
            return 1;
        }
        return 1 + this.rest.size1();
    }

    /** iteration to find the size
     *
     * @return size
     */
    public int size2(){
        IntList p = this;
        int totalSize = 0;
        while (p != null){
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    /** return the ith item of this IntList using recursion
     *
     * @param i which item
     * @return the item
     */
    public int get(int i){
        if (i == 0){
            return this.first;
        }
        return this.rest.get(i-1);
    }

    public static void main(String[] args){
        IntList L = new IntList(15,null);
        L = new IntList(10, L);
        L = new IntList(5,L);
        System.out.println(L.size2());
        System.out.println(L.size1());
        for (int i = 0; i < L.size1(); i++){
            System.out.println(L.get(i));
        }


    }
}
