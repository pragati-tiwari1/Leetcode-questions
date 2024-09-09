/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int ans[][] =  new int[m][n];
        for(int i = 0;i<m;i++){
            Arrays.fill(ans[i],-1);
        }
        int sr =0;
        int sc =0;
        int er =m-1;
        int ec = n-1;
        while(head!=null){
            //up
            for(int j = sc;head!=null && j<=ec;j++){
                ans[sr][j] = head.val;
                head = head.next;
            }
            //right
            for(int i=sr+1;head!=null && i<=er;i++){
                ans[i][ec] = head.val;
                head = head.next;
            }
            //down
            for(int j = ec-1;head!=null && j>=sc;j--){
                ans[er][j] = head.val;
                head = head.next;
            }
            //left
            for(int i=er-1;head!=null && i>sr;i--){
                ans[i][sc] = head.val;
                head = head.next;
            }
            sr++;
            er--;
            sc++;
            ec--;
        }
        return ans;
    }
}