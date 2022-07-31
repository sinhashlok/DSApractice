// https://leetcode.com/problems/defanging-an-ip-address/

package DSApractice.LeetCode.Strings.Easy;

public class Defanging_an_IP_Address_1108 {

    static String defangIPaddr(String address) {
        StringBuilder str = new StringBuilder();
        int index = 0;
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                str.append(address.substring(index, i));
                str.append("[.]");
                index = i + 1;
            }
        }

        str.append(address.substring(index, address.length()));

        return str.toString();
    }

}
