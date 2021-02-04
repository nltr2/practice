package in.inishant.practice.lc.codingChallenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        HashMap<Integer,Integer> map = new HashMap<>();
        boolean isCycle = false;
        ListNode temp=head;
        
        while(temp !=null ){
            Integer key = temp.hashCode();
            if(map.containsKey(key))
                {
                    isCycle = true;
                    break;
                }else{
                    map.put(key, key);
                    temp= temp.next;
                }
            
        }
        return isCycle;
    }


   
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
}
