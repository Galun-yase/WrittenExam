package Offer;

public class offer12 {
    public double Power(double base, int exponent) {
        if (exponent>=0){
            return fastM(base,exponent);
        }else {
            return 1/fastM(base,-exponent);
        }
    }
    private double fastM(double base,int exponent){
        if (base==0)return 0;
        if (exponent==0)return 1;
        if (base==1)return 1;
        if (exponent==1)return base;

        int res = 1;
        while (base!=0){
            if ((exponent&1)!=0){
                res*=base;
            }
            exponent = exponent>>1;
            base*=base;
        }
        return res;








//        int res=1;
//        while (exponent!=0){
//            if ((exponent&1)==1){
//                res*=base;
//            }
//            base*=base;
//            exponent=exponent>>>1;
//        }
//        return res;

    }
}
