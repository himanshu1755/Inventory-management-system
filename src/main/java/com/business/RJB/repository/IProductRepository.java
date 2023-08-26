package com.business.RJB.repository;


import com.business.RJB.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Products, Long> {

//	@Modifying
//	@Query("delete from EitAsset where locId = ?1 ")
//	public void removeByLocationId(String LocationID);

}
