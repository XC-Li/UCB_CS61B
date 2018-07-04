public class Palindrome {

    //put word into deque
    public Deque<Character> wordToDeque(String word){
        Deque<Character> wordList = new LinkedListDeque1b<>(); // this is the way to use
            for (int i = 0; i < word.length(); i++){
                char temp = word.charAt(i);
                wordList.addLast(temp);
            }
            return wordList;
    }

    private boolean isPalindrome(Deque wordList){
        if(wordList.size() == 0 || wordList.size() == 1){
            return true;
        }
        Object head = wordList.removeFirst();
        Object tail = wordList.removeLast();
        return (head.equals(tail) && isPalindrome(wordList));
    }

    //examine whether a word is palindrome
    public boolean isPalindrome(String word){
        return isPalindrome(wordToDeque(word));
    }

    // task 4

    private boolean isPalindrome(Deque wordList, CharacterComparator cc){
        if(wordList.size() == 0 || wordList.size() == 1){
            return true;
        }
        Object head = wordList.removeFirst();
        Object tail = wordList.removeLast();
        char headc = head.toString().charAt(0);
        char tailc = tail.toString().charAt(0);
        return (cc.equalChars(headc, tailc) && isPalindrome(wordList));
    }
    public boolean isPalindrome(String word, CharacterComparator cc){
        return isPalindrome(wordToDeque(word),cc);
    }


}
