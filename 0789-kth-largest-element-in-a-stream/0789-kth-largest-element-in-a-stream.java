class KthLargest {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    int key;
    TreeNode node ;
    public KthLargest(int k, int[] nums) {
        Arrays.sort(nums);
       node = create(nums,0,nums.length-1);
        key = k;
        return;
    }
    public TreeNode create(int nums[],int s,int e){
       if(s<=e){
        int mid = (int)Math.ceil((s+e)/2);
        TreeNode root = new TreeNode(nums[mid]);
         //  System.out.println(root.val);
        root.left = create(nums,s,mid-1);
        root.right = create(nums,mid+1,e);
        return root;
       }
       return null;
    }
    TreeNode curr = null;
    int c =0;
    public int add(int val) {
        TreeNode n = new TreeNode(val);
        curr = null;
        c =0;
        
        addinBST(n);
      find(node);
      return curr.val;
    }
    public void find(TreeNode node){
        if(node == null){
            return;
        }
        find(node.right);
        // System.out.println(node.val);
        c++;
        if(c == key){
            curr = node;
            return;
        }
        find(node.left);
        return;
    }
    public void addinBST(TreeNode n){
        TreeNode temp = node;
    if(temp == null){
        node = n;
        return;
    }
        while(temp !=null){
    //   System.out.println(temp.val);
            if(temp.val > n.val ){
                if(temp.left == null){
                    temp.left = n;
                    break;
                }
                temp = temp.left;
            }else if(temp.val <= n.val){
                if(temp.right == null){
                    temp.right = n;
                    break;
                }
                temp = temp.right;
            }
        }
     
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */