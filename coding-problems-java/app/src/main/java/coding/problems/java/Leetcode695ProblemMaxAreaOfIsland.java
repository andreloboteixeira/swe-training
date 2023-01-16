package coding.problems.java;

import java.util.*;

public class Leetcode695ProblemMaxAreaOfIsland{

    public static void main(String[] args) {
        System.out.println("------ EXAMPLE 1");
        System.out.println(Leetcode695ProblemMaxAreaOfIsland.maxAreaOfIsland(new int[][]{
            {0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}
        }));
        System.out.println("------ EXAMPLE 2");
        System.out.println(Leetcode695ProblemMaxAreaOfIsland.maxAreaOfIsland(new int[][]{
            {0,0,0,0,0,0,0,0,0,0,0,0,0}
        }));
    }

    // t: O(M*N), s: O(M*N)
    public static int maxAreaOfIsland(int[][] grid) {

        List<Integer> islandsAreas = new ArrayList<>();
        Integer maxArea = 0;

        Integer rowSize = grid.length;
        Integer colSize = grid[0].length;

        boolean[][] visited = new boolean[rowSize][colSize];

        for(int r = 0; r < rowSize; r++){
            for(int c = 0; c < colSize; c++){
                if(grid[r][c] == 1 && !visited[r][c]){
                    Integer area = Leetcode695ProblemMaxAreaOfIsland.connectedRegionArea(grid, visited, r, c);
                    System.out.println(area);
                    islandsAreas.add(area);
                    maxArea = Integer.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private static Integer connectedRegionArea(int[][] grid, boolean[][] visited, int r, int c){
        Integer rowSize = grid.length;
        Integer colSize = grid[0].length;

        Integer area = 0;

        List<int[]> pixelsToProcess = new ArrayList<>();
        pixelsToProcess.add(new int[]{r,c});

        while(!pixelsToProcess.isEmpty()){

            int[] currPixel = pixelsToProcess.remove(0);
            int row = currPixel[0];
            int col = currPixel[1];

            if(row >= rowSize || row < 0 || col >= colSize || col < 0){
                continue;
            }

            if(grid[row][col] == 1 && !visited[row][col]){
                area++;
                visited[row][col] = true;

                pixelsToProcess.add(new int[]{row, col + 1});
                pixelsToProcess.add(new int[]{row, col - 1});
                pixelsToProcess.add(new int[]{row - 1, col});
                pixelsToProcess.add(new int[]{row + 1, col});

            } else {
                visited[row][col] = true;
            }
        }

        return area;
    }
}
