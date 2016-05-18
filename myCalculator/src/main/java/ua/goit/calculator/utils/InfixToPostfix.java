package ua.goit.calculator.utils;

import java.util.*;

public class InfixToPostfix {

// Private methods:

   private boolean isOperator(char c) { // Tell whether c is an operator.

     return c == '+'  ||  c == '-'  ||  c == '*'  ||  c == '/'  ||  c == '^'
           || c=='(' || c==')';   
   } 

   private boolean isSpace(char c) {  // Tell whether c is a space.
     return (c == ' ');   
   }


   private boolean lowerPrecedence(char op1, char op2) {            
      switch (op1) {
         case '+':
         case '-':
            return !(op2=='+' || op2=='-') ;

         case '*':
         case '/':
            return op2=='^' || op2=='(';

         case '^':
            return op2=='(';

         case '(': return true;

         default:  // (shouldn't happen)
            return false;
      } 
   } 


// Method to convert infix to postfix:

   public String convertToPostfix(String infix) {
      // Return a postfix representation of the expression in infix.

     Stack operatorStack = new Stack();  // the stack of operators

     char c;       // the first character of a token
   
     StringTokenizer parser = new StringTokenizer(infix,"+-*/^() ",true);
                   // StringTokenizer for the input string

     StringBuffer postfix = new StringBuffer(infix.length());  // result
 
     // Process the tokens.
        while (parser.hasMoreTokens()) {
                                        
           String token = parser.nextToken();          
                                                             
           c = token.charAt(0);         
   
           if ( (token.length() == 1) && isOperator(c) ) {    
                                                             
     
              while (!operatorStack.empty() &&
                  !lowerPrecedence(((String)operatorStack.peek()).charAt(0), c))               
             
                 postfix.append(" ").append((String)operatorStack.pop());

              if (c==')') {
                    String operator = (String)operatorStack.pop();
                    while (operator.charAt(0)!='(') {
                       postfix.append(" ").append(operator);
                       operator = (String)operatorStack.pop();
                    }
              }
              else
                 operatorStack.push(token);// Push this operator onto the stack.
   
           }
           else if ( (token.length() == 1) && isSpace(c) ) {    // else if token was a space ignore it
           }
           else {  // (it is an operand)
             postfix.append(" ").append(token);  // output the operand
           }
 
         }
 
     // Output the remaining operators on the stack.
        while (!operatorStack.empty())
           postfix.append(" ").append((String)operatorStack.pop());   

       return postfix.toString();
   }
}
