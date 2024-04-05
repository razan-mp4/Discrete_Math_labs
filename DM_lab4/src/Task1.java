import java.util.Scanner;


public class Task1 {
    //перевірка матриці на симетричність
    static int checkSymmetric(int mat[][], int row,
                              int col) {
        int i, j, flag = 1;
        //створюємо нову матрицю
        int[][] transpose = new int[row][col];
        //робимо транспоновану матрицю
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                //заповнюємо транспоновану матрицю
                transpose[j][i] = mat[i][j];
            }
        }
        //перевірка на квадратність матриці
        if (row == col) {
            //перевірка на однаковість початкової та транспонованої матриці
            for (i = 0; i < row; i++) {
                for (j = 0; j < col; j++) {
                    //перевіряєио кожен елемент
                    //якщо не однакові кажемо що flag = 0
                    if (mat[i][j] != transpose[i][j]) {
                        flag = 0;
                        break;
                    }
                }
            }
            return flag;
        }
        //повертаємо тільки кли матриця не квадратна
        return -1;
    }
    public static void main(String args[]) {
        // створюємо єлемент для вводу данних
        Scanner sc = new Scanner(System.in);
        int i, j, row, col;

        System.out.print("Enter the number of rows:");
        row = sc.nextInt();

        System.out.print("Enter the number of columns:");
        col = sc.nextInt();
        int[][] mat = new int[row][col];
        System.out.println("Enter the matrix elements:");
        // вводимо єлементи матриці
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                //вводимо 1 елемент матриці
                mat[i][j] = sc.nextInt();
            }
        }
        // викликаємо превірку симетричність для нашої матриці
        int symmetric = checkSymmetric(mat, row, col);
        if(symmetric == 0){
            System.out.println("oriented");
        } else if(symmetric == 1){
            System.out.println("don't know is oriented");
        }
    }
}