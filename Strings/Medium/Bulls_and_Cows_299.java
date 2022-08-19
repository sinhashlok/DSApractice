package DSApractice.Strings.Medium;

import jdk.jshell.spi.SPIResolutionException;

import java.util.HashMap;
import java.util.Map;

public class Bulls_and_Cows_299 {

    public String getHintLeet(String secret, String guess) {
        //table records the appearance of a digit
        //digit from secret will increase the counter
        //digit from guess will decrease the counter
        int[] count = new int[10];

        int counterA = 0, counterB = 0;

        for(int i = 0; i < secret.length(); i++){
            int a = secret.charAt(i) - '0', b = guess.charAt(i) - '0';
            if(a == b){
                //accurate match (same digit with same position)
                counterA ++;
            } else {

                //if prev part of guess has curr digit in secret
                //then we found a pair that has same digit with different position
                if(count[a] < 0) {
                    counterB ++;
                }

                //if prev part of secret has curr digit in guess
                //then we found a pair that has same digit with different position
                if(count[b] > 0) {
                    counterB ++;
                }

                count[a] ++;
                count[b] --;
            }
        }

        return counterA + "A" + counterB + "B";
    }


    public String getHintMy(String secert, String guess) {
        int n = secert.length();
        int[] sec = new int[n];
        int[] gus = new int[n];
        for (int i = 0; i < n; i++) {
            if (i <= secert.length() - 1) {
                sec[i] = (int)(secert.charAt(i) - '0');
            } else {
                sec[i] = -1;
            }

            if (i <= guess.length() - 1) {
                gus[i] = (int) (guess.charAt(i) - '0');
            } else {
                gus[i] = -1;
            }
        }

        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            if (sec[i] == gus[i]) {
                x++;
                sec[i] = -1;
            } else {
                y += checkContains(sec, gus, i);
            }
        }

        return x + "A" + y + "B";
    }

    private int checkContains(int[] sec, int[] gus, int x) {
        for (int i = 0; i < sec.length; i++) {
            if (sec[i] == gus[x] && sec[i] != gus[i]) {
                sec[i] = -1;
                return 1;
            }
        }

        return 0;
    }
}