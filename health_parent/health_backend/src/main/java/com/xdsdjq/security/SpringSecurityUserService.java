package com.xdsdjq.security;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xdsdjq.entity.Result;
import com.xdsdjq.pojo.Permission;
import com.xdsdjq.pojo.Role;
import com.xdsdjq.pojo.User;
import com.xdsdjq.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class SpringSecurityUserService implements UserDetailsService {

    @Reference
    private UserService userService;

    //由SpringSecurity自动调用
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if (user == null) {
            //用户不存在
            return null;
        }
        List<GrantedAuthority> list = new ArrayList<>();
        Set<Role> roles = user.getRoles();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority(role.getKeyword()));
            Set<Permission> permissions = role.getPermissions();
            for (Permission permission : permissions) {
                String keyword = permission.getKeyword();
                list.add(new SimpleGrantedAuthority(keyword));
            }
        }
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(username,user.getPassword(), list);
        return userDetails;
    }

}
