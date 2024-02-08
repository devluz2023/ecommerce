package br.com.faluz.shoppingapi.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import br.com.faluz.shoppingapi.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>, ReportRepository {

    List<Shop> findAllByUserIdentifier(String userIdentifier);

    List<Shop> findAllByTotalGreaterThan(Float total);

    List<Shop> findAllByDateGreaterThan(LocalDateTime date);

}
