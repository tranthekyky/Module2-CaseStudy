package model;

import login.Login;

public class Customer extends User {
    private int id;
    private String email;
    private String numberPhone;
    private String address;

    private static int count = 1;
    public Customer( String name, Login account, String email, String numberPhone, String address) {
        super(name, account);
        this.id = count++;
        this.email = email;
        this.numberPhone = numberPhone;
        this.address = address;
    }
    public Customer(String name ,String email, String numberPhone, String address) {
        super(name);
        this.id = count++;
        this.email = email;
        this.numberPhone = numberPhone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Customer.count = count;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Khách hàng [ " +
                "ID = '" + id + '\'' +
                " Tên = '" + super.getName() + '\'' +
                " Email = '" + email + '\'' +
                ", Số điện thoại = '" + numberPhone + '\'' +
                ", Địa chỉ = '" + address + '\'' +
                ']';
    }
}
