package regex;

import exception.InputException;

public class RegexLogin {
    InputException exception = new InputException();
    public String inputAccountCustomer() {
        String regex = "^[a-z0-9]{6,16}$" ;
        String str ;
        do {
            str = exception.inputString();
            if (str.matches(regex)) {
                return str;
            }else {
                System.err.println("Tên tài khoản cần ít nhất một chữ số, số kí tự 6 - 16 kí tự !");
            }
        }while (true) ;
    }
    public String inputPassr() {
        String regex = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$" ;
        String str ;
        do {
            str = exception.inputString();
            if (str.matches(regex)) {
                return str;
            }else {
                System.err.println("Mật khẩu cần ít nhất 1 số , một kí tự in hoa , và số kí tự 8 - 16 kí tự ! ");
            }
        }while (true);
    }
    public String inputAccountAdmin () {
        String regex = "^(?=.*\\d)[A-Za-z\\d]{7,15}\\.admin$" ;
        String str ;
        do {
            str = exception.inputString();
            if (str.matches(regex)) {
                return str;
            }else {
                System.err.println("Tài khoản cần ít nhất một chữ số và cần có đuôi '.admin' ! ");
            }
        }while (true) ;
    }
}
