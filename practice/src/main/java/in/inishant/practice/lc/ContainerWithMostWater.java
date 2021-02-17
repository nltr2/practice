package in.inishant.practice.lc;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater cmw=new ContainerWithMostWater();
        /* int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(cmw.maxArea(height));
        int[] height1 = {1,2,4,3};
        System.out.println(cmw.maxArea(height1)); */
        int[] height2 = {6,4,3,1,4,6,99,62,1,2,6};
        System.out.println(cmw.maxArea(height2));

    }

    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int[] currentIndex = {0,height.length-1};
        int[] finalIndex = {0,height.length-1};
        int currentMin =  Math.min(height[finalIndex[0]],height[finalIndex[1]]);

        while(i<j){
            if(calulateArea(height, currentIndex)> calulateArea(height, finalIndex)){
                finalIndex[0]= currentIndex[0];
                finalIndex[1]= currentIndex[1];
            }

            // if yes , then i is getting increased, else j is getting decreased,
        // for move from lower height to heigher height.
            boolean isFlowForward = height[currentIndex[0]] < height[currentIndex[1]]? true:false;
            while(isFlowForward && i<j){
                i++;
                if(currentMin<height[i]){
                    currentIndex[0]=i;
                    break;
                }
            }
            
            while(!isFlowForward && i<j){
                j--;
                if(currentMin<height[j]){
                    currentIndex[1]=j;
                    break;
                }
            }
        }
        return calulateArea(height, finalIndex);
    }

    int calulateArea(int[] height,int[] index){
        return Math.min(height[index[0]],height[index[1]]) * (index[1]-index[0]);
    }
}
