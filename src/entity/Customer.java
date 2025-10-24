package entity;

import javax.persistence.*;

@Entity
@Table (name = "customer") // Table name

public class Customer {
    @Id // Primary Key
 //   @GeneratedValue (strategy = GenerationType.AUTO) //  Auto generated id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Keyboard input ekk nan
    private int id;

    @Embedded
    private String name; //Name kiyl dunnma Fist name and Last Name eka gnn thmai meka denne

 //   @Column(name = "Customer_email" , nullable = false)  Column names change krnnn thamai use krnne  / nullable = null wenn bh
    private String email;
    private String phone;

    @Transient // database eke  field ekk (column ekk) hadenne nh database eke nathuw anith wada walata gnnw
    private String visaCardNumber;

    @Lob    //loku unlimited text ekk manage krnw nn
    private String description;

    public Customer() {
    }

    public Customer(int id ,String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void CustomerFullName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
