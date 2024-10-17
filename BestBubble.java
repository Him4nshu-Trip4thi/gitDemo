import java.util.Scanner;

public class BestBubble {
    public static int bubbleSortSwaps(int[] arr, boolean ascending) {
        int n = arr.length;
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((ascending && arr[j] > arr[j + 1]) || (!ascending && arr[j] < arr[j + 1])) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                }
            }
        }
        return swaps;
    }

    public static int minimumSwapsToBeautiful(int[] arr) {
        int[] copy1 = arr.clone();
        int[] copy2 = arr.clone();
        int ascSwaps = bubbleSortSwaps(copy1, true);
        int descSwaps = bubbleSortSwaps(copy2, false);
        return Math.min(ascSwaps, descSwaps);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(minimumSwapsToBeautiful(arr));
        sc.close();
    }
}
