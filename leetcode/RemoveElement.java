class RemoveElement {

    /*
     * Leetcode's instructions are a little misleading. You cannot explicitly
     * remove value from a primitive array in java such as replacing a value
     * with a null value.
     * 
     * Assumption:
     * The solution to that in this case is to trust that the return value is
     * going to be used to prevent trying to access those values that are no-
     * longer relevant.
     */

    public int removeElement(int[] nums, int val) {
        
        //keep track of how many times the value appears
        int count = 0;

        for (int i = 0; i<nums.length; i++) {
            //if it's the value, increase the count
            //it will be replaced in the next iteration
            if (nums[i] == val){ count++; }
            //re-assign the array value
            else{
                nums[i-count] = nums[i];
            }
        }

        //return the desired number elements that "remain"
        return nums.length-count;
    }
}