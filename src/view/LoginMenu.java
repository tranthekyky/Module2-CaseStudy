package view;

import exception.InputException;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import login.Login;
import manager.LoginManager;
import manager.UserManager;
import model.Customer;
import read_write.ReadAndWriteDataAccount;
import read_write.ReadAndWriteDataUser;
import regex.RegexData;
import regex.RegexLogin;

public class LoginMenu {
    LoginManager loginManager = new LoginManager();
    InputException inputException = new InputException();
    RegexData regex = new RegexData();
    RegexLogin regexLogin = new RegexLogin();
    UserManager userManager = new UserManager();
    UserMenu userMenu = new UserMenu();
    AdminMenu adminMenu = new AdminMenu();
    ReadAndWriteDataUser readAndWriteDataUser = new ReadAndWriteDataUser();
    ReadAndWriteDataAccount readAndWriteDataAccount = new ReadAndWriteDataAccount();
    public void handleLoginCustomer () {
        int choice ;
        do {
            System.out.println();
            System.out.println("======= ĐĂNG NHẬP , ĐĂNG KÝ TÀI KHOẢN NGƯỜI DÙNG =======");
            System.out.println("1. Đăng nhập ");
            System.out.println("2. Đăng ký");
            System.out.println("0. Trở về trang chủ");
            System.out.println();
            System.out.println("Nhập lựa chọn : ");
            choice = inputException.inputNumberInt();
            switch (choice) {
                case 1:
                    signInCustomerMenu();
                    break;
                case 2:
                    signUpCustomerMenu();
                    break;
            }
        }while (choice != 0);
    }
    public void handleLoginAdmin () {
        int choice ;
        do {
            System.out.println();
            System.out.println("======= ĐĂNG NHẬP QUẢN TRỊ VIÊN =======");
            System.out.println("1. Đăng nhập ");
            System.out.println("0. Trở về trang chủ");
            System.out.println();
            System.out.println("Nhập lựa chọn : ");
            choice = inputException.inputNumberInt();
            switch (choice) {
                case 1:
                    signInAdminMenu();
                    break;

            }
        }while (choice != 0);
    }
    public void signInCustomerMenu () {
        System.out.println("========== ĐĂNG NHẬP ==========");
        System.out.println("Tên đăng nhập : ");
        String name = inputException.inputString();
        System.out.println("Mật khẩu :");
        String password = inputException.inputString();
        if (loginManager.signInCustomer(name , password) != -1) {
            userMenu.handleUserMenu(loginManager.signInCustomer(name , password));
        }else {
            System.err.println("Tài khoản không hợp lệ !!");
        }
    }
    public void signUpCustomerMenu () {
        System.out.println("========== ĐĂNG KÝ ==========");
        System.out.println("Nhập họ và tên : ");
        String name = inputException.inputString();
        System.out.println("Email :");
        String email = regex.inputEmail();
        System.out.println("Số điện thoại :");
        String numberPhone = regex.inputNumberPhone();
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
        readAndWriteDataUser.writeDataCustomer(userManager.getCustomers());
        System.out.println("Đăng ký thành công !");
    }
    public void signInAdminMenu () {
        System.out.println("========== ĐĂNG NHẬP ==========");
        System.out.println("Tên đăng nhập : ");
        String name = inputException.inputString();
        System.out.println("Mật khẩu :");
        String password = inputException.inputString();
        if (loginManager.signInAdmin(name ,password)) {
            adminMenu.handleAdminMenu_User();
        }else {
            System.err.println("Tài khoản không hợp lệ !!");
        }
    }
}
