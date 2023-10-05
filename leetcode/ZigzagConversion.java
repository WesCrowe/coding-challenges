class ZigzagConversion {
    public String convert(String s, int numRows) {
        
        //get the length of the string
        int sLen = s.length();

        //if 1 row OR the number of rows is at least the
        // length of the string, just return the string
        if (numRows == 1 || sLen <= numRows) { return s; }

        //the number of steps between each character of the
        // top row of the zigzagged string is equal to
        // numRows * 2 - 2
        int cycleStep = numRows * 2 - 2;
        
        //result string
        String zigzagged = "";

        /* Imagining the String already as a Zigzag */

        //this loop iterates through the "rows"
        for (int i=0; i<numRows; i++){
            //this loop iterates through the "columns",
            // skipping "entries" that are empty in the
            // zigzag pattern
            for (int j=0; i+j < sLen; j += cycleStep){

                //add the current character to the String
                zigzagged += s.charAt(j+i);


                /* In every row between the top and bottom, characters will
                 * be added in closer-together groups of two. The distance
                 * between the two characters in these groups is equal to 
                 * current "column" + cycleStep - current "row"
                 * 
                 * So after adding the character above to the string, we
                 * add the next one using the following if statement
                 */

                //i is not zero AND
                //i has not reached the last row AND
                //the next character step is not out of bounds
                if (i > 0 &&
                    i < numRows - 1 &&
                    j + cycleStep - i < sLen){
                        zigzagged += s.charAt(j+cycleStep-i);
                    }

            }
        }

        return zigzagged;
    }
}