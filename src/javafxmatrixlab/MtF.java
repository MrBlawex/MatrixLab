package mtrxf;

import java.lang.*;
import java.util.Random;

public class MtF {

    //Сделать переименовку матрицы
    public static class Matrix {

        private int n, m;
        private String name;

        //Копирование размерности другой матрицы
        public Matrix(Matrix M) {
            this.n = M.getN();
            this.m = M.getM();
            this.name = "Ans";
        }

        public Matrix(String name, int n, int m) {
            this.n = n;
            this.m = m;
            this.name = name;
        }

        public Matrix(String name, int n) {
            this.n = n;
            this.m = n;
            this.name = name;
        }

        public Matrix(String name) {
            this.n = 0;
            this.m = 0;
            this.name = name;
        }

        public Matrix(int n, int m) {
            this.n = n;
            this.m = m;
            this.name = "Ans";
        }

        public Matrix(int n) {
            this.n = n;
            this.m = n;
            this.name = "Ans";
        }

        public Matrix() {
            this.n = 0;
            this.m = 0;
            this.name = "";
        }

        //Создание матрицы после создания экземпляра
        public void setMatrix(String name, int n, int m) {
            float[][] res = new float[n][m];
            this.matrix = res;
            this.n = n;
            this.m = m;
            this.name = name;
        }

        public void setMatrix(int n, int m) {
            float[][] res = new float[n][m];
            this.matrix = res;
            this.n = n;
            this.m = m;
            this.name = "Ans";
        }

        public void setMatrix(int n) {
            float[][] res = new float[n][n];
            this.matrix = res;
            this.n = n;
            this.m = n;
            this.name = "Ans";
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getN() {
            return this.n;
        }

        public int getM() {
            return this.m;
        }

        public String getName() {
            return this.name;
        }

        float[][] matrix = new float[n][m];

        //заполнение матрицы целыми числами
        public void autoSetInt(int range) {
            float[][] res = new float[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    res[i][j] = (float) Math.round(Math.random() * range * 2) - range;
                }
            }
            this.matrix = res;
        }

        //рандом заполнение матрицы вещественными числами
        public void autoSetFloat(float range) {
            float[][] res = new float[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    res[i][j] = (float) (Math.random() * range * 2) - range;
                }
            }
            this.matrix = res;
        }

        //заполнение матрицы и целыми и вещественными числами - не сделано
        public void autoSetIntFloat(float range) {
            Random random = new Random();
            float[][] res = new float[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    switch ((int) Math.round(Math.random())) {
                        case 0:
                            res[i][j] = (float) Math.round(Math.random() * range * 2) - range;
                            break;
                        case 1:
                            res[i][j] = (float) (Math.random() * range * 2) - range;
                            break;
                    }
                }
            }
            this.matrix = res;
        }

        //перевод матрицы в строку
        public String toStringM(int length) {
            String str = "\t" + name + ":\n";
            String lth = "%." + length + "f";
            float[][] matr = this.matrix;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matr[i][j] == Math.round(matr[i][j])) {
                        str += "\t" + String.valueOf((int) matr[i][j]);
                    } else {
                        str += "\t" + String.format(lth, matr[i][j]);
                    }
                }
                str += "\n";
            }
            return str;
        }

        //Трансформация матрицы в другую (клонирование)
        public void to(Matrix M) {
            this.n = M.getN();
            this.m = M.getM();
            this.name = M.getName();
            this.matrix = M.matrix;
        }

    }

    //Конец класса ------------------------------------------
    //Сумма матриц
    public static Matrix SumMatrix(Matrix A, Matrix B) {
        Matrix Res = new Matrix(A);
        float[][] res = new float[A.getN()][A.getM()];

        for (int i = 0; i < A.getN(); i++) {
            for (int j = 0; j < A.getM(); j++) {
                res[i][j] = A.matrix[i][j] + B.matrix[i][j];
            }
        }
        Res.matrix = res;
        return Res;
    }

    public static Matrix reverSignMatrix(Matrix A) {
        Matrix Res = new Matrix(A);
        float[][] res = A.matrix;
        for (int i = 0; i < A.getN(); i++) {
            for (int j = 0; j < A.getM(); j++) {
                res[i][j] *= -1;
            }
        }
        Res.matrix = res;
        return Res;
    }

    //Поэлементная сумма матрицы
    public static Matrix SumMatrixEl(float k, Matrix A) {
        Matrix Res = new Matrix(A);

        for (int i = 0; i < A.getN(); i++) {
            for (int j = 0; j < A.getM(); j++) {
                Res.matrix[i][j] = A.matrix[i][j] + k;
            }
        }
        return Res;
    }

    //Умножение матриц
    public static Matrix MultMatrix(Matrix A, Matrix B) {
        Matrix Res = new Matrix(A.getN(), B.getM());
        float[][] res = new float[A.getN()][B.getM()];

        for (int i = 0; i < Res.getN(); i++) {
            for (int j = 0; j < Res.getM(); j++) {
                res[i][j] = 0;
            }
        }
        for (int y = 0; y < Res.getN(); y++) {
            for (int x = 0; x < Res.getM(); x++) {
                for (int j = 0; j < A.getM(); j++) {
                    res[y][x] += A.matrix[y][j] * B.matrix[j][x];
                }
            }
        }
        Res.matrix = res;
        return Res;
    }

    //Поэлементное умножение матрицы
    public static Matrix MultMatrixEl(float k, Matrix A) {
        Matrix Res = new Matrix(A.getN(), A.getM());
        float[][] res = new float[A.getN()][A.getM()];
        for (int i = 0; i < A.getN(); i++) {
            for (int j = 0; i < A.getM(); j++) {
                Res.matrix[i][j] = A.matrix[i][j] * k;
            }
        }
        Res.matrix = res;
        return Res;
    }

    //Возведение матрицы в степень 
    public static Matrix PowMatrix(Matrix M, int n) {
        Matrix Res = M;
        for (int i = 0; i < n - 1; i++) {
            Res = MultMatrix(Res, M);
        }
        return Res;
    }

    //Определитель матрицы - не готово -----------------------------------------
    public static float DetMatrix(Matrix M) {
        float det = 0;

        return det;
    }

    //МинорМатрицы
    public static Matrix MinorMatrix(Matrix Mt, int row, int col) {
        Matrix minor = new Matrix(Mt.getN() - 1, Mt.getM() - 1);
        float[][] res = new float[minor.getN()][minor.getM()];

        for (int i = 0; i < Mt.getN(); i++) {
            boolean isRowDeleted = row < i;
            int resRowIndex = isRowDeleted ? i - 1 : i;

            for (int j = 0; j < Mt.matrix[i].length; j++) {
                boolean isColDeleted = col < j;
                int resColIndex = isColDeleted ? j - 1 : j;

                if (row != i && col != j) {
                    res[resRowIndex][resColIndex] = Mt.matrix[i][j];
                }
            }
        }

        minor.matrix = res;
        return minor;
    }

    //Ранг матрицы - не готово ------------------------------------------------- 
    public static float RangeMatrix(Matrix M) {
        float range = 0;
        float[][] res = new float[M.getN()][M.getM()];

        return range;
    }

    //Обратная матрица - не готово ---------------------------------------------
    public static Matrix ReversMatrix(Matrix M) {
        Matrix Res = new Matrix(M.getN(), M.getM());

        return Res;
    }

    //Алгебраическое дополнение - не готово ------------------------------------
    public static Matrix AlgComlementMatrix(Matrix M) {
        Matrix Res = new Matrix(M.getN(), M.getM());

        return Res;
    }

    //Транспонирование матрицы
    public static Matrix TranspMatrix(Matrix M) {
        Matrix Res = new Matrix(M.getM(), M.getN());
        float[][] res = new float[M.getM()][M.getN()];
        for (int i = 0; i < M.getM(); i++) {
            for (int j = 0; j < M.getN(); j++) {
                res[i][j] = M.matrix[j][i];
            }
        }
        Res.matrix = res;
        return Res;
    }

    //Решение СЛАУ методом Крамера - не готово ---------------------------------
    public static Matrix equationKramar(Matrix M) {
        Matrix Res = new Matrix(M.getN(), 1);

        return Res;
    }
}
