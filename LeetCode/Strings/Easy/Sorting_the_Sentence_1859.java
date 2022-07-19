package DSApractice.LeetCode.Strings.Easy;

public class Sorting_the_Sentence_1859 {
    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";

        System.out.println(sortSentence(s));
    }

    static String sortSentence(String s) {
        String[] words = s.split(" "); // Since the String contains only whitespaces, it's safe to split the String at them
        String[] res = new String[words.length];

        for (String i : words) {
            // Get index from the word
            int index = Character.getNumericValue(i.charAt(i.length() - 1)) - 1;

            // Store the original word without a numeric value
            res[index] = i.substring(0, i.length() - 1);
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            String substring = res[i].substring(0, res[i].length());
            if (i == res.length - 1) {
                str.append(substring);
            } else {
                str.append(substring).append(" ");
            }
        }

        return str.toString();
    }
}
