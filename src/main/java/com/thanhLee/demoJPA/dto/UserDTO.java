package com.thanhLee.demoJPA.dto;

public class UserDTO {


    private String email ;
    private String password ;
    private String fullname ;
    private String avatar ;

    private int roleId ;

    public UserDTO() {

    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public UserDTO(String email, String password, String fullname, String avatar) {

        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.avatar = avatar;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
