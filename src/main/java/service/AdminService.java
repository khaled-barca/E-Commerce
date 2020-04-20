package service;

import entity.Category;
import entity.Product;
import entity.User;
import exceptions.ProductAlreadyExistsException;

import java.util.List;

public interface AdminService extends UserService{
    int addProduct(Product product) throws ProductAlreadyExistsException;;
    Product getProductById(int productId);
    List<Product> getAllProducts();
    List<Category> getCategoriesByIds(List<Integer> categoryIds);
    List<Category> getAllCategories();
    void editProduct(int productId, Product product) throws ProductAlreadyExistsException;
    void editProduct(Product product) throws ProductAlreadyExistsException;
    int deleteProduct(int productId);
    User viewCustomerProfile(int userId);
     //int deleteCategory(int parseInt);
    int addCategory(Category category);
}
