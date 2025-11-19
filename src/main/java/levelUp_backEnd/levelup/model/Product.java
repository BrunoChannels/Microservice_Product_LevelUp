package levelUp_backEnd.levelup.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * Entidad JPA que representa un producto del catálogo.
 * Mapeada a la tabla {@code product}. Usa Lombok para generar
 * automáticamente getters, setters y constructores.
 */
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /** Identificador único del producto (clave primaria). */
    private Long id;
    
    @Column(nullable = false)
    /** Nombre del producto visible para el usuario. */
    private String name;

    @Column(nullable = true, length = 2000)
    /** Descripción extendida del producto (opcional). */
    private String description;

    @Column(nullable = false)
    /** Precio expresado en moneda local sin formato (entero). */
    private Integer price;

    @Column(nullable = true)
    /** Ruta de la imagen del producto (opcional). */
    private String img;

    @Column(nullable = true)
    /** Categoría a la que pertenece el producto (opcional). */
    private String category;

    @Column(nullable = false)
    /** Stock disponible actual del producto. */
    private Integer stock;
}