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

using std::vector;

class TwoSum {
public:

    //O(n^2) Solution
    vector<int> twoSum(vector<int>& nums, int target) {
        
        vector<int> indexes;
        int isDone = 0;

        //we need to investigate all sums of the array
        for (int i=0; i < nums.size(); i++){
            for (int j=i+1; j < nums.size(); j++){

                //skip the current index
                if (i == j){
                    continue;
                }
                
                //compare values to target
                if (nums[i]+nums[j] == target){
                    indexes.push_back(i);
                    indexes.push_back(j);
                    isDone++;
                    break;
                }
            }
            if (isDone){ break; }
        }
        return indexes;
    }
};