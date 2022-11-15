package DSApractice.Strings.Medium;

public class Reverse_Words_in_a_String_151 {

    public String reverseWords(String s) {
        StringBuilder str = new StringBuilder();    // stores word
        StringBuilder res = new StringBuilder();    // final reversed string

        for (int i = s.length() - 1; i >= 0 ; i--) {
            char ch = s.charAt((i));
            if (ch == ' ') {
                str.reverse();
                res.append(str);
                
                if (str.length() != 0 && res.charAt(res.length() - 1) != ' ') {
                    res.append(" ");
                }

                str.setLength(0);
            } else {
                str.append(ch);
            }
        }
        if (!str.isEmpty()) {
            res.append(str.reverse());
            res.append(" ");
        }

        s = res.substring(0, res.length() - 1);

        return s;
    }
}