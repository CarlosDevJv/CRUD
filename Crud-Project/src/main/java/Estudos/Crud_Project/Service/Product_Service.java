package Estudos.Crud_Project.Service;

import Estudos.Crud_Project.DTO.ProductDTO;
import Estudos.Crud_Project.Model.Product_Model;
import Estudos.Crud_Project.Repository.Product_Repository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

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

    public Optional<Product_Model> getId(Integer Id){
        return productRepository.findById(Id);
    }

    public void delete(Integer Id){
        productRepository.deleteById(Id);
    }

    public Product_Model update(Integer Id,ProductDTO productDTO){
        Product_Model productModel = productRepository.findById(Id).orElseThrow();
        BeanUtils.copyProperties(productDTO, productModel);
        return productRepository.save(productModel);
    }
}
