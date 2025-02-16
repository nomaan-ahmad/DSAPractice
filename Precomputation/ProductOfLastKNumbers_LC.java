package Precomputation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// https://leetcode.com/problems/product-of-the-last-k-numbers/description/
public class ProductOfLastKNumbers_LC {
    public static void main(String[] args) {
        ProductOfNumbers p = new ProductOfNumbers();
        p.add(3);
        p.add(0);
        p.add(2);
        p.add(5);
        p.add(4);
        System.out.println(p.getProduct(2));
        System.out.println(p.getProduct(3));
        System.out.println(p.getProduct(4));
        p.add(8);
        System.out.println(p.getProduct(2));
    }


    private static class ProductOfNumbers {
        private final List<Integer> lastZeroIdx;
        private final List<Integer> prefixProduct;

        public ProductOfNumbers() {
            lastZeroIdx = new ArrayList<>();
            lastZeroIdx.add(-1);
            prefixProduct = new ArrayList<>();
            prefixProduct.add(1);
        }

        public void add(int num) {
            if (num == 0)
                lastZeroIdx.add(lastZeroIdx.size()-1);
            else lastZeroIdx.add(lastZeroIdx.getLast());

            if (prefixProduct.getLast() == 0) prefixProduct.add(num);
            else prefixProduct.add(prefixProduct.getLast() * num);
        }

        public int getProduct(int k) {
            int len = prefixProduct.size() - 1;

            if (lastZeroIdx.getLast() == len - k) return 0;
            if (!Objects.equals(lastZeroIdx.getLast(), lastZeroIdx.get(len - k + 1))) return 0;

            return (prefixProduct.get(len-k) == 0) ? prefixProduct.getLast() : prefixProduct.getLast() / prefixProduct.get(len - k);
        }
    }
}
