public class OffByN implements CharacterComparator {
    private int N;

    public OffByN(int n) {
        this.N = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        if(diff == N || diff == -1 * N){
            return true;
        }else {
            return false;
        }
    }
}
