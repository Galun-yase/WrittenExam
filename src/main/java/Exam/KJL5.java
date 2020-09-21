package Exam;

/**
 * @author 任青成
 * @date 2020/9/20 18:47
 */
//LC223
public class KJL5 {

        private int sum(int[] a){
        int A = a[0];
        int B = a[1];
        int C = a[2];
        int D = a[3];
        int E = a[4];
        int F = a[5];
        int G = a[6];
        int H = a[7];

        if (E>=C || B>=H || F>=D || A>=G){
            return (D-B)*(C-A)+(H-F)*(G-E);
        }
        int h = Math.min(D,H)-Math.max(B,F);
        int l = Math.min(C,G)-Math.max(A,E);
        return (D-B)*(C-A)+(H-F)*(G-E)-h*l;
    }


    public static void main(String[] args) {
        int[] a = {-3,0,3,4,0,-1,9,2};
        int sum = new KJL5().sum(a);
        System.out.println(sum);
    }

}
