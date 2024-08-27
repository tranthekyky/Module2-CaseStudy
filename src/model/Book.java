package model;

public class Book {
    private String codeBook;
    private String name;
    private String author;
    private double price;
    private int quantity;
    private String codeType ;
    public Book(String codeBook, String name, String author, double price, int quantity , String codeType) {
        this.codeBook = codeBook;
        this.name = name;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
        this.codeType = codeType;

    }

    public String getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(String codeBook) {
        this.codeBook = codeBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getCodeType() {
        return codeType;
    }
    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    @Override
    public String toString() {
        return "Book [" +
                " Code = '" + codeBook + '\'' +
                ", Name = '" + name + '\'' +
                ", Author = '" + author + '\'' +
                ", Price = " + price +
                ", Quantity = " + quantity +
                ", Type = " + codeType +
                ']';
    }
}
