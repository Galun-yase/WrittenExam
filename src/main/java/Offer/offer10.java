package Offer;

public class offer10 {

    public static int RectCover(int target) {
        if (target<1)return 0;
        if (target<=2)return target;

        return RectCover(target-1)+RectCover(target-2);


    }
}
