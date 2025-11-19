package levelUp_backEnd.levelup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import levelUp_backEnd.levelup.model.Product;

@Repository
/**
 * Repositorio JPA para la entidad {@link Product}.
 * Proporciona operaciones CRUD y consultas derivadas sobre la tabla {@code product}.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}