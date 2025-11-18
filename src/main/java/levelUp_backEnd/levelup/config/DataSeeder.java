package levelUp_backEnd.levelup.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import levelUp_backEnd.levelup.model.Product;
import levelUp_backEnd.levelup.repository.ProductRepository;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(ProductRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new Product(null, "Catán", "Juego de estrategia para 3-4 jugadores.", 29990, "/assets/img/catan.png", "juegos", 12));
                repo.save(new Product(null, "Carcassonne", "Juego de colocación de fichas para 2-5 jugadores.", 24990, "/assets/img/carcassonne.webp", "juegos", 8));
                repo.save(new Product(null, "Control Xbox Series X", "Control inalámbrico para Xbox y PC.", 59990, "/assets/img/control-xbox.webp", "accesorios", 20));
                repo.save(new Product(null, "Auriculares HyperX Cloud II", "Sonido envolvente con micrófono desmontable.", 24990, "/assets/img/hyperxCloudII.webp", "accesorios", 15));
                repo.save(new Product(null, "Play Station 5", "Consola de última generación de Sony.", 549990, "/assets/img/ps5.jpg", "consolas", 5));
                repo.save(new Product(null, "PC Gamer ASUS ROG", "Computadora gamer potente.", 1299990, "/assets/img/ROGSTRIX.png", "consolas", 2));
                repo.save(new Product(null, "Silla Gamer Secretlab Titan", "Máxima comodidad y soporte ergonómico.", 349990, "/assets/img/silla-gamer.jpg", "accesorios", 0));
                repo.save(new Product(null, "Mouse Logitech G502 HERO", "Sensor óptico y 11 botones programables.", 49990, "/assets/img/mouse-logitech.jpg", "accesorios", 13));
                repo.save(new Product(null, "Mousepad Razer Chroma", "Superficie microtexturizada con iluminación RGB.", 29990, "/assets/img/mousepad-razer.webp", "accesorios", 7));
                repo.save(new Product(null, "Polera Level-Up", "Polera de algodón personalizada para gamers.", 14990, "/assets/img/polera-gamer.png", "ropa", 25));
            }
        };
    }
}