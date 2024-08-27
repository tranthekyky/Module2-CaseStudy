package view;

import exception.InputException;
import manager.CartManager;
import manager.LibraryManager;
import manager.UserManager;
import model.Book;
import model.Customer;
import regex.RegexData;

import java.util.Set;

public class AdminMenu_Library {
    LibraryManager libraryManager = new LibraryManager();
    InputException inputException = new InputException();
    CartManager cartManager = new CartManager();
    UserManager userManager = new UserManager();
    RegexData regexData = new RegexData();
    public void handleAdminMenu_Library () {
        int choice ;
        do {
            menuAdmin_Library();
            choice = inputException.inputNumberInt();
            switch (choice) {
                case 1:
                    displayAllLibrary();
                    break;
                case 2:
                    addBookInLibrary();
                    break;
                case 3:
                    removeBookFromLibrary();
                    break;
                case 4:
                    updateBookInLibrary();
                    break;
                case 5:
                    displaysBookByType();
                    break;
                case 6:
                    displaysBookByName();
                    break;
                case 7:
                    displaysBookByCode();
                    break;
                case 8:
                    displayAllBookSell();
                    break;
                case 9:
                    displayHistorySell();
                    break;
            }
        }while (choice != 0);
    }
    public void menuAdmin_Library () {
        System.out.println("=========== QUẢN LÝ THƯ VIỆN ===========");
        System.out.println("1. Hiển thị tất cả sách .");
        System.out.println("2. Thêm sách vào thư viện .");
        System.out.println("3. Xoá sách khỏi thư viện .");
        System.out.println("4. Sửa thông tin sách .");
        System.out.println("5. Hiển thị sách theo loại .");
        System.out.println("6. Tìm sách theo tên sách .");
        System.out.println("7. Tìm sách theo mã sách.");
        System.out.println("8. Hiển thị tất cả sách đã bán .");
        System.out.println("9. Xem Chi tiết lịch sử bán .");
        System.out.println("0. Thoát .");
        System.out.println();
        System.out.println("Nhập yêu cầu :");
    }
    public void displayAllLibrary () {
        System.out.println("=========== THƯ VIỆN ===========");
        System.out.println("Tổng số lượng sách : " + libraryManager.getBooksQuantityAll());
        libraryManager.displaysAllBookByLibrary();
    }
    public void addBookInLibrary () {
        System.out.println("=========== THÊM SÁCH VÀO THƯ VIỆN ===========");
        System.out.println("Nhập mã sách : ");
        String code = inputException.checkInputCode(libraryManager.getBooks());
        System.out.println("Nhập tên sách :");
        String name = inputException.inputString();
        System.out.println("Tên tác giả :");
        String author = inputException.inputString();
        System.out.println("Nhập đơn giá :");
        double price = inputException.inputNumberDouble();
        System.out.println("Nhập số lượng :");
        int quantity = inputException.inputNumberInt();
        System.out.println("Chọn loại sách :");
        int choice ;
        String type = "" ;
            System.out.println("1. Khoa học, công nghệ - T01.");
            System.out.println("2. Tâm lý, Tình cảm - T02.");
            System.out.println("3. Tiểu thuyết - T03.");
            System.out.println("4. Tôn giáo - T04.");
            System.out.println();
            System.out.println("Nhập lựa chọn :");
            choice = inputException.checkNumberChoice(4);
            switch (choice) {
                case 1:
                    type = "T01" ;
                    break;
                case 2:
                    type = "T02" ;
                    break;
                case 3:
                    type = "T03" ;
                    break;
                case 4:
                    type = "T04" ;
                    break;
            }
        Book book = new Book(code, name, author, price, quantity, type);
        libraryManager.addNewBooks(book);
        System.out.println("Thêm sách thành công !!");
    }
    public void removeBookFromLibrary () {
        System.out.println("=========== XOÁ SÁCH ===========");
        System.out.println("Nhập mã sách cần xoá :");
        String code = inputException.checkFindCode(libraryManager.getBooks());
        int index = libraryManager.getIndexBooks(code);
        libraryManager.deleteBook(index);
        System.out.println("Xoá sách thành công !!");
    }
    public void updateBookInLibrary () {
        System.out.println("=========== SỬA THÔNG TIN SÁCH ===========");
        System.out.println("Nhập mã sách cần sửa :");
        String code = inputException.checkFindCode(libraryManager.getBooks());
        int index = libraryManager.getIndexBooks(code);
        System.out.println("Nhập mã sách mới : ");
        String codeNew = inputException.checkInputCode(libraryManager.getBooks());
        System.out.println("Nhập tên sách mới :");
        String name = inputException.inputString();
        System.out.println("Tên tác giả mới:");
        String author = inputException.inputString();
        System.out.println("Nhập đơn giá mới :");
        double price = inputException.inputNumberDouble();
        System.out.println("Nhập số lượng :");
        int quantity = inputException.inputNumberInt();
        System.out.println("Chọn loại sách :");
        int choice ;
        String type = "" ;
            System.out.println("1. Khoa học, công nghệ - T01.");
            System.out.println("2. Tâm lý, Tình cảm - T02.");
            System.out.println("3. Tiểu thuyết - T03.");
            System.out.println("4. Tôn giáo - T04.");
            System.out.println();
            System.out.println("Nhập lựa chọn :");
            choice = inputException.checkNumberChoice(4);
            switch (choice) {
                case 1:
                    type = "T01" ;
                    break;
                case 2:
                    type = "T02" ;
                    break;
                case 3:
                    type = "T03" ;
                    break;
                case 4:
                    type = "T04" ;
                    break;
            }
        Book book = new Book(codeNew, name, author, price, quantity, type);
        libraryManager.updateBook(index, book);
        System.out.println("Sửa thông tin thành công !!");
    }
    public void displaysBookByType () {
        System.out.println("=========== CHỌN LOẠI SÁCH ===========");
        int choice ;
        do {
            System.out.println("1. Khoa học, công nghệ - T01.");
            System.out.println("2. Tâm lý, Tình cảm - T02.");
            System.out.println("3. Tiểu thuyết - T03.");
            System.out.println("4. Tôn giáo - T04.");
            System.out.println();
            System.out.println("Nhập lựa chọn :");
            choice = inputException.checkNumberChoice(4);
            switch (choice) {
                case 1:
                    System.out.println("Loại : Khoa học, công nghệ - T01.");
                    System.out.println("Tổng số lượng sách : " + libraryManager.getBooksQuantityByType("T01"));
                    for (Book book : libraryManager.findBooksByType("T01")) {
                        System.out.println(book);
                    }
                    break;
                case 2:
                    System.out.println("Loại : Tâm lý, Tình cảm - T02.");
                    System.out.println("Tổng số lượng sách : " + libraryManager.getBooksQuantityByType("T02"));
                    for (Book book : libraryManager.findBooksByType("T02")) {
                        System.out.println(book);
                    }
                    break;
                case 3:
                    System.out.println("Tổng số lượng sách : " + libraryManager.getBooksQuantityByType("T03"));
                    System.out.println("Loại : Tiểu thuyết - T03.");
                    for (Book book : libraryManager.findBooksByType("T03")) {
                        System.out.println(book);
                    }
                    break;
                case 4:
                    System.out.println("Tổng số lượng sách : " + libraryManager.getBooksQuantityByType("T04"));
                    System.out.println("Loại : Tôn giáo - T04.");
                    for (Book book : libraryManager.findBooksByType("T04")) {
                        System.out.println(book);
                    }
                    break;
            }
        }while (choice != 0);
    }
    public void displaysBookByName () {
        System.out.println("Nhập tên sách cần tìm : ");
        String name = inputException.inputString();
        for (Book book : libraryManager.findBooksByName(name)) {
            System.out.println(book);
        }
    }
    public void displaysBookByCode () {
        System.out.println("Nhập mã sách cần tìm : ");
        String code = inputException.checkFindCode(libraryManager.getBooks());
        int index = libraryManager.getIndexBooks(code);
        System.out.println(libraryManager.getBooks().get(index));
    }
    public void displayAllBookSell () {
        System.out.println("=========== SÁCH ĐÃ ĐƯỢC BÁN ===========");
        double total = 0;
        int quantity = 0;
        Set<Integer> keys = libraryManager.getSaleBook().keySet();
        for (Integer key : keys) {
            for (Book book : libraryManager.getSaleBook().get(key)) {
                System.out.println(book);
                total += (book.getPrice() * book.getQuantity());
                quantity += book.getQuantity();
            }
        }
        System.out.println("DOANH THU : " + total);
        System.out.println("SỐ LƯỢNG : " + quantity);

    }
    public void displayHistorySell () {
        int choice ;
        do {
            System.out.println("=========== LỊCH SỬ BÁN ===========");
            System.out.println("1. Hiển thị tất cả .");
            System.out.println("2. Hiển thị theo ngày cụ thể .");
            System.out.println("3. Hiển thị theo người dùng .");
            System.out.println("4. Hiển thị số lượng sách đã mua .");
            System.out.println();
            System.out.println("Nhập lựa chọn :");
            choice = inputException.inputNumberInt();
            switch (choice) {
                case 1:
                    double total = 0;
                    int quantity = 0 ;
                    Set <Integer> keys = libraryManager.getSaleBook().keySet();
                    for (Integer key : keys) {
                        for (Book book : libraryManager.getSaleBook().get(key)) {
                            total += (book.getPrice() * book.getQuantity());
                            quantity += book.getQuantity();
                        }
                    }
                    System.out.println("DOANH THU : " + total);
                    System.out.println("TỔNG SỐ LƯỢNG : " + quantity);
                    for (Customer customer : userManager.getCustomers()) {
                         if (!cartManager.readDataBuy(customer.getId()).isEmpty()) {
                             System.out.println("KHÁCH HÀNG : " + customer.getName() + " ; ID : " + customer.getId());
                             System.out.println(cartManager.readDataBuy(customer.getId()));
                        }
                    }
                    break;
                case 2:
                    System.out.println("Nhập ngày : ");
                    String date = regexData.inputDate();
                    System.out.println("TỔNG SỐ SÁCH BÁN NGÀY : " + date);
                    for (Customer customer : userManager.getCustomers()) {
                        if (cartManager.readDataBuy(customer.getId()).contains(date)) {
                            System.out.println(cartManager.readDataBuy(customer.getId()));
                        }
                    }
                    break;
                case 3:
                    System.out.println("Nhập ID người dùng :");
                    int id = inputException.checkID(userManager.getCustomers());
                    int index = userManager.getIndexCustomer(id) ;
                    System.out.println("---KHÁCH HÀNG : " + userManager.getCustomers().get(index).getName());
                    System.out.println("----- Sách đã mua -->");
                    System.out.println(cartManager.readDataBuy(id));
                    break;
                case 4:
                    System.out.println("Nhập mã sách : ");
                    String code = inputException.checkFindCode(libraryManager.getBooks());
                    double total3 = 0;
                    if (libraryManager.getQuantityByCodeSell(code) != -1) {
                        Set<Integer> keys2 = libraryManager.getSaleBook().keySet();
                        for (Integer key : keys2) {
                            for (Book book : libraryManager.getSaleBook().get(key)) {
                                if (book.getCodeBook().equals(code)) {
                                    System.out.println(book);
                                    total3 += (book.getPrice() * book.getQuantity());
                                }
                            }
                        }
                        System.out.println("TỔNG SỐ LƯỢNG : " + libraryManager.getQuantityByCodeSell(code));
                        System.out.println("DOANH THU : " + total3);

                    }else {
                        System.err.println("Hiện tại sách này chưa được bán !");
                    }
                    break ;
            }
        }while (choice != 0);
    }






}
