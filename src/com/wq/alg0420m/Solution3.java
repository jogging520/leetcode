package com.wq.alg0420m;

/**@547
 * @author Administrator
 * 
 * 2017年4月20日 下午4:59:06   
 */
public class Solution3 {
	//思路：并查集方法
	/*经典的并查集问题，并查集就是考察一个组中的互相联通问题。在这个题中，就是看有几个好友环。
首先，定义一个200大小的数组，记录节点对应的根节点编号。findRoot(int x)函数是找出x节点的根节点，在查找某个特定节点的根节点时，同时将其与根节点之间的所有节点都指向根节点，这个工程叫做路径压缩。
在遍历矩阵之前，首先把数组所有的值都初始化为-1，这样如果之后某个节点的根节点编号为-1，说明它是根节点；如果某节点对应的根节点编号不是-1，那么说明这个节点不是根节点，并且已经被捆绑到另外的节点上。
遍历矩阵时，如果矩阵(i,j)位置的值为1，说明它们直接相连，分别用findRoot()找出i,j对应的根节点，如果根节点不相同，则把他们绑在一起。
最终统计下-1的个数，就是有多少个根节点，即有多少个环。*/
	int []rootIndex=new int[200];
	public int findCircleNum(int[][] M) {
	     if(M==null||M.length==0)  return 0; 
         for(int i=0;i<M.length;i++){
        	 rootIndex[i]=-1;
         }
         for(int i=0;i<M.length;i++){
        	 for(int j=i;i<M.length;j++){
        		 if(M[i][j]==1){
        			 int roota=find(i);
                	 int rootb=find(j);
                	 rootIndex[roota]=rootb;
        		 }
        	 }
        	 
         }
         int res=0;
         for(int i=0;i<M.length;i++){
        	 if(rootIndex[i]==-1)  res++;
         }
         return res;		
	}

	private int find(int i) {
		if(rootIndex[i]==-1) 
			  return i;//根的位置
		else{
			int temp=find(rootIndex[i]);//i的前一个节点的根节点
			rootIndex[i]=temp;
			return temp;
		}
	}

}
