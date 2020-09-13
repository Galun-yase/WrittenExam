
public class Main {



}
















































//    private static int dfs(int[] price,int has,int index){
//        if (has<price[index]){
//            return -1;
//        }
//        int temp = has;
//        int res = 0;
//        int i = index;
//        while (temp>0 && i<price.length){
//            res += temp/price[i];
//            temp=temp%price[i];
//            i++;
//            if (temp==0){
//                return res;
//            }
//        }
//        return -1;
//    }
//
//
//
//    public static int minZ(String[] array){
//        if (array.length<2)return -1;
//        int[] price = new int[array.length-1];
//        int has = Integer.parseInt(array[array.length-1]);
//        for (int i = 0; i < array.length-1; i++) {
//            price[i] = Integer.parseInt(array[i]);
//        }
//
//        Arrays.sort(price);
//        int res = Integer.MAX_VALUE;
//        for (int i = 0; i < price.length; i++) {
//            int dfs = dfs(price, has, i);
//            if (dfs!=-1){
//                res = Math.min(dfs,res);
//            }
//        }
//        if (res==Integer.MAX_VALUE){
//            return -1;
//        }else {
//            return res;
//        }
//
//    }
//
////    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
////        while (scanner.hasNext()){
////            String s = scanner.nextLine();
////            String[] str = s.split(" ");
////            System.out.println(minZ(str));
////        }
////
////
////    }