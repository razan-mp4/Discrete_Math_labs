package com.company;

import java.util.*;


public class Main {

    public static void main(String[] args) {
            // Множини
            // Створюємо масив A і введення значень
            int a = 5;
            int b = 6;
            System.out.println("Введіть першу множину: ");
            int[] arrOne = new int[a];
            for (int i = 0; i < arrOne.length; i++) {
                    Scanner scanner = new Scanner(System.in);
                    int num = scanner.nextInt();
                    arrOne[i] = num;
            }
            // Створюємо масив B і введення значень
            System.out.println("Введіть другу множину: ");
            int[] arrTwo = new int[b];
            for (int i = 0; i < arrTwo.length; i++) {
                    Scanner scanner = new Scanner(System.in);
                    int num = scanner.nextInt();
                    arrTwo[i] = num;
            }
            // Створюємо юніверсум
            int[] universal = new int[8];
            for (int i = 0; i < universal.length; i++) {
                    universal[i] = i + 1;
            }
            // Перетворюємо масив A у множину
            LinkedHashSet<Integer> setOne = new LinkedHashSet<>();
            for (int k : arrOne) {
                    setOne.add(k);
            }
            // Перетворюємо масив B у множину
            LinkedHashSet<Integer> setTwo = new LinkedHashSet<>();
            for (int k : arrTwo) {
                    setTwo.add(k);
            }
            // Показуємо множини
            System.out.print("Множина A: ");
            System.out.println(setOne);
            System.out.print("Множина B: ");
            System.out.println(setTwo);
            // Завдання №1
            System.out.println("Завдання №1");
            // Об'єднання
            System.out.println("Об'єднання: ");
            Set<Integer> union = new TreeSet<>(setOne);
            union.addAll(setTwo);
            System.out.println(union);
            // Перетин
            System.out.println("Перетин: ");
            Set<Integer> crossing = new TreeSet<>(setOne);
            crossing.retainAll(setTwo);
            System.out.println(crossing);
            // Різниця A від B
            System.out.println("Різниця A від B: ");
            Set<Integer> differenceOne = new TreeSet<>(setOne);
            differenceOne.removeAll(setTwo);
            System.out.println(differenceOne);
            // Різниця B від A
            System.out.println("Різниця B від A: ");
            Set<Integer> differenceTwo = new TreeSet<>(setTwo);
            differenceTwo.removeAll(setOne);
            System.out.println(differenceTwo);
            // Доповнення до множини A
            System.out.println("Доповнення до множини A: ");
            Set<Integer> addition = new TreeSet<>();
            // Юніверсум
            for (int i = 1; i <= 8; i++) {
                    addition.add(i);
            }
            addition.removeAll(setOne);
            System.out.println(addition);
            // Доповнення  до множини B
            System.out.println("Доповнення до множини B: ");
            Set<Integer> additionTwo = new TreeSet<>();
            // Юніверсум
            for (int i = 1; i <= 8; i++) {
                    additionTwo.add(i);
            }
            additionTwo.removeAll(setTwo);
            System.out.println(additionTwo);
            // Cиметрична різниця
            System.out.println("Cиметрична різниця: ");
            Set<Integer> symmetry = new TreeSet<>(setOne);
            symmetry.addAll(setTwo);
            symmetry.removeAll(crossing);
            System.out.println(symmetry);
            // Декартовий добуток AxB
            System.out.println("Декартовий добуток AxB: ");
            System.out.println("{");
            for (int value : arrOne) {
                    for (int k : arrTwo) {
                            System.out.print("(" + value + ", " + k + ")" + ", ");
                    }
                    System.out.println();
            }
            System.out.println("}");
            // Декартовий добуток BxA
            System.out.println("Декартовий добуток BxA: ");
            System.out.println("{");
            for (int k : arrTwo) {
                    for (int i : arrOne) {
                            System.out.print("(" + k + ", " + i + ")" + ", ");
                    }
                    System.out.println();
            }
            System.out.println("}");
            // Завдання №2
            System.out.println("Завдання №2");
            // Перевіряємо чи є множини рівними
            int check = 0;
            for (int k : arrOne) {
                    for (int i : arrTwo) {
                            if (k != i) {
                                    check = 1;
                                    break;
                            }

                    }
            }
            if (check == 0) {
                    System.out.println("Множини є рівними і множина A є підмножиною множини B");
            } else {
                    System.out.println("Множини не є рівними і множина A не є підмножиною множини B");
            }
            System.out.println("Завдання №3");
            // Представляємо введені користувачем множини у вигляді бітових рядків
            System.out.println("Введені множини у вигляді бітових рядків");
            // Множина A
            System.out.print("Множина A {");
            int checkA = 0;
            int[] arrBitOne = new int[universal.length];
            for (int k = 0; k < universal.length; k++) {
                    for (int j : arrOne) {
                            if (universal[k] == j) {
                                    checkA = 1;
                                    arrBitOne[k] = 1;
                                    System.out.print(arrBitOne[k]);
                                    break;
                            } else {
                                    checkA = 0;
                            }
                    }
                    if (checkA == 0) {
                            arrBitOne[k] = 0;
                            System.out.print(arrBitOne[k]);
                    }
            }
            System.out.print("}");
            System.out.println();
            // Множина B
            System.out.print("Множина B {");
            int checkB = 0;
            int[] arrBitTwo = new int[universal.length];
            for (int k = 0; k < universal.length; k++) {
                    for (int j : arrTwo) {
                            if (universal[k] == j) {
                                    checkB = 1;
                                    arrBitTwo[k] = 1;
                                    System.out.print(arrBitTwo[k]);
                                    break;
                            } else {
                                    checkB = 0;
                            }
                    }
                    if (checkB == 0) {
                            arrBitTwo[k] = 0;
                            System.out.print(arrBitTwo[k]);
                    }
            }
            System.out.print("}");
            // Завдання №4
            System.out.println();
            System.out.println("Завдання №4");
            // Об’єднання A і B
            System.out.print("Об’єднання A і B {");
            int[] unionBit = new int[universal.length];
            for (int i = 0; i < universal.length; i++) {
                    unionBit[i] = arrBitOne[i] | arrBitTwo[i];
                    System.out.print(unionBit[i]);
            }
            System.out.println("}");
            // Порівнюємо бітові резельтати
            System.out.print("Отримана множина у звичайногму вигляді: { ");
            for (int i = 0; i < universal.length; i++) {
                    if (unionBit[i] == 1) {
                            System.out.print((i + 1) + " ");
                    }
            }
            System.out.println("} для порівняння множина отримана у Завданні №1 " + union);
            // Перетин A i B
            System.out.print("Перетин A i B {");
            int[] crossingBit = new int[universal.length];
            for (int i = 0; i < universal.length; i++) {
                    crossingBit[i] = arrBitOne[i] & arrBitTwo[i];
                    System.out.print(crossingBit[i]);
            }
            System.out.println("}");
            // Порівнюємо бітові резельтати
            System.out.print("Отримана множина у звичайногму вигляді: { ");
            for (int i = 0; i < universal.length; i++) {
                    if (crossingBit[i] == 1) {
                            System.out.print((i + 1) + " ");
                    }
            }
            System.out.println("} для порівняння множина отримана у Завданні №1 " + crossing);
            // Різниця A від B
            System.out.print("Різниця A від B {");
            int[] bitDifferenceOne = new int[universal.length];
            for (int i = 0; i < universal.length; i++) {
                    if (arrBitOne[i] == 1 && arrBitTwo[i] == 1) {
                            bitDifferenceOne[i] = 0;
                            System.out.print(bitDifferenceOne[i]);
                    } else if (arrBitOne[i] == 1 && arrBitTwo[i] == 0) {
                            bitDifferenceOne[i] = 1;
                            System.out.print(bitDifferenceOne[i]);
                    } else if (arrBitOne[i] == 0 && arrBitTwo[i] == 1) {
                            bitDifferenceOne[i] = 0;
                            System.out.print(bitDifferenceOne[i]);
                    } else if (arrBitOne[i] == 0 && arrBitTwo[i] == 0) {
                            bitDifferenceOne[i] = 0;
                            System.out.print(bitDifferenceOne[i]);
                    }
            }
            System.out.println("}");
            // Порівнюємо бітові резельтати
            System.out.print("Отримана множина у звичайногму вигляді: { ");
            for (int i = 0; i < universal.length; i++) {
                    if (bitDifferenceOne[i] == 1) {
                            System.out.print((i + 1) + " ");
                    }
            }
            System.out.println("} для порівняння множина отримана у Завданні №1 " + differenceOne);
            // Різниця B від A
            System.out.print("Різниця B від A {");
            int[] bitDifferenceTwo = new int[universal.length];
            for (int i = 0; i < universal.length; i++) {
                    if (arrBitTwo[i] == 1 && arrBitOne[i] == 1) {
                            bitDifferenceTwo[i] = 0;
                            System.out.print(bitDifferenceTwo[i]);
                    } else if (arrBitTwo[i] == 1 && arrBitOne[i] == 0) {
                            bitDifferenceTwo[i] = 1;
                            System.out.print(bitDifferenceTwo[i]);
                    } else if (arrBitTwo[i] == 0 && arrBitOne[i] == 1) {
                            bitDifferenceTwo[i] = 0;
                            System.out.print(bitDifferenceTwo[i]);
                    } else if (arrBitTwo[i] == 0 && arrBitOne[i] == 0) {
                            bitDifferenceTwo[i] = 0;
                            System.out.print(bitDifferenceTwo[i]);
                    }
            }
            System.out.println("}");
            // Порівнюємо бітові резельтати
            System.out.print("Отримана множина у звичайногму вигляді: { ");
            for (int i = 0; i < universal.length; i++) {
                    if (bitDifferenceTwo[i] == 1) {
                            System.out.print((i + 1) + " ");
                    }
            }
            System.out.println("} для порівняння множина отримана у Завданні №1 " + differenceTwo);
            // Симетрична різниця A і B
            System.out.print("Симетрична різниця A і B {");
            int[] symmetryBit = new int[universal.length];
            for (int i = 0; i < universal.length; i++) {
                    symmetryBit[i] = arrBitOne[i] ^ arrBitTwo[i];
                    System.out.print(symmetryBit[i]);
            }
            System.out.println("}");
            // Порівнюємо бітові резельтати
            System.out.print("Отримана множина у звичайногму вигляді: { ");
            for (int i = 0; i < universal.length; i++) {
                    if (symmetryBit[i] == 1) {
                            System.out.print((i + 1) + " ");
                    }
            }
            System.out.println("} для порівняння множина отримана у Завданні №1 " + symmetry);

    }
}
/*
            System.out.println("Введені множини у вигляді бітових рядків");
            System.out.print("Множина C ");
            LinkedHashSet<Integer> setOneAgain = new LinkedHashSet<Integer>();
            for (int i = 0; i < arrOne.length; i++){
                    setOneAgain.add(Integer.valueOf(Integer.toBinaryString(arrOne[i])));
            }
            System.out.println(setOneAgain);
            System.out.print("Множина D ");
            LinkedHashSet<Integer> setTwoAgain = new LinkedHashSet<Integer>();
            for (int i = 0; i < arrTwo.length; i++){
                    setTwoAgain.add(Integer.valueOf(Integer.toBinaryString(arrTwo[i])));
            }
            System.out.println(setTwoAgain);
*/
// trying
/*
         Об'єднання
                    System.out.println("Об'єднання: ");
                    Set<Integer> unionAgain = new TreeSet<Integer>(setOneAgain);
                    unionAgain.addAll(setTwoAgain);
                    System.out.println(unionAgain);
         Перетин
                    System.out.println("Перетин: ");
                    Set<Integer> crossingAgain = new TreeSet<Integer>(setOneAgain);
                    crossingAgain.retainAll(setTwoAgain);
                    System.out.println(crossingAgain);
         Різниця C від D
                    System.out.println("Різниця C від D: ");
                    Set<Integer> differenceAgain = new TreeSet<Integer>(setOneAgain);
                    differenceAgain.removeAll(setTwoAgain);
                    System.out.println(differenceAgain);
         Різниця D від C
                    System.out.println("Різниця D від C: ");
                    Set<Integer> differenceTwoAgain = new TreeSet<Integer>(setTwoAgain);
                    differenceTwoAgain.removeAll(setOneAgain);
                    System.out.println(differenceTwoAgain);
         Cиметрична різниця
                    System.out.println("Cиметрична різниця: ");
                    Set<Integer> symmetryAgain = new TreeSet<Integer>(setOneAgain);
                    symmetryAgain.addAll(setTwoAgain);
                    symmetryAgain.removeAll(crossingAgain);
                    System.out.println(symmetryAgain);
        */
            /*
        // Об'єднання бітових рядків
            System.out.print("Об’єднання A і B {");
            //int finish [] = new int[arrOneAgain.length];
            for (int i = 0; i < arrOne.length; i++){
                   // finish[i] = arrOneAgain[i] & arrTwoAgain[i];
                    System.out.print(arrOneAgain[i] & arrTwoAgain[i]);
            }
            System.out.println("}");
        // Перетин бітових рядків
            System.out.print("Перетин A або B {");
            for (int i = 0; i < arrOne.length; i++){
                    System.out.print(arrOne[i] | arrOne[i]);
            }
            System.out.println("}");
        // Cиметрична різниця бітових рядків
            System.out.print("Симетрична різниця A і B {");
            for (int i = 0; i < arrOne.length; i++){
                    System.out.print(arrOneAgain[i] ^ arrTwoAgain[i]);
            }
            System.out.println("}");

        // Порівнюємо множини
            System.out.println("Множина A отримана з бітових рядків");
            Set<Integer> comparingFirst = new TreeSet<Integer>();
            for (int i = 0; i < arrOne.length; i++) {
                    int decimal = Integer.parseInt(String.valueOf(arrOneAgain[i]), 2);
                    comparingFirst.add(decimal);
            }
            System.out.println(comparingFirst);
            System.out.println("Множина B отримана з бітових рядків");
            Set<Integer> comparingSecond = new TreeSet<Integer>();
            for (int i = 0; i < arrTwo.length; i++) {
                    int decimal = Integer.parseInt(String.valueOf(arrTwoAgain[i]), 2);
                    comparingSecond.add(decimal);
            }
            System.out.println(comparingSecond);
            System.out.println("Ви могли побачити що множини, отримані з бітових рядків, співпадають із множинами які ви ввели спочатку.");
*/
// Завдання №3
// Представляємо введені користувачем множини у вигляді бітових рядків
            /*
            System.out.println("Введені множини у вигляді бітових рядків");
            System.out.print("Множина C {");
            int [] arrOneAgain = new int[a];
            arrOneAgain = arrOne;
            for (int i = 0; i < arrOneAgain.length; i++) {
                    arrOneAgain[i] = Integer.parseInt(Integer.toBinaryString(arrOneAgain[i]));

            }
            for (int i = 0; i < arrOneAgain.length; i++) {
                    System.out.print(arrOneAgain[i]);
            }
            System.out.println("}");
            System.out.print("Множина D {");
            int [] arrTwoAgain = new int[b];
            arrTwoAgain = arrTwo;
            for (int i = 0; i < arrTwoAgain.length; i++) {
                    arrTwoAgain[i] = Integer.parseInt(Integer.toBinaryString(arrTwoAgain[i]));
            }
            for (int i = 0; i < arrTwoAgain.length; i++) {
                    System.out.print(arrTwoAgain[i]);
            }
            System.out.println("}");*/

