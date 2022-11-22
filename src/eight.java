public class eight {


    public static void main(String[] args) {
        int[] queens = new int[8];
        solve(queens, 0);
        prettyPrint(queens);
    }

    /**
     * try to find a valid column for the queen on row i and recursively call for all the next rows.
     */
    private static boolean solve(int[] queens, int i) {
        if(i >= queens.length) {
            return true;
        }       

        for(queens[i] = 0; queens[i] < queens.length ; queens[i]++) {
            if(!isAttacking(queens, i) && solve(queens, i+1)){
                return true;
            }
        }
        return false;
    }

    /**
     * check if the queen on the given row is attacking a queen on any of the previous rows
     */
    private static boolean isAttacking(int[] queens, int row){
        //check same column
        for(int prevRow = 0; prevRow < row; prevRow++){
            if (queens[prevRow] == queens[row]) {
                return true;
            }
        }

        //check diagonals
        for(int prevRow = 0; prevRow < row; prevRow++) {
            if(Math.abs(prevRow - row) ==
                    Math.abs(queens[prevRow] - queens[row])){
                return true;
            }
        }
        return false;
    }

    private static void prettyPrint(int[] queens){
        StringBuilder output = new StringBuilder();
        for (int row : queens) {
            for (int col = 0; col < queens.length; col++) {
                if (row == col) {
                    output.append('Q');
                } else {
                    output.append('X');
                }
                output.append('|');
            }
            output.append('\n');
        }
        System.out.println(output.toString());
    }
}
