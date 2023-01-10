package DSApractice.Strings.Easy;

public class Long_Pressed_Name_925 {

    public boolean isLongPressedName(String name, String typed) {
        int i = 0, m = name.length(), n = typed.length();
        for (int j = 0; j < n; ++j) {
            if (i < m && name.charAt(i) == typed.charAt(j)) {
                ++i;
            }
            else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1)) {// check with prev element if current doesn't match
                return false;
            }
        }
        return i == m;
    }
}