package br.com.faluz.productapi.repository;

import java.util.List;

import br.com.faluz.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select p "
            + "from product p "
            + "join category c on p.category.id = c.id "
            + "where c.id = :categoryId ")
    public List<Product> getProductByCategory(@Param("categoryId") long categoryId);

    public Product findByProductIdentifier(String productIdentifier);

}
