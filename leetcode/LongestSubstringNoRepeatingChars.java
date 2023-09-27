/*
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 */
import java.util.*;
class LongestSubstringNoRepeatingChars {

    public int lengthOfLongestSubstring(String s) {
        
        int longest = 0; //length of longest substring
        int pin = 0;     //index of starting character of current substring
        
        //create a set to keep track of characters used
        // a set is useful because it won't allow repeat values
        Set<Character> charSet = new HashSet<>();

        for (int i=0; i<s.length(); i++){
            
            //if the current character is successfully added to
            // the set, add it to the substring
            if (charSet.add(s.charAt(i))){
                //adjust longest substring
                longest = Math.max(longest, i - pin + 1);
            }
            //if it doesn't fit, move on
            else{
                //clear the set
                while (charSet.contains(s.charAt(i))){
                    charSet.remove(s.charAt(pin));
                    pin++;
                }
                
                //in the case of "cbab", should be left with "ab" in the set
                charSet.add(s.charAt(i));
            }
        }
        //return the length of the longest substring
        return longest;
    }
}