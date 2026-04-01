package Springboot_CRUD;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class Product_Controller {

    private final Product_Service ps;

    public Product_Controller(Product_Service ps) {
        this.ps = ps;
    }

    // CREATE
    @PostMapping("/add")
    public Product addproduct(@RequestBody Product product) {
        return ps.addproduct(product);
    }

    // READ - Get All
    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return ps.getAllProducts();
    }

    // READ - Get By ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return ps.getProductById(id);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable Long id,
                                 @RequestBody Product product) {
        return ps.updateProduct(id, product);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        ps.deleteProduct(id);
        return "Product deleted successfully!";
    }
}