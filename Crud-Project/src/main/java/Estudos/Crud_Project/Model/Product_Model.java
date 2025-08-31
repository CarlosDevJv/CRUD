package Estudos.Crud_Project.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Iterator;

@Entity(name = "product")
@Table(name = "product")
@EqualsAndHashCode(of = "Id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product_Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String name;
    private Long price;
    private Date date;
}
