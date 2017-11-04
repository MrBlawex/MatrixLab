package javafxmatrixlab;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javafxmatrixlab.MtF;

public class SintacsisFunc{
    public static class Sintacsis{
        protected String stringFunc;
        protected int size;

        public Sintacsis(String string){
            this.stringFunc = string;
            this.size = string.length();
        }
        
        public String getString(){
            return this.stringFunc;
        }
        
        public int getSize(){
            return this.size;
        }
    }
    
    public static class PatternConst{
        /**
         *Создание матрицы в строке
         */
        public static final String CREATE_MATRIX = "[\\s]{0,}([A-Za-z][A-Za-z0-9]{0,2})[\\s]{0,}[=][\\s]{0,}[\\x5B]([[[\\d]{0,}[\\056]{0,1}[\\d]{1,}[,]]{0,}[\\d]{0,}[\\056]{0,1}[\\d]{1,}[;]]{0,}[[\\d]{0,}[\\056]{0,1}[\\d]{1,}[,]]{0,}[\\d]{0,}[\\056]{0,1}[\\d]{1,})[\\x5D]";
        /**
         *Создание нулевой матрицы
         */ 
        public static final String CREATE_NULL_MATRIX = "zeros[(]([\\d]{1,}[,][\\d]{1,})[)]";
        /**
         *Создание единичной матрицы
         */
        public static final String CREATE_ONES_MATRIX = "ones[(]([\\d]{1,}[,][\\d]{1,})[)]";
        /**
         *Создание матрицы с нулями кроме диагонали
         */
        public static final String CREATE_DIAG_MATRIX = "diag[(]([A-Za-z][A-Za-z0-9]{0,2})[)]";
        /**
         *Создание единичной матрицы
         */
        public static final String CREATE_EYE_MATRIX = "eye[(]([\\d]{1,})[)]";
        /**
         *Создание инвертированной матрицы 
         */
        public static final String CREATE_INV_MATRIX = "inv[(]([A-Za-z][A-Za-z0-9]{0,2})[)]";
        /**
         *Поиск функции транспорации
         */
        public static final String FUNC_TRANSPORATION = "[A-Za-z][A-Za-z0-9]{0,2}[\\x27]";
        /**
         *Синус от каждого элемента
         */
        public static final String FUNC_SIN_MATRIX = "sin[(]([A-Za-z][A-Za-z0-9]{0,2})[)]";
        /**
         *Косинус от каждого элемента
         */
        public static final String FUNC_COS_MATRIX = "cos[(]([A-Za-z][A-Za-z0-9]{0,2})[)]";
        /**
         *Тангенс от каждого элемента
         */
        public static final String FUNC_TG_MATRIX = "tg[(]([A-Za-z][A-Za-z0-9]{0,2})[)]";
        /**
         *Катангенс от каждого элемента
         */
        public static final String FUNC_CTG_MATRIX = "ctg[(]([A-Za-z][A-Za-z0-9]{0,2})[)]";
        /**
         *Поэлементное умножение матриц
         */
        public static final String FUNC_EL_PROD_MATRIX = "([A-Za-z][A-Za-z0-9]{0,2})[\\x2E][\\x2A]([A-Za-z][A-Za-z0-9]{0,2})";
        /**
         *Поэлементное деление матриц
         */
        public static final String FUNC_EL_DIV_MATRIX = "([A-Za-z][A-Za-z0-9]{0,2})[\\x2E][\\x2F]([A-Za-z][A-Za-z0-9]{0,2})";
        /**
         *Поэлементное возведение в степень
         */
        public static final String FUNC_EL_SQR_MATRIX = "([A-Za-z][A-Za-z0-9]{0,2})[\\x2E][\\x5E]([A-Za-z][A-Za-z0-9]{0,2})";
        /**
         *Поэлементное добавление
         */
        public static final String FUNC_ADD_MATRIX = "([A-Za-z][A-Za-z0-9]{0,2})[\\x2B]([A-Za-z][A-Za-z0-9]{0,2})";
        /**
         *Поэлементное отнимание
         */
        public static final String FUNC_MIN_MATRIX = "([A-Za-z][A-Za-z0-9]{0,2})[\\x2D]([A-Za-z][A-Za-z0-9]{0,2})";
        /**
         *Поэлементное умножение
         */
        public static final String FUNC_MULT_MATRIX = "([A-Za-z][A-Za-z0-9]{0,2})[\\x2A]([A-Za-z][A-Za-z0-9]{0,2})";
        /**
         *Поэлементное деление
         */
        public static final String FUNC_DIV_MATRIX = "([A-Za-z][A-Za-z0-9]{0,2})[\\x2F]([A-Za-z][A-Za-z0-9]{0,2})";
        /**
         *Поэлементное возведение в степень
         */
        public static final String FUNC_SQR_MATRIX = "([A-Za-z][A-Za-z0-9]{0,2})[\\x5E]([A-Za-z][A-Za-z0-9]{0,2})";
        /**
         *Вывести размер матрицы
         */
        public static final String VIEW_SIZE_MATRIX = "size[(]([A-Za-z][A-Za-z0-9]{0,2})[)]";
        /**
         *Вывести элемент матрицы или ее столбец или ее рядок
         */
        public static final String VIEW_El_MATRIX = "([A-Za-z][A-Za-z0-9]{0,2})[(][[\\d]{1,}|[\\x3A]][,][[\\d]{1,}|[\\x3A]][)]";
        /**
         *Вывести определитель матрицы
         */
        public static final String VIEW_DET_MATRIX = "det[(]([A-Za-z][A-Za-z0-9]{0,2})[)]";
        /**
         *Поиск ее значений(Любое число)
         */
        public static final String SEARCH_ELEMENTS_MATRIX = "[\\d]{0,}[\\056]{0,1}[\\d]{1,}";
        
    }
    
    public static String readCommand(Sintacsis sintacsis){
        String stringReturn = null;
        
        if (searchEqual(sintacsis.getString(), PatternConst.CREATE_MATRIX).find()) {
            System.out.println("YEAH!!!");
        }
        if (searchEqual(sintacsis.getString(), PatternConst.CREATE_NULL_MATRIX).find()) {
            System.out.println("YEAH!!!");
        }
        
        return stringReturn;
    }

    public static Matcher searchEqual(String commandOnString,String patternOnString){
        Pattern pattern = Pattern.compile(patternOnString);
        Matcher matcher = pattern.matcher(commandOnString);
        
        if (true) {

        }
        return matcher;
    }
    
    public static MtF.Matrix createMatrix(String nameMatrix,String[] findValueOnStrings){
        MtF.Matrix matrixRes = new MtF.Matrix();
        
        
        
        float[][] res = new float[3][3];
        matrixRes.setName(nameMatrix);
        matrixRes.matrix = res;
        return matrixRes;
    }
}