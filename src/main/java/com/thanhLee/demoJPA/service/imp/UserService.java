package com.thanhLee.demoJPA.service.imp;

import com.thanhLee.demoJPA.dto.UserDTO;
import com.thanhLee.demoJPA.entity.UsersEntity;
import com.thanhLee.demoJPA.payload.LoginRequest;
import com.thanhLee.demoJPA.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {
    List<UserDTO> getUserByEmailAndPassword (String email ,String password ) ;
     UsersEntity saveToDatabase(UsersEntity usersEntity);
     boolean login (LoginRequest loginRequest);

     boolean insertUser (UserDTO userDTO) ;

     List <UserDTO> getAllUsers();


     List <UserDTO> getUsersEntitiesByEmailAndRolesName (String email ,String roleName );

}
