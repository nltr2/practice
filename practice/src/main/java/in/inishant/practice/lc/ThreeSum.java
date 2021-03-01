package in.inishant.practice.lc;

import java.util.*;

/**
 *  3SUM  
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums= {-1,0,1,2,-1,-4,-2,-3,3,0,4};
     //   int[] nums= {-1,0,1,2,-1,-4};
        ThreeSum ts=new ThreeSum();
        System.out.println(ts.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> sumList=new ArrayList<>();
        Map<Integer,Integer> map = null;
        //x
        for(int i=0;i<nums.length;i++){
            
            // populate map and remove current entry.
            int x = nums[i];
            if(x> 0) break;
            if(i>0 && nums[i] == nums [i-1]){
                continue;
            }
            map = new HashMap<>(nums.length,1);
            for(int j=i+1; j <nums.length;j++){
                    int y = nums[j];
                    //y,z=-(x+y) 

                    if(map.get(y) != null){
                        map.put(y,map.get(y)+1);
                    }else{

                        map.put(y,1);
                    }
            }
            HashSet<Integer> set=new HashSet<>();
            for (Map.Entry<Integer,Integer> e : map.entrySet()) {
                Integer count = e.getValue();
                Integer y = e.getKey();
                int z=-(x+y) ;


                if(y==z && count == 1 ){
                    continue;
                }
                if(map.get(z)!=null && ! set.contains(y)){
                    
                    List<Integer> list = new ArrayList<>(3);
                    list.add(x);
                    list.add(y);
                    list.add(z);
                    set.add(y);
                    set.add(z);
                    sumList.add(list);
                }
            }
        }

        return sumList;
    }
}
