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
         * Создание инвертированной матрицы
         */
        public static final String CREATE_INV_MATRIX = "^inv[(]([A-Za-z][A-Za-z0-9]{0,7})[)]";
        /**
         * Создание клонированной матрицы
         */
        public static final String CREATE_CLONE_MATRIX = "^[\\s]{0,}([A-Za-z][A-Za-z0-9]{0,7})[\\s]{0,}[=][\\s]{0,}([A-Za-z][A-Za-z0-9]{0,7})";
        /**
         * Поиск функции транспорации
         */
        public static final String FUNC_TRANSPORATION = "([A-Za-z][A-Za-z0-9]{0,7})[\\x39]";
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
        public static final String FUNC_EL_SQR_MATRIX = "([A-Za-z][A-Za-z0-9]{0,7})[\\x2E][\\x5E]([A-Za-z][A-Za-z0-9]{0,7})";
        /**
         * Поэлементное добавление
         */
        public static final String FUNC_ADD_MATRIX = "([A-Za-z][A-Za-z0-9]{0,7})[\\x2B]([A-Za-z][A-Za-z0-9]{0,7})";
        /**
         * Поэлементное отнимание
         */
        public static final String FUNC_MIN_MATRIX = "([A-Za-z][A-Za-z0-9]{0,7})[\\x2D]([A-Za-z][A-Za-z0-9]{0,7})";
        /**
         * Поэлементное умножение
         */
        public static final String FUNC_MULT_MATRIX = "([A-Za-z][A-Za-z0-9]{0,7})[\\x2A]([A-Za-z][A-Za-z0-9]{0,7})";
        /**
         * Поэлементное деление
         */
        public static final String FUNC_DIV_MATRIX = "([A-Za-z][A-Za-z0-9]{0,7})[\\x2F]([A-Za-z][A-Za-z0-9]{0,7})";
        /**
         * Поэлементное возведение в степень
         */
        public static final String FUNC_SQR_MATRIX = "([A-Za-z][A-Za-z0-9]{0,7})[\\x5E]([A-Za-z][A-Za-z0-9]{0,7})";
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
        public static final String VIEW_El_MATRIX = "^([A-Za-z][A-Za-z0-9]{0,7})[(][[\\d]{1,}|[\\x3A]][,][[\\d]{1,}|[\\x3A]][)]";
        /**
         * Вывести определитель матрицы
         */
        public static final String VIEW_DET_MATRIX = "^det[(]([A-Za-z][A-Za-z0-9]{0,7})[)]";     
        
        //Специфические паттерны
        /**
         * Поиск ее значений(Любое число)
         */
        public static final String SEARCH_ELEMENTS_MATRIX = "[-]{0,1}[\\d]{0,}[\\056]{0,1}[\\d]{1,}";

        
        public static final String FORMAT_MODE = "format";
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
            PATTERN_CONST_HASHMAP.put(14, FUNC_EL_SQR_MATRIX);
            PATTERN_CONST_HASHMAP.put(15, FUNC_ADD_MATRIX);
            PATTERN_CONST_HASHMAP.put(16, FUNC_MIN_MATRIX);
            PATTERN_CONST_HASHMAP.put(17, FUNC_MULT_MATRIX);
            PATTERN_CONST_HASHMAP.put(18, FUNC_DIV_MATRIX);
            PATTERN_CONST_HASHMAP.put(19, FUNC_SQR_MATRIX);
            PATTERN_CONST_HASHMAP.put(20, VIEW_SIZE_MATRIX);
            PATTERN_CONST_HASHMAP.put(21, VIEW_MATRIX);
            PATTERN_CONST_HASHMAP.put(22, VIEW_El_MATRIX);
            PATTERN_CONST_HASHMAP.put(23, VIEW_DET_MATRIX);
            PATTERN_CONST_HASHMAP.put(24, FORMAT_MODE);
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
        
        if (IndexOfExeptPattern == -1) {
            
            stringReturn = formatStringForReturn(sintacsis.getString(), ErrorFunc.returnError(ErrorFunc.ErrorType.WRONG_FUNC));
            
        }else if (IndexOfExeptPattern == 0) {//Создание матрицы
            
            stringReturn = formatStringForReturn(sintacsis.getString(), CreateMatrix(createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern))));
            
        }else if (IndexOfExeptPattern == 1) {
         
            
        
        }else if (IndexOfExeptPattern == 2) {
         
            
        
        }else if (IndexOfExeptPattern == 3) {
         
        
        }else if (IndexOfExeptPattern == 4) {
         
        
        }else if (IndexOfExeptPattern == 5) {
         
        
        }else if (IndexOfExeptPattern == 6) {
         
            stringReturn = formatStringForReturn(sintacsis.getString(), createCloneMatrix(createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern))));
        
        }else if (IndexOfExeptPattern == 7) {
            stringReturn = formatStringForReturn(sintacsis.getString(), printTransporationMatrix(createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern))));
            
            
        }else if (IndexOfExeptPattern == 8) {
         
        
        }else if (IndexOfExeptPattern == 9) {
         
        
        }else if (IndexOfExeptPattern == 10) {
         
        
        }else if (IndexOfExeptPattern == 11) {
         
        
        }else if (IndexOfExeptPattern == 12) {
         
        
        }else if (IndexOfExeptPattern == 13) {
         
        
        }else if (IndexOfExeptPattern == 14) {
            
        
        }else if (IndexOfExeptPattern == 15) {
         
        
        }else if (IndexOfExeptPattern == 16) {
         
        
        }else if (IndexOfExeptPattern == 17) {
            stringReturn = formatStringForReturn(sintacsis.getString(), viewMultMatrix(createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern))));
        
        }else if (IndexOfExeptPattern == 18) {
         
        
        }else if (IndexOfExeptPattern == 19) {
         
        
        }else if (IndexOfExeptPattern == 20) {
         
        
        }else if (IndexOfExeptPattern == 21) {//Вывод матрицы
         
            stringReturn = formatStringForReturn(sintacsis.getString(), viewMatrix(createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern))));
        
        }else if (IndexOfExeptPattern == 22) {
            
            
            
        }else if (IndexOfExeptPattern == 23) {//Определитель
            
            stringReturn = formatStringForReturn(sintacsis.getString(), viewDetMatrix(createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern))));

        }else if (IndexOfExeptPattern == 24) {//Формат вывода
            String mode;
            if (MtF.Matrix.format)
                mode = "on";
            else
                mode = "off";
            stringReturn = formatStringForReturn(sintacsis.getString(), ">> Format:" + mode);
            MtF.formatMode();

        }

        
        return stringReturn;
    }

    /**
     * Создает матрицу и добавляет ее в HashMap 
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
            }else{
                homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.remove(matcher.group(1));
                homeMatrixLabController.PublicVar.listOfHistory.remove(matcher.group(1));
                
                Matrix = new MtF.Matrix(matcher.group(1), matcher.group(2));

                homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.put(matcher.group(1), Matrix);
                homeMatrixLabController.PublicVar.listOfHistory.add(matcher.group(1));
            }
        }
        catch (Exception e) {
            System.out.println("Неизвестная ошибка");
        }
        return Matrix.toString(homeMatrixLabController.PublicVar.countOfDigits);
    }
    
    /**
     * Создает или заменяет матрицу на ту что указана после = 
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
            }else{
                homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.remove(matcher.group(1));
                homeMatrixLabController.PublicVar.listOfHistory.remove(matcher.group(1));
                
                Matrix = new MtF.Matrix(matcher.group(1), homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(2)));

                homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.put(matcher.group(1), Matrix);
                homeMatrixLabController.PublicVar.listOfHistory.add(matcher.group(1));
            }
        }
        catch (Exception e) {
            System.out.println("Неизвестная ошибка");
        }
        
        return Matrix.toString(homeMatrixLabController.PublicVar.countOfDigits);
    }
    
    public static String printTransporationMatrix(Matcher matcher) {
        return MtF.TranspMatrix(homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(1))).toString(homeMatrixLabController.PublicVar.countOfDigits);
    }
    
    public static String viewMultMatrix (Matcher matcher) {        
        MtF.Matrix Matrix = MtF.MultMatrix(homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(1)),
                homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(2)));
        
        if (Matrix.getIdError() == null && homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.containsKey("Ans")) {
            homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.remove("Ans");
            homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.put("Ans", Matrix);
            return Matrix.toString(homeMatrixLabController.PublicVar.countOfDigits);
        }else if (Matrix.getIdError() == null){
            homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.put("Ans", Matrix);
            return "Ans = " + Matrix.toString(homeMatrixLabController.PublicVar.countOfDigits);
        }else{    
            return Matrix.getIdError();
        }
        
    }
    
    
    /**
     * Выводит выбранную матрицу
     * @param matcher
     * @return
     */
    public static String viewMatrix(Matcher matcher){//21
        MtF.Matrix Matrix = null;
        
        try {
            if (matcher.find()) {
                Matrix = homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(1));
            }
        }
        catch (Exception e) {
            System.out.println("Неизвестная ошибка");
        }
        
        return Matrix.toString(homeMatrixLabController.PublicVar.countOfDigits);
    }
    
    /**
     * Выводит определитель матрицы
     * @param matcher
     * @return
     */
    public static String viewDetMatrix(Matcher matcher){//23
        
        String returnNum = "";
        
        try {
            if (matcher.find()) {
                MtF.Matrix buff = homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(1));
                if (buff.getN() == buff.getM()) {
                    returnNum = "Ans = " + String.valueOf(MtF.DetGauss(buff));
                } else {
                    returnNum = ">> Матрица не квадратная";
                }
            }
        }
        catch (Exception e) {
            returnNum = (">> Неизвестная ошибка");
        }          
        
        return returnNum;
    }
    
    public static Matcher createMatcher(String commandOnString, String patternOnString) {
        Pattern pattern = Pattern.compile(patternOnString);
        Matcher matcher = pattern.matcher(commandOnString);

        return matcher;
    }
    
    public static String formatStringForReturn(String commandOnString,String result){
        String res = null;
        
        res = ">> " + commandOnString + "\n" +  result + "\n";
        
        return res;
    }
}