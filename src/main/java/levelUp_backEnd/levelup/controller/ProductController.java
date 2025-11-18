package levelUp_backEnd.levelup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.Parameter;

import levelUp_backEnd.levelup.model.Product;
import levelUp_backEnd.levelup.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "http://localhost:5173")
@Tag(name = "Products", description = "Operaciones CRUD de productos")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @Operation(summary = "Listar productos", description = "Obtiene la lista de productos disponibles")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista recuperada exitosamente",
            content = @Content(mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = Product.class)))),
        @ApiResponse(responseCode = "204", description = "Sin contenido")
    })
    public ResponseEntity<List<Product>> list() {
        List<Product> products = productService.listAll();
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @PostMapping
    @Operation(summary = "Crear producto", description = "Crea un nuevo producto")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Producto creado",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Product.class))),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    public ResponseEntity<Product> save(@RequestBody Product product) {
        Product created = productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener producto por ID", description = "Devuelve un producto dado su ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Producto encontrado",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Product.class))),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    public ResponseEntity<Product> get(@PathVariable @Parameter(description = "ID del producto", example = "1") Long id) {
        try {
            Product product = productService.findById(id);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar producto", description = "Actualiza un producto existente")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Producto actualizado",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Product.class))),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    public ResponseEntity<Product> update(@PathVariable @Parameter(description = "ID del producto", example = "1") Long id, @RequestBody Product product) {
        try {
            Product existing = productService.findById(id);
            existing.setName(product.getName());
            existing.setDescription(product.getDescription());
            existing.setPrice(product.getPrice());
            existing.setImg(product.getImg());
            existing.setCategory(product.getCategory());
            existing.setStock(product.getStock());
            Product saved = productService.save(existing);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar producto", description = "Elimina un producto por ID")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Eliminado"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    public ResponseEntity<?> delete(@PathVariable @Parameter(description = "ID del producto", example = "1") Long id) {
        try {
            productService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/descontar/{id}/{cantidad}")
    public ResponseEntity<String> descontar(@PathVariable Long id, @PathVariable int cantidad) {
        try {
            productService.descontarStock(id, cantidad);
            return ResponseEntity.ok("Stock actualizado");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(500).body("Error al descontar stock");
        }
    }
}