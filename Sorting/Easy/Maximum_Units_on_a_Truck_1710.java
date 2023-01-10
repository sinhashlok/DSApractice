package DSApractice.Sorting.Easy;

import java.util.Arrays;

public class Maximum_Units_on_a_Truck_1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // sort reverse

        // reverse quick sort - faster
        qSort(boxTypes, 0, boxTypes.length - 1);

        // lambda function sorting - shorter code, but slower
//        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int boxes = 0;
        for (int[] box : boxTypes) {
            if (truckSize >= box[0]) {
                boxes += box[0] * box[1];
                truckSize -= box[0];
            } else {
                boxes += truckSize * box[1];
                return boxes;
            }
        }

        return boxes;
    }

    private void qSort(int[][] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);

            qSort(arr, l, p);
            qSort(arr, p + 1, r);
        }
    }

    private int partition(int[][] arr, int l, int r) {
        int p = arr[l][1];
        int i = l - 1, j = r + 1;

        while (true) {
            do {
                i++;
            } while (arr[i][1] > p);
            do {
                j--;
            } while (arr[j][1] < p);

            if (i >= j) {
                return j;
            }

            swap(arr, i, j);
        }
    }

    private void swap(int[][] arr, int i, int j) {
        int temp1 = arr[i][0];
        int temp2 = arr[i][1];

        arr[i][0] = arr[j][0];
        arr[i][1] = arr[j][1];

        arr[j][0] = temp1;
        arr[j][1] = temp2;
    }
}