// 如果按照从前往后进行比较排序的方法，则根据数组的性质必须在插入一个元素后，其往后的所有元素需要向后进行移动一位。这样下来，将发生多次一位操作，时间效率会大幅度降低。
// 现在换一种思路，我们从后往前进行插入排序，即先确定第m+n-1个位置上的元素值，再确定m+n-2个位置上的元素值，然后依次确定前面个每个元素，这样每个元素最多移动一次就可以获得最后的排序队列。
// 下面为从后往前排序的源代码：




class Solution {
    public void merge(int[] A, int m, int[] B, int n) {

    	//创建i指针指向nums1尾部
	    int i = m + n - 1;

	    //创建j指针指向nums1最末端元素
        int j = m - 1;

        //创建k指针指向nums2尾部
        int k = n - 1;

        //外循环，只有当nums1全部走完后才结束
        while(i >= 0) {

        	//如果j,k都还有至少1个元素
            if(j >= 0 && k >= 0) {

            	//寻找当前更大的元素
                if(A[j] > B[k]) {

                	//暂时设定A尾部为较大数
                    A[i] = A[j];

                    //对应list指针移动一位
                    j--;
                } else {
                    A[i] = B[k];
                    k--;
                }

              //如果只剩A中还有元素没有遍历
            } else if(j >= 0) {
            	//把元素放入A
                A[i] = A[j];
                j--;

               //只剩B元素了
            } else if(k >= 0) {

            	//把元素依次放入A
                A[i] = B[k];
                k--;
            }

            //外部指针走一位
            i--;
        }
    }
}