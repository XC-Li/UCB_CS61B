//Discussion 3 Array List
//https://sp18.datastructur.es/materials/discussion/disc03.pdf

public class Dis3AList {

    public static int[] insert(int[] arr, int item, int position){
        int[] result = new int[arr.length + 1];
        if(position<arr.length) {
            System.arraycopy(arr,0,result,0,position);
            result[position] = item;
            System.arraycopy(arr, position,result,position+1,arr.length-position);
        }else {
            System.arraycopy(arr, 0, result, 0, arr.length);
            result[arr.length] = item;
        }
        return result;
    }

    public static void reverse(int[] arr){
        for(int i = 0; i < arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
    }

    public static void printItem(int[] x){
        for (int i = 0; i < x.length; i++){
            System.out.print(x[i]);
            System.out.print(" ");
        }
        System.out.print("\n");
    }

    public static int[] replicate(int[] arr){
        int total = 0;
        for(int item :arr){
            total += item;
        }
        int[] result = new int[total];
        int location = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i]; j++){
                result[location] = arr[i];
                location ++;
            }

        }
        return result;
    }
    public static void main(String[] args){
        int[] x = new int[]{5, 9, 14, 15};
        printItem(x);
        int[] y = insert(x,6,2);
        printItem(y);
        reverse(y);
        printItem(y);
        int[] a = new int[]{3,2,1};
        int[] b = replicate(a);
        printItem(b);
    }
}
