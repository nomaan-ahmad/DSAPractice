package Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

// Problem statement: https://leetcode.com/problems/insert-delete-getrandom-o1/description/
public class DesignInsertDeleteGetRandom {
    public static void main(String[] args) {
        RandomizedSet rndSet = new RandomizedSet();
        rndSet.insert(0);
        rndSet.insert(1);
        rndSet.remove(0);
        rndSet.insert(2);
        rndSet.remove(1);
        System.out.println(rndSet.getRandom());
    }
    private static class RandomizedSet {
        private final HashMap<Integer, Integer> map;
        private final List<Integer> list;

        private final Random random;
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (search(val)) return false;

            list.add(val);
            map.put(val, list.size()-1);
            return true;
        }

        public boolean remove(int val) {
            if (!search(val)) return false;

            int index = map.get(val);
            int lastElement = list.get(list.size()-1);

            list.set(index, lastElement);
            list.remove(list.size()-1);
            map.put(lastElement, index);
            map.remove(val);

            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }

        private boolean search(int val) {
            return map.containsKey(val);
        }
    }
}
