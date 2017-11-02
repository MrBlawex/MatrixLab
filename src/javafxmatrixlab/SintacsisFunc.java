package javafxmatrixlab;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SintacsisFunc {
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
    
    public static String readCommand(Sintacsis sintacsis){
        String stringReturn = null;
        Matcher r;
        
        r = searchEqual(sintacsis.getString(), "dwadwa");
        r.find();
        return stringReturn;
    }
    
    public static Matcher searchEqual(String commandOnString,String patternOnString){
        Pattern pattern = Pattern.compile(patternOnString);
        Matcher matcher = pattern.matcher(commandOnString);
        
        if (true) {
            
        }
        return matcher;
    }
}