package com.example.demo3.repo;

import com.example.demo3.EntityManagerProvider;
import com.example.demo3.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductRepo {

    private static EntityManager entityManager= EntityManagerProvider.getEntityManager();

    public static void saveProduct(Product product) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(product);
        transaction.commit();
    }

    public static void updateProduct(Product product) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(product);
        transaction.commit();
    }

    public static void deleteProduct(Product product) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(product);
        transaction.commit();
    }

    public static Product findProductById(int productId) {
        return entityManager.find(Product.class, productId);
    }

    public static List<Product> findAllProducts() {
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p", Product.class);
        return query.getResultList();
    }
}
