package com.devsuperior.dscommerce.factory;

import com.devsuperior.dscommerce.projections.UserDetailsProjection;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsFactory {

    public static List<UserDetailsProjection> createCustomClientUser(String userName){

        List<UserDetailsProjection> list = new ArrayList<>();
        list.add(new UserDetailsImpl(userName, "123", 1L, "ROLE_CLIENT"));
        return list;

    }

    public static List<UserDetailsProjection> createCustomAdmintUser(String userName){

        List<UserDetailsProjection> list = new ArrayList<>();
        list.add(new UserDetailsImpl(userName, "123", 2L, "ROLE_ADMIN"));
        return list;

    }

    public static List<UserDetailsProjection> createCustomAdminClientUser(String userName){

        List<UserDetailsProjection> list = new ArrayList<>();
        list.add(new UserDetailsImpl(userName, "123", 1L, "ROLE_CLIENT"));
        list.add(new UserDetailsImpl(userName, "123", 2L, "ROLE_ADMIN"));
        return list;

    }
}

class UserDetailsImpl implements UserDetailsProjection {

    private String userName;
    private String password;
    private Long roleId;
    private String authority;

    public UserDetailsImpl(){}

    public UserDetailsImpl(String userName, String password, Long roleId, String authority) {
        this.userName = userName;
        this.password = password;
        this.roleId = roleId;
        this.authority = authority;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Long getRoleId() {
        return roleId;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}


