package manager;

import model.Book;
import function.function_customer.IFunctionCustomer;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CartManager implements IFunctionCustomer <Book>{
    private ArrayList<Book> cart ;

    public CartManager() {
        this.cart = new ArrayList<>();
    }


    @Override
    public int getIndexBookInCart(String code) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getCodeBook().equals(code)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ArrayList<Book> getBookListInCart() {
        return cart;
    }


    @Override
    public void addBooksIntoCart(Book book , int  quantity) {
        book.setQuantity(quantity);
        this.cart.add(book);
    }

    @Override
    public void removeBooksByCart(int index, int quantity) {
        int newQuantity = cart.get(index).getQuantity() - quantity;
        if (newQuantity > 0) {
            cart.get(index).setQuantity(newQuantity);
        }else {
            cart.remove(index);
        }
    }

    @Override
    public void displaysCart() {
        for (int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i));
        }
    }

    @Override
    public double totalAmountInCart() {
        double sum = 0;
        for (int i = 0; i < cart.size(); i++) {
            sum += cart.get(i).getPrice();
        }
        return sum;
    }

    @Override
    public String getDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy  HH:mm:ss");
        return now.format(formatter);
    }


    @Override
    public void saveDataBuy(int idUser, Book book) {
        String dataTime = getDateTime();
        String filename = "data_users/" +idUser + ".txt";
        File directory = new File ("data_users");
        if (!directory.exists()) {
            directory.mkdir();
        }
        try (FileWriter fileWriter = new FileWriter(filename , true)){
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String data ="ĐÃ MUA : " + book.getName()+" - SỐ LƯỢNG : "+book.getQuantity()+", NGÀY : "+dataTime ;
            bufferedWriter.write(data);
            bufferedWriter.newLine();
            bufferedWriter.close();

        }catch (IOException e) {
            System.err.println("Lỗi lưu vào file '"+filename+"'");
        }
    }

    @Override
    public String readDataBuy(int idUser) {
        String dataBuy = "" ;
        String filename = "data_users/" +idUser + ".txt";
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data ;
            while ((data = bufferedReader.readLine()) != null) {
                    dataBuy += data + "\n";
            }
            bufferedReader.close();
        }catch (IOException e) {
            System.err.println("Lỗi đọc file '"+filename+"'");
        }
        return dataBuy;
    }



}
