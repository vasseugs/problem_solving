package think_like_a_programmer.d;

import think_like_a_programmer.d.model.BinaryTree;
import think_like_a_programmer.d.model.TreeNode;

public class Recursion_4 {
    public static void main(String[] args) {
        /*
                         (root)
                        /      \
                      a(5)     b(7)
                    /    \    /    \
                  c(4)  d(6) e(1)  f(2)

         */
        TreeNode root = new TreeNode(3);
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(7);
        root.setLeftChild(a);
        root.setRightChild(b);

        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(4);
        a.setLeftChild(c);
        a.setRightChild(d);

        TreeNode e = new TreeNode(1);
        TreeNode f = new TreeNode(2);
        b.setLeftChild(e);
        b.setRightChild(f);

        int largerstValue = largestTreeNode(root);
        System.out.println(largerstValue);
    }

    /*
    Работа с рекурсией в бинарном дереве.

    Когда мы работали со связным списком, мы использовали рекурсивный принцип
    "обработать первый элемент, а остаток списка передать в рекурсивный вызов".

    Работа с рекурсией в бинарном дереве будет выглядеть следующим образом.
    Мы имеем минимальную обрабатываемую единицу - это узел дерева, а остатка у нас
    теперь 2 - всё поддерево слева от узла и всё поддерево справа. Отсюда следует вывод -
    каждый узел дерева, имеющий левый и правый дочерние узлы, будет делать 2 рекурсивных
    вызова.

    Можно построить абстрактный план при работе с рекурсией в бинарном дереве.

    1. Если дерево Д имеет минимальный размер, то сразу вернуть ответ. Иначе...
    2. Сделать рекурсивный вызов для получения результата к левому поддереву.
    3. Сделать рекурсивный вызов для получения результата к правому поддереву.
    4. Проанализировать значение корневого узла дерева Д
    5. Использовать результаты предыдущих 3 шагов, чтобы покрыть всё бинарное дерево
     */


    /*
    Задача - найти наибольшее значение в бинарном дереве
     */
    private static int largestTreeNode(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.getLeftChild() == null && root.getRightChild() == null) {
            return root.getValue();
        }

        int leftMax = largestTreeNode(root.getLeftChild());
        int rightMax = largestTreeNode(root.getRightChild());

        int maxNum = root.getValue();
        if (leftMax > maxNum) {
            maxNum = leftMax;
        }
        if (rightMax > maxNum) {
            maxNum = rightMax;
        }
        return maxNum;
    }

    private int func(int i) {
        return i + 2;
    }
}
