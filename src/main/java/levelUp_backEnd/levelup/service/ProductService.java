package levelUp_backEnd.levelup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import levelUp_backEnd.levelup.model.Product;
import levelUp_backEnd.levelup.repository.ProductRepository;

@Service
@Transactional
/**
 * Servicio de negocio para la gestión de productos.
 * Orquesta las operaciones CRUD y la lógica de actualización de stock
 * sobre la entidad {@link levelUp_backEnd.levelup.model.Product}.
 */
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Lista todos los productos disponibles.
     * @return colección de productos persistidos
     */
    public List<Product> listAll() {
        return productRepository.findAll();
    }

    /**
     * Busca un producto por su identificador.
     * @param id identificador del producto
     * @return el producto encontrado
     * @throws java.util.NoSuchElementException si no existe el producto
     */
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    /**
     * Persiste o actualiza un producto.
     * @param product entidad de producto a guardar
     * @return producto guardado
     */
    public Product save(Product product) {
        return productRepository.save(product);
    }

    /**
     * Elimina un producto por su identificador.
     * @param id identificador del producto
     */
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    /**
     * Descuenta una cantidad del stock del producto.
     * @param id identificador del producto
     * @param cantidad cantidad a descontar
     * @return producto con el stock actualizado
     * @throws IllegalArgumentException si la cantidad excede el stock disponible
     */
    public Product descontarStock(Long id, int cantidad) {
        Product p = findById(id);
        if (p.getStock() < cantidad) {
            throw new IllegalArgumentException("Stock insuficiente");
        }
        p.setStock(p.getStock() - cantidad);
        return productRepository.save(p);
    }
}