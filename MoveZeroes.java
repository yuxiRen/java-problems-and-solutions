public class MoveZeroes {
    // if don't need to maintain the original array elements' order
    public int[] moveZero(int[] array) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] != 0) {
                i++;
            } else if (array[j] == 0) {
                j--;
            } else {
                swap(array, i++, j--);
            }
        }
        return array;
    }

    //need to maintain the original array elements' order
    public int[] moveZero(int[] array) {
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                array[end++] = array[i];
            }
        }
        while (end < array.length) {
            array[end++] = 0;
        }
        return array;
    }
}