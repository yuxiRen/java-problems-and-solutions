public class QuickSort {
    public int[] quickSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIdx = partition(arr, left, right);
        quickSort(arr, left, pivotIdx - 1);
        quickSort(arr, pivotIdx + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int smallPointer = left;
        int bigPointer = right - 1;
        while (smallPointer <= bigPointer) {
            if (arr[smallPointer] <= pivot) {
                smallPointer++;
            } else if (arr[bigPointer] > pivot) {
                bigPointer--;
            } else {
                swap(arr, smallPointer++, bigPointer--);
            }
        }
        swap(arr, smallPointer, right);
        return smallPointer;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}