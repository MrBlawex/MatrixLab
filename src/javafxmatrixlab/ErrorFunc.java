package javafxmatrixlab;

public class ErrorFunc {

    public static enum ErrorType {

        /**
         * Неправильное имя
         */
        WRONG_NAME,
        /**
         * Неправильный ввод данных
         */
        WRONG_ITEM,
        /**
         * Неверная функция
         */
        WRONG_FUNC,
        /**
         * Неправильный размер
         */
        WRONG_SIZE
    }

    public static String returnError(ErrorType errorType) {
        switch (errorType) {
            case WRONG_FUNC:
                return "Неправильная функция";
            case WRONG_ITEM:
                return "Неправильные данные";
            case WRONG_NAME:
                return "Неправильное имя";
            case WRONG_SIZE:
                return "Неверная размерность матрицы";
        }
        return null;
    }

}
