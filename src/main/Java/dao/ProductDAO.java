package dao;

import org.springframework.stereotype.Component;
import Java.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Component
public class ProductDAO {
    private final List<Product> repository = new ArrayList<>();

    public List<Product> index() {
        return repository;
    }

    public Product getById(int id) {
        return repository.stream().filter(e -> e.getId() == id).findAny().orElse(null);
    }

    public void save(Product product) {
        product.setId();
        repository.add(product);
    }

    public void update(int id, Product updatedProduct) {
        Optional<Product> optionalProduct = repository.stream().filter(e -> e.getId() == id).findAny();
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(updatedProduct.getName());
            product.setCost(updatedProduct.getCost());
        }
    }

    public boolean delete(int id) {
       return repository.removeIf(e -> e.getId() == id);
    }

    public boolean isEmpty() {
        return repository.isEmpty();
    }
}
