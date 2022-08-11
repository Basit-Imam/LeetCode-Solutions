/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water. 

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
*/

class Solution {
    //create direction array which will in exploring all 4 neighbours
    //             {top, left, down, rigth}
    static int[] rdir = {-1, 0, 1, 0};
    static int[] cdir = {0, -1, 0, 1};

    public int numIslands(char[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == '1'){
                    dfs(grid, r, c);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int r, int c){
        //base case
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0')
            return;
        
        //set current cell to 0 so it doesn't repeat
        grid[r][c] = '0';
        
        //call all 4 neighbours
        for(int d = 0; d < 4; d++){
            int row = r + rdir[d];
            int col = c + cdir[d];
            dfs(grid, row, col);
        }
    }
}
