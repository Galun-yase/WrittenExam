import java.util.HashSet;

public class Main  {

    public boolean shudu(String[][] array){
        return condition1(array)&&condition2(array)&&condition3(array);
    }

    private boolean condition1(String[][] arr){
        for (int i = 0; i < arr.length; i++) {
            HashSet<String> set = new HashSet<>();
            for (int j = 0; j < arr[0].length; j++) {
                if (!".".equals(arr[i][j]) && set.contains(arr[i][j])){
                    return false;
                }else {
                    set.add(arr[i][j]);
                }
            }
        }
        return true;
    }

    private boolean condition2(String[][] arr){
        for (int i = 0; i < arr.length; i++) {
            HashSet<String> set = new HashSet<>();
            for (int j = 0; j < arr[0].length; j++) {
                if (!".".equals(arr[j][i]) && set.contains(arr[j][i])){
                    return false;
                }else {
                    set.add(arr[j][i]);
                }
            }
        }
        return true;
    }

    private boolean condition3(String[][] arr){
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                return condition4(arr,i,j);
            }
        }
        return true;
    }

    private boolean condition4(String[][] arr,int k,int g){
        HashSet<String> set = new HashSet<>();
        for (int i = k; i < k+3; i++) {
            for (int j = g; j < g+3; j++) {
                    if (!".".equals(arr[i][j]) && set.contains(arr[i][j])){
                        return false;
                    }else {
                        set.add(arr[i][j]);
                    }
            }
        }
        return true;
    }





}
