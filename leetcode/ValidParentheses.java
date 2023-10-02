import java.util.Stack;

class ValidParentheses {
    public boolean isValid(String s) {

        //create a stack
        Stack<Character> parens = new Stack<>();

        for (int i=0; i<s.length(); i++){
            
            //get the current character
            char currChar = s.charAt(i);

            //if the current character is an opening bracket, put into stack
            if (currChar == '(' || currChar == '[' || currChar == '{'){
                parens.push(currChar);
            }
            //if the current character is a closing bracket, pop from the stack
            else{
                //if the stack is already empty, then not valid
                if (parens.isEmpty()){ return false; }

                //if the closing bracket matches, pop the stack
                char top = parens.peek();
                if ( (top == '(' && currChar == ')') ||
                     (top == '[' && currChar == ']') ||
                     (top == '{' && currChar == '}')
                    ){
                        parens.pop();
                }
                
                //if it does not match, then not valid
                else{
                    return false;
                }
            }
        }
        //if the stack is empty, then valid
        return parens.isEmpty();
    }
}