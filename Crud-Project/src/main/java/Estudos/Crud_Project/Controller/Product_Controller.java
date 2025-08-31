package Estudos.Crud_Project.Controller;

import Estudos.Crud_Project.DTO.ProductDTO;
import Estudos.Crud_Project.Model.Product_Model;
import Estudos.Crud_Project.Service.Product_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

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

    @PostMapping("/cadastre") //Cadastrar produto
    public ResponseEntity<Product_Model> create(@RequestBody ProductDTO productDTO){
        Product_Model createdProduct = productService.create(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

}
