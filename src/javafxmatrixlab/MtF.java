package javafxmatrixlab;

/*
------------------------------------
Кратная документация к коду
Функции:
    - SumMatrix(A,B) возвращает сумму матриц
    - SumMatrixEl(k, A) возвращает матрицу с элементами a + k
    - MultMatrix(A, B)  возвращает произведение матрицы A на матр. B 
    - MultMatrixEl(k, A) возвращает матрицу А умноженую на k
    - PowMatrix(A, n)   возвращает матрицу А в степени n
    - DetGauss(A) возвращает определитель матрицы
    - UnderMatrix(A, i, j) возвращает матрицу N-1xM-1 без строки j и столбца i
    - MinorMatrix(A, i, j) возвращает минор матрицы A
    - RangeMatrix(A)  возвращает ранг матрицы A
    - ReverseMatrix(A)  возврашает обратную матрицу A
    - AlgComlementMatrix(A) возвращает алгебраическое дополнение матрицы A
    - TransMatrix(A) возвращает транспонированую матрицу А
    - revS(A) возвращает матрицу -A (меняя исходную!)
-------------------------------------
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MtF {

    public static class Matrix {

        private int n, m;
        private String name;
        //Работа с ошибками
        private String idError = null;
        public static boolean format = false;

        public void isWrong(String id) {
            this.idError = id;
        }

        public void isRight() {
            this.idError = null;
        }

        public String getIdError() {
            return this.idError;
        }

        // Конструкторы
        public Matrix(String name, String line) {
            this.name = name;
            int nSize, mSize;
            ArrayList<String> rowList = new ArrayList<>();

            String patternString = "[[[-]{0,1}[\\d]{0,}[\\056]{0,1}[\\d]{1,}]{1,}[,]]{0,}[[-]{0,1}[\\d]{0,}[\\056]{0,1}[\\d]{1,}]{1,}";

            Pattern pattern = Pattern.compile(patternString);

            boolean fl = true;
            while (fl) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find() && !line.isEmpty()) {
                    try {
                        rowList.add(matcher.group());
                        line = line.substring(matcher.end());
                    } catch (Exception e) {
                        fl = false;
                    }
                } else {
                    fl = false;
                }
            }
            boolean isTrue = true;
            nSize = rowList.size();
            mSize = getRowFromSintacsis(rowList.get(0)).length;
            for (int i = 1; i < nSize; i++) {
                if (getRowFromSintacsis(rowList.get(i)).length != mSize) {
                    isTrue = false;
                    break;
                }
            }
            float[][] res = new float[nSize][mSize];

            if (isTrue) {
                for (int i = 0; i < nSize; i++) {
                    res[i] = getRowFromSintacsis(rowList.get(i));
                }
            } else {
                this.idError = "\n>> Неверная размерность";
            }

            this.n = nSize;
            this.m = mSize;
            this.matrix = res;
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

        //конструктор копирования другой матрицы
        public Matrix(Matrix M) {
            this.n = M.getN();
            this.m = M.getM();
            this.name = M.name;
            this.matrix = M.matrix;
        }

        public Matrix(String name, Matrix M) {
            this.n = M.getN();
            this.m = M.getM();
            this.name = name;
            this.matrix = M.matrix;
        }
        //Создание матрицы после создания экземпляра
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

        // Сеттеры и геттеры
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

        //заполнение матрицы и целыми и вещественными числами
        public void autoSetIntFloat(float range, int digit) {
            Random random = new Random();
            float[][] res = new float[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int rand = (int) Math.round(Math.random());
                    float buffer;
                    switch (rand) {
                        case 0:
                            buffer = Math.round(Math.random() * range * 2 - range);
                            res[i][j] = buffer;
                            break;
                        case 1:
                            buffer = (float) ((Math.random() * range * 2) - range);
                            buffer = Math.round((buffer * (10 * digit)));
                            buffer /= 10 * digit;
                            res[i][j] = buffer;
                            break;
                    }
                }
            }
            this.matrix = res;
        }

        //перевод матрицы в строку
        public String toString(int length) {
            String result = "\t" + name + ":\n";
            String lth = "%." + length + "f";
            float[][] matr = this.matrix;
            if (idError == null) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (matr[i][j] == Math.round(matr[i][j])) {
                            result += "\t" + String.valueOf((int) matr[i][j]);
                        } else {
                            if (!format) {
                                result += "\t" + String.format(lth, matr[i][j]);
                            } else {
                                result += "\t" + toFormat(matr[i][j]);
                            }
                        }
                    }
                    result += "\n";
                }
            } else {
                result = this.idError;
            }
            return result;
        }
        // возвращает размер матрицы в строке
        public String getSize() {
            String result = "N." + this.n + " M." + this.m;
            return result;
        }
    }

    //---------- КОНЕЦ КЛАССА --------------------------------------------------
    //Возвращает число обычной дробью
    public static String toFormat(float val) {
        String res = "";
        final float ratio = 0.01f;
        for (int i = 1; i > 0; i++) {
            double tem = val / (1f / i);
            if (Math.abs(tem - Math.round(tem)) < ratio) {
               res += String.valueOf(Math.round(tem)) + "/" + i;
               break;
            }
        }
        return res;
    }
    // GCD 
    public static int getGCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0) return a;
        int x = a % b;
        return getGCD(b, x);
    }
    
    //Меняет режим вывод
    public static void formatMode() {
        Matrix.format = !Matrix.format;
    }
    //Получить столбец матрицы
    public static Matrix getColumMatrix(Matrix A, int n) {
        n--;
        Matrix Res = new Matrix(A.getN(), 1);
        float[][] res = new float[A.getN()][1];
        for (int i = 0; i < A.getN(); i++) {
            res[i][0] = A.matrix[i][n];
        }
        Res.matrix = res;
        return Res;
    }
    //Получить строку матрицы
    public static Matrix getRowMatrix(Matrix A, int n) {
        n--;
        Matrix Res = new Matrix(1,A.getM());
        float[][] res = new float[1][A.getM()];
        for (int i = 0; i < A.getM(); i++) {
            res[0][i] = A.matrix[n][i];
        }
        Res.matrix = res;
        return Res;
    }
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

    public static Matrix revS(Matrix A) {
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
        Matrix Res = new Matrix("Ans", A.getM(), B.getN());
        float[][] res = new float[A.getM()][B.getN()];
        
        if (A.getM() != B.getN()) {
            Res.isWrong("\n>> Не подходят размерности");
        } else {
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
        }
        return Res;
    }

    //Поэлементное умножение матрицы
    public static Matrix MultMatrixEl(float k, Matrix A) {
        Matrix Res = new Matrix(A.getN(), A.getM());

        float[][] res = new float[A.getN()][A.getM()];

        for (int i = 0; i < A.getN(); i++) {
            for (int j = 0; j < A.getM(); j++) {
                res[i][j] = A.matrix[i][j] * k;
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

    //Определитель матрицы методом гаусса
    public static float DetGauss(Matrix M) {
        final float E = 0.000001f;
        float det = 1, s;
        int n = M.getM(), k;
        float[][] Mt = new float[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Mt[i][j] = M.matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            k = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(Mt[j][i]) > Math.abs(Mt[k][i])) {
                    k = j;
                }
            }
            if (Math.abs(Mt[k][i]) < E) {
                det = 0;
                break;
            }
            //Swap
            for (int l = 0; l < M.getN(); l++) {
                s = Mt[i][l];
                Mt[i][l] = Mt[k][l];
                Mt[k][l] = s;
            }
            if (i != k) {
                det *= -1;
            }
            det *= Mt[i][i];
            for (int j = i + 1; j < n; j++) {
                Mt[i][j] /= Mt[i][i];
            }

            for (int j = 0; j < n; j++) {
                if ((j != i) && (Math.abs(Mt[j][i]) > E)) {
                    for (k = i + 1; k < n; k++) {
                        Mt[j][k] -= Mt[i][k] * Mt[j][i];
                    }
                }
            }
        }
        det = Math.round(det * 100) * 0.01f;
        return det;
    }

    //МинорМатрицы (НЕ ДЕТЕРМИНАНТ)
    public static Matrix UnderMatrix(Matrix Mt, int row, int col) {
        Matrix minor = new Matrix(Mt.getN() - 1, Mt.getM() - 1);
        float[][] res = new float[minor.getN()][minor.getM()];

        for (int i = 0; i < Mt.getN(); i++) {
            int resRowIndex = row < i ? i - 1 : i;

            for (int j = 0; j < Mt.matrix[i].length; j++) {
                int resColIndex = col < j ? j - 1 : j;

                if (row != i && col != j) {
                    res[resRowIndex][resColIndex] = Mt.matrix[i][j];
                }
            }
        }
        minor.matrix = res;
        return minor;
    }

    //Минор матрицы
    public static float MinorMatrix(Matrix Mt, int row, int col) {
        float DetMinor = 0;
        if (Mt.getN() == 2) {
            DetMinor = Mt.matrix[0][0] * Mt.matrix[1][1] - Mt.matrix[0][1] * Mt.matrix[1][0];
        }
        if (Mt.getN() > 2) {
            DetMinor += DetGauss(UnderMatrix(Mt, row, col));
        }

        return DetMinor;
    }

    //Алгебраическое дополнение
    public static float AlgComlementMatrix(Matrix Mt, int row, int col) {
        float AlgCompl;
        int unit = 1;
        row++;
        col++;
        if ( (row + col) % 2 != 0) {
            unit *= -1;
        }
        AlgCompl = unit * MinorMatrix(Mt, --row, --col);
        return AlgCompl;
    }
    
    public static Matrix UnionMatrix(Matrix Mt) {
        Matrix Res = new Matrix(Mt);
        float[][] res = new float[Mt.getN()][Mt.getM()];
        for (int i = 0; i < Mt.getN(); i++) {
            for (int j = 0; j < Mt.getM(); j++) {
                res[i][j] = AlgComlementMatrix(Mt, i, j);
            }
        }
        Res.matrix = res;
        return Res;
    }

    //Ранг матрицы - не готово ------------------------------------------------- 
    public static float RangeMatrix(Matrix M) {
        float range = 0;
        float[][] res = new float[M.getN()][M.getM()];

        return range;
    }

    //Обратная матрица
    public static Matrix InversMatrix(Matrix M) {
        Matrix Res = new Matrix(M.getN(), M.getM());
        float det = DetGauss(M);
        if (det == 0) {
            Res.isWrong("\n>> Обратной матрицы не существует! определитель = 0");
        } else {
            Res = MultMatrixEl( 1 / DetGauss(M), TranspMatrix( UnionMatrix(M) ) );
        }
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
    public static Matrix equationKramar(Matrix A, Matrix B) {
        Matrix Res = new Matrix(1, A.getM());
        float det = DetGauss(A);
        
        float[] Sol = new float[A.getM()];

        return Res;
    }

    //Работа с синтаксисом
    //Возвращает массив(флоат) строки матрицы который потом нужно присваивать матрице  
    public static float[] getRowFromSintacsis(String line) {
        //Нужно реализовать считывание не только константных чисел а и переменных
        ArrayList<Float> listOfNumber = new ArrayList<>();
        String patternOnString = "[-]{0,1}[\\d]{0,}[\\056]{0,1}[\\d]{1,}";
        int len = 0;
        Pattern pattern = Pattern.compile(patternOnString);

        boolean fl = true;
        while (fl) {
            Matcher m = pattern.matcher(line);
            float buff;
            if (m.find()) {
                buff = Float.valueOf(m.group(0));
                listOfNumber.add(buff);
                len++;
                if (!line.isEmpty()) {
                    line = line.substring(m.end());
                }
            } else {

                fl = false;

            }
        }   

        float[] res = new float[len];
        for (int i = 0; i < len; i++) {
            res[i] = listOfNumber.get(i);
        }
        return res;
    }
}

