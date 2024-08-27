package view;

import exception.InputException;
import manager.LoginManager;

public class HomePageMenu {
        InputException inputException = new InputException();
        LoginMenu loginMenu = new LoginMenu();
        public void optionHomePage () {
            System.out.println();
            System.out.println("========== TRANG CHỦ ==========");
            System.out.println("1. Khách hàng");
            System.out.println("2. Quản trị viên");
            System.out.println();
            System.out.println("Nhập lựa chọn :");

        }
        public void handleMain () {
            int choice ;
            do {
                optionHomePage();
                choice = inputException.inputNumberInt();
                switch (choice) {
                    case 1:
                        loginMenu.handleLoginCustomer();
                        break;
                    case 2:
                        loginMenu.handleLoginAdmin();
                        break;
                }
            }while (choice != 0);
        }


}
