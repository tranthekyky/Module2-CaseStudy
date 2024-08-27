package view;

import exception.InputException;
import manager.UserManager;

public class AdminMenu {
    InputException inputException = new InputException();
    AdminMenu_User adminMenu_User = new AdminMenu_User();
    AdminMenu_Library adminMenu_Library = new AdminMenu_Library();
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
                    System.out.println("3");
                    break;
            }
        }while (choice != 0);
    }



}
