class FindDifference {

    ////////////////////
    //HASHMAP SOLUTION//	
    ////////////////////
    public char findTheDifference(String s, String t) {
        
        int sLen = s.length();
        int tLen = t.length();

        //if s was blank, return the new character
        if (sLen < 1){
            return t.charAt(0);
        }

        //create a map of all characters and fill it with the number of times
        // a character has appeared in s
        HashMap<Character, Integer> sChars = new HashMap<>();
        for (int i=0; i<sLen; i++){
            //put into the hashmap,
            // key: current character
            // value: the value that currently resides at that key + 1
            if (sChars.get(s.charAt(i)) != null){
                sChars.put(s.charAt(i), sChars.get(s.charAt(i))+1);
            }
            else{
                sChars.put(s.charAt(i), 1);
            }
        }

        //do the same for t
        HashMap<Character, Integer> tChars = new HashMap<>();
        for (int j=0; j<tLen; j++){
            //put into the hashmap,
            // key: current character
            // value: the value that currently resides at that key + 1
            if (tChars.get(t.charAt(j)) != null){
                tChars.put(t.charAt(j), tChars.get(t.charAt(j))+1);
            }
            else{
                tChars.put(t.charAt(j), 1);
            }
        }

        //now check all the key-values in j and compare them to s
        for (char c : t.toCharArray()){
            //if the value for a key in t is null in sChars,
            // it's the new character
            if (sChars.get(c) == null){ return c; }

            //if the value for a key in tChars is more than the value
            // in sChars, it is the new character
            if (sChars.get(c) < tChars.get(c)){ return c; }
        }
	//won't compile without this
        return 'z';
    }


    //////////////////////
    //ASCII SUM SOLUTION//
    //////////////////////
    @Override
    public char findTheDifference(String s, String t) {
        //ASCII characters are represented as numbers
        int result = 0;

        //add the characters of t as integers
        for (char c : t.toCharArray()){
            result += (int)c;
        }

        //subtract the characters of s as integers
        for (char c : s.toCharArray()){
            result -= (int)c;
        }

        //return the difference
        return (char)result;

    } 
}
