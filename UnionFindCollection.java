package codingInterview;

public class UnionFindCollection {
		     private int[] s;
		     private int count;//记录并查集中子集合的个数(子树的个数)
		     
		     
		     public UnionFindCollection(int numElements) {
		         s = new int[numElements];
		         count = numElements;
		         //初始化并查集,相当于新建了s.length 个互不相交的集合
		         for(int i = 0; i < s.length; i++)
		             s[i] = -1;//s[i]存储的是高度(秩)信息
		     }
		     
		     /**
		      * 
		      * @param root1 并查集中以root1为代表的某个子集
		      * @param roo2 并查集中以root2为代表的某个子集
		      * 按高度(秩)合并以root1 和 root2为代表的两个集合
		      */
		     public void unionByHeight(int root1, int root2){
		         if(find(root1) == find(root2))
		             return;//root1 与 root2已经连通了
		         
		         if(s[root2] < s[root1])//root2 is deeper
		             s[root1] = root2;
		         else{
		             if(s[root1] == s[root2])//root1 and root2 is the same deeper
		                 s[root1]--;//将root1的高度加1
		             s[root2] = root1;//将root2的根(指向)更新为root1
		         }
		         
		         count--;//每union一次,子树数目减1
		     }
		     
		     public void union(int root1, int root2){
		         s[root2] = root1;//将root1作为root2的新树根
		     }
		     
		     
		     public void unionBySize(int root1, int root2){
		         
		         if(find(root1) == find(root2))
		             return;//root1 与 root2已经连通了
		         
		         if(s[root2] < s[root1])//root2 is deeper
		             s[root1] = root2;
		         else{
		             if(s[root1] == s[root2])//root1 and root2 is the same deeper
		                 s[root1]--;//将root1的高度加1
		             s[root2] = root1;//将root2的根(指向)更新为root1
		         }
		         
		         count--;//每union一次,子树数目减1
		     }
		     
		     
		     public int find(int x){
		         if(s[x] < 0)//s[x]为负数时,说明 x 为该子集合的代表(也即树根), 且s[x]的值表示树的高度
		             return x;
		         else 
		             return s[x] = find(s[x]);//使用了路径压缩,让查找路径上的所有顶点都指向了树根(代表节点)
		             //return find(s[x]); 没有使用 路径压缩
		     }
		     
		     public int find0(int x){
		         if(s[x] < 0)
		             return x;
		         else 
		             return find0(s[x]);
		     }
		     
		     
		     public int size(){
		         return count;
		     }
		     
		     //for test purpose
		     public static void main(String[] args) {
		    	 UnionFindCollection dSet = new UnionFindCollection(6);
		         dSet.unionBySize(1, 2);
		         
		         for(int i : dSet.s)
		             System.out.print(i + " ");
		         
		         dSet.unionBySize(3, 4);
		         
		         System.out.println();
		         for(int i : dSet.s)
		             System.out.print(i + " ");
		         
		         System.out.println();
		         dSet.unionBySize(1, 3);
		         for(int i : dSet.s)
		             System.out.print(i + " ");
		         
		         System.out.println();
		         dSet.unionBySize(1, 0);
		         for(int i : dSet.s)
		             System.out.print(i + " ");
		         
		         System.out.println();
		         int x = dSet.find(4);
		         System.out.println(x);
		         
		         for(int i : dSet.s)
		             System.out.print(i + " ");
		         
		         System.out.println("\nsize:" + dSet.size());
		     }
}
