package Estudos.Crud_Project.Repository;

import Estudos.Crud_Project.Model.Product_Model;
import Estudos.Crud_Project.DTO.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Product_Repository extends JpaRepository<Product_Model, Integer > {
}
