package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_buy_product", schema = "ecommerce")
@AssociationOverrides({
        @AssociationOverride(name = "pk.product",
                joinColumns = @JoinColumn(name = "product_id")),
        @AssociationOverride(name = "pk.buyer",
                joinColumns = @JoinColumn(name = "buyer_id")) })
public class UserBuyProduct implements Serializable {
    private Integer quantity;
    private UserBuyProductPK pk = new UserBuyProductPK();

    @EmbeddedId
    public UserBuyProductPK getPk() {
        return pk;
    }

    public void setPk(UserBuyProductPK pk) {
        this.pk = pk;
    }

    @Transient
    public Product getProduct() {
        return getPk().getProduct();
    }

    @Transient
    public Buyer getBuyer() {
        return getPk().getBuyer();
    }

    public void setBuyer(Buyer buyer) {
        getPk().setBuyer(buyer);
    }

    public void setProduct(Product product) {
        getPk().setProduct(product);
    }



    @Basic
    @Column(name = "quantity", nullable = false)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }



}
