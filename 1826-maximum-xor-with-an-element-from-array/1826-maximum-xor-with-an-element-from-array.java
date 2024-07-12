import java.util.Arrays;
import java.util.HashMap;

class Solution {
    class Node {
        Node[] child = new Node[2];
    }

    Node root;

    public int[] maximizeXor(int[] nums, int[][] queries) {
        HashMap<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            map.put(queries[i], i);
        }

        Arrays.sort(nums);
        Arrays.sort(queries, (a, b) -> Integer.compare(a[1], b[1]));

        int j = 0;
        int[] ans = new int[queries.length];
        root = new Node();

        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][1];
            while (j < nums.length && val >= nums[j]) {
                insert(nums[j]);
                j++;
            }

            if (j == 0) {
                // If no numbers have been inserted into the Trie, the answer is -1
                ans[map.get(queries[i])] = -1;
            } else {
                ans[map.get(queries[i])] = getMax(queries[i][0]);
            }
        }
        return ans;
    }

    public void insert(int num) {
        Node curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (curr.child[bit] == null) {
                curr.child[bit] = new Node();
            }
            curr = curr.child[bit];
        }
    }

    public int getMax(int num) {
        Node curr = root;
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (curr.child[1 - bit] != null) {
                ans |= (1 << i);
                curr = curr.child[1 - bit];
            } else {
                curr = curr.child[bit];
            }
        }
        return ans;
    }
}
