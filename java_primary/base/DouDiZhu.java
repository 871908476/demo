package base;

import java.util.*;

public class DouDiZhu {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        distribute();
    }

    private final static HashMap<Integer, String> poker = create();

    //创建扑克
    private static HashMap<Integer, String> create() {
        List<String> color = List.of("♥", "♣", "♦", "♠");
        List<String> num = List.of("3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2");
        HashMap<Integer, String> poker = new HashMap<>();
        int idx = 0;
        for (String n : num) {
            for (String c : color) {
                poker.put(idx, c + n);
                idx++;
            }
        }
        for (String p : List.of("小王", "大王")) {
            poker.put(idx, p);
            idx++;
        }
        return poker;
    }

    //洗牌、发牌
    private static void distribute() {
        ArrayList<Integer> player01 = new ArrayList<>();
        ArrayList<Integer> player02 = new ArrayList<>();
        ArrayList<Integer> player03 = new ArrayList<>();
        ArrayList<Integer> dipai = new ArrayList<>();
        ArrayList<Integer> idx = new ArrayList<>(poker.keySet());
        Collections.shuffle(idx);
        for (int i = 0; i < idx.size(); i++) {
            Integer tmp = idx.get(i);
            if (i > 50) {
                dipai.add(tmp);
            } else if (i % 3 == 0) {
                player01.add(tmp);
            } else if (i % 3 == 1) {
                player02.add(tmp);
            } else {
                player03.add(tmp);
            }
        }
        show(player01);
        show(player02);
        show(player03);
        show(dipai);
    }

    //看牌
    private static void show(ArrayList<Integer> list) {
        Collections.sort(list);
        for (Integer i : list) {
            System.out.print(poker.get(i) + "  ");
        }
        System.out.println();
    }
}
