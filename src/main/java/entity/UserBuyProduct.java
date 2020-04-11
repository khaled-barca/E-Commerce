package entity;

import javax.persistence.*;

@Entity
@Table(name = "user_buy_product")
@AssociationOverrides({
        @AssociationOverride(name = "pk.USER",
                joinColumns = @JoinColumn(name = "user_id")),
        @AssociationOverride(name = "pk.category",
                joinColumns = @JoinColumn(name = "product")) })
public class UserBuyProduct implements java.io.Serializable {
    private  UserProductID pk = new UserProductID();
    private int quantity ;

    public UserBuyProduct() {
    }

    @EmbeddedId
    public UserProductID getPk() {
        return pk;
    }

    public void setPk(UserProductID pk) {
        this.pk = pk;
    }

    @Transient
    public User getUser() {
        return getPk().getUser();
    }

    public void setUser(User user) {
        getPk().setUser(user);
    }

    @Transient
    public Product getProduct() {
        return getPk().getProduct();
    }

    public void setProduct(Product product) {
        getPk().setProduct(product);
    }

    @Column(name = "Quantity_OF_Product", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        UserBuyProduct that = (UserBuyProduct) o;

        if (getPk() != null ? !getPk().equals(that.getPk())
                : that.getPk() != null)
            return false;

        return true;
    }

    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }

}