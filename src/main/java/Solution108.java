import java.util.Arrays;

public class Solution108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0){return null;}
        int mid=nums.length/2;

        TreeNode root=new TreeNode(nums[mid]);

        int[] left=Arrays.copyOfRange(nums,0,mid);
        root.left=sortedArrayToBST(left);

        int[] right=Arrays.copyOfRange(nums,mid+1,nums.length);
        root.right=sortedArrayToBST(right);


        return root;

    }
}



