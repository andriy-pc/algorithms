package algorithms;

public class Sorting {
    public static int[] selectSort(int arr[]) {
        int length = arr.length;
        int indexMin;
        int tmp;
        for (int i = 0; i < length; ++i) {
            indexMin = i;
            for (int j = i + 1; j < length; ++j) {
                if (arr[j] < arr[indexMin]) {
                    indexMin = j;
                }
            }
            if (indexMin != i) {
                tmp = arr[i];
                arr[i] = arr[indexMin];
                arr[indexMin] = tmp;
            }
        }
        return arr;
    }

    public static int[] insertSort(int arr[]) {
        int length = arr.length;
        int curr;
        for (int i = 1; i < length; ++i) {
            curr = arr[i];
            for (int j = i - 1; j >= 0; --j) {
                if (curr < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
                arr[j] = curr;
            }

        }
        return arr;
    }

    public static int[] shellSort(int[] arr) {
        int curr;
        for (int startStep = 4; startStep > 0; --startStep) {
            for (int i = startStep; i < arr.length; i += startStep) {
                curr = arr[i];
                for (int j = i - startStep; j >= 0; j -= startStep) {
                    if (curr < arr[j]) {
                        arr[j + startStep] = arr[j];
                    } else {
                        break;
                    }
                    arr[j] = curr;
                }
            }
        }
        return arr;
    }

    public static int[] shellSortImproved(int arr[]) {


        int h = 1;
        int length = arr.length;
        int curr;

        while (h < length / 3) {
            h = 3 * h + 1;
        }

        while (h > 1) {
            for (int i = h; i < length; ++i) {
                curr = arr[i];
                for (int j = i - 1; j >= 0; --j) {
                    if (curr < arr[j]) {
                        arr[j + 1] = arr[j];
                    } else {
                        break;
                    }
                    arr[j] = curr;
                }
            }
            h = h / 3;
        }

        return arr;
    }

    public static int[] bubbleSort(int arr[]) {
        int length = arr.length;
        int tmp;
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < length; ++j) {
                if (arr[i] < arr[j]) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }

    public static int[] mergeSort(int arr[]) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int[] mergeSort(int arr[], int startIndex, int endIndex) {
        int mid;
        if (startIndex < endIndex) {
            mid = (endIndex + startIndex) / 2;
            mergeSort(arr, startIndex, mid);
            mergeSort(arr, mid + 1, endIndex);
            merge(arr, startIndex, mid, endIndex);
        }
        return arr;
    }

    private static void merge(int arr[], int start, int mid, int end) {
        int l = mid - start + 1;
        int r = end - mid;
        int left[] = new int[l];
        int right[] = new int[r];

        System.arraycopy(arr, start, left, 0, l);
        System.arraycopy(arr, mid + 1, right, 0, r);

        int i = 0;
        int j = 0;
        int k = start;
        while (i < l && j < r) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < l) {
            arr[k++] = left[i++];
        }
        while (j < r) {
            arr[k++] = right[j++];
        }
    }

    public static int[] quickSort(int arr[]) {
        return quickSort(arr, 0, arr.length - 1);
    }

    private static int[] quickSort(int arr[], int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int mid = partition(arr, startIndex, endIndex);
            quickSort(arr, startIndex, mid - 1);
            quickSort(arr, mid + 1, endIndex);
        }
        return arr;
    }

    private static int partition(int arr[], int startIndex, int endIndex) {
        int pivot = arr[endIndex];
        int i = startIndex - 1;
        int j = startIndex;
        int tmp;

        while (j <= endIndex - 1) {
            if (arr[j] < pivot) {
                tmp = arr[++i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            ++j;
        }
        tmp = arr[++i];
        arr[i] = arr[endIndex];
        arr[endIndex] = tmp;
        return i;
    }

    public static int[] quickSortHoar(int arr[]) {
        return quickSortHoar(arr, 0, arr.length - 1);
    }

    private static int[] quickSortHoar(int arr[], int startIndex, int endIndex) {
        if(startIndex < endIndex) {
            int pivot = calculatePivot(arr, startIndex, endIndex);
            quickSort(arr, startIndex, pivot-1);
            quickSort(arr, pivot + 1, endIndex);
        }
        return arr;
    }

    private static int calculatePivot(int arr[], int start, int end) {
        int pivot = arr[(start + end)/2];
        int l = start;
        int r = end;
        int tmp;

        while(true) {
            while(arr[l] < pivot) {
                ++l;
            }

            while(arr[r] > pivot) {
                --r;
            }

            if(l >= r) {
                return r;
            }

            tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            ++l;
            --r;
        }
    }

}

