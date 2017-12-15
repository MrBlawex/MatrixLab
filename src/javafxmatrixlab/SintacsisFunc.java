package javafxmatrixlab;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafxmatrixlab.controller.homeMatrixLabController;

public class SintacsisFunc {

    public static class Sintacsis {

        protected String stringFunc;
        protected int size;

        public Sintacsis(String string) {
            this.stringFunc = string;
            this.size = string.length();
        }

        public String getString() {
            return this.stringFunc;
        }

        public int getSize() {
            return this.size;
        }

    }

    public static Matcher createMatcher(String commandOnString, String patternOnString) {
        Pattern pattern = Pattern.compile(patternOnString);
        Matcher matcher = pattern.matcher(commandOnString);

        return matcher;
    }

    public static String formatStringForReturn(String commandOnString, String result) {
        return ">> " + commandOnString + "\n" + result + "\n";
    }

    public static class PatternConst {

        /**
         * Создание матрицы в строке
         */
        public static final String CREATE_MATRIX = "^[\\s]{0,}([A-Za-z][A-Za-z0-9]{0,7})[\\s]{0,}[=][\\s]{0,}[\\x5B]([[[-]{0,1}[\\d]{0,}[\\056]{0,1}[\\d]{1,}[,]]{0,}[-]{0,1}[\\d]{0,}[\\056]{0,1}[\\d]{1,}[;]]{0,}[[-]{0,1}[\\d]{0,}[\\056]{0,1}[\\d]{1,}[,]]{0,}[-]{0,1}[\\d]{0,}[\\056]{0,1}[\\d]{1,})[\\x5D]";
        /**
         * Создание нулевой матрицы
         */
        public static final String CREATE_NULL_MATRIX = "^zeros[(]([\\d]{1,}[,][\\d]{1,})[)]";
        /**
         * Создание единичной матрицы
         */
        public static final String CREATE_ONES_MATRIX = "^ones[(]([\\d]{1,}[,][\\d]{1,})[)]";
        /**
         * Создание матрицы с нулями кроме диагонали
         */
        public static final String CREATE_DIAG_MATRIX = "^diag[(]([A-Za-z][A-Za-z0-9]{0,7})[)]";
        /**
         * Создание единичной матрицы
         */
        public static final String CREATE_EYE_MATRIX = "^eye[(]([\\d]{1,})[)]";
        /**
         * Создание инвертированной матрицы (обратной)
         */
        public static final String CREATE_INV_MATRIX = "^inv[(]([A-Za-z][A-Za-z0-9]{0,7})[)]";
        /**
         * Создание клонированной матрицы
         */
        public static final String CREATE_CLONE_MATRIX = "^[\\s]{0,}([A-Za-z][A-Za-z0-9]{0,7})[\\s]{0,}[=][\\s]{0,}([A-Za-z][A-Za-z0-9]{0,7})";
        /**
         * Поиск функции транспорации
         */
        public static final String FUNC_TRANSPORATION = "([A-Za-z][A-Za-z0-9]{0,7})[\\x27]";
        /**
         * Синус от каждого элемента
         */
        public static final String FUNC_SIN_MATRIX = "^sin[(]([A-Za-z][A-Za-z0-9]{0,7})[)]";
        /**
         * Косинус от каждого элемента
         */
        public static final String FUNC_COS_MATRIX = "^cos[(]([A-Za-z][A-Za-z0-9]{0,7})[)]";
        /**
         * Тангенс от каждого элемента
         */
        public static final String FUNC_TG_MATRIX = "^tg[(]([A-Za-z][A-Za-z0-9]{0,7})[)]";
        /**
         * Котангенс от каждого элемента
         */
        public static final String FUNC_CTG_MATRIX = "^ctg[(]([A-Za-z][A-Za-z0-9]{0,7})[)]";
        /**
         * Поэлементное умножение матриц
         */
        public static final String FUNC_EL_PROD_MATRIX = "([A-Za-z][A-Za-z0-9]{0,7})[\\x2E][\\x2A]([A-Za-z][A-Za-z0-9]{0,7})";
        /**
         * Поэлементное деление матриц
         */
        public static final String FUNC_EL_DIV_MATRIX = "([A-Za-z][A-Za-z0-9]{0,7})[\\x2E][\\x2F]([A-Za-z][A-Za-z0-9]{0,7})";
        /**
         * Поэлементное возведение в степень
         */
        public static final String FUNC_EL_POW_MATRIX = "([A-Za-z][A-Za-z0-9]{0,7})[\\x2E][\\x5E]([A-Za-z][A-Za-z0-9]{0,7})";
        /**
         * Поэлементное добавление
         */
        public static final String FUNC_ADD_MATRIX = "([A-Za-z][A-Za-z0-9]{0,7})[\\x2B]([A-Za-z][A-Za-z0-9]{0,7})";
        /**
         * Поэлементное отнимание
         */
        public static final String FUNC_DIFFER_MATRIX = "([A-Za-z][A-Za-z0-9]{0,7})[\\x2D]([A-Za-z][A-Za-z0-9]{0,7})";
        /**
         * Умножение
         */
        public static final String FUNC_MULT_MATRIX = "([A-Za-z][A-Za-z0-9]{0,7})[\\x2A]([A-Za-z][A-Za-z0-9]{0,7})";
        /**
         * Деление матрицы
         */
        public static final String FUNC_DIV_MATRIX = "([A-Za-z][A-Za-z0-9]{0,7})[\\x2F]([A-Za-z][A-Za-z0-9]{0,7})";
        /**
         * Возведение в степень
         */
        public static final String FUNC_POW_MATRIX = "([A-Za-z][A-Za-z0-9]{0,7})[\\x5E]([0-9]{1,2})";
        /**
         * Вывести размер матрицы
         */
        public static final String VIEW_SIZE_MATRIX = "^size[(]([A-Za-z][A-Za-z0-9]{0,7})[)]";
        /**
         * Вывести элемент матрицы или ее столбец или ее рядок
         */
        public static final String VIEW_MATRIX = "^([A-Za-z][A-Za-z0-9]{0,7})[(][)]";
        /**
         * Вывести элемент матрицы или ее столбец или ее рядок
         */
        public static final String VIEW_EL_MATRIX = "^([A-Za-z][A-Za-z0-9]{0,7})[(][[\\d]{1,}|[\\x3A]][,][[\\d]{1,}|[\\x3A]][)]";
        /**
         * Вывести определитель матрицы
         */
        public static final String VIEW_DET_MATRIX = "^det[(]([A-Za-z][A-Za-z0-9]{0,7})[)]";

        //Специфические паттерны
        /**
         * Поиск ее значений(Любое число)
         */
        public static final String SEARCH_ELEMENTS_MATRIX = "[-]{0,1}[\\d]{0,}[\\056]{0,1}[\\d]{1,}";

        /**
         * Изменение формата вывода
         */
        public static final String FORMAT_MODE = "format";
        /**
         * Перестановка матриц
         */
        public static final String FUNC_SWAP_MATRIX = "^swap[(]([A-Za-z][A-Za-z0-9]{0,7})[\\x2C]([A-Za-z][A-Za-z0-9]{0,7})[)]";
        /**
         *
         */
        public static final String VIEW_COMMENT = "^[/][/]([A-Za-z][A-Za-z0-9]{0,256})";

        public static final String FUNC_SOLVE_KRAMAR = "^solve[(]([A-Za-z][A-Za-z0-9]{0,7})[,]([A-Za-z][A-Za-z0-9]{0,7})[)]";
        
        public static final String CREATE_RANDOM_MATRIX = "^randmatr[(]([a-z]{0,8})[)]";
        /**
         * HashMap представление констант
         */
        public static HashMap<Integer, String> PATTERN_CONST_HASHMAP = new HashMap<Integer, String>();

        public static void initialize() {
            PATTERN_CONST_HASHMAP.put(0, CREATE_MATRIX);
            PATTERN_CONST_HASHMAP.put(1, CREATE_NULL_MATRIX);
            PATTERN_CONST_HASHMAP.put(2, CREATE_ONES_MATRIX);
            PATTERN_CONST_HASHMAP.put(3, CREATE_DIAG_MATRIX);
            PATTERN_CONST_HASHMAP.put(4, CREATE_EYE_MATRIX);
            PATTERN_CONST_HASHMAP.put(5, CREATE_INV_MATRIX);
            PATTERN_CONST_HASHMAP.put(6, CREATE_CLONE_MATRIX);
            PATTERN_CONST_HASHMAP.put(7, FUNC_TRANSPORATION);
            PATTERN_CONST_HASHMAP.put(8, FUNC_SIN_MATRIX);
            PATTERN_CONST_HASHMAP.put(9, FUNC_COS_MATRIX);
            PATTERN_CONST_HASHMAP.put(10, FUNC_TG_MATRIX);
            PATTERN_CONST_HASHMAP.put(11, FUNC_CTG_MATRIX);
            PATTERN_CONST_HASHMAP.put(12, FUNC_EL_PROD_MATRIX);
            PATTERN_CONST_HASHMAP.put(13, FUNC_EL_DIV_MATRIX);
            PATTERN_CONST_HASHMAP.put(14, FUNC_EL_POW_MATRIX);
            PATTERN_CONST_HASHMAP.put(15, FUNC_ADD_MATRIX);
            PATTERN_CONST_HASHMAP.put(16, FUNC_DIFFER_MATRIX);
            PATTERN_CONST_HASHMAP.put(17, FUNC_MULT_MATRIX);
            PATTERN_CONST_HASHMAP.put(18, FUNC_DIV_MATRIX);
            PATTERN_CONST_HASHMAP.put(19, FUNC_POW_MATRIX);
            PATTERN_CONST_HASHMAP.put(20, VIEW_SIZE_MATRIX);
            PATTERN_CONST_HASHMAP.put(21, VIEW_MATRIX);
            PATTERN_CONST_HASHMAP.put(22, VIEW_EL_MATRIX);
            PATTERN_CONST_HASHMAP.put(23, VIEW_DET_MATRIX);
            PATTERN_CONST_HASHMAP.put(24, FORMAT_MODE);
            PATTERN_CONST_HASHMAP.put(25, FUNC_SWAP_MATRIX);
            PATTERN_CONST_HASHMAP.put(26, VIEW_COMMENT);
            PATTERN_CONST_HASHMAP.put(27, FUNC_SOLVE_KRAMAR);
            PATTERN_CONST_HASHMAP.put(28, CREATE_RANDOM_MATRIX);
        }
    }

    public static String readCommand(Sintacsis sintacsis) {
        String stringReturn = null;

        Matcher matcher;

        int cout = 0;
        Integer IndexOfExeptPattern = -1;
        while (cout < PatternConst.PATTERN_CONST_HASHMAP.size()) {
            if (createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(cout)).find()) {
                IndexOfExeptPattern = cout;
            }
            cout++;
        }

        homeMatrixLabController hController = new homeMatrixLabController();

        switch (IndexOfExeptPattern) {
            case -1:
                stringReturn = formatStringForReturn(sintacsis.getString(), ErrorFunc.returnError(ErrorFunc.ErrorType.WRONG_FUNC));
                break;
            case 0:
                //Создание матрицы
                stringReturn = formatStringForReturn(sintacsis.getString(), CreateMatrix(createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern))));
                break;
            case 1:
                //Создание нулевой матрицы
                
                break;
            case 2:
                //Создание единичной матрицы
                stringReturn = formatStringForReturn(sintacsis.getString(), CreateOnesMatrix(createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern))));
                break;
            case 3:
                //Создание диагональной матрицы
                break;
            case 4:
                break;
            case 5:
                //обратная матрица
                stringReturn = formatStringForReturn(sintacsis.getString(), printInvMatrix(createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern))));
                break;
            case 6:
                //Клон матрицы
                stringReturn = formatStringForReturn(sintacsis.getString(), createCloneMatrix(createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern))));
                break;
            case 7:
                //Транспониррование матрицы
                stringReturn = formatStringForReturn(sintacsis.getString(), printTransporationMatrix(createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern))));
                break;
            case 8:
                //Синус каждого элемента
                stringReturn = formatStringForReturn(sintacsis.getString(), sinMatrix(createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern))));
                break;
            case 9:
                //Косинус каждого элемента
                stringReturn = formatStringForReturn(sintacsis.getString(), cosMatrix(createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern))));
                break;
            case 10:
                //Тангенс каждого элемента
                stringReturn = formatStringForReturn(sintacsis.getString(), tgMatrix(createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern))));
                break;
            case 11:
                //Котангенс каждого элемента
                stringReturn = formatStringForReturn(sintacsis.getString(), ctgMatrix(createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern))));
                break;
            case 12:
                //Поелементное умножение матриц
                break;
            case 13:
                //Поелементное деление матриц
                break;
            case 14:
                //Поелементное возведение в степень
                stringReturn = formatStringForReturn(sintacsis.getString(), viewPowElMatrix(createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern))));
                break;
            case 15:
                //Cумма матриц
                stringReturn = formatStringForReturn(sintacsis.getString(), viewAddMatrix(createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern))));
                break;
            case 16:
                //Разница матриц
                stringReturn = formatStringForReturn(sintacsis.getString(), viewDifferMatrix(createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern))));
                break;
            case 17:
                //Умножение матриц
                stringReturn = formatStringForReturn(sintacsis.getString(), viewMultMatrix(createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern))));
                break;
            case 18:
                //Деление матриц
                stringReturn = formatStringForReturn(sintacsis.getString(), viewDivMatrix(createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern))));
                break;
            case 19:
                //Возведение в степень матрицы
                stringReturn = formatStringForReturn(sintacsis.getString(), viewPowMatrix(createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern))));
                break;
            case 20:
                //Вывод размерности матрицы
                break;
            case 21:
                //Вывод матрицы
                stringReturn = formatStringForReturn(sintacsis.getString(), viewMatrix(createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern))));
                break;
            case 22:
                //Вывод элемента матрицы
                break;
            case 23:
                //Определитель
                stringReturn = formatStringForReturn(sintacsis.getString(), viewDetMatrix(createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern))));
                break;
            case 24:
                //Формат вывода
                MtF.formatMode();
                String mode;
                if (MtF.Matrix.format) {
                    mode = "on";
                } else {
                    mode = "off";
                }
                stringReturn = formatStringForReturn(sintacsis.getString(), ">> Format:" + mode);
                break;
            case 25:
                // Перестановка матриц
                stringReturn = formatStringForReturn(sintacsis.getString(), swapMatrix(createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern))));
                break;
            case 26:
                // Комментарий
                stringReturn = sintacsis.getString() + "\n";
                break;
            case 27:
                //Слау методом крамара
                stringReturn = formatStringForReturn(sintacsis.getString(), funcSolveKramar(createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern))));
                break;
            case 28:
                //Рандомизированая матрица с параметрами
                stringReturn = formatStringForReturn(sintacsis.getString(), CreateRandomMatrix(createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern))));
                break;
            default:
                break;
        }

        return stringReturn;
    }

    /**
     * Создает матрицу и добавляет ее в HashMap
     *
     * @param matcher - для создания матрицы
     * @return Матрицу в виде строки
     */
    public static String CreateMatrix(Matcher matcher) {//0
        MtF.Matrix Matrix = null;

        try {
            if (matcher.find() && !homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.containsKey(matcher.group(1))) {
                Matrix = new MtF.Matrix(matcher.group(1), matcher.group(2));

                homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.put(matcher.group(1), Matrix);
                homeMatrixLabController.PublicVar.listOfHistory.add(matcher.group(1));
            } else {
                homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.remove(matcher.group(1));
                homeMatrixLabController.PublicVar.listOfHistory.remove(matcher.group(1));

                Matrix = new MtF.Matrix(matcher.group(1), matcher.group(2));

                homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.put(matcher.group(1), Matrix);
                homeMatrixLabController.PublicVar.listOfHistory.add(matcher.group(1));
            }
        } catch (Exception e) {
            System.out.println("Неизвестная ошибка \n");
        }
        return Matrix.toString(homeMatrixLabController.PublicVar.countOfDigits);
    }
    
    public static String CreateOnesMatrix(Matcher matcher) {//
        String res = null;
        try {
            if (matcher.find()) {
                MtF.Matrix matr = MtF.onesMatrix(3, 3);
                res = matr.toString(homeMatrixLabController.PublicVar.countOfDigits);
                ToAnswer(matr);
            }
        } catch (Exception e) {
            res = "Неизвестная ошибка \n";
        }
        return res;
    }
    
    public static String printInvMatrix(Matcher matcher) {//5
        String res = null;
        try {
            if (matcher.find()) {
                MtF.Matrix matr = MtF.InversMatrix(homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(1)));
                res = matr.toString(homeMatrixLabController.PublicVar.countOfDigits);
                ToAnswer(matr);
            }
        } catch (Exception e) {
            res = "Неизвестная ошибка \n";
        }
        return res;
    }

    /**
     * Создает или заменяет матрицу на ту что указана после =
     *
     * @param matcher
     * @return
     */
    public static String createCloneMatrix(Matcher matcher) {//6
        MtF.Matrix Matrix = null;

        try {
            if (matcher.find() && !homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.containsKey(matcher.group(1))) {
                Matrix = new MtF.Matrix(matcher.group(1), homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(2)));

                homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.put(matcher.group(1), Matrix);
                homeMatrixLabController.PublicVar.listOfHistory.add(matcher.group(1));
            } else {
                homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.remove(matcher.group(1));
                homeMatrixLabController.PublicVar.listOfHistory.remove(matcher.group(1));

                Matrix = new MtF.Matrix(matcher.group(1), homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(2)));

                homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.put(matcher.group(1), Matrix);
                homeMatrixLabController.PublicVar.listOfHistory.add(matcher.group(1));
            }
        } catch (Exception e) {
            System.out.println("Неизвестная ошибка \n");
        }

        return Matrix.toString(homeMatrixLabController.PublicVar.countOfDigits);
    }

    public static String sinMatrix(Matcher matcher) {//8
        String res = null;
        try {
            if (matcher.find()) {
                MtF.Matrix matr = MtF.sinMatrix(homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(1)));
                res = matr.toString(homeMatrixLabController.PublicVar.countOfDigits);

                ToAnswer(matr);
            }
        } catch (Exception e) {
            res = "Неизвестная ошибка\n";
        }
        return res;
    }

    public static String cosMatrix(Matcher matcher) {//9
        String res = null;
        try {
            if (matcher.find()) {
                MtF.Matrix matr = MtF.cosMatrix(homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(1)));
                res = matr.toString(homeMatrixLabController.PublicVar.countOfDigits);

                ToAnswer(matr);
            }
        } catch (Exception e) {
            res = "Неизвестная ошибка\n";
        }
        return res;
    }

    public static String tgMatrix(Matcher matcher) {//10
        String res = null;
        try {
            if (matcher.find()) {
                MtF.Matrix matr = MtF.tgMatrix(homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(1)));
                res = matr.toString(homeMatrixLabController.PublicVar.countOfDigits);

                ToAnswer(matr);
            }
        } catch (Exception e) {
            res = "Неизвестная ошибка\n";
        }
        return res;
    }

    public static String ctgMatrix(Matcher matcher) {//11
        String res = null;
        try {
            if (matcher.find()) {
                MtF.Matrix matr = MtF.ctgMatrix(homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(1)));
                res = matr.toString(homeMatrixLabController.PublicVar.countOfDigits);

                ToAnswer(matr);
            }
        } catch (Exception e) {
            res = "Неизвестная ошибка\n";
        }
        return res;
    }

    public static String viewPowElMatrix(Matcher matcher) { //19
        String res = null;
        try {
            if (matcher.find()) {
                MtF.Matrix matr = MtF.PowElMatrix(homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(1)), Integer.valueOf(matcher.group(2)));

                res = matr.toString(homeMatrixLabController.PublicVar.countOfDigits);

                ToAnswer(matr);
            }
        } catch (Exception e) {
            res = "Неизвестная ошибка \n";
        }
        return res;
    }

    public static String printTransporationMatrix(Matcher matcher) {
        String res = null;
        try {
            if (matcher.find()) {
                MtF.Matrix matr = MtF.TranspMatrix(homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(1)));
                res = matr.toString(homeMatrixLabController.PublicVar.countOfDigits);
                ToAnswer(matr);
            }
        } catch (Exception e) {
            res = "Неизвестная ошибка \n";
        }
        return res;
    }

    public static String viewAddMatrix(Matcher matcher) { //15
        String res = null;
        try {
            if (matcher.find()) {
                MtF.Matrix matr = MtF.SumMatrix(homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(1)),
                        homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(2)));

                res = matr.toString(homeMatrixLabController.PublicVar.countOfDigits);

                ToAnswer(matr);
            }
        } catch (Exception e) {
            res = "Неизвестная ошибка \n";
        }
        return res;
    }

    public static String viewDifferMatrix(Matcher matcher) { //16
        String res = null;
        try {
            if (matcher.find()) {
                MtF.Matrix matr = MtF.DifferMatrix(homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(1)),
                        homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(2)));
                res = matr.toString(homeMatrixLabController.PublicVar.countOfDigits);
                ToAnswer(matr);
            }
        } catch (Exception e) {
            res = "Неизвестная ошибка \n";
        }
        return res;
    }

    public static String viewMultMatrix(Matcher matcher) { //17
        String res = null;
        try {
            if (matcher.find()) {
                MtF.Matrix matr = MtF.MultMatrix(homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(1)), homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(2)));

                res = matr.toString(homeMatrixLabController.PublicVar.countOfDigits);

                ToAnswer(matr);
            }
        } catch (Exception e) {
            res = "Неизвестная ошибка \n";
        }
        return res;
    }

    public static String viewDivMatrix(Matcher matcher) { //18
        String res = null;
        try {
            if (matcher.find()) {
                MtF.Matrix matr = MtF.DivMatrix(homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(1)), homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(2)));

                res = matr.toString(homeMatrixLabController.PublicVar.countOfDigits);

                ToAnswer(matr);
            }
        } catch (Exception e) {
            res = "Неизвестная ошибка \n";
        }

        return res;
    }

    public static String viewPowMatrix(Matcher matcher) { //19
        String res = null;
        try {
            if (matcher.find()) {
                MtF.Matrix matr = MtF.PowMatrix(homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(1)), Integer.valueOf(matcher.group(2)));
                res = matr.toString(homeMatrixLabController.PublicVar.countOfDigits);
                ToAnswer(matr);
            }
        } catch (NumberFormatException e) {
            res = "Неизвестная ошибка \n";
        }
        return res;
    }

    public static String aaaa(Matcher matcher) { //20
        String res = null;
        return res;
    }

    /**
     * Выводит выбранную матрицу
     *
     * @param matcher
     * @return
     */
    public static String viewMatrix(Matcher matcher) {//21
        MtF.Matrix Matrix = null;

        try {
            if (matcher.find()) {
                Matrix = homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(1));
            }
        } catch (Exception e) {
            return "Неизвестная ошибка";

        }
        return Matrix.toString(homeMatrixLabController.PublicVar.countOfDigits);
    }

    public static String aaa(Matcher matcher) { //22
        String res = null;
        return res;
    }

    /**
     * Выводит определитель матрицы
     *
     * @param matcher
     * @return
     */
    public static String viewDetMatrix(Matcher matcher) {//23

        String returnNum = "";

        try {
            if (matcher.find()) {
                MtF.Matrix buff = homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(1));
                if (buff.getN() == buff.getM()) {
                    returnNum = MtF.DetGauss(buff).toString(homeMatrixLabController.PublicVar.countOfDigits);
                    ToAnswer(buff);
                } else {
                    returnNum = "Матрица не квадратная \n";
                }
            }
        } catch (Exception e) {
            returnNum = ("Неизвестная ошибка \n");
        }

        return returnNum;
    }

    //Смена матриц местами
    public static String swapMatrix(Matcher matcher) {//25
        String res = null;
        try {
            if (matcher.find()) {
                res = "swap " + matcher.group(1) + " <-> " + matcher.group(2);
                //Здесь нужно сделать смену ключей в хешмепе
            }
        } catch (Exception e) {
            res = "Неизвестная ошибка \n";
        }
        return res;
    }

    public static String funcSolveKramar(Matcher matcher) {//27
        String res = null;
        try {
            if (matcher.find()) {
                MtF.Matrix matr = MtF.equationKramar(homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(1)), homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(2)));
                res = matr.toString(homeMatrixLabController.PublicVar.countOfDigits);
                ToAnswer(matr);
            }
        } catch (Exception e) {
            res = "Неизвестная ошибка \n";
        }
        return res;
    }
    
    public static String CreateRandomMatrix(Matcher matcher) {//27
        String res = null;
        try {
            if (matcher.find()) {
                MtF.Matrix matr;
                matr = MtF.randomMatrix(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Float.parseFloat(matcher.group(3)), matcher.group(4));
                res = matr.toString(homeMatrixLabController.PublicVar.countOfDigits);
                ToAnswer(matr);
            }
        } catch (NumberFormatException e) {
            res = "Неизвестная ошибка \n";
        }
        return res;
    }

    public static void ToAnswer(MtF.Matrix matr) {
        if (homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.containsKey("Ans")) {
            homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.remove("Ans");
            homeMatrixLabController.PublicVar.listOfHistory.remove("Ans");
            homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.put("Ans", matr);
            homeMatrixLabController.PublicVar.listOfHistory.add("Ans");
        } else {
            homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.put("Ans", matr);
            homeMatrixLabController.PublicVar.listOfHistory.add("Ans");
        }
    }
}
