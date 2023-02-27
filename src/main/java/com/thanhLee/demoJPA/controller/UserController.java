package com.thanhLee.demoJPA.controller;

import com.thanhLee.demoJPA.dto.UserDTO;
import com.thanhLee.demoJPA.entity.RolesEntity;
import com.thanhLee.demoJPA.entity.UsersEntity;
import com.thanhLee.demoJPA.payload.LoginRequest;
import com.thanhLee.demoJPA.service.imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
//

//    @GetMapping ("/add")
//    public ResponseEntity<?> addUser (@RequestBody UsersEntity usersEntity)
//    {
//
//        RolesEntity rolesEntity = new RolesEntity();
//        rolesEntity.setId(2);
//        rolesEntity.setName("test");
//        rolesEntity.setDescription("test desc");
//        usersEntity.setRoles(rolesEntity);
//
//        userService.saveToDatabase(usersEntity);
//        return new ResponseEntity<>(null,HttpStatus.OK);
//    }
    @PostMapping("")
    public ResponseEntity<?> login (@RequestBody LoginRequest loginRequest)
    {
        return new ResponseEntity<>(userService.login(loginRequest),HttpStatus.OK) ;
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveUser (@RequestBody UserDTO userDTO)
    {
        return new ResponseEntity<>(userService.insertUser(userDTO),HttpStatus.OK) ;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllUser ( )
    {
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK) ;
    }

    @GetMapping("/getByEmailAndRoleName")
    public ResponseEntity<?> getAllUserByEmailAndRoleName (
            @RequestParam ("email")String email ,
            @RequestParam ("roleName") String roleName )
    {
        return new ResponseEntity<>(userService.getUsersEntitiesByEmailAndRolesName(email ,roleName),HttpStatus.OK) ;
    }
}
