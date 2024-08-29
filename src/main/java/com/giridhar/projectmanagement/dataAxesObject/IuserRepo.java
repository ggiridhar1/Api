package com.giridhar.projectmanagement.dataAxesObject;

import com.giridhar.projectmanagement.entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//<OBJECT and @ID TYPE>
public interface IuserRepo extends CrudRepository<Users, Long> {
    @Override
    public List<Users> findAll();
}
