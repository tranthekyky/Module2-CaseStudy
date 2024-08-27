package manager;

import model.Book;
import function.function_admin.IFunctionAdmin_Book;
import read_write.ReadAndWriteDataSell;
import read_write.ReadAnhWriteDataLibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class LibraryManager implements IFunctionAdmin_Book <Book> {
    private ArrayList<Book> books ;
    private HashMap<Integer, ArrayList<Book>> salesBook ;

    private ReadAndWriteDataSell readAndWriteDataSell = new ReadAndWriteDataSell();
    private ReadAnhWriteDataLibrary readAnhWriteDataLibrary = new ReadAnhWriteDataLibrary();

    public LibraryManager() {
        books = readAnhWriteDataLibrary.readDataLibrary();
        salesBook = readAndWriteDataSell.readDataSell();
    }

    @Override
    public ArrayList<Book> getBooks() {
        return books;
    }

    @Override
    public int getIndexBooks(String code) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getCodeBook().equals(code)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void displaysAllBookByLibrary() {
        for (Book book : this.books) {
            System.out.println(book);
        };
    }

    @Override
    public void addNewBooks(Book book) {
        this.books.add(book);
        readAnhWriteDataLibrary.writeDataLibrary(books);
    }

    @Override
    public void deleteBook(int index) {
        books.remove(index);
        readAnhWriteDataLibrary.writeDataLibrary(books);
    }

    @Override
    public void updateBook(int index, Book book) {
        books.set(index, book);
        readAnhWriteDataLibrary.writeDataLibrary(books);
    }

    @Override
    public Book findBookByCode(int index) {
       return books.get(index);
    }

    @Override
    public ArrayList<Book> findBooksByName(String name) {
        ArrayList<Book> booksSearch = new ArrayList<>();
        for (Book book : books) {
            if (book.getName().toLowerCase().contains(name.toLowerCase())) {
                booksSearch.add(book);
            }
        }
        return booksSearch;
    }

    @Override
    public ArrayList<Book> findBooksByType(String codeType) {
        ArrayList<Book> booksSearch = new ArrayList<>();
        for (Book book : books) {
            if (book.getCodeType().equals(codeType)) {
                booksSearch.add(book);
            }
        }
        return booksSearch;
    }

    @Override
    public int getBooksQuantityAll() {
        int total = 0;
        for (Book book : books) {
            total += book.getQuantity();
        }
        return total;
    }

    @Override
    public int getBooksQuantityByType(String codeType) {
        int total = 0;
        for (Book book : books) {
            if (book.getCodeType().equals(codeType)) {
                total += book.getQuantity();
            }
        }
        return total;
    }

    @Override
    public boolean checkQuantityBooks(ArrayList<Book> cart , int quantity , int index) {
       if (cart.get(index).getQuantity() >= quantity) {
           return true;
       }
       return false;
    }

    @Override
    public void saleBook(ArrayList<Book> cart , int idUser) {
        int index ;
        int quantity;
        for (int i = 0; i < cart.size(); i++) {
            index = getIndexBooks(cart.get(i).getCodeBook());
            quantity = cart.get(i).getQuantity();
            books.get(index).setQuantity(books.get(index).getQuantity() - quantity);
            readAnhWriteDataLibrary.writeDataLibrary(books);
        }
        salesBook.put(idUser,cart);
        readAndWriteDataSell.writeDataSell(salesBook);
    }





    @Override
    public void printInvoice(ArrayList<Book> cart) {
        double total = 0;
        String formatTable = "| %-7s | %-21s | %-8d | %-10.2f | %-12.2f |%n" ;
        System.out.format("+---------+-----------------------+----------+------------+--------------+%n");
        System.out.format("| Mã Sách | Tên Sản Phẩm          | Số Lượng | Đơn Giá    | Thành Tiền   |%n");
        System.out.format("+---------+-----------------------+----------+------------+--------------+%n");
        for (int i = 0; i < cart.size(); i++) {
            System.out.format(formatTable, cart.get(i).getCodeBook(), cart.get(i).getName(), cart.get(i).getQuantity(), cart.get(i).getPrice()
            ,(cart.get(i).getQuantity() * cart.get(i).getPrice()));
            total += (cart.get(i).getQuantity() * cart.get(i).getPrice());
        }

        System.out.format("+---------+-----------------------+----------+------------+--------------+%n");
        System.out.println("TỔNG TIỀN ĐƠN HÀNG : " + total);
    }

    @Override
    public HashMap<Integer, ArrayList<Book>> getSaleBook() {
        return readAndWriteDataSell.readDataSell();
    }

    @Override
    public int getQuantityByCodeSell(String code) {
        Set<Integer> keys = salesBook.keySet();
        int quantity = 0;
        for (Integer key : keys) {
            for (Book book : salesBook.get(key)) {
                if (book.getCodeBook().equals(code)) {
                    quantity += book.getQuantity();
                    return quantity;
                }
            }
        }
        return -1;
    }


}
