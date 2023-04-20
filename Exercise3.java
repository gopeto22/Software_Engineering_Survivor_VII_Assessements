import java.util.*;

public class CarrotRabbit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] garden = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                garden[i][j] = scanner.nextInt();
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (garden[i][j] > 0) {
                    count++;
                    dfs(garden, i, j);
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int[][] garden, int i, int j) {
        if (i < 0 || i >= garden.length || j < 0 || j >= garden.length || garden[i][j] == 0) {
            return;
        }
        garden[i][j] = 0;
        dfs(garden, i+1, j);
        dfs(garden, i-1, j);
        dfs(garden, i, j+1);
        dfs(garden, i, j-1);
    }
}
