import java.util.*;

public class BallBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //store the count of balls for each color.
        Map<String, Integer> balls = new HashMap<>();
        //keeps track of the total number of balls 
        int totalBalls = 0;
        String input = scanner.nextLine();
        //reading all the input
        while (!input.equals("End")) {
            String[] tokens = input.split(": ");
            String color = tokens[0];
            int count = Integer.parseInt(tokens[1]);
            balls.put(color, count);
            totalBalls += count;
            input = scanner.nextLine();
        }
        int smallestCount = Integer.MAX_VALUE;
        //iterates over the count of balls for each color, computes the number 
        //of balls that would remain if those balls were removed from the box, 
        //and checks if this number is even and smaller than the current smallest count
        for (int count : balls.values()) {
            int remainingBalls = totalBalls - count;
            if (remainingBalls % 2 == 0 && remainingBalls/2 < smallestCount) {
                smallestCount = remainingBalls/2;
            }
        }
        //prints the smallest count found
        System.out.println(smallestCount);
    }
}
