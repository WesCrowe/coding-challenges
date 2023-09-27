/* 
 * Given an array of integers nums and an integer target, return 
 * indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n^2) time complexity?
 */
public class TwoSum {
    
    //O(n^2) solution
    public int[] TwoSum(int[] nums, int target) {
        int[] indexes = new int[2];
        bool isDone = false;

        for (int i = 0; i< nums.Length; i++){
            for (int j = i+1; j<nums.Length; j++){
                
                //skip the current index
                if (i == j){
                    continue;
                }
                
                //compare values to target
                if (nums[i]+nums[j] == target){
                    indexes[0] = i;
                    indexes[1] = j;
                    isDone = true;
                    break;
                }
            }
            if (isDone){ break; }
        }
        return indexes;
    }
}