/*
* Creative Exercise 1b: DrawTriangle
* Name this new method drawTriangle and give it a return type of void (this means that it doesn’t return anything at all).
* */

public class DrawTriangle2 {
    public static void drawTriangle(int N) {
        int row = 1;
        while (row <= N) {
            int col = 1;
            while (col <= row) {
                System.out.print("*");
                col += 1;
            }
            row += 1;
            System.out.print("\n");
        }
    }

    public static void main(String[] args){
        drawTriangle(10);
    }
}
