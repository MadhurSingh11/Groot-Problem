import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/* Author Madhur Singh*/
public class GrootPieFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of pies: ");
        int n = scanner.nextInt();
        int[] pies = new int[n];
        System.out.println("Enter the sweetness values of the pies: ");
        for (int i = 0; i < n; i++) {
            pies[i] = scanner.nextInt();
        }
        System.out.println("Enter the desired sweetness: ");
        int desiredSweetness = scanner.nextInt();
        List<List<Integer>> result = findPies(pies, desiredSweetness);
        System.out.println("Combinations of pies: " + result);
    }

    public static List<List<Integer>> findPies(int[] pies, int desiredSweetness) {
        List<List<Integer>> result = new ArrayList<>();
        findPiesHelper(pies, desiredSweetness, 0, new ArrayList<>(), result);
        return result;
    }

    private static void findPiesHelper(int[] pies, int desiredSweetness, int start, List<Integer> currentCombination, List<List<Integer>> result) {
        if (desiredSweetness == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        if (desiredSweetness < 0) {
            return;
        }
        for (int i = start; i < pies.length; i++) {
            currentCombination.add(i);
            findPiesHelper(pies, desiredSweetness - pies[i], i + 1, currentCombination, result);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}

