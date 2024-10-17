import java.util.Scanner;

public class GoodString {
    public static int calculateDistance(String goodString, String name) {
        int totalDistance = 0;
        char prevGoodLetter = goodString.charAt(0);
        
        for (char c : name.toCharArray()) {
            if (goodString.indexOf(c) != -1) {
                prevGoodLetter = c;
                continue;
            }
            
            int minDistance = Integer.MAX_VALUE;
            char nearestGoodLetter = prevGoodLetter;
            
            for (char goodChar : goodString.toCharArray()) {
                int distance = Math.abs(c - goodChar);
                
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestGoodLetter = goodChar;
                } else if (distance == minDistance && Math.abs(prevGoodLetter - goodChar) < Math.abs(prevGoodLetter - nearestGoodLetter)) {
                    nearestGoodLetter = goodChar;
                }
            }
            
            totalDistance += Math.abs(c - nearestGoodLetter);
            prevGoodLetter = nearestGoodLetter;
        }
        
        return totalDistance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String goodString = sc.nextLine();
        String name = sc.nextLine();
        System.out.println(calculateDistance(goodString, name));
        sc.close();
    }
}
