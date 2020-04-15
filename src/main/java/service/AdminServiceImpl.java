package service;

import entity.Product;
import entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utility.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import entity.*;

public class AdminServiceImpl implements AdminService {
    private EntityManager entityManager;

    {
        entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public int addProduct(Product product) {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        return product.getId();
    }

    @Override
    public Product getProductById(int productId) {
        Product product = entityManager.find(Product.class, productId);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> root = cq.from(Product.class);
        cq.select(root);
        TypedQuery<Product> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void editProduct(long id, Product product) {
        entityManager.getTransaction().begin();
        Product prod = entityManager.find(Product.class, id);
        prod.setPrice(product.getPrice());
        prod.setDescription(product.getDescription());
        prod.setName(product.getName());
        prod.setQuantity(product.getQuantity());
        prod.setCategories(product.getCategories());
        prod.setCartProductsById(product.getCartProductsById());
        entityManager.merge(prod);
        entityManager.getTransaction().commit();


    }

    @Override
    public void deleteProduct(long id) {
        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, id);
        entityManager.remove(product);
        entityManager.getTransaction().commit();
    }

    @Override
    public User viewCustomerProfile(int userId) {
        User user = entityManager.find(User.class, userId);
        return user;
    }
}
