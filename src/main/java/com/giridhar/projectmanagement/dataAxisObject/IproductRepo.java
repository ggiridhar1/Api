package com.giridhar.projectmanagement.dataAxisObject;

import com.giridhar.projectmanagement.entity.Products;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
//extend to crud repo for entity class name+ ID variable
public interface IproductRepo extends CrudRepository<Products, Long> {
   @Override
   public List<Products> findAll();
}
