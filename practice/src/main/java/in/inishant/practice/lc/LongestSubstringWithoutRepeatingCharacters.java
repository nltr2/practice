package in.inishant.practice.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem statement: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * 
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        String s  = "abcabcbb";
        System.out.println(obj.lengthOfLongestSubstring(s));
        s = "bbbbb";
        System.out.println(obj.lengthOfLongestSubstring(s));
        s = "pwwkew";
        System.out.println(obj.lengthOfLongestSubstring(s));
        s = "aab";
        System.out.println(obj.lengthOfLongestSubstring(s));
        
    }

    //Take 1 : failed
    public int lengthOfLongestSubstringTake1Failed(String s) {
        int len = 0;
        //base condition
        if(s == null || s.length() == 0) return len;

        char[] arr= s.toCharArray();
        Map<Integer,Integer>  map = new HashMap<>();
        for(int i=0;i<arr.length ; i++){
            if(map.containsKey(Integer.valueOf(arr[i])) ){
               len=Math.max(len, map.values().size()); 
               map =new HashMap<>();
             }
            map.put(Integer.valueOf(arr[i]), i);
            
        }
    

        return Math.max(len,map.values().size());
    }


    take 2 halted:
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        //base condition
        if(s == null || s.length() == 0) return len;
        //for size 1 string
        len = 1;
        char[] arr= s.toCharArray();
        int i=0,j=1;
        for(;i<arr.length && j< arr.length; ){
            if(arr[j] == arr[i]){
                len = Math.max(len, j-i);
                i++;
            }
        }        

     return len;
    }
}
