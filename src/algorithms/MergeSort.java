package algorithms;
//归并法

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class MergeSort {
    public static <T extends Comparable> void run(ArrayList<T> data, int startIdx, int endIdx) {
        if (endIdx - startIdx<2) {
            if(data.get(endIdx).compareTo(data.get(startIdx))<0){
                T tmp=data.get(startIdx);
                data.set(startIdx,data.get(endIdx));
                data.set(endIdx,tmp);
            }
        } else {
            run(data, startIdx, (startIdx + endIdx) / 2);
            run(data, (startIdx + endIdx) / 2+1, endIdx);
            merge(data,startIdx, (startIdx + endIdx) / 2, endIdx);
        }
    }

    private static <T extends Comparable> void merge(ArrayList<T> data, int startIdx, int midIdx, int endIdx) {
        ArrayList<T> result=new ArrayList<>();
        int i = startIdx;
        int j = midIdx + 1;
        while (i < midIdx + 1 && j < endIdx+1) {
            if (data.get(i).compareTo(data.get(j)) < 0) {
                result.add(data.get(i));
                i++;
            } else {
                result.add(data.get(j));
                j++;
            }
        }
        while (i < midIdx + 1) {
            result.add(data.get(i));
            i++;
        }
        while (j < midIdx + 1) {
            result.add(data.get(j));
            j++;
        }
        for (T r : result) {
            data.set(startIdx,r);
            startIdx++;
        }
    }
}
