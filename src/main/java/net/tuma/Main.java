package net.tuma;

public class Main {
    public static void main(String[] args) {
    }

    //we can use recursion, but a loop realisation on 25% faster
    private int binarySearchTwoPartsSortedArray(int[] arr, int value) {
        if (arr == null) {
            return -1;
        }

        if (arr.length == 1) {
            return arr[0]==value?0:-1;
        }

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal == value)
                return mid;

            if (arr[low] <= arr[mid]) {
                if (value >= arr[low] && value <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (value >= arr[mid] && value <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public int findElem(int[] arr, int value) {
        return binarySearchTwoPartsSortedArray(arr, value);
    }
}
