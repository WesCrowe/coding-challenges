/* 
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * 
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 
 * For example, 2 is written as II in Roman numeral, just two ones added together.
 * 12 is written as XII, which is simply X + II. 
 * The number 27 is written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right. 
 * However, the numeral for four is not IIII. Instead, the number four is written 
 * as IV. Because the one is before the five we subtract it making four. The same 
 * principle applies to the number nine, which is written as IX. There are six 
 * instances where subtraction is used:
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90. 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 */

class RomanNumeralToInt {

    /* A semi-fancy solution to show off try-catch */
    public int romanToInt(String s) {

        //get the string length
        int sLen = s.length();

        //account for empty string
        if (sLen == 0){ return 0; }

        //create arrays with keys and values
        char[] numerals = {'I','V','X','L','C','D','M'};
        int[] values = {1, 5, 10, 50, 100, 500, 1000};

        //create a map and populate it with keys and values
        Map<Character, Integer> numVals = new HashMap<>();
        for (int i=0; i<numerals.length; i++){
            numVals.put(numerals[i], values[i]);
        }

        //iterate through the roman numerals
        int positive = 0;
        int negative = 0;
        for (int i=0; i < sLen; i++){
            //get the current value
            int currVal = numVals.get(s.charAt(i));
            try{
                //get the next value
                int nextVal = numVals.get(s.charAt(i+1));

                //if the numeral is less than the numeral to its right,
                // it is a numeral to subtract
                if (currVal < nextVal){
                    negative += currVal;
                    //skip to the next iteration
                    continue;
                }
            }
            //will catch an index out-of-bounds error at end of loop
            // should move on to the last value being added without issue
            catch(Exception e){}

            //elsewise, it is a numeral to add
            positive += currVal;
        }

        return positive-negative;
    }

    /* A more technically efficient solution */
    @Override
    public int romanToInt(String s) {
        
        //create a map and populate it with numerals and values
        Map<Character, Integer> numVals = new HashMap<>();
        numVals.put('I', 1);
        numVals.put('V', 5);
        numVals.put('X', 10);
        numVals.put('L', 50);
        numVals.put('C', 100);
        numVals.put('D', 500);
        numVals.put('M', 1000);
        
        //iterate through the numerals
        int val = 0;
        for (int i = 0; i < s.length(); i++) {

            //if the current numeral is not the last one AND
            //the current numeral is of lesser value than the next one
            if (i < s.length() - 1 &&
                numVals.get(s.charAt(i)) < numVals.get(s.charAt(i + 1))) {
                
                    //subtract the current numeral's value
                    val -= numVals.get(s.charAt(i));
            }
            //elsewise, add the current numeral's value
            else {
                val += numVals.get(s.charAt(i));
            }
        }
        
        return val;
    }
}