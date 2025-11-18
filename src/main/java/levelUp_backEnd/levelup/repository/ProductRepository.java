package levelUp_backEnd.levelup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import levelUp_backEnd.levelup.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}