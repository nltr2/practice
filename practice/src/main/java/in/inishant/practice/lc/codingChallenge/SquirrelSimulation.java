package in.inishant.practice.lc.codingChallenge;

public class SquirrelSimulation {

    /**
     * https://leetcode.com/problems/squirrel-simulation/
     * Input: Height : 5 Width : 7 Tree position : [2,2] Squirrel : [4,4] Nuts :
     * [[3,0], [2,5]] Output: 12
     * 
     * @param args
     */
    public static void main(String[] args) {
        SquirrelSimulation sm = new SquirrelSimulation();

        int height = 5;
        int width = 7;
        int[] tree = { 2, 2 };
        int[] squirrel = { 4, 4 };
        int[][] nuts = { { 3, 0 }, { 2, 5 } };
         System.out.println(sm.minDistance(height, width, tree, squirrel, nuts));

        height = 5;
        width = 5;
        int[] tree1 = { 3, 2 };
        int[] squirrel1 = { 0, 1 };
        int[][] nuts1 = { { 2, 0 }, { 4, 1 }, { 0, 4 }, { 1, 3 }, { 1, 0 }, { 3, 4 }, { 3, 0 }, { 2, 3 }, { 0, 2 },
                { 0, 0 }, { 2, 2 }, { 4, 2 }, { 3, 3 }, { 4, 4 }, { 4, 0 }, { 4, 3 }, { 3, 1 }, { 2, 1 }, { 1, 4 },
                { 2, 4 } };
        System.out.println(sm.minDistance(height, width, tree1, squirrel1, nuts1));
    }

    /**
     * Remove all nuts out side the height and weight. Create a new Array valid
     * ones. 
     * First find max distance saving from right nut to squirell and tree using
     * abs|x-x1|+abs|y-y1|.
     * once squirell reaches the nearest nut then calculate
     * distance from that nut from tree for others, calculate distance of all other
     * nuts from tree * 2
     * 
     * @param height
     * @param width
     * @param tree
     * @param squirrel
     * @param nuts
     * @return
     */
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        // TODO:Remove all nuts out side the height and weight. Create a new Array valid
        // ones.
        int[][] nutsTObeCovered = nuts;
        int minDistanceNearestNutFromTree = Integer.MAX_VALUE;
        int nearestNutIndex = -1;

        // maximum distance saving for choosing right nut
        // then calculate max saving from tree for particular nut.n2
        int maxSaving = Integer.MIN_VALUE;
        for (int i = 0; i < nutsTObeCovered.length; i++) {
            int distanceFromNut = Math.abs(nuts[i][0] - squirrel[0]) + Math.abs(nuts[i][1] - squirrel[1]);
            int distanceFromTree = Math.abs(nuts[i][0] - tree[0]) + Math.abs(nuts[i][1] - tree[1]);
            int distance = distanceFromNut + distanceFromTree;
            int saving = 2*distanceFromTree - distance;
            if (maxSaving < saving) {
                nearestNutIndex = i;
                minDistanceNearestNutFromTree = distance;
                maxSaving= saving;
            }
        }
        System.out.println("nearestNutIndex: " + nearestNutIndex);
        System.out.println("nearestNutIndex: " + nuts[nearestNutIndex][0] + " "+ nuts[nearestNutIndex][1]);
        System.out.println("minDistanceNearestNut: " + minDistanceNearestNutFromTree);

        int distanceOfOtherNutsFromTree = 0;
        for (int i = 0; i < nutsTObeCovered.length; i++) {
            if (i != nearestNutIndex)
                distanceOfOtherNutsFromTree += Math.abs(nuts[i][0] - tree[0]) + Math.abs(nuts[i][1] - tree[1]);
        }

        int totalSum = minDistanceNearestNutFromTree+ distanceOfOtherNutsFromTree * 2;
        return totalSum;

    }

}