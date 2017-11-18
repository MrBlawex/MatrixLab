package javafxmatrixlab;

import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javafxmatrixlab.MtF;
import javafxmatrixlab.controller.createMatrixController;
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
        public static final String CREATE_MATRIX = "^[\\s]{0,}([A-Za-z][A-Za-z0-9]{0,2})[\\s]{0,}[=][\\s]{0,}[\\x5B]([[[-]{0,1}[\\d]{0,}[\\056]{0,1}[\\d]{1,}[,]]{0,}[-]{0,1}[\\d]{0,}[\\056]{0,1}[\\d]{1,}[;]]{0,}[[-]{0,1}[\\d]{0,}[\\056]{0,1}[\\d]{1,}[,]]{0,}[-]{0,1}[\\d]{0,}[\\056]{0,1}[\\d]{1,})[\\x5D]";
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
        public static final String CREATE_DIAG_MATRIX = "^diag[(]([A-Za-z][A-Za-z0-9]{0,2})[)]";
        /**
         * Создание единичной матрицы
         */
        public static final String CREATE_EYE_MATRIX = "^eye[(]([\\d]{1,})[)]";
        /**
         * Создание инвертированной матрицы
         */
        public static final String CREATE_INV_MATRIX = "^inv[(]([A-Za-z][A-Za-z0-9]{0,2})[)]";
        /**
         * Создание клонированной матрицы
         */
        public static final String CREATE_CLONE_MATRIX = "^([A-Za-z][A-Za-z0-9]{0,2})[\\s]{0,}[=][\\s]{0,}([A-Za-z][A-Za-z0-9]{0,2})";
        /**
         * Поиск функции транспорации
         */
        public static final String FUNC_TRANSPORATION = "[A-Za-z][A-Za-z0-9]{0,2}[\\x27]";
        /**
         * Синус от каждого элемента
         */
        public static final String FUNC_SIN_MATRIX = "^sin[(]([A-Za-z][A-Za-z0-9]{0,2})[)]";
        /**
         * Косинус от каждого элемента
         */
        public static final String FUNC_COS_MATRIX = "^cos[(]([A-Za-z][A-Za-z0-9]{0,2})[)]";
        /**
         * Тангенс от каждого элемента
         */
        public static final String FUNC_TG_MATRIX = "^tg[(]([A-Za-z][A-Za-z0-9]{0,2})[)]";
        /**
         * Котангенс от каждого элемента
         */
        public static final String FUNC_CTG_MATRIX = "^ctg[(]([A-Za-z][A-Za-z0-9]{0,2})[)]";
        /**
         * Поэлементное умножение матриц
         */
        public static final String FUNC_EL_PROD_MATRIX = "([A-Za-z][A-Za-z0-9]{0,2})[\\x2E][\\x2A]([A-Za-z][A-Za-z0-9]{0,2})";
        /**
         * Поэлементное деление матриц
         */
        public static final String FUNC_EL_DIV_MATRIX = "([A-Za-z][A-Za-z0-9]{0,2})[\\x2E][\\x2F]([A-Za-z][A-Za-z0-9]{0,2})";
        /**
         * Поэлементное возведение в степень
         */
        public static final String FUNC_EL_SQR_MATRIX = "([A-Za-z][A-Za-z0-9]{0,2})[\\x2E][\\x5E]([A-Za-z][A-Za-z0-9]{0,2})";
        /**
         * Поэлементное добавление
         */
        public static final String FUNC_ADD_MATRIX = "([A-Za-z][A-Za-z0-9]{0,2})[\\x2B]([A-Za-z][A-Za-z0-9]{0,2})";
        /**
         * Поэлементное отнимание
         */
        public static final String FUNC_MIN_MATRIX = "([A-Za-z][A-Za-z0-9]{0,2})[\\x2D]([A-Za-z][A-Za-z0-9]{0,2})";
        /**
         * Поэлементное умножение
         */
        public static final String FUNC_MULT_MATRIX = "([A-Za-z][A-Za-z0-9]{0,2})[\\x2A]([A-Za-z][A-Za-z0-9]{0,2})";
        /**
         * Поэлементное деление
         */
        public static final String FUNC_DIV_MATRIX = "([A-Za-z][A-Za-z0-9]{0,2})[\\x2F]([A-Za-z][A-Za-z0-9]{0,2})";
        /**
         * Поэлементное возведение в степень
         */
        public static final String FUNC_SQR_MATRIX = "([A-Za-z][A-Za-z0-9]{0,2})[\\x5E]([A-Za-z][A-Za-z0-9]{0,2})";
        /**
         * Вывести размер матрицы
         */
        public static final String VIEW_SIZE_MATRIX = "^size[(]([A-Za-z][A-Za-z0-9]{0,2})[)]";
        /**
         * Вывести элемент матрицы или ее столбец или ее рядок
         */
        public static final String VIEW_El_MATRIX = "^([A-Za-z][A-Za-z0-9]{0,2})[(][[\\d]{1,}|[\\x3A]][,][[\\d]{1,}|[\\x3A]][)]";
        /**
         * Вывести определитель матрицы
         */
        public static final String VIEW_DET_MATRIX = "^det[(]([A-Za-z][A-Za-z0-9]{0,2})[)]";     
        
        //Спецефические паттерны
        /**
         * Поиск ее значений(Любое число)
         */
        public static final String SEARCH_ELEMENTS_MATRIX = "[-]{0,1}[\\d]{0,}[\\056]{0,1}[\\d]{1,}";

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
            PATTERN_CONST_HASHMAP.put(21, VIEW_El_MATRIX);
            PATTERN_CONST_HASHMAP.put(22, VIEW_DET_MATRIX);
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
//                System.out.println(cout + " -> " + PatternConst.PATTERN_CONST_HASHMAP.get(cout));
                matcher = createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(cout));
                if (matcher.find()) {
                    boolean fl = true;
                    int i = 0;
                    while (fl) {
                        try {
                            System.out.println("Найдено значение: " + matcher.group(i));
                        }
                        catch (Exception e) {
                            fl = false;
                        }
                        i++;
                    }
                }
            }
            cout++;
        }
        
        homeMatrixLabController hController = new homeMatrixLabController();
        
        if (IndexOfExeptPattern == -1) {
            
            stringReturn = formatStringForReturn(sintacsis.getString(), ErrorFunc.returnError(ErrorFunc.ErrorType.WRONG_FUNC));
            
        }else if (IndexOfExeptPattern == 0) {//Создание матрицы
            
            String nameMatrix = "";
            MtF.Matrix Matrix = null;
              
            matcher = createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern));//Готовый матчер с паттерном
            try {
                if (matcher.find()) {
                    Matrix = new MtF.Matrix(matcher.group(1), matcher.group(2));
                    nameMatrix = matcher.group(1);
                }
            }
            catch (Exception e) {
                System.out.println("Неизвестная ошибка");
            }

            homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.put(nameMatrix, Matrix);
            homeMatrixLabController.PublicVar.listOfHistory.add(nameMatrix);
            
//            hController.refreshHistoryOfMatrix();
            
            stringReturn = formatStringForReturn(sintacsis.getString(),Matrix.toString(2));
            
        }else if (IndexOfExeptPattern == 1) {
         
            
        
        }else if (IndexOfExeptPattern == 2) {
         
            
        
        }else if (IndexOfExeptPattern == 3) {
         
        
        }else if (IndexOfExeptPattern == 4) {
         
        
        }else if (IndexOfExeptPattern == 5) {
         
        
        }else if (IndexOfExeptPattern == 6) {
         
        
        }else if (IndexOfExeptPattern == 7) {
         
        
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
         
        
        }else if (IndexOfExeptPattern == 18) {
         
        
        }else if (IndexOfExeptPattern == 19) {
         
        
        }else if (IndexOfExeptPattern == 20) {
         
        
        }else if (IndexOfExeptPattern == 21) {
         
        
        }else if (IndexOfExeptPattern == 22) {
            Float returnNum = 0f;
            
            matcher = createMatcher(sintacsis.getString(), PatternConst.PATTERN_CONST_HASHMAP.get(IndexOfExeptPattern));//Готовый матчер с паттерном
            
            try {
                if (matcher.find()) {
                    returnNum = MtF.DetGauss(homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.get(matcher.group(1)));
                }
            }
            catch (Exception e) {
                System.out.println("Неизвестная ошибка");
            }
            
            stringReturn = formatStringForReturn(sintacsis.getString(),"Ans = " + String.valueOf(returnNum));
        }
        
        return stringReturn;
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