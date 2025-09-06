package Estudos.Crud_Project.Controller;

import Estudos.Crud_Project.DTO.ProductDTO;
import Estudos.Crud_Project.Model.Product_Model;
import Estudos.Crud_Project.Service.Product_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class Product_Controller {

    @Autowired
    private Product_Service productService;
    private final ProductDTO productDTO;

    public Product_Controller(ProductDTO productDTO){
        this.productDTO = productDTO;
    }


    @GetMapping("/GetAll") //Requisição de lista de todos os produtos
    public ResponseEntity<List<Product_Model>> GetAll(){
        List<Product_Model> getProduct = productService.GetAll();
        return ResponseEntity.status(HttpStatus.OK).body(getProduct);
    }

    @PostMapping("/register") //Cadastrar produto
    public ResponseEntity<Product_Model> create(@RequestBody ProductDTO productDTO){
        Product_Model createdProduct = productService.create(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @GetMapping(path = "/{Id}") // Buscar produto por ID
    public ResponseEntity<?> getID(@PathVariable(value = "Id") Integer Id){
        Optional<Product_Model> product = productService.getId(Id);
        if (product.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(product.get());
    }

    @DeleteMapping(path = "/{Id}") // Deletar produto por ID
    public ResponseEntity<?> deleteId(@PathVariable(value = "Id") Integer Id) {
        Optional<Product_Model> product = productService.getId(Id);
        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND");
        }
        productService.delete(Id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted with Success".toUpperCase());
    }

    @PutMapping(path = "/{Id}")
    public ResponseEntity<?> update(@PathVariable(value = "Id") Integer Id, @RequestBody ProductDTO productDTO){
        Optional<Product_Model> product = productService.getId(Id);
        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND");
        }
        Product_Model UpdateModel = productService.update(Id, productDTO);
        return ResponseEntity.status(HttpStatus.OK).body(UpdateModel);
    }

}
