package workingWithAbstraction.jediGalaxy;

public class Filed {
    private int[][] matrix;
    public Filed(int rows, int cols){
        this(rows,cols,0);

    }
    public Filed(int rows, int cols, int beginFillValue){
        this.matrix = new int[rows][cols];
        this.fillValues(beginFillValue);
    }
    private void fillValues(int beginValue){
        for(int row = 0; row < this.matrix.length; row++){
            for (int col = 0; col < this.matrix[row].length; col++) {
                this.matrix[row][col] = beginValue++;
            }
        }
    }

    public boolean isInBounds(int row, int col) {
            return row >=0 && row < this.matrix.length && col>= 0 && col < this.matrix[0].length;//////////
    }

    public void setValue(int rowSith, int colSith, int newValue) {
        this.matrix[rowSith][colSith] = newValue;
    }

    public int getColLenght(int row) {
        return this.matrix[row].length;
    }

    public int getValue(int rowJedi, int colJedi) {
        return this.matrix[rowJedi][colJedi];
    }
}
