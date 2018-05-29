/*
* Exercise 2
Using everything you’ve learned so far on this homework, you’ll now create a function with
the signature public static int max(int[] m) that returns the maximum value of an int array.
You may assume that all of the numbers are greater than or equal to zero.*/

public class FindMaxInArray {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int i = 0;
        int result = 0;
        while (i < m.length){
            if(result < m[i]){
                result = m[i];
            }
            i += 1;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        System.out.print("Solution is:");
        System.out.print(max(numbers));
    }
}
