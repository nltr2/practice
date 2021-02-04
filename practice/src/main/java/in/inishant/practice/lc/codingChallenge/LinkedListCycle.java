package in.inishant.practice.lc.codingChallenge;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        boolean isCycle = false;
        ListNode temp=head;
        set.add(temp);
        while(temp !=null && temp.next != null ){
            if(set.add(temp.next))
                temp = temp.next;
                else{
                    isCycle = true;
                    break;
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
