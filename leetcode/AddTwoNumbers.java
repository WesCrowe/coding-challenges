/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits 
 * are stored in reverse order, and each of their nodes contains a single digit. Add the two 
 * numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Example:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class AddTwoNumbers {

    //O(max(m,n)) solution
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummyHead = new ListNode(); //dummy head node
        ListNode curr = dummyHead;           //current node
        int surplus = 0;                     //to carry a value to the next place

        //iterate until both linked lists are null and there is no surplus value.
        // sum from the back going forward.
        int x = 0;
        int y = 0;
        int sum = 0;
        while (l1 != null || l2 != null || surplus != 0) {
            
            //if l1 still has digits, use them
            if (l1 != null){ x = l1.val; }
            else{ x = 0; }
            
            //if l2 still has digits, use them
            if (l2 != null){ y = l2.val; }
            else{ y = 0; }
            
            //sum the current value
            sum = surplus + x + y;
            
            //get the leftover surplus
            surplus = sum / 10;

            //create a new next node without the surplus
            curr.next = new ListNode(sum % 10);

            //iterate to the next nodes
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        //the dummy head is generated with value 0, so
        // return it's next node
        return dummyHead.next;
    }
}