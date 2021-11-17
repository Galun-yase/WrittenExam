package FoundationDS;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution20 {


    /**
     * 括号匹配，用栈
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        Deque stack=new ArrayDeque();

        for (int i = 0; i <s.length() ; i++) {
            char temp=s.charAt(i);
            if (temp=='(' ||temp=='['||temp=='{'){
                stack.push(temp);
                continue;
            }
            if (stack.isEmpty()){return false;}
            char temp2=(char)stack.pop();
            if ((temp==')' && temp2!='(') ||(temp==']' && temp2!='[')||(temp=='}' && temp2!='{')){
                return false;
            }

        }
        if (!stack.isEmpty()){return false;}
        return true;

    }
}
