public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> wordList = new LinkedListDeque1b<>(); // this is the way to use
            for (int i = 0; i < word.length(); i++){
                char temp = word.charAt(i);
                wordList.addLast(temp);
            }
            return wordList;
    }

}
