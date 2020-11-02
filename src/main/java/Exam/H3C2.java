package Exam;

/**
 * @author 任青成
 * @date 2020/10/19 20:43
 */
public class H3C2 {
    public String character_auto_complete (String str) {
        // write code here
        if ("S".equals(str)){
            return "Saturday Sunday";
        }else if ("T".equals(str)){
            return "Tuesday Thursday";
        }else if ("M".equals(str)){
            return "Monday";
        }else if ("W".equals(str)){
            return "Wednesday";
        }else if ("F".equals(str)){
            return "Friday";
        }else {
            return "No match";
        }

    }
}
