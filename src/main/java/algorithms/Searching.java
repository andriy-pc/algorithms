package algorithms;

public class Searching {

    public static int linearSearch(int arr[], int elem) {

        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == elem) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int arr[], int elem) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (elem < arr[mid]) {
                end = mid - 1;
            } else if (elem > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearchRecurrent(int arr[], int elem, int start, int end) {

        if (start <= end) {
            int mid = start + (end - start) / 2;
            if (elem < arr[mid]) {
                return binarySearchRecurrent(arr, elem, start, mid - 1);
            } else if (elem > arr[mid]) {
                return binarySearchRecurrent(arr, elem, mid + 1, end);
            } else {
                return mid;
            }
        }
        return -1;
    }

}
