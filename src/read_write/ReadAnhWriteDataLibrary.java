package read_write;

import model.Book;

import java.io.*;
import java.util.ArrayList;

public class ReadAnhWriteDataLibrary {
    private File libraryFile = new File("data_base/books.csv");

    public void writeDataLibrary(ArrayList<Book> books) {
        try {

            String data = "";
            for (Book book : books) {
                data += book.getCodeBook() + "," + book.getName() + "," + book.getAuthor() + "," + book.getPrice() + "," + book.getQuantity() + "," + book.getCodeType() + "\n";
            }
            FileWriter fileWriter = new FileWriter(this.libraryFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Lỗi lưu dữ liệu vào file 'books.csv'");
        }
    }

    public ArrayList<Book> readDataLibrary() {
        ArrayList<Book> books = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(this.libraryFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line ;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                books.add(new Book(data[0], data[1], data[2], Double.parseDouble(data[3]), Integer.parseInt(data[4]), data[5]));
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Lỗi đọc dữ liệu từ file 'books.csv'");
        }
        return books;
    }
}

