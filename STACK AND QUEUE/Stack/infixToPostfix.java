package Stack;

import java.util.Stack ;

public class infixToPostfix{
    
    static int prec(char c){
        if (c == '^'){
            return 3;
        }
        else if (c == '/' || c == '*'){
            return 2 ;
        }
        else if (c == '+' || c == '-'){
            return 1 ;
        }
        else
            return -1;
    }

    static char asosiatif(char c){
        if (c == '^'){
            return 'R';
        }
        return 'L';
    }

    static void infixToPostfix(String s){
        StringBuilder hasil = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int infix = s.length();
            for (int i = 0; i < infix; i++){
                char c = s.charAt(i);

                if((c >= 'a' && c <= 'z')||(c >= 'A' && c <= 'Z')||(c >='0' && c <= '9')){
                    hasil.append(c);
            }
                else if (c == '('){
                    stack.push(c);
                }
                else if (c == ')'){
                    while (!stack.isEmpty() && stack.peek() != '('){
                        hasil.append(stack.pop());
                    }
                    stack.pop();
                }
                else {
                    while(!stack.isEmpty() &&(prec(s.charAt(i))
                    <prec(stack.peek()) || prec(s.charAt(i)) == prec(stack.peek())
                    && asosiatif(s.charAt(i)) == 'L')){
                        hasil.append(stack.pop());
                    }
                    stack.push(c);
                }
            }
            while(!stack.isEmpty()){
                hasil.append(stack.pop());
            }
            System.out.println(hasil);
        }
        public static void main(String[] args){
            String call = "a+b*(c^d-e)^(f+g*h)-i";
            System.out.println("Infix : " + call);
            System.out.print("Postfix : "); infixToPostfix(call);
        }
}

    // sumber referensi dari https://www.geeksforgeeks.org/convert-infix-expression-to-postfix-expression/
    // judul artikel conversition ifnix to postfix expresion
    // nama pembuat tidak di ketahui