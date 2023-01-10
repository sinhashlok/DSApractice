package DSApractice.Strings.Medium;

public class Optimal_Partition_of_String_6177 {

    public int partitionString(String s) {
        StringBuilder str = new StringBuilder();
        int count = 0;

        int i = 0;  // index
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (!str.toString().contains(ch + "")) {
                str.append(ch);
                i++;
            } else {
                count ++;
                str.setLength(0);
            }
        }

        return count + 1;
    }
}