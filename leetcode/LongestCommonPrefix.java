class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        
        //account for input of 0
        if (strs.length == 0){ return ""; }

        //start by containing the first String
        String prefix = strs[0];

        //get the length of the prefix
        int p_end = prefix.length();

        if (p_end < 0){ return ""; }

        //iterate through all the Strings
        for (String s : strs){

            //while the prefix does not match the current string
            while (s.indexOf(prefix) != 0){
                
                //decrease the last character index
                p_end--;
                
                //if p_end becomes negative, return an empty string
                if (p_end < 0){ return ""; }

                //update prefix
                prefix = prefix.substring(0, p_end);
            }
        }

        return prefix;
    }
}
