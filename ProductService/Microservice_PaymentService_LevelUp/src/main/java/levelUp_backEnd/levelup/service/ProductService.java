package levelUp_backEnd.levelup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import levelUp_backEnd.levelup.model.Product;
import levelUp_backEnd.levelup.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public Product descontarStock(Long id, int cantidad) {
        Product p = findById(id);
        if (p.getStock() < cantidad) {
            throw new IllegalArgumentException("Stock insuficiente");
        }
        p.setStock(p.getStock() - cantidad);
        return productRepository.save(p);
    }
}