/*
* Rewrite your solution to Exercise 2 so that it uses a for loop.
* Use your original solution as starter code, or if you’ve lost it, you can use this or this).*/

public class FindMaxinArrarywithForLoop {
    public static int forMax(int[] m){
        int result = 0;
        for (int i = 0; i < m.length; i +=1){
            if (result < m[i]){
                result = m[i];
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        System.out.print("Solution is:");
        System.out.print(forMax(numbers));
    }
}
