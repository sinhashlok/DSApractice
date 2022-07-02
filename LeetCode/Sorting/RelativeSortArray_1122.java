package DSApractice.LeetCode.Sorting;

public class RelativeSortArray_1122 {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};

        relativeSortArray(arr1, arr2);

        for (int x : arr1)
            System.out.print(x + " ");
    }

    static void relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int k : arr1)
            count[k]++;

        int i = 0, index = 0;
        while (i < arr2.length)
        {
            while (count[arr2[i]] != 0)
            {
                arr1[index] = arr2[i];
                count[arr2[i]]--;
                index++;
            }
            i++;
        }

        for (int j = 0; j < count.length; j++)
        {
            if (count[j] != 0)
            {
                arr1[index] = j;
                index++;
            }
        }

    }
}
