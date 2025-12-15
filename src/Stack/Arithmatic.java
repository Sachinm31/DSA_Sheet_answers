package Stack;
import java.util.*;
import java.util.Stack;

//Some examples:
//        ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//        ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
public class Arithmatic {
    public static int operation(String tokens[]){
        String op = "+-*/";
        Stack<String>st = new Stack<>();
        int returnValue = 0 ;

        for(String t : tokens){
            if(!op.contains(t)){
                st.push(t);
            }else {
                int a = Integer.valueOf(st.pop());
                int b = Integer.valueOf(st.pop());
                int index = op.indexOf(t);

                switch (index){
                    case 0 :
                        st.push(String.valueOf(a+b));
                        break;
                    case 1 :
                        st.push(String.valueOf(a-b));
                        break;
                    case 2 :
                        st.push(String.valueOf(a*b));
                        break;
                    case 3 :
                        st.push(String.valueOf(b/a));
                        break;
                }
            }
        }
        returnValue = Integer.valueOf(st.pop());
        return returnValue;
    }

    public static void main(String[] args) {
        String token[] = {"4", "13", "5", "/", "+"};
        System.out.println(operation(token));
    }
}
