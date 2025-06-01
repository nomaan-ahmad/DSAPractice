package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/most-frequent-subtree-sum/description/
public class MostFrequentSubtreeSum {
    private int maxFreq = Integer.MIN_VALUE;

    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        helper(root, map);

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> itr : map.entrySet()) {
            if (itr.getValue() == maxFreq) result.add(itr.getKey());
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) ans[i] = result.get(i);

        return ans;
    }

    private int helper(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) return 0;

        int left = helper(root.left, map);
        int right = helper(root.right, map);

        int sum = root.val + left + right;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        maxFreq = Math.max(maxFreq, map.get(sum));

        return sum;
    }
}
