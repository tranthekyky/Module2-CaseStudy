package manager;


import login.Login;
import model.Admin;
import model.Customer;
import read_write.ReadAndWriteDataAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class LoginManager {
    private HashMap <Integer , Login> acccountCustomer;
    private ArrayList<Admin> acccountAdmin;
    private ReadAndWriteDataAccount readAndWriteDataAccount = new ReadAndWriteDataAccount();
    public LoginManager() {
        acccountCustomer = readAndWriteDataAccount.readDataAccountUser();
        acccountAdmin = readAndWriteDataAccount.readDataAccountAdmin();
    }
    public HashMap <Integer , Login> getAcccountCustomer() {
        return acccountCustomer;
    }
    public int signInCustomer(String userName , String password) {
        Set<Integer> keys = acccountCustomer.keySet();
        for (Integer key : keys) {
            if (acccountCustomer.get(key).getUsername().equals(userName) &&
                    acccountCustomer.get(key).getPassword().equals(password)) {
                return key;
            }
        }
        return -1;
    }

    public void singUpCustomer(Customer customer) {
        this.acccountCustomer.put(customer.getId(), customer.getAccount()) ;
        readAndWriteDataAccount.writeDataAccountUser(acccountCustomer);
    }

    public boolean signInAdmin(String userName , String password) {
        for (Admin admin : acccountAdmin) {
            if (admin.getAccount().getUsername().equals(userName) && admin.getAccount().getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void signInAdmin(Admin admin) {
        this.acccountAdmin.add(admin);
        readAndWriteDataAccount.writeDataAccountAdmin(acccountAdmin);
    }


}
