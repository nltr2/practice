package in.inishant.practice.lc.codingChallenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a path create a cannonical path
 * Input: path = "/a/./b/../../c/"
 * Output: "/c"
 * https://leetcode.com/problems/simplify-path/
 */
public class SimplifyPathUnixStyle {
    public static void main(String[] args) {
        SimplifyPathUnixStyle obj=new SimplifyPathUnixStyle();
        System.out.println(obj.simplifyPath("/a/./b/../../c/"));
        System.out.println(obj.simplifyPath("/home//foo/"));
        System.out.println(obj.simplifyPath("/../"));
        System.out.println(obj.simplifyPath("/home/"));
        System.out.println(obj.simplifyPath("/"));
       
    }

    public String simplifyPath(String path) {
        StringBuilder simplePath = new StringBuilder();
        String[] ca= path.split("/");
        List<String> simplePathList= new ArrayList<>(ca.length);
        if(ca.length != 0){
            for(int i=0;i<ca.length;i++){
                String key= ca[i];
                switch (key) {
                    case "."  :
                    break;
                    case ""  :
                    break;
                    case ".."  :

                    if (simplePathList.size()>0)
                        simplePathList.remove(simplePathList.size()-1);

                        break;

                    default:
                        simplePathList.add(key);
                        break;
                }

               

            }
            for (String string : simplePathList) {
                simplePath.append("/").append(string);
            }

        }
        if(simplePath.length() == 0){
            simplePath.append("/");
        }
        return simplePath.toString();
    }
}
