# 剑指Offer编程题

**说明：**

\* 未想出或漏解

\# 题解有优化

|题号|题目|解答
|-|-|-
| 64 | [最小路径和][leetcode64] | [Java][64]|
| 98 | [验证二叉搜索树][leetcode98] | [Java][98]|
| 99 | [恢复二叉搜索树][leetcode99] | [Java][99]|
| 100 | [相同的树][leetcode100] | [Java][100]|
| 104 | [二叉树的最大深度][leetcode104] | [Java][104]|
| 105 | [从前序与中序遍历序列构造二叉树][leetcode105] | [Java][105]|
| 112 | [路径总和][leetcode112] | [Java][112]|
| 124 | [二叉树中的最大路径和][leetcode124] | [Java][124]|
| 146 | [LRU缓存机制][leetcode146] | [Java][146]|
| 207 | [课程表][leetcode207] | [Java][207]|
| 239 | [滑动窗口最大值][leetcode239] | [Java][239]|
| 329 | [矩阵中的最长递增路径][leetcode329] | [Java][329]|
| 392 | [分割数组的最大值][leetcode392] | [Java][392]|
| 410 | [分割数组的最大值][leetcode410] | [Java][410]|
| 415 | [字符串相加][leetcode415] | [Java][415]|
| 435 | [无重叠区间][leetcode435] | [Java][435]|
| 450 | [删除二叉搜索树中的节点][leetcode450] | [Java][450]|
| 496 | [下一个更大元素 I][leetcode496] | [Java][496]|
| 560 | [和为K的子数组][leetcode560] | [Java][560]|
| 700 | [二叉搜索树中的搜索][leetcode700] | [Java][700]|
| 701 | [二叉搜索树中的插入操作][leetcode701] | [Java][701]|
| 1025 | [除数博弈][leetcode1025] | [Java][1025]|

[^_^]: github链接
[64]: https://github.com/pallcard/learn-java/blob/master/src/main/java/com/wishhust/arithmetic/leetcode/Leetcode64.java ""
[98]: https://github.com/pallcard/learn-java/blob/master/src/main/java/com/wishhust/arithmetic/leetcode/Leetcode98.java ""
[99]: https://github.com/pallcard/learn-java/blob/master/src/main/java/com/wishhust/arithmetic/leetcode/Leetcode99.java ""
[100]: https://github.com/pallcard/learn-java/blob/master/src/main/java/com/wishhust/arithmetic/leetcode/Leetcode100.java ""
[104]: https://github.com/pallcard/learn-java/blob/master/src/main/java/com/wishhust/arithmetic/leetcode/Leetcode104.java ""
[105]: https://github.com/pallcard/learn-java/blob/master/src/main/java/com/wishhust/arithmetic/leetcode/Leetcode105.java ""
[112]: https://github.com/pallcard/learn-java/blob/master/src/main/java/com/wishhust/arithmetic/leetcode/Leetcode112.java ""
[124]: https://github.com/pallcard/learn-java/blob/master/src/main/java/com/wishhust/arithmetic/leetcode/Leetcode124.java ""
[146]: https://github.com/pallcard/learn-java/blob/master/src/main/java/com/wishhust/arithmetic/leetcode/Leetcode146.java ""
[207]: https://github.com/pallcard/learn-java/blob/master/src/main/java/com/wishhust/arithmetic/leetcode/Leetcode207.java ""
[239]: https://github.com/pallcard/learn-java/blob/master/src/main/java/com/wishhust/arithmetic/leetcode/Leetcode239.java ""
[329]: https://github.com/pallcard/learn-java/blob/master/src/main/java/com/wishhust/arithmetic/leetcode/Leetcode329.java ""
[392]: https://github.com/pallcard/learn-java/blob/master/src/main/java/com/wishhust/arithmetic/leetcode/Leetcode392.java ""
[410]: https://github.com/pallcard/learn-java/blob/master/src/main/java/com/wishhust/arithmetic/leetcode/Leetcode410.java ""
[415]: https://github.com/pallcard/learn-java/blob/master/src/main/java/com/wishhust/arithmetic/leetcode/Leetcode415.java ""
[435]: https://github.com/pallcard/learn-java/blob/master/src/main/java/com/wishhust/arithmetic/leetcode/Leetcode435.java ""
[450]: https://github.com/pallcard/learn-java/blob/master/src/main/java/com/wishhust/arithmetic/leetcode/Leetcode450.java ""
[496]: https://github.com/pallcard/learn-java/blob/master/src/main/java/com/wishhust/arithmetic/leetcode/Leetcode496.java ""
[560]: https://github.com/pallcard/learn-java/blob/master/src/main/java/com/wishhust/arithmetic/leetcode/Leetcode560.java ""
[700]: https://github.com/pallcard/learn-java/blob/master/src/main/java/com/wishhust/arithmetic/leetcode/Leetcode700.java ""
[701]: https://github.com/pallcard/learn-java/blob/master/src/main/java/com/wishhust/arithmetic/leetcode/Leetcode701.java ""
[1025]: https://github.com/pallcard/learn-java/blob/master/src/main/java/com/wishhust/arithmetic/leetcode/Leetcode1025.java ""


[^_^]: leetcode链接
[leetcode64]: https://leetcode-cn.com/problems/minimum-path-sum/
[leetcode98]: https://leetcode-cn.com/problems/validate-binary-search-tree/
[leetcode99]: https://leetcode-cn.com/problems/recover-binary-search-tree/
[leetcode100]: https://leetcode-cn.com/problems/same-tree/
[leetcode104]: https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
[leetcode105]: https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
[leetcode112]: https://leetcode-cn.com/problems/path-sum/
[leetcode124]: https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
[leetcode146]: https://leetcode-cn.com/problems/lru-cache/
[leetcode207]: https://leetcode-cn.com/problems/course-schedule/
[leetcode239]: https://leetcode-cn.com/problems/sliding-window-maximum/
[leetcode329]: https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/
[leetcode392]: https://leetcode-cn.com/problems/is-subsequence/
[leetcode410]: https://leetcode-cn.com/problems/split-array-largest-sum/
[leetcode415]: https://leetcode-cn.com/problems/add-strings/
[leetcode435]: https://leetcode-cn.com/problems/non-overlapping-intervals/
[leetcode450]: https://leetcode-cn.com/problems/delete-node-in-a-bst/
[leetcode496]: https://leetcode-cn.com/problems/next-greater-element-i/
[leetcode560]: https://leetcode-cn.com/problems/subarray-sum-equals-k/
[leetcode700]: https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
[leetcode701]: https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
[leetcode1025]: https://leetcode-cn.com/problems/divisor-game/
