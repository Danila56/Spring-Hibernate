package com.service.impl;


import com.dao.UserDAO;
import com.model.Role;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("UserDeteilsService")
public class MyUserServiceDeteilsImpl implements UserDetailsService {
    @Autowired
    private UserDAO userDAO;
    @Transactional
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(s);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
        return buildUserForAutoIntification(user, authorities);
    }

//    Преобразовали user'а в user'а SpringSecurity
    private UserDetails buildUserForAutoIntification(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(List<Role> roles) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (Role role: roles){
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        List<GrantedAuthority> list = new ArrayList<>(authorities);
        return list;
    }
}
