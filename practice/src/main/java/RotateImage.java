import java.util.Arrays;

public class RotateImage {
    
    public static void main(String[] args) {
        //int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix ={{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        RotateImage rImage=new RotateImage();
        printMatrix(matrix);
        System.out.println(); 
        rImage.rotate(matrix);
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public void rotate(int[][] matrix) {
        
        //int steps =matrix.length;
        int length = matrix.length;
        int lowerRowBound =  0;
        int lowerColBound =  0;
        int upperRowBound =  length-1;
        int upperColBound =  length-1;
        
        while(lowerRowBound < upperRowBound || lowerColBound < upperColBound){
            rotateRecursive( matrix, lowerRowBound, upperRowBound, lowerColBound, upperColBound);
            lowerColBound++;upperColBound--;lowerRowBound++;upperRowBound--;
        }
        

    }

    private void rotateRecursive(int[][] matrix,int lowerRowBound,int upperRowBound,int lowerColBound,int upperColBound) {
        int steps = upperRowBound-lowerRowBound;
        for(int i=0;i<steps;i++){
            rotateRight(matrix,lowerRowBound,upperRowBound,lowerColBound,upperColBound);
            
        }
    }

    private void rotateRight(int[][] matrix,int lowerRowBound,int upperRowBound,int lowerColBound,int upperColBound) {
    
        //do processing of outer steps and recursively call for inner circle
        int rowProcessingIndex=lowerRowBound;
        int colProcessingIndex = upperColBound;
        int lastVal= processTop(matrix,rowProcessingIndex,lowerColBound,upperColBound);

        lastVal= processRight(matrix,colProcessingIndex,lowerRowBound,upperRowBound,lastVal);
       
        rowProcessingIndex=upperRowBound;
        colProcessingIndex = lowerColBound;
        lastVal= processBottom(matrix,rowProcessingIndex,lowerColBound,upperColBound,lastVal);
        lastVal= processLeft(matrix,colProcessingIndex,lowerRowBound,upperRowBound,lastVal);
       
        
 
        
    }

    private int processTop(int[][] matrix, int rowProcessingIndex, int lowerColBound, int upperColBound) {
        int lastVal=matrix[rowProcessingIndex][lowerColBound];
        for(int j=lowerColBound+1;j<=upperColBound;j++){
            lastVal= move(matrix, lastVal, rowProcessingIndex, j);
        }
        return lastVal;
    }

    private int processRight(int[][] matrix, int colProcessingIndex, int lowerRowBound, int upperRowBound,
            int lastVal) {
        for(int i=lowerRowBound+1;i<=upperRowBound;i++){
            lastVal = move(matrix, lastVal, i, colProcessingIndex);
        }
        return lastVal;
    }

   

    private int processBottom(int[][] matrix, int rowProcessingIndex, int lowerColBound, int upperColBound,
            int lastVal) {
            
            for(int j=upperColBound-1;j>=lowerColBound;j--){
                lastVal= move(matrix, lastVal, rowProcessingIndex, j);
            }
            return lastVal;
    }

    private int processLeft(int[][] matrix, int colProcessingIndex, int lowerRowBound, int upperRowBound, int lastVal) {
        for(int i=upperRowBound-1;i>=lowerRowBound;i--){
            lastVal = move(matrix, lastVal, i, colProcessingIndex);
        }
        return lastVal;
    }

    int move(int[][] matrix,int lastVal,int row2,int col2){
        int temp = matrix[row2][col2];
        matrix[row2][col2]=lastVal;
        return temp;
    }

    

    



}
