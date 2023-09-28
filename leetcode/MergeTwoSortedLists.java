class MergeTwoSortedLists {
	
    public class ListNode{
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) {this.val = val;}
	    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        //account for null lists
        if (list1 != null && list2 == null){ return list1; }
        else if (list1 == null && list2 != null){ return list2; }

        //create a dummy head and current node variables
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;

        //iterate until both lists are empty
        while (list1 != null || list2 != null){
            
            //if either one is null, add the rest of the other list
            if (list1 != null && list2 == null){
                curr.next = list1;
                break;
            }
            else if (list1 == null && list2 != null){
                curr.next = list2;
                break;
            }

            //add the next smallest node to the list
            else if (list1 != null && list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
            }
            else if (list2 != null && list1.val >= list2.val){
                curr.next = list2;
                list2 = list2.next;
            }

            //update the current node
            curr = curr.next;
        }

        //the dummy head's next is the true head
        return dummyHead.next;
    }
}
