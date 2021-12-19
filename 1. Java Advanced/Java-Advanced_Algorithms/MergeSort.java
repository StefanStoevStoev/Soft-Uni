import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split("\\s+");
        int[] array = new int[tokens.length];
        for (int k = 0; k < tokens.length; k++) {
            array[k] = Integer.parseInt(tokens[k]);
        }

        int[] sorted = mergeSort(array);

        for (int k = 0; k < sorted.length; k++) {
            System.out.print(sorted[k] + " ");
        }
    }

    private static int[] mergeSort(int[] array) {
        if(array.length == 1){
            return array;
        }
        int halfIdx = array.length / 2;
        int[] leftHalf = Arrays.copyOfRange(array,0, halfIdx);
        int[] rightHalf = Arrays.copyOfRange(array, halfIdx, array.length);

        leftHalf = mergeSort(leftHalf);
        rightHalf = mergeSort(rightHalf);
        return mergeTwoSortedArrays(leftHalf,rightHalf);
    }

    public static int[] mergeTwoSortedArrays(int[] firstArr, int[] secondArr) {
        int[] merged = new int[firstArr.length + secondArr.length];
        int firstIndex = 0;
        int secondIndex = 0;

        while (firstIndex < firstArr.length && secondIndex < secondArr.length) {
            int firstElement = firstArr[firstIndex];
            int secondElement = secondArr[secondIndex];

            if (firstElement < secondElement) {
                merged[firstIndex + secondIndex] = firstElement;
                firstIndex++;
            } else {
                merged[firstIndex + secondIndex] = secondElement;
                secondIndex++;
            }
        }
        while (firstIndex < firstArr.length) {
            merged[firstIndex + secondIndex] = firstArr[firstIndex];
            firstIndex++;
        }
        while (secondIndex < secondArr.length) {
            merged[firstIndex + secondIndex] = secondArr[secondIndex];
            secondIndex++;
        }
        return merged;
    }
}
