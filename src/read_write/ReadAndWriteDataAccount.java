package read_write;

import login.Login;
import model.Admin;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ReadAndWriteDataAccount {
    private File accountUser = new File("data_base/account_user.csv");
    private File accountAdmin = new File("data_base/account_admin.csv");
    public void writeDataAccountUser(HashMap<Integer , Login> login) {
        try {
            FileWriter fileWriter = new FileWriter(this.accountUser);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String data = "";
            for (Integer key : login.keySet()) {
                data += key + "," + login.get(key).getUsername() + "," + login.get(key).getPassword() + "\n";
            }
            bufferedWriter.write(data);
            bufferedWriter.close();

        }catch (IOException e) {
            System.err.println("Lỗi lưu dữ liệu vào file 'account_user.csv'");
        }
    }
    public void writeDataAccountAdmin(ArrayList<Admin> login) {
        try {
            FileWriter fileWriter = new FileWriter(this.accountAdmin);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String data = "";
            for (Admin admin : login) {
                data += admin.getName() + "," + admin.getAccount().getUsername() + "," + admin.getAccount().getPassword() + "\n";
            }
            bufferedWriter.write(data);
            bufferedWriter.close();
        }catch (IOException e) {
            System.err.println("Lỗi lưu dữ liệu vào file 'account_admin.csv'");
        }
    }
    public HashMap<Integer , Login> readDataAccountUser() {
        HashMap<Integer , Login> login = new HashMap<>();
        try {
            FileReader fileReader = new FileReader(this.accountUser);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line ;
            while ((line = bufferedReader.readLine()) != null) {
                String [] data = line.split(",");
                login.put(Integer.parseInt(data[0]), new Login(data[1], data[2]));
            }
            bufferedReader.close();
        }catch (IOException e) {
            System.err.println("Lỗi đọc dữ liệu từ file 'account_user.csv'");
        }
        return login;
    }
    public ArrayList<Admin> readDataAccountAdmin() {
        ArrayList<Admin> login = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(this.accountAdmin);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line ;
            while ((line = bufferedReader.readLine()) != null) {
                String [] data = line.split(",");
                login.add(new Admin(data[0] , new Login(data[1], data[2])));
            }
            bufferedReader.close();
        }catch (IOException e) {
            System.err.println("Lỗi đọc dữ liệu từ file 'account_admin.csv'");
        }
        return login;
    }

}
