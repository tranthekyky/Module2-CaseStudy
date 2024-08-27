package view;

import exception.InputException;
import login.Login;
import manager.LoginManager;
import manager.UserManager;
import model.Admin;
import regex.RegexLogin;

public class AdminMenu {
    InputException inputException = new InputException();
    AdminMenu_User adminMenu_User = new AdminMenu_User();
    AdminMenu_Library adminMenu_Library = new AdminMenu_Library();
    RegexLogin regexLogin = new RegexLogin();
    LoginManager loginManager = new LoginManager();
    public void handleAdminMenu_User () {
        int choice ;
        do {
            System.out.println("========== MỤC XỬ LÝ ==========");
            System.out.println("1. Quản lý người dùng .");
            System.out.println("2. Quản lý thư viện .");
            System.out.println("3. Thêm quản trị viên .");
            System.out.println("0. Thoát .");
            System.out.println();
            System.out.println("Nhập yêu cầu :");
            choice = inputException.inputNumberInt();
            switch (choice) {
                case 1:
                    adminMenu_User.handleMenuAdmin_User();
                    break;
                case 2:
                    adminMenu_Library.handleAdminMenu_Library();
                    break;
                case 3:
                    addAdmin();
                    break;
            }
        }while (choice != 0);
    }
    public void addAdmin () {
        System.out.println("======== THÊM QUẢN TRỊ VIÊN ========");
        System.out.println("Nhập tên :");
        String name = inputException.inputString();
        System.out.println("Nhập tài khoản đăng nhập : ");
        String nameAcc = regexLogin.inputAccountAdmin();
        System.out.println("Nhập mật khẩu :");
        String password = regexLogin.inputPassr();
        Login login = new Login(nameAcc ,password);
        Admin admin = new Admin(name , login) ;
        loginManager.signUpAdmin(admin);
        System.out.println("Thêm thành công !!");
    }



}
