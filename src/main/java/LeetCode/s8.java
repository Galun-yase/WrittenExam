package LeetCode;

/**
 * @author 任青成
 * @date 2020/8/24 22:02
 */
public class s8 {
    public int myAtoi(String str) {
        if (str.length()==0 || str==null ||str.equals("+")||str.equals("-"))return 0;
        str = str.replaceFirst("[\\s]*", "");
        if (str.startsWith("+-")||str.startsWith("-+"))return 0;
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i)>'9'||str.charAt(i)<'0'){
                break;
            }
            sb.append(str.charAt(i));

        }
        str = sb.toString();
        str = str.replaceFirst("0*", "");
        if (str.length()>12)return 0;
        if ((str.charAt(0)<'9'+1 && str.charAt(0)>'0'-1)|| str.charAt(0)=='+'){
            Long a = new Long(str);
            if (a>Integer.MAX_VALUE)return Integer.MAX_VALUE;
            return new Integer(str);
        }
        if (str.charAt(0)=='-'){
            Long a = new Long(str);
            if (a<Integer.MIN_VALUE)return Integer.MIN_VALUE;
            return new Integer(str);
        }
        return 0;
    }

    public static void main(String[] args) {

        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());

        ClassLoader contextClassLoader = thread.getContextClassLoader();
        System.out.println(contextClassLoader.getParent().toString());
        System.gc();
    }

}
