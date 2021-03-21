package in.inishant.practice.lc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindAndReplaceInString {
    public static void main(String[] args) {
        FindAndReplaceInString fs=new FindAndReplaceInString();
        String s = "jjievdtjfb"; 
        int[] indexes = {4,6,1};
         String[] sources = {"md","tjgb","jf"};
        String[] targets = {"foe","oov","e"};
        String mod= fs.findReplaceString(s, indexes, sources, targets);

        System.out.println("original = " + s);
        System.out.println("modified = " + mod);


    }

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
       // int[] origArr= Arrays.copyOf(indexes, indexes.length);
        Map<Integer,String> source_target = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            source_target.put(indexes[i],sources[i]+"_"+targets[i]);
        }
        Arrays.sort(indexes);
        
       // char[] origArray = S.toCharArray();
        StringBuilder sb= new StringBuilder();
        int processedIndex = -1;
        for (int i = 0; i < indexes.length; i++) {
            //add all before next index to stringbuilder
            int currentIndex = indexes[i];

            //move processedIndex pointer of original string to just before index pointer.
            if(currentIndex < S.length()){
                if(processedIndex < currentIndex-1){

                    sb.append(S.substring(processedIndex+1, currentIndex));
                    processedIndex=currentIndex-1;
                }
                //match indexes for source and orignal string 
                String[] s_t = source_target.get(currentIndex).split("_") ;
                String source = s_t[0];
                // can cause index out of bounds : TODO check :  currentIndex+source.length() <=  S.length
                String subStringTobeMatched = S.substring(currentIndex, currentIndex+source.length());
                //if matched add the target string and move processedIndex pointer of original to end of source string 
                if(subStringTobeMatched.equals(source) ){
                    sb.append(s_t[1]);
                    processedIndex = currentIndex+source.length()-1;
                }
                //else continue;
            }

            
        }
        // if processed index is less than length -1 of original string, add all processed index to end of string.
        if(processedIndex < S.length() -1){
            sb.append(S.substring(processedIndex+1, S.length()));
        }

        return sb.toString();
    }
}
