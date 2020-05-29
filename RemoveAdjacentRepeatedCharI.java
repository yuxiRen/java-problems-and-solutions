public class RemoveAdjacentRepeatedCharI {
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
}
