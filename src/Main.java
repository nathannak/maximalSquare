public class Main {

    public static void main(String[] args) {

        char[][] arr = { {'1','0','1','0','0'} , {'1','0','1','1','1'} , {'1','1','1','1','1'} , {'1','0','0','1','0'} };

        System.out.println( maximalSquare ( arr ) );

    }

    // optimized dp; remember dp[j] always refer to values for previous row [item on the top]
    // dp[j-1] refers to previous item we just optimized in current row [left item from current item]
    // prev refers to item in previous row , previous column item on top left
    // therefore we are basically getting minimum of item on the top, left, and top left + 1 , with only 1d array
    
    public static int maximalSquare(char[][] matrix) {

        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen * maxsqlen;

    }

}
