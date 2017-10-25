package javafxmatrixlab;

import java.lang.*;

public class MtF {

    public static class Matrix {

        private int n, m;
        private String name;

        public Matrix(int n, int m, String name) {
            this.n = n;
            this.m = m;
            this.name = name;
        }

        public Matrix(int n, int m) {
            this.n = n;
            this.m = m;
            this.name = "Answer";
        }

        public Matrix(int n, String name) {
            this.n = n;
            this.m = n;
            this.name = name;
        }

        public Matrix(int n) {
            this.n = n;
            this.m = n;
            this.name = "Answer";
        }

        //Копирование размерности другой матрицы
        public Matrix(Matrix M) {
            this.n = M.getN();
            this.m = M.getM();
            this.name = "Answer";
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

        public void setName(String name) {
            this.name = name;
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
            float[][] res = new float[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    res[i][j] = (float) (Math.random() * range * 2) - range;
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

    //Поэлементная сумма матрицы
    public static Matrix SumMatrixEl(int k, Matrix A) {
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
        //
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

    //Определитель матрицы - не готово
    public static float DetMatrix(Matrix M) {
        float det = 0;

        return det;
    }

    //Матрица n-1 x m-1  - не готово
    public static Matrix UnderMatrix(Matrix M, int k) {
        int n = M.getN() - 1, m = M.getM() - 1;
        Matrix Res = new Matrix(n, m);
        float[][] res = new float[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = M.matrix[i + 1][j + 1];
            }
        }
        Res.matrix = res;
        return Res;
    }

    //МинорМатрицы - не готово
    public static float MinorMatrix(Matrix M) {
        float m = 0;

        return m;
    }

    //Ранг матрицы
    public static float RangeMatrix(Matrix M) {
        float range = 0;
        float[][] res = new float[M.getN()][M.getM()];

        return range;
    }

    //Обратная матрица - не готово
    public static Matrix ReversMatrix(Matrix M) {
        Matrix Res = new Matrix(M.getN(), M.getM());

        return Res;
    }

    //Алгебраическое дополнение - не готово
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

    //Решение СЛАУ методом какого то там - не готово
    public static Matrix awd(Matrix M) {
        Matrix Res = new Matrix(1, M.getM());

        return Res;
    }
}
