package DSApractice.Searching.Medium;

public class Minimum_Number_of_Days_to_Make_m_Bouquets_1482 {

    // First approach - faster
    public int minDaysMy(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) {
            return -1;
        }

        int start = 0, end = 0;
        for (int i : bloomDay) {
            start = Math.min(start, i);
            end = Math.max(end, i);
        }

        while (start < end) {
            int mid = start + (end - start) / 2;

            int i = 0;
            int mtemp = m;
            // keep track of number of bouquets
            while (mtemp != 0 && i < bloomDay.length) {
                int ktemp = k;
                // keep track of adjacent flowers for the bouquets
                while (ktemp != 0 && i < bloomDay.length) {
                    if (bloomDay[i] <= mid) {
                        ktemp--;
                        i++;
                    } else {
                        i++;
                        break;
                    }
                }

                if (ktemp == 0) {
                    mtemp--;
                }
            }

            if (mtemp == 0) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start; // start == end
    }

        // Second approach - neater
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) {
            return -1;
        }

        int start = 0, end = 0;
        for (int i : bloomDay) {
            start = Math.min(start, i);
            end = Math.max(end, i);
        }

        while (start < end) {
            int mid = start + (end - start) / 2;
            int flower = 0, bouq = 0;

            for (int j : bloomDay) {
                // if the adjacent flower has not bloomed is broken
                // start with 0 flowers, as now they are not adjacent
                if (j > mid) {
                    flower = 0;
                } else if (++flower == k) {
                    // once flower has reach k
                    // we can make a bouquet
                    // so now set flower to 0, as flowers are used to make one bouquet
                    bouq++;
                    flower = 0;
                }
            }

            if (bouq < m) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start; // start == end
    }
}