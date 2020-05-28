public class RemoveSpaces {
    public String removeSpaces(String input) {
        char[] arr = input.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast < arr.length) {
            if (fast == 0 && arr[fast] == ' ') {
                while (fast < arr.length && arr[fast] == ' ') {
                    fast++;
                }
            } else if (arr[fast] == ' ' && (fast == arr.length - 1 || arr[fast+1] == ' ')) {
                fast++;
            } else {
                arr[slow++] = arr[fast++];
            }
        }
        return new String(arr, 0, slow);
    }
}
