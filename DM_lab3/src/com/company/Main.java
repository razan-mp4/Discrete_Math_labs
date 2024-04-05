package com.company;

public class Main {
    // колір шрифта
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    // оголошую булеву функцію
    static boolean[] bool = new boolean[8];

    public static void main(String[] args) {
        System.out.println(TEXT_YELLOW + "F = (x & y) + (!y & z)" + TEXT_RESET);
        System.out.println("F* = (x + y) & (!y + z)");
        System.out.println("Таблиця істинності: ");
        System.out.println(TEXT_BLUE + "X Y Z" + TEXT_RESET + "  X&Y !Y !Y&Z" + TEXT_YELLOW + "   F" + TEXT_RESET + "   F*");
        out(false,false,false);
        out(false,false,true);
        out(false,true,false);
        out(false,true,true);
        out(true,false,false);
        out(true,false,true);
        out(true,true,false);
        out(true,true,true);


        // ініціалізую булеву функцію
        bool[0] = false;
        bool[1] = true;
        bool[2] = false;
        bool[3] = false;
        bool[4] = false;
        bool[5] = true;
        bool[6] = true;
        bool[7] = true;
        System.out.println();
        System.out.println("ДДНФ і ДКНФ: ");
        System.out.println("X Y Z  F");
        outTwo(false,false,false, bool[0]);
        outTwo(false,false,true, bool[1]);
        outTwo(false,true,false, bool[2]);
        outTwo(false,true,true, bool[3]);
        outTwo(true,false,false, bool[4]);
        outTwo(true,false,true, bool[5]);
        outTwo(true,true,false, bool[6]);
        outTwo(true,true,true, bool[7]);

        // булева функція у вигляді 0 та 1
        int[] boolNum = new int[8];
        for (int i = 0; i < bool.length; i ++) {
            if (bool[i]) {
                boolNum[i] = 1;
            } else {
                boolNum[i] = 0;
            }
        }
        // диз'юнкція
        System.out.print("ДДНФ: F = ");
        disjunction(false,false,false, bool[0]);
        disjunction(false,false,true, bool[1]);
        disjunction(false,true,false, bool[2]);
        disjunction(false,true,true, bool[3]);
        disjunction(true,false,false, bool[4]);
        disjunction(true,false,true, bool[5]);
        disjunction(true,true,false, bool[6]);
        disjunction(true,true,true, bool[7]);
        System.out.println();

        // кон'юнкція
        System.out.print("ДКНФ: F = ");
        conjunction(false,false,false, bool[0]);
        conjunction(false,false,true, bool[1]);
        conjunction(false,true,false, bool[2]);
        conjunction(false,true,true, bool[3]);
        conjunction(true,false,false, bool[4]);
        conjunction(true,false,true, bool[5]);
        conjunction(true,true,false, bool[6]);
        conjunction(true,true,true, bool[7]);
        System.out.println();

        // поліномом Жегалкіна
        System.out.print("Поліном Жегалкіна: F = ");
        String polOne;
        String polTwo;
        String polThree;
        String polFour;
        String polFive;
        String polSix;
        String polSeven;
        String polEight;
        boolean four = false;
        boolean six = false;
        boolean seven = false;
        boolean eight = false;
        if (bool[0]) {
            polOne = "1 ^ ";
        } else {
            polOne = "";
        }
        if (bool[1]) {
            polTwo = "z ^ ";
        } else {
            polTwo = "";
        }
        if (bool[2]) {
            polThree = "y ^ ";
        } else {
            polThree = "";
        }
        if (bool[3]) {
            polFour = "yz ^ ";
            four = true;
        } else {
            polFour = "";
        }
        if (bool[4]) {
            polFive = "x ^ ";
        } else {
            polFive = "";
        }
        if (bool[5]) {
            polSix = "xz ^ ";
            six = true;
        } else {
            polSix = "";
        }
        if (bool[6]) {
            polSeven = "xy ^ ";
            seven = true;
        } else {
            polSeven = "";
        }
        if (bool[7]) {
            polEight = "xyz ^ ";
            eight = true;
        } else {
            polEight = "";
        }
        System.out.println(polOne + polTwo + polThree + polFour + polFive + polSix + polSeven + polEight);
        // перевірка 0 i 1
        boolean checkNull = false;
        boolean checkOne = false;
        for (int i = 0; i < bool.length; i++) {
            if (!bool[i]) checkNull = true;
        }
        for (int i = 0; i < bool.length; i++) {
            if (bool[i]) checkOne = true;
        }
        if (checkNull) {
            System.out.println("Функція зберігає константу 0");
        } else {
            System.out.println("Функція не зберігає константу 0");
        }
        if (checkOne) {
            System.out.println("Функція зберігає константу 1");
        } else {
            System.out.println("Функція не зберігає константу 1");
        }
        // перевірка на самодвоїстість
        boolean[] selfDual = new boolean[8];
        selfDual[0] = checkSelfDual(false,false,false);
        selfDual[1] = checkSelfDual(false,false,true);
        selfDual[2] = checkSelfDual(false,true,false);
        selfDual[3] = checkSelfDual(false,true,true);
        selfDual[4] = checkSelfDual(true,false,false);
        selfDual[5] = checkSelfDual(true,false,true);
        selfDual[6] = checkSelfDual(true,true,false);
        selfDual[7] = checkSelfDual(true,true,true);
        boolean checking = false;
        for (int i = 0; i < selfDual.length; i++) {
            if (bool[i] != selfDual[i]) {
                checking = true;
            }
        }
        if (checking) {
            System.out.println("Функція не самодвоїста");
        } else {
            System.out.println("Функція самодвоїста");
        }
        // перевірка на монотонність
        boolean monotone = false;
        if (boolNum[0] >= boolNum[1]) {
            monotone = true;
        }
        if (boolNum[2] >= boolNum[3]) {
            monotone = true;
        }
        if (boolNum[4] >= boolNum[5]) {
            monotone = true;
        }
        if (boolNum[6] >= boolNum[7]) {
            monotone = true;
        }
        if (monotone) {
            System.out.println("Функція не монотонна");
        } else {
            System.out.println("Функція монотонна");
        }
        // перевірка на лінійність
        if (four & six & seven & eight) {
            System.out.println("Функція лінійна");
        } else {
            System.out.println("Функція не лінійна");
        }
    }

    public static void out (boolean x, boolean y, boolean z) {
        System.out.println(TEXT_BLUE + (x ? "1 " : "0 ") + (y ? "1 " : "0 ") + (z ? "1 \t" : "0 \t") + TEXT_RESET
                + ((x && y) ? "1 \t" : "0 \t") + (!y  ? "1 \t" : "0 \t") + ((!y && z) ? "1 \t" : "0 \t")
                + TEXT_YELLOW + ((x && y) || (!y && z) ? " 1" : " 0") + TEXT_RESET + ((x || y) && (!y || z) ? "   1" : "   0"));

    }
    public static void outTwo (boolean x, boolean y, boolean z, boolean F) {
        System.out.println((x ? "1 " : "0 ") + (y ? "1 " : "0 ") + (z ? "1  " : "0  ") + (F ? "1 " : "0 "));
    }
    public static void disjunction (boolean x, boolean y, boolean z, boolean F) {
        String a;
        String b;
        String c;
        if (F) {
            if (x) {
                a = "х";
            } else {
                a = "!х";
            }
            if (y) {
                b = "y";
            } else {
                b = "!y";
            }
            if (z) {
                c = "z";
            } else {
                c = "!z";
            }
            System.out.print("(" + a + b + c + ")");
        }
        if (F) System.out.print(" + ");
    }
    public static void conjunction (boolean x, boolean y, boolean z, boolean F) {
        String a;
        String b;
        String c;
        if (!F) {
            if (x) {
                a = "!х";
            } else {
                a = "х";
            }
            if (y) {
                b = "!y";
            } else {
                b = "y";
            }
            if (z) {
                c = "!z";
            } else {
                c = "z";
            }
            System.out.print("(" + a + "+" + b + "+" + c + ")");
        }
    }
    public static int checkZero (boolean[] boolCheck) {
        for (boolean b : boolCheck) {
            if (b) {
                return 0;
            }
        }
        return 1;
    }
     public static boolean checkSelfDual (boolean x, boolean y, boolean z) {
        return (x || y) && (!y || z);
    }
}