package in.inishant.practice.lc;

import java.util.Arrays;
/**
 * Rotate only works for n*n matrix
 */
public class RotateImage2 {

    public static void main(String[] args) {
        //int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix ={{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        print2dMatrix(matrix);
        RotateImage2 rt2=new RotateImage2();
        rt2.rotate(matrix);
        print2dMatrix(matrix);
        
        rt2.rotateAnticlockwise(matrix);
        System.out.println("order changed to see effect");
        print2dMatrix(matrix);
    }

    public void rotateAnticlockwise(int[][] matrix) {
        mirrorMatrix(matrix);
        transposeMatrix(matrix);

    }
    /**
     * Rotate clockwise
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        transposeMatrix(matrix);
        mirrorMatrix(matrix);

    }

    private void mirrorMatrix(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length/2;j++){
                int temp = matrix[i][j];
                //last column index to be subtracted by current col index
                int coltoBeSwapped= (n-1) - j;
                matrix[i][j]=matrix[i][coltoBeSwapped];
                matrix[i][coltoBeSwapped]=temp;
            }
        }
    }

    private void transposeMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            //System.out.println("i="+i);
            // print2dMatrix(matrix);
            //j = i as outer column is processed already.
            for(int j=i;j<matrix.length;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }

    private static void print2dMatrix(int[][] matrix) {
        System.out.println();
        for(int i=0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println();
    }
}
