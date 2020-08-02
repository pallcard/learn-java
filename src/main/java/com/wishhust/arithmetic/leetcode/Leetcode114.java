package com.wishhust.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode114 {

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();

        for (int i = 0; i < list.size()-1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i+1);
        }

    }

    public void preOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);

        preOrder(root.left, list);
        preOrder(root.right, list);
    }


}
