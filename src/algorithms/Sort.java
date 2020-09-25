package algorithms;
/*
排序算法java演示代码
* */

import java.io.Reader;
import java.util.*;

public class Sort {
    public static void main(String[] args) {
        Random r = new Random();
        int count = 10000;
        ArrayList<Integer> data1 = new ArrayList<>();
        ArrayList<Integer> data2 = new ArrayList<>();
        ArrayList<Integer> data3 = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int tmp = r.nextInt(count * 2);
            data1.add(tmp);
            data2.add(tmp);
            data3.add(tmp);
        }
        long s = new Date().getTime();
        MergeSort.run(data1, 0, data1.size() - 1);
        long e = new Date().getTime();
        System.out.println("归并法排序结果：" + data1);
        System.out.println("归并法耗时：" + (e - s));
        System.out.println("------------------------");
        s = new Date().getTime();
        Collections.sort(data3);
        e = new Date().getTime();
        System.out.println("Collections.sort排序结果：" + data3);
        System.out.println("Collections.sort耗时：" + (e - s));
        System.out.println("------------------------");
        s = new Date().getTime();
        ArrayList<Integer> result = InsertSort(data2);
        e = new Date().getTime();
        System.out.println("插入法排序结果：" + result);
        System.out.println("插入法耗时：" + (e - s));
        System.out.println("------------------------");
        
    }

    //插入法
    public static ArrayList<Integer> InsertSort(ArrayList<Integer> data) {
        for (int i = 1; i < data.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (data.get(j) < data.get(j - 1)) {
                    Integer tmp = data.get(j);
                    data.set(j, data.get(j - 1));
                    data.set((j - 1), tmp);
                } else break;
            }
        }
        return data;
    }


}
