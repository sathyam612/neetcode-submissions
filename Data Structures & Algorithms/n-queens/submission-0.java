class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        int[] queens = new int[n];
        backtrack(queens, 0, n);
        return result;
    }

    private void backtrack(int[] queens, int row, int n){

        if(row == n){
            result.add(buildBoard(queens, n));
            return;
        }


        for(int col=0;col<n;col++){
            if(isValid(queens, row, col)){
                queens[row] = col;
                backtrack(queens, row+1, n);
            }
        }
    }

    private boolean isValid(int[] queens, int row, int col){

        for(int r=0; r<row;r++){
            int c = queens[r];
            if(c == col || Math.abs(row-r) == Math.abs(col-c)){
                return false;
            }
        }

        return true;
    }

    private List<String> buildBoard(int[] queens, int n){
        List<String> board = new ArrayList<>();

        for(int r=0; r<n;r++){
            char[] rowChars = new char[n];
            Arrays.fill(rowChars,'.');
            rowChars[queens[r]] = 'Q';
            board.add(new String(rowChars));
        }

        return board;
    }
}
