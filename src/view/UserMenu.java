package view;

import exception.InputException;
import manager.CartManager;
import manager.LibraryManager;
import manager.UserManager;
import model.Book;
import read_write.ReadAndWriteDataSell;

public class UserMenu {
    UserManager userManager = new UserManager();
    LibraryManager libraryManager = new LibraryManager();
    CartManager cartManager = new CartManager();
    InputException inputException = new InputException();

    ReadAndWriteDataSell readAndWriteDataSell = new ReadAndWriteDataSell();
    public void handleUserMenu (int idUser) {
        int choice ;
        do {
            menuUserOption();
            System.out.println();
            choice = inputException.checkNumberChoice(8);
            switch (choice) {
                case 1:
                    displayInfoUser(idUser);
                    break;
                case 2:
                    displayAllBook();
                    break;
                case 3:
                    addBookInCart();
                    break;
                case 4:
                    removeBookFromCart();
                    break;
                case 5:
                    findBookByName();
                    break;
                case 6:
                    findBookByType();
                    break;
                case 7:
                    displayCart(idUser);
                    break;
                case 8:
                    checkHistory(idUser);
            }
        }while (choice != 0);
    }
    public void menuUserOption () {
        System.out.println("=========== XIN CHÀO ==========");
        System.out.println("1. Hiển thị thông tin cá nhân .");
        System.out.println("2. Hiển thị tất cả sản phẩm .");
        System.out.println("3. Thêm sản phẩm mới vào giỏ hàng .");
        System.out.println("4. Bỏ sản phẩm ra khỏi giỏ hàng .");
        System.out.println("5. Tìm sách theo tên .");
        System.out.println("6. Tìm sách theo loại .");
        System.out.println("7. Xem giỏ hàng .");
        System.out.println("8. Xem lịch sử hoạt động .");
        System.out.println("0. Thoát .");
        System.out.println();
        System.out.println("Nhập yêu cầu :");
    }
    public void displayInfoUser (int idUser) {
        System.out.println("======== THÔNG TIN CÁ NHÂN ========");
        int index = userManager.getIndexCustomer(idUser) ;
        System.out.println("TÊN : " + userManager.getCustomers().get(index).getName());
        System.out.println("EMAIL : " + userManager.getCustomers().get(index).getEmail());
        System.out.println("SỐ ĐIỆN THOẠI : " + userManager.getCustomers().get(index).getNumberPhone());
        System.out.println("ĐỊA CHỈ : "+ userManager.getCustomers().get(index).getAddress());
        System.out.println("SỐ DƯ TÀI KHOẢN : ");
    }
    public void displayAllBook () {
        System.out.println("======== SÁCH TRONG THƯ VIỆN ========");
        libraryManager.displaysAllBookByLibrary();
    }
    public void addBookInCart () {
        System.out.println("=========== THÊM SÁCH ===========");
        System.out.println("Nhập mã sách bạn muốn thêm :");
        String code = inputException.checkFindCode(libraryManager.getBooks());
        int index = libraryManager.getIndexBooks(code);
        System.out.println("Nhập số lượng sách bạn muốn mua :");
        int quantity = inputException.inputNumberInt();
        if (libraryManager.checkQuantityBooks(libraryManager.getBooks(),quantity ,index)) {
            Book newBook = new Book(libraryManager.getBooks().get(index).getCodeBook(),libraryManager.getBooks().get(index).getName(),
                    libraryManager.getBooks().get(index).getAuthor(),libraryManager.getBooks().get(index).getPrice(),quantity,libraryManager.getBooks().get(index).getCodeType());
            libraryManager.getBooks().get(index).setQuantity(libraryManager.getBooks().get(index).getQuantity() - quantity);
            cartManager.addBooksIntoCart(newBook,quantity);
            System.out.println("Thêm sách thành công !! ");

        }else {
            System.err.println("Số lượng sách trong thư viện không đủ !!");
        }

    }
    public void removeBookFromCart () {
        System.out.println("=========== XOÁ SÁCH ===========");
        System.out.println("Nhập mã sách bạn muốn bỏ : ");
        String code = inputException.checkFindCode(cartManager.getBookListInCart());
        int index = cartManager.getIndexBookInCart(code);
        System.out.println("Nhập số lượng muốn bỏ :");
        int quantity = inputException.inputNumberInt();
        if (libraryManager.checkQuantityBooks(cartManager.getBookListInCart(),quantity ,index)) {
            cartManager.removeBooksByCart(index , quantity);
            int indexLibra = libraryManager.getIndexBooks(code);
            libraryManager.getBooks().get(indexLibra).setQuantity(libraryManager.getBooks().get(indexLibra).getQuantity() + quantity);
            System.out.println("Xoá thành công !!");
        }else {
            System.err.println("Số lượng bạn nhập không hợp lệ !!");
        }


    }
    public void findBookByName () {
        System.out.println("=========== TÌM SÁCH THEO TÊN ===========");
        System.out.println("Nhập tên bạn muốn tìm :");
        String name = inputException.inputString();
        if (libraryManager.findBooksByName(name).isEmpty()) {
            System.err.println("Không tìm thấy tên bạn cần !");
        }else {
            for (Book book : libraryManager.findBooksByName(name)) {
                System.out.println(book);
            }
        }
    }
    public void findBookByType () {
        System.out.println("=========== TÌM SÁCH THEO LOẠI SÁCH ===========");
        System.out.println("1. Khoa học, công nghệ - T01.");
        System.out.println("2. Tâm lý, Tình cảm - T02.");
        System.out.println("3. tiểu thuyết - T03.");
        System.out.println("4. Tôn giáo - T04.");
        System.out.println();
        System.out.println("Nhập yêu cầu :");
        int choice = inputException.checkNumberChoice(4);
        switch (choice) {
            case 1:
                for (Book book : libraryManager.findBooksByType("T01")) {
                    System.out.println(book);
                };
                break;
            case 2:
                for (Book book1 : libraryManager.findBooksByType("T02")) {
                    System.out.println(book1);
                }
                break;
            case 3:
                for (Book book2 : libraryManager.findBooksByType("T03")) {
                    System.out.println(book2);
                }
                break;
            case 4:
                for (Book book3 : libraryManager.findBooksByType("T04")) {
                    System.out.println(book3);
                }
                break;
        }



    }
    public void displayCart (int idUser) {
        System.out.println("=========== GIỎ HÀNG CỦA BẠN ===========");
        cartManager.displaysCart();
        buyBook(idUser);
    }
    public void buyBook (int idUser) {

            System.out.println("---- 1. Xem hoá đơn .");
            System.out.println("---- 0. Thoát . ");
            System.out.println();
            System.out.println("Nhập yêu cầu :");
            int choice = inputException.checkNumberChoice(1);
            switch (choice) {
                case 1:
                    System.out.println("---------- HOÁ ĐƠN ----------");
                    libraryManager.printInvoice(cartManager.getBookListInCart());
                    payBook(idUser);
                case 0 :
                    handleUserMenu(idUser);
                    break;
            }

    }
    public void payBook (int idUser) {

            System.out.println("---- 1. Thanh toán hoá đơn .");
            System.out.println("---- 0. Thoát .");
            System.out.println();
            int choice = inputException.checkNumberChoice(1);
            switch (choice) {
                case 1:
                    libraryManager.saleBook(cartManager.getBookListInCart(), idUser);
                    readAndWriteDataSell.writeDataSell(libraryManager.getSaleBook());
                    for (Book book : cartManager.getBookListInCart()) {
                        cartManager.saveDataBuy(idUser, book);
                    }
                    cartManager.getBookListInCart().clear();
                    System.out.println("Thành toán thành công .");
                    break;
                case 0 :
                    handleUserMenu(idUser);
                    break;
            }

    }
    public void checkHistory (int idUser) {
        System.out.println("=========== LỊCH SỬ MUA HÀNG ===========");
        System.out.println(cartManager.readDataBuy(idUser));;
    }

}
