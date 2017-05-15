package com.wq.alg0515m;

/**
   @ClassName: NumArray 
   @Description: 319
   Given nums = [1, 3, 5]
	sumRange(0, 2) -> 9
	update(1, 2)
	sumRange(0, 2) -> 8
	
   @param  
   @return 
 * @author Administrator
 * 2017年5月15日 上午9:18:20   
 */

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
public class NumArray {
	  class SegmentTreeNode {
	        int start,end;
	        int sum;
	        SegmentTreeNode left,right;
	        public SegmentTreeNode(int start, int end) {
	           this.start=start;
	           this.end=end;
	           this.sum=0;
	           left=null;
	           right=null;
	        }
	    }
	      
	    SegmentTreeNode root = null;
	   
	    public NumArray(int[] nums) {
	       root=buildTree(nums,0,nums.length);     
	    }

	    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
	       if(start>end){
	    	   return null;
	       }else{
	    	   root=new SegmentTreeNode(start,end);
	    	   if(start==end){
	    		   root.sum=nums[start];
	    	   }else{
	    		   int mid=start+(end-start)/2;
	    		   root.left=buildTree(nums,0,mid);;
	    		   root.right=buildTree(nums,mid+1,end);
	    		   root.sum=root.left.sum+root.right.sum;	    		   
	    	   }
	    	   return root;
	       }
	    }
	   
	    void update(int i, int val) {
	    	update(root,i,val);
	    }
	   
	    void update(SegmentTreeNode root, int pos, int val) {
		      if(root.start==root.end){
		    	  root.sum=val;
		      }else{
		    	  int mid=root.start+(root.end-root.start)/2;
		    	  if(pos<=mid){
		    		  update(root.left,pos,val);
		    	  }else{
		    		  update(root.right,pos,val);
		    	  }
			      root.sum=root.left.sum+root.right.sum;  
		      }  
	    }

	    public int sumRange(int i, int j) {
			return sumRange(root,i,j);
	    }
	    //key******************************************************************
	    public int sumRange(SegmentTreeNode root, int start, int end) {
			if(start==end) return root.sum;
			else{
				int mid=root.start+(root.end-root.start)/2;
				if(mid>=end){
					return sumRange(root.left, start, end);
				}else if(mid+1<=start){
					return sumRange(root.right, start, end);
				}else{// mid between  start and end
					  return sumRange(root.right, mid+1, end) + sumRange(root.left, start, mid);
				}
			}
	    }
	       
}
