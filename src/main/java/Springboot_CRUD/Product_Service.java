package Springboot_CRUD;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Product_Service {
    
    private final ProductRepository pr;
    
    public Product_Service(ProductRepository pr) {
        this.pr = pr;
    }
    
    // CREATE
    public Product addproduct(Product product) {
        return pr.save(product);
    }

    // READ - Get All
    public List<Product> getAllProducts() {
        return pr.findAll();
    }

    // READ - Get By ID
    public Product getProductById1(Long id) {
        return pr.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
    //retrieve by id
    public Product getProductById(Long id) {
        return pr.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // UPDATE
    public Product updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = pr.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());

        return pr.save(existingProduct);
    }

    // DELETE
    public void deleteProduct(Long id) {
        pr.deleteById(id);
    }
}