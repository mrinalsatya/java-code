class Solution {

    void mergeSort(int arr[], int l, int r) {
        if (l >= r) return;

        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        int[] sortedArr = new int[r - l + 1];
        mergeArr(arr, l, mid + 1, r, sortedArr);
    }

    void mergeArr(int[] arr, int l, int mid, int r, int[] sortedArr) {
        int i = l, j = mid, k = 0;

        while (i < mid && j <= r) {
            if (arr[i] <= arr[j]) {
                sortedArr[k++] = arr[i++];
            } else {
                sortedArr[k++] = arr[j++];
            }
        }

        while (i < mid) {
            sortedArr[k++] = arr[i++];
        }

        while (j <= r) {
            sortedArr[k++] = arr[j++];
        }

        for (int a = 0; a < sortedArr.length; a++) {
            arr[l + a] = sortedArr[a];
        }
    }
}
