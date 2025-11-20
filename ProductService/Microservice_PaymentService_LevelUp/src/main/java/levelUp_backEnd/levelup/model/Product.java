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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;

    @Column(nullable = true, length = 2000)
    private String description;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = true)
    private String img;

    @Column(nullable = true)
    private String category;

    @Column(nullable = false)
    private Integer stock;
}