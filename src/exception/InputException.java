package exception;

import model.Book;
import model.Customer;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class InputException {
    Scanner scanner = new Scanner(System.in);
    public int inputNumberInt() {
        int number ;
        do {
            try {
                number = Integer.parseInt(scanner.nextLine());
                return number;
            }catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập dữ liệu là số !");
            }
        }while(true) ;
    }
    public double inputNumberDouble() {
        double number ;
        do {
            try {
                number = Double.parseDouble(scanner.nextLine());
                return number ;
            }catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập dữ liệu là số !");
            }
        }while(true) ;
    }
    public String inputString() {
        return scanner.nextLine();
    }
    public String checkFindCode(ArrayList<Book> books) {
        String code;
        boolean found = false;
        do {
            try {
                code = inputString();
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).getCodeBook().equals(code)) {
                        found = true;
                        return code;
                    }
                }
                if (!found) {
                    System.err.println("Mã sách không tồn tại! Vui lòng nhập lại.");
                }
            } catch (Exception e) {
                System.err.println("Đã xảy ra lỗi khi nhập mã sách, vui lòng thử lại!");
            }
        } while (!found);
        return null;
    }
    public String checkInputCode (ArrayList<Book> books) {
        String code;
        boolean found ;
        do {
            code = scanner.nextLine();
            found = false;

            for (Book book : books) {
                if (book.getCodeBook().equals(code)) {
                    System.err.println("Mã code đã tồn tại, vui lòng nhập lại.");
                    found = true;
                    break;
                }
            }
        } while (found);

        return code;
    }

    public int checkID(ArrayList<Customer> customers) {
        int id;
        boolean found = false;

        do {
            try {
                id = inputNumberInt();
                for (int i = 0; i < customers.size(); i++) {
                    if (customers.get(i).getId() == id) {
                        found = true;
                        return id;
                    }
                }
                if (!found) {
                    System.err.println("ID không tồn tại! Vui lòng nhập lại.");
                }
            } catch (Exception e) {
                System.err.println("Đã xảy ra lỗi khi nhập ID, vui lòng thử lại!");
            }
        } while (!found);


        return -1;
    }
    public int checkNumberChoice (int choiceMax ) {
        int choice;
        do {
            choice = inputNumberInt();
            if (choice < 0 || choice > choiceMax) {
                System.err.println("Số yêu cầu không phù hợp !!");
            }else {
                return choice;
            }
        }while(true);
    }
    public String inputDate () {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date;
        LocalDate localDate = null;
        boolean found = false;
        do {
            try {
                System.out.println("Nhập theo định dạng \"dd-MM-yyyy\"");
                date = scanner.nextLine();
                localDate = LocalDate.parse(date, dateFormat);
                found = true;
                return date;
            }catch (DateTimeException e) {
                System.err.println("Định dạng ngày không hợp lệ !");
            }
        }while (!found) ;

        return localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

}
