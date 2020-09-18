package com.f.rhythm;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ParentChildConvertToTree {
    private static class Tree {
        private Integer id;
        private Integer parentId;
        private List<Tree> child;

        public Tree(Integer id, Integer parentId, List<Tree> child) {
            this.id = id;
            this.parentId = parentId;
            this.child = child;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getParentId() {
            return parentId;
        }

        public void setParentId(Integer parentId) {
            this.parentId = parentId;
        }

        public List<Tree> getChild() {
            return child;
        }

        public void setChild(List<Tree> child) {
            this.child = child;
        }
    }

    public static List<Tree> convertTree(int parentId, Map<Integer, List<Tree>> data) {
        List<Tree> currentNode = data.get(parentId);
        if (currentNode == null)
            return null;
        data.put(parentId, null);
        for (Tree item : currentNode) {
            item.setChild(data.get(item.getId()));
            if (Objects.nonNull(item.getChild())) {
                for (Tree childItem : item.getChild()) {
                    childItem.setChild(convertTree(childItem.getId(), data));
                }
            }
        }
        return currentNode;
    }

    public static void main(String[] args) {
        Tree tree = new Tree(1, 0, null);
        Tree tree1 = new Tree(2, 0, null);

        Tree tree2 = new Tree(3, 1, null);
        Tree tree3 = new Tree(4, 3, null);
        Tree tree4 = new Tree(5, 3, null);

        Map<Integer, List<Tree>> data = Arrays.asList(tree, tree1, tree2, tree3, tree4).stream().collect(Collectors.groupingBy(Tree::getParentId, Collectors.toList()));

        List<Tree> treeVal = convertTree(0, data);
        System.out.println();

    }
}
