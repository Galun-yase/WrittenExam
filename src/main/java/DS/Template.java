package DS;

/**
 * @author 任青成
 * @date 2020/9/4 14:06
 */
//模板方法模式：由一个抽象类和一组实现组成，抽象类定义一个操作中算法的框架，而将一些步骤延迟到子类实现
public class Template {

    public static int[] a = { 10, 32, 1, 9, 5, 7, 12, 0, 4, 3 }; // 预设数据数组
    public static void main(String[] args){
        AbstractSort s = new ConcreteSort();
        s.showSortResult(a);
    }

}
abstract class AbstractSort {

    /**
     * 将数组array由小到大排序
     * @param array
     */
    protected abstract void sort(int[] array);

    public void showSortResult(int[] array) {
        this.sort(array);
        System.out.print("排序结果：");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%3s", array[i]);
        }
    }
}
class ConcreteSort extends AbstractSort {
    @Override
    protected void sort(int[] array){
        for(int i=0; i <= array.length-1; i++){
            selectSort(array, i);
        }
    }

    private void selectSort(int[] array, int index) {
        int MinValue = 32767; // 最小值变量
        int indexMin = 0; // 最小值索引变量
        int Temp; // 暂存变量
        for (int i = index; i <= array.length-1; i++) {
            if (array[i] <= MinValue){ // 找到最小值
                MinValue = array[i]; // 储存最小值
                indexMin = i;
            }
        }
        Temp = array[index]; // 交换两数值
        array[index] = array[indexMin];
        array[indexMin] = Temp;
    }
}