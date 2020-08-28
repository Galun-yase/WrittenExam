package Exam;

import java.util.ArrayList;
import java.util.Scanner;

//AC10% 图dfs遍历
public class Huawei3 {



        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            while (scanner.hasNext()){
                int n=scanner.nextInt();
                int[] array=new int[n];
                for (int i = 0; i < n; i++) {
                    array[i]=scanner.nextInt();
                }

                ArrayList<Integer>[] arr=new ArrayList[n];
                for (int i = 0; i < n; i++) {

                    arr[i]=new ArrayList<Integer>();
                    for (int j = 0; j < array[i]+2; j++) {
                        arr[i].add(scanner.nextInt());
                    }

                }
                int temp=0;
                for (int i = 0; i < n; i++) {
                    temp+=arr[i].get(1);

                }
                System.out.println(temp);





            }
        }


    }

