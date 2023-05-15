package Nibm.lk.PitzzaShop.MODEL;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PRODUCT")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @OneToMany(mappedBy = "product")
    private List<BasketItem> basketItems;

    @Column(name = "Name")
    private String Name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    @Column(name = "Size")
    private  String Size;

    @Column(name = "Price")
    private  Double Price;


    public void setBasketItems(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
    }
}
