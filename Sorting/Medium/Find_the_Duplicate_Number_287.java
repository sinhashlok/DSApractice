package DSApractice.Sorting.Medium;

public class Find_the_Duplicate_Number_287 {

    // cycle sort approach
    public int findDuplicateCyc(int[] nums) {
        // cycle sort
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
                i -= 1;
            }
        }

        return nums[nums.length - 1];
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // HashMap in Iteration
    public int findDuplicateHashIter(int[] nums) {
        while (nums[0] != nums[nums[0]]) {
            int temp = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = temp;
        }

        return nums[0];
    }

    // Binary Search
    public int findDuplicateBinarySearch(int[] nums) {
        int low = 1, high = nums.length - 1;
        int duplicate = -1;

        while (low <= high) {
            int cur = (low + high) / 2;

            // Count how many numbers in 'nums' are less than or equal to 'cur'
            int count = 0;
            for (int num : nums) {
                if (num <= cur)
                    count++;
            }

            if (count > cur) {
                duplicate = cur;
                high = cur - 1;
            } else {
                low = cur + 1;
            }
        }
        return duplicate;
    }


    // Floyd's Tortoise and Hare (Cycle Detection) - Linked List II
    /*
    * Each new element in the sequence is an element in nums at the index of the previous element.
    * If one starts from x = nums[0], such a sequence will produce a linked list with a cycle.
    *
    *
    * Algo:
    * In phase 1, hare = nums[nums[hare]] is twice as fast as tortoise = nums[tortoise].
    * Since the hare goes fast, it would be the first to enter the cycle and run around the cycle. At some point,
    * the tortoise enters the cycle as well, and since it's moving slower the hare catches up to the
    * tortoise at some intersection point.
    * Now phase 1 is over, and the tortoise has lost.
    * ### Note that the intersection point is not the cycle entrance in the general case.
    *
    * To compute the intersection point, let's note that the hare has traversed twice as many nodes as the tortoise, i.e.
    * ### 2d(tortoise) = d(hare)
    *
    * In phase 2, we give the tortoise a second chance by slowing down the hare, so that it now moves at the
    * speed of tortoise: tortoise = nums[tortoise], hare = nums[hare].
    * The tortoise is back at the starting position, and the hare starts from the intersection point.
    *
    * Let's show that this time they meet at the cycle entrance after F steps.
    *   The tortoise started at zero, so its position after F steps is F.
    *   The hare started at the intersection point F+a=nC, so its position after F steps is nC+F, that is the same point as F.
    *   So the tortoise and the (slowed down) hare will meet at the entrance of the cycle.
    */
    public int findDuplicateCycleDetect(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];

        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = nums[0];

        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }
}