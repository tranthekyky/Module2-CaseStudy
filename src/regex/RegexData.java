package regex;

import exception.InputException;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class RegexData {
    InputException inputException = new InputException();

    public String inputNumberPhone () {
        String regex = "^(0|\\+84)[3-9][0-9]{8}$" ;
        String str ;
        do {
            str = inputException.inputString() ;
            if (str.matches(regex)) {
                return str ;
            }else {
                System.err.println("Sai dịnh dạng số !! ( VD : 0365... ; 0983... )");
            }
        }while (true) ;
    }
    public String inputEmail () {
        String regex = "^[a-zA-Z0-9._%+-]+@gmail\\.com$" ;
        String str ;
        do {
            str = inputException.inputString() ;
            if (str.matches(regex)) {
                return str ;
            }else {
                System.err.println("Sai định dạng !! ( VD : txt12@gmail.com , user34Ggmail.com)");
            }
        }while (true) ;
    }
    public String inputDate () {
        String regex = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-\\d{4}$" ;
        String str ;
        do {
            str = inputException.inputString() ;
            if (str.matches(regex)) {
                return str ;
            }else {
                System.err.println("Sai định dạng 'dd-MM-yyyy'!!  ");
            }
        }while (true) ;
    }
}
