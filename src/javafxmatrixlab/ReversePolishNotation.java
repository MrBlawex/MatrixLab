package javafxmatrixlab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafxmatrixlab.MtF;
import javafxmatrixlab.controller.homeMatrixLabController;

public class ReversePolishNotation {
    
    static HashMap<String, MtF.Matrix> MapMatrix;
    
    private static HashMap<String, Integer> operations = new HashMap<>();
    {
        operations.put("+", 1);
        operations.put("-", 1);
        operations.put("*", 2);
        operations.put("/", 2);
        operations.put("^", 3);
        MapMatrix = homeMatrixLabController.PublicVar.DATA_BASE_MATRIX;
    }
    
    public static MtF.Matrix get(String command) {
        MtF.Matrix Res;
        
        ArrayList<String> input = getTokens(command);
        Res = calculation(input);
        return Res;
    }

    // ----------------------------------------------- RESULT OF POLISH NOTATION
    private static MtF.Matrix calculation(ArrayList<String> input) {
        Stack<MtF.Matrix> A = new Stack<>();
        Stack<String> B = new Stack<>();

        for (String i : input) {
            if (operations.containsKey(i)) { // ----------- is operation
                if (B.isEmpty()) {
                    B.push(i);
                } else {
                    if (operations.get(i) > operations.get(B.peek())) {
                        B.push(i);
                    } else {
                        MtF.Matrix res,
                                b = A.pop(),
                                a = A.pop();
                        String t = B.pop();
                        res = action(t, a, b);
                        A.push(res);
                        B.push(i);
                    }
                }
            } else { // -------------------------- is MtF.Matrix
                if (MapMatrix.containsKey(i)) {
                    A.push(MapMatrix.get(i));
                } else {
                    System.out.println("Error: Invalid sintax, not found " + "'" + i + "'");
                    break;
                }
            }
        }
        if (A.size() > 1) {
            MtF.Matrix res = new MtF.Matrix(),
                    b = A.pop(),
                    a = A.pop();
            String t = B.pop();
            res = action(t, a, b);
            A.push(res);
        }

        if (A.isEmpty()) {
            MtF.Matrix res = new MtF.Matrix();
            res.isWrong("Error: stack is empty");
            return res;
        } else {
            return A.pop();
        }
    }
    // -------------------------------------------------------- GET TOKENS
    private static ArrayList<String> getTokens(String string) {
        ArrayList<String> res = new ArrayList<>();
        String pattern = "([A-Za-z][A-Za-z0-9]{0,7})|\\W";
        Pattern p = Pattern.compile(pattern);

        Matcher m = p.matcher(string);

        try {
            while (m.find()) {
                res.add(m.group(0));
            }
        } catch (Exception ex) {
            System.out.println("Error");
        }
        return res;
    }
    
    private static MtF.Matrix action(String op, MtF.Matrix a, MtF.Matrix b) {
        MtF.Matrix res = new MtF.Matrix();
        if (null == op) {
            return res;
        } else {
            switch (op) {
                case "+":
                    res = MtF.SumMatrix(a, b);
                    break;
                case "-":
                    res = MtF.DifferMatrix(a, b);
                    break;
                case "*":
                    res = MtF.MultMatrix(a, b);
                    break;
                case "/":
                    res = MtF.DivMatrix(a, b);
                    break;
                case "^":
                    res = MtF.PowElMatrix(a, b);
                    break;
                default:
                    res.isWrong("Ошибка: Недопустимая операция");
            }
        }
        return res;
    }
}
