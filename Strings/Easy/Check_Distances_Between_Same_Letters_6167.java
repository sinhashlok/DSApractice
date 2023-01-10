package DSApractice.Strings.Easy;

public class Check_Distances_Between_Same_Letters_6167 {

    public boolean checkDistances(String s, int[] distance) {
        for (int i = 0; i < s.length(); i++) {
            int x = (int)(s.charAt(i) - 'a');
            int d = distance[x] + 1;

            if (d != 0) {
                if (d >= s.length() - i) {
                    return false;
                }

                if (s.charAt(i) == s.charAt(i + d)) {
                    distance[x] = -1;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}