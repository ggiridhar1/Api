package com.giridhar.projectmanagement.dataAxisObject;

import com.giridhar.projectmanagement.dto.UserProduct;
import com.giridhar.projectmanagement.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.giridhar.projectmanagement.dto.UserProduct;
import java.util.List;

//<OBJECT and @ID TYPE>
public interface IuserRepo extends CrudRepository<Users, Long> {
    @Override
    public List<Users> findAll();

    //Custom query
    @Query(nativeQuery = true,value = "select u.name as Name,u.phone_number as PhoneNumber,count(pu.product_id) as MappedProduct from users u left join product_user as pu on u.user_id =pu.user_id group by u.name,u.phone_number;")
    public List<UserProduct> userProducts();
}
