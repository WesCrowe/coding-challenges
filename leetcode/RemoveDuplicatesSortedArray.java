import java.util.TreeSet;

class RemoveDuplicatesSortedArray {
    
    /* efficient solution */
    public int removeDuplicates(int[] nums){
           
        //create an index pointer
        int point = 1;

        //iterate through the array
        for (int i=1; i<nums.length; i++){

            //if the current value of the array is not equal to
            // the previous value, use the index pointer to move
            // it to earlier in the array
            if (nums[i] != nums[i-1]){
                nums[point] = nums[i];
                point++;
            }

        }

        //now the index pointer is the size of the array
        return point;
    }

    ////////////////////////////////////////////////////////
    /* slower solution, takes up time, but shows off sets */
    ////////////////////////////////////////////////////////
    public int slowerRemoveDuplicates(int[] nums) {
        
        //create a set to store unique values
        TreeSet<Integer> uniques = new TreeSet<>();

        //array is sorted, so add each value to the sorted set
        for (int i=0; i<nums.length; i++){
            uniques.add(nums[i]);
        }

        //get the size of the set
        int size = uniques.size();

        //use the set to modify the original array
        for (int i=0; i<size; i++){
            nums[i] = uniques.pollFirst();
        }

        //now return the size of the set
        return size;
    }
}