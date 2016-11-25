package com.hr.securitylab.database.models;

import com.hr.securitylab.database.models.entities.User;
import com.hr.securitylab.database.models.dao.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service("userAccount")
public class UserAccount implements UserDetailsService
{
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        try
        {
            User user = userService.findUsername(username);
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
        }
        catch (Exception e)
        {
            throw new UsernameNotFoundException("Username doesn't exist");
        }
    }

    // Authorities tabel for different roles still to be added.
    private Set<GrantedAuthority> getAuthorities(User user)
    {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRole());
        authorities.add(grantedAuthority);
        return authorities;
    }




}
