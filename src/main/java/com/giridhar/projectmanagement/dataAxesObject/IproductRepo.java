package com.giridhar.projectmanagement.dataAxesObject;

import com.giridhar.projectmanagement.entity.Products;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IproductRepo extends CrudRepository<Products, Long> {
   @Override
   public List<Products> findAll();
}
