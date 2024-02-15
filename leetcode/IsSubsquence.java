class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        
        int sLen = s.length();
        int tLen = t.length();

        //if s is bigger than t, then it cannot be a subsequence
        if (sLen > tLen){ return false; }

        //indices for s and t
        int si = 0;
        int ti = 0;

        //while all characters of s have not been found
        while (si < sLen){

            //if index of t goes out of bounds, return false
            if (ti == tLen){ return false; }

            //if current character of t is next for s,
            // increase index of s
            if (t.charAt(ti) == s.charAt(si)){ si++; }

            //increase index of t
            ti++;
        }

        //loop ends if all characters of s have been found
        return true;
    }
}
