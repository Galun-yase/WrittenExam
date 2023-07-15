# WrittenExam

## 数据结构

数组Array 列表ArrayList(动态数组) 链表LinkedList(单向 环形 双向)

栈Stack 单调栈

> 栈Stack：peek pop push empty size

队列Queue 双向队列Deque 优先队列PriorityQueue

> 队列Queue：add remove element / offer poll peek
>
> - `LinkedList`：基于链表实现的队列，同时也实现了`Deque`接口。
> - `ArrayDeque`：基于数组实现的队列，同时也实现了`Deque`接口。
>
> 双向队列Deque：addFirst addLast removeFirst removeLast getFirst getLast/ offer poll peek
>
> - `LinkedList`：基于链表实现的队列，同时也实现了`Deque`接口。
> - `ArrayDeque`：基于数组实现的队列，同时也实现了`Deque`接口。
>
> 优先队列PriorityQueue：add remove / offer poll peek
>
> - `PriorityQueue`：基于堆实现的优先队列。

哈希表Map Set

> 哈希表：put set

`?树、图`

## 数据结构题目
#### 数组：
> - LeetCode 283、移动零
> - LeetCode 26、删除有序数组中的重复项
> - LeetCode 88、合并两个有序数组
#### 链表：
> - LeetCode 206、反转链表
> - LeetCode 203、移除链表元素
> - LeetCode 142、环形链表II
> - LeetCode 160、相交链表
> - LeetCode 876、链表的中间结点
#### 栈：
> - LeetCode 20、有效的括号
> - LeetCode 150、逆波兰表达式求值
> - LeetCode 739、每日温度(单调递增栈)
#### 哈希表：
> - LeetCode 217、存在重复元素
> - LeetCode 1、两数之和
#### 二叉树：
> - LeetCode 144、二叉树的前序遍历
> - LeetCode 94、二叉树的中序遍历
> - LeetCode 145、二叉树的后序遍历
> - LeetCode 236、二叉树的最近公共祖先
#### 二分查找：
> - LeetCode 704、二分查找
#### 位运算：
> - LeetCode 137只出现一次的数字 II
> - LeetCode 260只出现一次的数字 III
#### 并查集：
> - LeetCode 200岛屿数量(DFS也可)
#### 动态规划：
> - LeetCode 70爬楼梯
> - LeetCode 121买卖股票的最佳时机
#### 贪心思想：
> - LeetCode 860柠檬水找零
> - LeetCode 605种花问题

## 面试笔试题解

### 剑指Offer
查找：
- 	1、二维数组中的查找 改进右上二分查找
- 	42、和为S的两个数字 双指针
- 	37、数字在升序数组中出现的次数 二分查找上下界
-	6、旋转数组的最小数字 二分(不一定有序数组)

贪心思想：

DP：
-	67、剪绳子 数学思想可以，Dp也可以，注意初始条件
-	30、连续子数组的最大和
-	9、变态跳台阶 dp
-
递归：
-	61、序列化二叉树 反序列化时递归构建
-	46、孩子们的游戏，利用规则递归
-	39、判断平衡二叉树 递归
-	38、二叉树的深度
-	26、二叉搜索树与双向链表 递归挺巧妙线索化
-	24、二叉树中和为某一值的路径 递归
-	23、是否二叉树的后序遍历序列 递归遍历
-	18、二叉树的镜像 
-	17、树的子结构
-	16、合并两个排序的链表
-	10、矩形覆盖 递归规律
-	4、重建二叉树


BFS、dfs:
-	66、机器人的运动范围 二维数组贪心 bfs/dfs都可
-	65、矩阵中的路径 
-	60、把二叉树打印成多行 bfs层次遍历
-	59、之字型打印二叉树 bfs遍历也可利用栈

树：
-	62、二叉树的第k个节点 遍历
-	58、对称的二叉树 利用性质递归
-	57、二叉树的下一节点 遍历也可利用指向父节点的性质
-	22、从上往下打印二叉树 队列层次遍历

堆：
-	64、滑动窗口 
-	63、数据流中的中位数 组合大顶堆和小顶堆
-	29、最小的K个数 也可以维护一个k小的集合


链表：
-	56、删除链表中的重复节点 暴力set 也可直接删除
-	55、链表中环的入口节点 利用性质快慢指针
-	36、两个链表的第一个公共节点 双指针
-	25、复杂链表的复制 巧妙在链表内复制链表再拆分
-	14、链表中的倒数第k个节点 双指针
-	3、从尾到头打印链表 反转 也可模仿二叉树递归遍历

hash+队列：
-	54、字符流中的第一个不重复字符

正则：
-	53、表示字符串的数值
-	52、正则表达式匹配

位运算：
-	48、不用加减乘除做加法
-	49、求1+2...+n 不用乘除法及控制语句
-	40、数组中只出现一次的数字

数学：
-	33、丑叔
-	32、把数组排成最小的数
-	31、整数中1出现的次数 
-	32、数组中出现次数超过一半的数字 找众数 候选人法
-	19、顺序枕打印矩阵 旋转矩阵、边界
-	13、调整数组顺序使奇数位于偶数前面 辅助数组、尾插法 头插法
-	12、数值的整数次方 快速幂
-	11、二进制中1的个数 位运算+技巧




52、未解决
35、未解决
27、未解决 全排列
