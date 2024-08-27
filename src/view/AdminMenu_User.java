package view;

import exception.InputException;
import login.Login;
import manager.CartManager;
import manager.LibraryManager;
import manager.LoginManager;
import manager.UserManager;
import model.Customer;
import read_write.ReadAndWriteDataAccount;
import regex.RegexData;
import regex.RegexLogin;

public class AdminMenu_User {
    UserManager userManager = new UserManager();
    InputException inputException = new InputException();
    RegexLogin regexLogin = new RegexLogin();
    RegexData regexData = new RegexData();
    CartManager cartManager = new CartManager();
    LoginManager loginManager = new LoginManager();
    ReadAndWriteDataAccount readAndWriteDataAccount = new ReadAndWriteDataAccount();
    public void handleMenuAdmin_User () {
        int choice ;
        do {
            menuAdmin_User();
            choice =inputException.inputNumberInt();
            switch (choice) {
                case 1:
                    displayAllCus();
                    break;
                case 2:
                    addNewCustomer();
                    break;
                case 3:
                    removeCustomer();
                    break;
                case 4:
                    updateCustomer();
                    break;
                case 5:
                    findCustomerByID();
                    break;
                case 6:
                    findCustomerByName();
                    break;
                case 7:
                    showHistoryByID();
                    break;
            }
        }while (choice != 0);
    }
    public void menuAdmin_User () {
        System.out.println("=========== QUẢN LÝ NGƯỜI DÙNG ===========");
        System.out.println("1. Hiển thị danh sách người dùng .");
        System.out.println("2. Thêm người dùng mới .");
        System.out.println("3. Xoá người dùng .");
        System.out.println("4. Sửa thông tin người dùng .");
        System.out.println("5. Tìm kiếm người dùng theo ID .");
        System.out.println("6. Tìm kiếm người dùng theo tên .");
        System.out.println("7. Xem lịch mua của người dùng theo ID .");
        System.out.println("0. Thoát .");
        System.out.println();
        System.out.println("Nhập yêu cầu :");

    }
    public void displayAllCus () {
        System.out.println("=========== DANH SÁCH NGƯỜI DÙNG ===========");
        userManager.displayALlCustomers();
    }
    public void addNewCustomer () {
        System.out.println("=========== THÊM NGƯỜI DÙNG ===========");
        System.out.println("Nhập họ và tên : ");
        String name = inputException.inputString();
        System.out.println("Email :");
        String email = regexData.inputEmail();
        System.out.println("Số điện thoại :");
        String numberPhone = regexData.inputNumberPhone();
        System.out.println("Địa chỉ :");
        String address = inputException.inputString();
        System.out.println("ĐIỀN TÀI KHOẢN ĐĂNG NHẬP :");
        String account = regexLogin.inputAccountCustomer();
        System.out.println("ĐIỀN MẬT KHẨU ĐĂNG NHẬP :");
        String pass = regexLogin.inputPassr();
        Customer customer = new Customer(name ,new Login(account,pass),email,numberPhone,address);
        userManager.addCustomer(customer);
        loginManager.singUpCustomer(customer);
        readAndWriteDataAccount.writeDataAccountUser(loginManager.getAcccountCustomer());
        System.out.println("Thêm người dùng thành công !!");
    }
    public void removeCustomer () {
        System.out.println("=========== XOÁ NGƯỜI DÙNG ===========");
        System.out.println("Nhập ID người dùng :");
        int id = inputException.checkID(userManager.getCustomers());
        int index = userManager.getIndexCustomer(id);
        userManager.deleteCustomer(index);
        System.out.println("Xoá người dùng thành công !!");
    }
    public void updateCustomer () {
        System.out.println("=========== SỬA THÔNG TIN NGƯỜI DÙNG ===========");
        System.out.println("Nhập ID người dùng cần sửa :");
        int id = inputException.checkID(userManager.getCustomers());
        int index = userManager.getIndexCustomer(id);
        System.out.println("Nhập họ và tên mới : ");
        String name = inputException.inputString();
        System.out.println("Email :");
        String email = regexData.inputEmail();
        System.out.println("Số điện thoại :");
        String numberPhone = regexData.inputNumberPhone();
        System.out.println("Địa chỉ :");
        String address = inputException.inputString();
        System.out.println("ĐIỀN TÀI KHOẢN ĐĂNG NHẬP :");
        String account = regexLogin.inputAccountCustomer();
        System.out.println("ĐIỀN MẬT KHẨU ĐĂNG NHẬP :");
        String pass = regexLogin.inputPassr();
        Customer customer = new Customer(name ,new Login(account,pass),email,numberPhone,address);
        customer.setId(id);
        userManager.updateCustomer(index ,customer);
        loginManager.singUpCustomer(customer);
        readAndWriteDataAccount.writeDataAccountUser(loginManager.getAcccountCustomer());
        System.out.println("Sửa thông tin thành công !!");
    }
    public void findCustomerByID () {
        System.out.println("Nhập ID cần tìm : ");
        int id = inputException.checkID(userManager.getCustomers());
        int index = userManager.getIndexCustomer(id);
        System.out.println( userManager.displaysInfo(index));

    }
    public void findCustomerByName () {
        System.out.println("Nhập Tên cần tìm : ");
        String name = inputException.inputString();
        if (userManager.searchCustomerByName(name).isEmpty()){
            System.out.println("Không tìm thấy tên này !!");
        }else {
            for (Customer cus : userManager.searchCustomerByName(name)) {
                System.out.println(cus);
            }
        }

    }
    public void showHistoryByID () {
        System.out.println("Nhập ID người dùng :");
        int id = inputException.checkID(userManager.getCustomers());
        int index = userManager.getIndexCustomer(id);
        System.out.println("Khách Hàng : " + userManager.displaysInfo(index).getName());
        String data =  cartManager.readDataBuy(id) ;
        System.out.println(data);

    }



}
