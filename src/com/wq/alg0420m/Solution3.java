package com.wq.alg0420m;

/**@547
 * @author Administrator
 * 
 * 2017��4��20�� ����4:59:06   
 */
public class Solution3 {
	//˼·�����鼯����
	/*����Ĳ��鼯���⣬���鼯���ǿ���һ�����еĻ�����ͨ���⡣��������У����ǿ��м������ѻ���
���ȣ�����һ��200��С�����飬��¼�ڵ��Ӧ�ĸ��ڵ��š�findRoot(int x)�������ҳ�x�ڵ�ĸ��ڵ㣬�ڲ���ĳ���ض��ڵ�ĸ��ڵ�ʱ��ͬʱ��������ڵ�֮������нڵ㶼ָ����ڵ㣬������̽���·��ѹ����
�ڱ�������֮ǰ�����Ȱ��������е�ֵ����ʼ��Ϊ-1���������֮��ĳ���ڵ�ĸ��ڵ���Ϊ-1��˵�����Ǹ��ڵ㣻���ĳ�ڵ��Ӧ�ĸ��ڵ��Ų���-1����ô˵������ڵ㲻�Ǹ��ڵ㣬�����Ѿ�����������Ľڵ��ϡ�
��������ʱ���������(i,j)λ�õ�ֵΪ1��˵������ֱ���������ֱ���findRoot()�ҳ�i,j��Ӧ�ĸ��ڵ㣬������ڵ㲻��ͬ��������ǰ���һ��
����ͳ����-1�ĸ����������ж��ٸ����ڵ㣬���ж��ٸ�����*/
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
			  return i;//����λ��
		else{
			int temp=find(rootIndex[i]);//i��ǰһ���ڵ�ĸ��ڵ�
			rootIndex[i]=temp;
			return temp;
		}
	}

}
