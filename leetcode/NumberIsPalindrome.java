/* 
 * Given an integer x, return true if x is a palindrome, and false otherwise. 
 * 
 */
class NumberIsPalindrome {
    public boolean isPalindrome(int x) {
        
        //turn the integer into a string
        //store its length
        String numString = Integer.toString(x);
        int strLen = numString.length();
        
        //set the limit for the loop, accounting for odd
        // or even number of characters
        int limit = 0;
        if (strLen % 2 > 0){
            limit = strLen/2+1;
        }
        else{
            limit = strLen/2;
        }

        //iterating from front-and-back to middle, compare
        // the characters of the String
        int i = 0;
        int j = strLen-1;
        while (i<limit){
            if (numString.charAt(i) != numString.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}