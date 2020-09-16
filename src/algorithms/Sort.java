package algorithms;
/*
排序算法java演示代码
* */

import java.util.*;

public class Sort {
    public static void main(String[] args) {
        Random r = new Random();
        int count = 1000;
        ArrayList<Integer> data1 = new ArrayList<>();
        ArrayList<Integer> data2 = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int tmp = r.nextInt();
            data1.add(tmp);
            //data2.add(tmp);
        }
        data2.addAll(data1);
        long s = new Date().getTime();
        ArrayList<Integer> result = MergeSort(data1);
        long e = new Date().getTime();
        System.out.println("排序结果：" + result);
        System.out.println("耗时：" + (e - s));

        s = new Date().getTime();
        result = InsertSort(data2);
        e = new Date().getTime();
        System.out.println("排序结果：" + result);
        System.out.println("耗时：" + (e - s));
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

    //合并法
    public static ArrayList<Integer> MergeSort(ArrayList<Integer> data) {
        if (data.size() == 1) {
            return data;
        }
        if (data.size() == 2) {
            if (data.get(0) > data.get(1)) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(data.get(1));
                tmp.add(data.get(0));
                return tmp;
            } else return data;
        } else {
            int count = data.size() / 2;
            ArrayList<Integer> copy = new ArrayList<>();
            while (count > 0) {
                copy.add(data.remove(count));
                count--;
            }
            ArrayList<Integer> tmp = new ArrayList<>();
            ArrayList<Integer> d2 = MergeSort(data);
            ArrayList<Integer> d1 = MergeSort(copy);
            Iterator<Integer> it1 = d1.iterator();
            Iterator<Integer> it2 = d2.iterator();
            while (it1.hasNext()) {
                Integer num1 = it1.next();
                Integer num2 = it2.next();
                if (num1 < num2) {
                    tmp.add(num1);
                    tmp.add(num2);
                } else {
                    tmp.add(num2);
                    tmp.add(num1);
                }
            }
            if (it2.hasNext()) tmp.add(it2.next());
            return tmp;
        }
    }
}
