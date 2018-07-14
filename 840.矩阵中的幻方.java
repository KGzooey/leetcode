
//最开始极其暴力的破解办法
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int row1,row2,row3;
        int col1,col2,col3;
        int dia1,dia2;
        int flag=1;
        int count = 0;
        if(grid.length < 3){
            return 0;
        }
        for(int i = 2; i < grid.length; i++){         
            for(int j = 2; j < grid[i].length; j++){ 
                if(grid[i].length < 3){
                    return 0;
                }
                if(grid[i][j] > 9 ||grid[i-1][j]>9 ||grid[i-2][j]>9 ||grid[i][j-1]>9 ||grid[i-1][j-1]>9 ||grid[i-2][j-1]>9 ||grid[i][j-2]>9 ||grid[i-1][j-2]>9 ||grid[i-2][j-2]>9){
                    continue;
                }
                if(grid[i][j]<1 ||grid[i-1][j]<1 ||grid[i-2][j]<1 ||grid[i][j-1]<1 ||grid[i-1][j-1]<1 ||grid[i-2][j-1]<1 ||grid[i][j-2]<1 ||grid[i-1][j-2]<1 ||grid[i-2][j-2]<1){
                    continue;
                }
                row1 = grid[i-2][j] + grid[i-2][j-1] + grid[i-2][j-2];
                row2 =  grid[i-1][j] + grid[i-1][j-1] + grid[i-1][j-2];
                row3 = grid[i][j] + grid[i][j-1] + grid[i][j-2];              
                if(row3 == row2 && row3 == row1){
                    col1 = grid[i][j-2] + grid[i-1][j-2] + grid[i-2][j-2];
                    col2 = grid[i][j-1] + grid[i-1][j-1] + grid[i-2][j-1];
                    col3 = grid[i][j] + grid[i-1][j] + grid[i-2][j];
                    if(col3 == col2 && col3 == col1 && col3 == row3){
                        dia1 = grid[i][j] + grid[i-1][j-1] + grid[i-2][j-2];
                        dia2 = grid[i][j-2] + grid[i-1][j-1] + grid[i-2][j];
                        if(dia1 == dia2 && row3 == dia1){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}