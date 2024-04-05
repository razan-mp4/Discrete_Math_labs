package com.company;

import java.util.*;

public class Main {
    // визначає дерево
    static class nptr
    {
        char data;
        nptr left, right;
    }

    // створення нового єлемента дерева
    static nptr newNode(char c)
    {
        nptr n = new nptr();
        n.data = c;
        n.left = n.right = null;
        return n;
    }

    // створення дерева з стандарного виразу
    static nptr build(String s)
    {

        Stack<nptr> stN = new Stack<>();

        Stack<Character> stC = new Stack<>();
        nptr t, t1, t2;

        int []p = new int[123];
        p['+'] = p['-'] = 1;
        p['/'] = p['*'] = 2;
        p['^'] = 3;
        p[')'] = 0;

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(') {
                stC.add(s.charAt(i));
            }

            else if (Character.isDigit(s.charAt(i)))
            {
                t = newNode(s.charAt(i));
                stN.add(t);
            }
            else if (p[s.charAt(i)] > 0)
            {
                while (
                        !stC.isEmpty() && stC.peek() != '('
                                && ((s.charAt(i) != '^' && p[stC.peek()] >= p[s.charAt(i)])
                                || (s.charAt(i) == '^'
                                && p[stC.peek()] > p[s.charAt(i)])))
                {
                    t = newNode(stC.peek());
                    stC.pop();
                    t1 = stN.peek();
                    stN.pop();
                    t2 = stN.peek();
                    stN.pop();
                    t.left = t2;
                    t.right = t1;
                    stN.add(t);
                }
                stC.push(s.charAt(i));
            }
            else if (s.charAt(i) == ')') {
                while (!stC.isEmpty() && stC.peek() != '(')
                {
                    t = newNode(stC.peek());
                    stC.pop();
                    t1 = stN.peek();
                    stN.pop();
                    t2 = stN.peek();
                    stN.pop();
                    t.left = t2;
                    t.right = t1;
                    stN.add(t);
                }
                stC.pop();
            }
        }
        t = stN.peek();
        return t;
    }

    // перетворення символу цифри на значення чифри
    private static int toInt(char s)
    {
        int num = s - 48;
        System.out.println(num);
        return num;
    }

    // обчислення дерева
    public static int evalTree(nptr root)
    {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return toInt(root.data);
        int leftEval = evalTree(root.left);
        int rightEval = evalTree(root.right);
        if (root.data == '+')
            return leftEval + rightEval;
        if (root.data == '-')
            return leftEval - rightEval;
        if (root.data == '*')
            return leftEval * rightEval;
        return leftEval / rightEval;
    }

    // виведення в зворотному порядку
    static void printPostorder(nptr node)
    {
        if (node == null)
            return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }

    // ввивід дерева в прямому порядку
    static void printPreorder(nptr node)
    {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    // обчислення в прямому порядку в прямій польській нотації
    static int evaluatePrefix(String exprsn)
    {
        Stack<Integer> Stack = new Stack<Integer>();
        for (int j = exprsn.length() - 1; j >= 0; j--) {
            if (isOperand(exprsn.charAt(j)))
                Stack.push((int)(exprsn.charAt(j) - 48));
            else {
                int o1 = Stack.pop();
                int o2 = Stack.pop();
                switch (exprsn.charAt(j)) {
                    case '+':
                        Stack.push(o1 + o2);
                        break;
                    case '-':
                        Stack.push(o1 - o2);
                        break;
                    case '*':
                        Stack.push(o1 * o2);
                        break;
                    case '/':
                        Stack.push(o1 / o2);
                        break;
                }
            }
        }
        return Stack.pop();
    }

    // перевірка чи оперант чи оператор
    static Boolean isOperand(char c)
    {
        if (c >= 48 && c <= 57)
            return true;
        else
            return false;
    }

    // формування рядка в прямому порядці
    static void preorder(nptr node,StringBuilder builder)
    {
        if (node == null)
            return;
        builder.append(node.data);
        preorder(node.left,builder);
        preorder(node.right,builder);
    }

    // точка входа в програму
    public static void main(String[] args)
    {
        String s = "((6-1)/5+2)*4";
        s = "(" + s;
        s += ")";
        nptr root = build(s);
        printPostorder(root);
        System.out.println();
        System.out.println(evalTree(root));
        System.out.println();
        System.out.println("PostOrder");
        printPostorder(root);
        System.out.println();
        System.out.println("Preorder");
        printPreorder(root);
        System.out.println();
        StringBuilder preorderBuilder = new StringBuilder();
        preorder(root,preorderBuilder);
        System.out.println(preorderBuilder);
        System.out.println();
        System.out.println(evaluatePrefix(preorderBuilder.toString()));
    }
}