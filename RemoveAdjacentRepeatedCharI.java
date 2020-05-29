import java.util.Arrays;

public class RemoveAdjacentRepeatedCharI {
    //mthod1:
    public String deDup(String input) {
        char[] arr = input.toCharArray();
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i] != arr[end - 1]) {
                arr[end++] = arr[i];
            }
        }
        return new String(arr, 0, end);
    }
    //method2:
    public String deDup(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int end = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[end]) {
                array[++end] = array[i];
            }
        }
        return Arrays.copyOf(array, end + 1);
    }

}
