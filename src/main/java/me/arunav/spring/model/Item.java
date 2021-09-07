package me.arunav.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ITEM")
public class Item {

    @Id
    private int id;
    private String name;
    private double price;
    private int quantity;

    @Transient
    private double total;

    public Item(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Item() {
    }

    public Item(int id, String name, double price, int quantity, double value) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.total = value;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", value=" + total +
                '}';
    }

}
