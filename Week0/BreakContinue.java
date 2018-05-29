/*Optional: Exercise 4
*This is a particularly challenging exercise, but strongly recommended.

Write a function windowPosSum(int[] a, int n) that replaces each element a[i] with the sum of a[i] through a[i + n],
but only if a[i] is positive valued. If there are not enough values because we reach the end of the array,
 we sum only as many values as we have. */
public class BreakContinue {
    public static void windowPosSum(int[] a, int n) {
        for (int i = 0; i < a.length; i += 1){
            int sum = 0;
            if (a[i] < 0){
                continue;
            }else {
                for(int j = i; j <= i + n; j +=1){
                    if (j > a.length-1){  //out of range
                        break;
                    }else{
                        sum += a[j];
                    }
                }
            }
            a[i] = sum;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, -3, 4, 5, 4};
        int n = 3;
        windowPosSum(a, n);

        // Should print 4, 8, -3, 13, 9, 4
        System.out.println(java.util.Arrays.toString(a));
    }
}