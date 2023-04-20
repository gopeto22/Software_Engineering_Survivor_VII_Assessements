import java.util.*;

public class CarrotRabbit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //reads the size of the garden and the number of carrots in each cell of the garden from the input
        int n = scanner.nextInt();
        int[][] garden = new int[n][n];
        //depth-first search (DFS) algorithm to count the number of groups of carrots
        //starts at the top left corner of the garden and visits all the cells in each 
        //group of carrots, marking them as visited by setting their value to 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                garden[i][j] = scanner.nextInt();
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //visited all the cells in a group
                if (garden[i][j] > 0) {
                    //increments the count of groups
                    count++;
                    //continues searching for the next group until it has visited all the cells in the garden
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
