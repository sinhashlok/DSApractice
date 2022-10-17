package DSApractice.Strings.Easy;

public class Check_if_the_Sentence_Is_Pangram_1832 {

    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) {
            return false;
        }

        boolean[] arr = new boolean[26];
        for (int i = 0; i < sentence.length(); i++) {
            arr[sentence.charAt(i) - 'a'] = true;
        }

        for (boolean b : arr) {
            if (!b) {
                return false;
            }
        }

        return true;
    }
}