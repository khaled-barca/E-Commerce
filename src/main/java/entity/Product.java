package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Product implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private int quantity;
    private int price;
    private String image;
    private Set<CartProduct> cartProductsById = new HashSet<>();
    private Set<Category> categories = new HashSet<Category>(0);
    private Set<UserBuyProduct> userBuyProductsById = new HashSet<>();

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 40)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 100)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Basic
    @Column(name = "image", nullable = false, length = 100)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @OneToMany(mappedBy = "pk.product")
    public Set<CartProduct> getCartProductsById() {
        return cartProductsById;
    }

    public void setCartProductsById(Set<CartProduct> cartProductsById) {
        this.cartProductsById = cartProductsById;
    }

    @ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.ALL})
    @JoinTable(name = "product_category", joinColumns = {
            @JoinColumn(name = "product_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "category_id")
    })
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @OneToMany(mappedBy = "pk.product")
    public Set<UserBuyProduct> getUserBuyProductsById() {
        return userBuyProductsById;
    }

    public void setUserBuyProductsById(Set<UserBuyProduct> userBuyProductsById) {
        this.userBuyProductsById = userBuyProductsById;
    }
}
