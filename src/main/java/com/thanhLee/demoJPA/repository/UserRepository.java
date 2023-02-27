package com.thanhLee.demoJPA.repository;

import com.thanhLee.demoJPA.dto.UserDTO;
import com.thanhLee.demoJPA.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity,Integer> {
    List<UsersEntity> findByEmailAndPassword (String email , String password ) ;

    @Query("from users u")
    List <UsersEntity> getAllUsers ( );

    @Query("select u  from users u join roles r on u.roles.id = r.id where u.email= ?1 and r.name = ?2 ")
    List <UsersEntity> getUsersEntitiesByEmailAndRolesName (String email ,String roleName );
}
