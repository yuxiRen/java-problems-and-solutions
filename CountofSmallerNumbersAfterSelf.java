public class CountofSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        Ele[] array = new Ele[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = new Ele(i, nums[i], 0);
        }
        Ele[] helper = new Ele[nums.length];
        mergeSort(array, helper, 0, nums.length - 1);
        Integer[] result = new Integer[nums.length];
        for (int i = 0; i < array.length; i++) {
            result[array[i].idx] = array[i].count;
        }
        return Arrays.asList(result);
    }

    private void mergeSort(Ele[] array, Ele[] helper, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, helper, left, mid);
        mergeSort(array, helper, mid + 1, right);
        merge(array, helper, left, mid, right);
    }

    private void merge(Ele[] array, Ele[] helper, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            helper[i] = array[i];
        }
        int l = left;
        int r = mid + 1;
        while (l <= mid && r <= right) {
            //考虑相等的情况给谁，若l.val==r.val,则说明r之前的也是smaller than l.val的
            if (helper[l].val <= helper[r].val) {
                array[left] = helper[l++];
                array[left].count += r - 1 - mid;
            } else {
                array[left] = helper[r++];
            }
            left++;
        }
        while(l <= mid) {
            array[left] = helper[l++];
            array[left++].count += r - 1 - mid;
        }

    }

    static class Ele {
        int idx;
        int val;
        int count;
        public Ele (int idx, int val, int count) {
            this.idx = idx;
            this.val = val;
            this.count = count;
        }
    }
