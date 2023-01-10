package DSApractice.Sorting.Easy;

public class Can_Make_Arithmetic_Progression_From_Sequence_1502 {

    public boolean canMakeArithmeticProgression(int[] arr) {
        // first find min and max
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num: arr) {
            max = Math.max(num,max);
            min = Math.min(num,min);
        }

        int diff = (max - min) / (arr.length - 1);  // common difference
        if(max - min != diff * (arr.length - 1)) {
            return false;
        }

        //Case 1: {1,1,1,1} or {0,0,0,0}
        if(diff == 0 && min == max) {
            return true;
        }

        //swap each num to according place
        //min + 0*diff, min + 1*diff, min + 2*diff,..., min + (arr.length-1)*diff
        for(int i = 0; i < arr.length;) {
            //Case 2: {1,2,5,7} meet with arr[i] which can not be put anywhere
            if((arr[i] - min) % diff != 0) {
                return false;
            }

            int index = (arr[i] - min) / diff;

            //Case 3: {1,2,3,4} -> {1,2,3,4} i++ when arr[i] is at the right place
            if(index == i) {
                i++;
            } else {
                //Case 4: {1,2,2,4} meet with duplicate
                if(arr[index] == arr[i]) {
                    return false;
                }

                //Case 5: {2,1,3,4} -> {1,2,3,4} after swap 2 and 1
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }

        return true;
    }
}