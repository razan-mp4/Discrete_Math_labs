package com.company;
class Locking {
    void reflexive(int[][] mat) {
        // матриця в якій всі елементи головної діагоналі доривнюють 1
        int[][] reflexiveMat = new int[5][5];
        for (int i = 0; i < reflexiveMat.length; i++) {
            for (int j = 0; j < reflexiveMat.length; j++) {
                reflexiveMat[i][j] = 0;
            }
        }
        for (int i = 0; i < reflexiveMat.length; i++) {
            reflexiveMat[i][i] = 1;
        }
        // перемножуємо матриці
        System.out.println();
        System.out.println("Рефлексивне замикання: ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int n = mat[i][j] | reflexiveMat[i][j];
                System.out.print(n + "\t");
            }
            System.out.println();
        }
    }

    void symmetric(int[][] mat) {
        System.out.println("Симетричне замикання: ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int n = mat[j][i] | mat[i][j];
                System.out.print(n + "\t");
            }
            System.out.println();
        }
    }
    void transitive(int[][] mat) {
        int[][] squareMatrix = new int[5][5];
        int[][] cubicMatrix = new int[5][5];
        System.out.println("2 степінь відношення: ");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                for (int k = 0; k < mat.length; k++) {
                    squareMatrix[i][j] += mat[i][k] * mat[k][j];
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(squareMatrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("3 степінь відношення: ");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                for (int k = 0; k < mat.length; k++) {
                    cubicMatrix[i][j] += squareMatrix[i][k] & mat[k][j];
                    if (cubicMatrix[i][j] > 1) {
                        cubicMatrix[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(cubicMatrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Транзитивне замикання: ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int n = cubicMatrix[i][j] | squareMatrix[i][j] | mat[i][j];
                System.out.print(n + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
public class Main {
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_BLUE = "\u001B[34m";
    static boolean isReflexive(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][i] != 1) {
                return false;
            }
        }
        return true;
    }
    static boolean isUnReflexive(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][i] != 0) {
                return false;
            }
        }
        return true;
    }
    static boolean isSymmetric(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = i + 1; j < mat.length; j++) {
                if (mat[i][j] != mat[j][i]){
                    return false;
                }
            }
        }
        return true;
    }
    static boolean isAntisymmetric(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = i + 1; j < mat.length; j++) {
                if (mat[i][j] != 0 && mat[i][j] == mat[j][i] ){
                    return false;
                }
            }
        }
        return true;
    }
    static boolean isAsymmetric(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][i] != 0) {
                return false;
            }
            for (int j = i + 1; j < mat.length; j++) {
                if (mat[i][j] != 0 && mat[i][j] == mat[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean isTransitive(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (i != j && mat[i][j] != mat[j][j] && mat[i][j] != mat[i][i]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
	// write your code here
        System.out.println("Булева матриця відношення: ");
        int[][] matrix = new int[5][5];
        // first line
        matrix[0][0] = 1;
        matrix[0][1] = 0;
        matrix[0][2] = 0;
        matrix[0][3] = 1;
        matrix[0][4] = 0;
        // second line
        matrix[1][0] = 1;
        matrix[1][1] = 0;
        matrix[1][2] = 1;
        matrix[1][3] = 0;
        matrix[1][4] = 0;
        // third line
        matrix[2][0] = 0;
        matrix[2][1] = 0;
        matrix[2][2] = 0;
        matrix[2][3] = 0;
        matrix[2][4] = 0;
        // fourth line
        matrix[3][0] = 0;
        matrix[3][1] = 0;
        matrix[3][2] = 0;
        matrix[3][3] = 0;
        matrix[3][4] = 0;
        // fifth line
        matrix[4][0] = 0;
        matrix[4][1] = 1;
        matrix[4][2] = 0;
        matrix[4][3] = 0;
        matrix[4][4] = 1;
        // showing matrix
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        // відношення еквівалентності (рефлексивне, симетричне та транзитивне)
        // рефлексивність
        System.out.println(TEXT_BLUE);
        if (isReflexive(matrix)) {
            System.out.println("відношення рефлексивне");
        } else {
            System.out.println("відношення не рефлексивне");
        }
        // антирефлексивність
        if (isUnReflexive(matrix)) {
            System.out.println("відношення антирефлексивне");
        } else {
            System.out.println("відношення не антирефлексивне");
        }
        // симетричність
        if (isSymmetric(matrix)) {
            System.out.println("відношення симетричне");
        }
        // антисиметричність
        if (isAntisymmetric(matrix)) {
            System.out.println("відношення антисиметричне");
        }
        // асиметричність
        if (isAsymmetric(matrix)) {
            System.out.println("відношення асиметричне");
        }
        // транзитивність
        if (isTransitive(matrix)) {
            System.out.println("відношення транзитивне");
        } else {
            System.out.println("відношення не транзитивне");
        }
        System.out.println(TEXT_RESET);
        // відношення еквівалентності
        if (isReflexive(matrix) && isSymmetric(matrix) && isTransitive(matrix)) {
            System.out.println("відношення є відношенням еквівалентності");
        } else {
            System.out.println("відношення не є відношенням еквівалентності");
        }
        // частковим порядком
        if (isReflexive(matrix) && isAntisymmetric(matrix) && isTransitive(matrix)) {
            System.out.println("відношення є частковим порядком");
        } else {
            System.out.println("відношення не є частковим порядком");
        }
        // строгим порядком
        if (isUnReflexive(matrix) && isAntisymmetric(matrix) && isTransitive(matrix)) {
            System.out.println("відношення є строгим порядком");
        } else {
            System.out.println("відношення не є строгим порядком");
        }
        // рефлексивне замикання
        Locking reflexive = new Locking();
        reflexive.reflexive(matrix);
        // симетричне замикання
        Locking symmetric = new Locking();
        symmetric.symmetric(matrix);
        // транзитивне замикання і степіні матриці
        Locking transitive = new Locking();
        transitive.transitive(matrix);
    }
}
