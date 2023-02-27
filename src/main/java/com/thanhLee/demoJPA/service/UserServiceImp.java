package com.thanhLee.demoJPA.service;

import com.thanhLee.demoJPA.dto.UserDTO;
import com.thanhLee.demoJPA.entity.RolesEntity;
import com.thanhLee.demoJPA.entity.UsersEntity;
import com.thanhLee.demoJPA.payload.LoginRequest;
import com.thanhLee.demoJPA.repository.UserRepository;
import com.thanhLee.demoJPA.service.imp.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDTO> getUserByEmailAndPassword(String email, String password) {
        List<UsersEntity> usersEntityList = userRepository.findByEmailAndPassword(email, password);
        List<UserDTO> userDTOList = new ArrayList<>();
        for (UsersEntity data : usersEntityList
        ) {
            userDTOList.add(new UserDTO( data.getEmail(), data.getPassword(), data.getFullname(), data.getAvatar()));
        }

        return userDTOList;

    }

    public UsersEntity saveToDatabase(UsersEntity usersEntity) {
        return userRepository.save(usersEntity);
    }

    @Override
    public boolean login(LoginRequest loginRequest) {
        return userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword()).size() > 0;
    }

    @Override
    public boolean insertUser(UserDTO userDTO) {
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setEmail(userDTO.getEmail());
        usersEntity.setAvatar(userDTO.getAvatar());
        usersEntity.setPassword(userDTO.getPassword());
        usersEntity.setFullname(userDTO.getFullname());

        RolesEntity rolesEntity = new RolesEntity();
        rolesEntity.setId(userDTO.getRoleId() );
        usersEntity.setRoles(rolesEntity);

        try
        {

            userRepository.save(usersEntity);
            return true ;
        }catch (Exception e )
        {
            return false ;
        }

    }

    @Override
    public List<UserDTO> getAllUsers() {
        List <UserDTO> userDTOList= new ArrayList<>();
        for (UsersEntity data :userRepository.getAllUsers()
             ) {
            UserDTO userDTO = new UserDTO();
            userDTO.setEmail(data.getEmail());
            userDTO.setAvatar(data.getAvatar());
            userDTO.setPassword(data.getPassword());
            userDTO.setFullname(data.getFullname());
            userDTOList.add(userDTO) ;
        }
        return userDTOList;
    }

    @Override
    public List<UserDTO> getUsersEntitiesByEmailAndRolesName(String email, String roleName) {

        List <UserDTO> userDTOList= new ArrayList<>();
        for (UsersEntity data :userRepository.getUsersEntitiesByEmailAndRolesName(email,roleName)
        ) {
            UserDTO userDTO = new UserDTO();
            userDTO.setEmail(data.getEmail());
            userDTO.setAvatar(data.getAvatar());
            userDTO.setPassword(data.getPassword());
            userDTO.setFullname(data.getFullname());
            userDTOList.add(userDTO) ;
        }
        return userDTOList;

    }


}
