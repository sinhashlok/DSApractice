package DSApractice.Math.Medium;

public class Integer_to_Roman_12 {

    // My approach
    public String intToRomanMy(int num) {
        int n = (int) (Math.log10(num) + 1);
        StringBuilder str = new StringBuilder();

        if (n == 4) {
            int x = (int) (num / Math.pow(10, n - 1));
            num %= x * Math.pow(10, n - 1);
            while (x != 0) {
                str.append("M");
                x--;
            }

            n = (int) (Math.log10(num) + 1);
        }

        while (n > 0) {
            if (n == 3) {
                helper(num, n, str, 'M', 'C', 'D');
                int x = (int)(num / Math.pow(10, n - 1));
                num %= x * Math.pow(10, n - 1);
                n = (int) (Math.log10(num) + 1);
            }
            if (n == 2) {
                helper(num, n, str, 'C', 'X', 'L');
                int x = (int)(num / Math.pow(10, n - 1));
                num %= x * Math.pow(10, n - 1);
                n = (int) (Math.log10(num) + 1);
            }
            if (n == 1) {
                helper(num, n, str, 'X', 'I', 'V');
                int x = (int)(num / Math.pow(10, 0));
                num %= x * Math.pow(10, 0);
                n = 0;
            }

            if (n < 0) {
                break;
            }
        }

        return str.toString();
    }

    public void helper(int num, int n, StringBuilder str, char f, char s, char t) {
        int x = (int)(num / Math.pow(10, n - 1));
        if (x == 9) {
            str.append(s).append(f);
        } else if (x == 4) {
            str.append(s).append(t);
        } else if (x == 5) {
            str.append(t);
        } else if (x > 5) {
            str.append(t);
            while (x != 5) {
                str.append(s);
                x--;
            }
        } else {
            while (x != 0) {
                str.append(s);
                x--;
            }
        }
    }

    // Discussion - very slow solution, but short code
    // credits: https://leetcode.com/problems/integer-to-roman/discuss/6274/Simple-Solution
    public String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}