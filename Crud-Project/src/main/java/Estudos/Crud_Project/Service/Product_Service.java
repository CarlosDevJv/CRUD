package Estudos.Crud_Project.Service;

import Estudos.Crud_Project.DTO.ProductDTO;
import Estudos.Crud_Project.Model.Product_Model;
import Estudos.Crud_Project.Repository.Product_Repository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class   Product_Service {
    @Autowired
    private Product_Repository productRepository;

    private final ProductDTO productDTO;

    public Product_Service(ProductDTO productDTO){
        this.productDTO = productDTO;
    }


    public List<Product_Model> GetAll(){
        return productRepository.findAll();
    }

    public Product_Model create(ProductDTO productDTO){
        Product_Model product = new Product_Model();
        BeanUtils.copyProperties(productDTO, product);
        return productRepository.save(product);
    }

}
