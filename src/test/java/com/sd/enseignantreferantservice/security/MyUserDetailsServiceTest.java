package com.sd.enseignantreferantservice.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyUserDetailsServiceTest {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    PasswordEncoder encoder;

    @Test
    public void loadUserByUsername() {
        MyUserDetails myUserDetails = (MyUserDetails)myUserDetailsService.loadUserByUsername("jean.dupont@mail.com");
        assertEquals("jean.dupont@mail.com",myUserDetails.getUsername());
        assertTrue(encoder.matches("motdepasse", myUserDetails.getPassword()));
        assertTrue(myUserDetails.isAccountNonExpired());
        assertTrue(myUserDetails.isAccountNonLocked());
        assertTrue(myUserDetails.isCredentialsNonExpired());
        assertTrue(myUserDetails.isEnabled());
        for (GrantedAuthority grantedAuthority: myUserDetails.getAuthorities()){
            assertEquals("User", grantedAuthority.getAuthority());
        }
}
    @Test (expected = UsernameNotFoundException.class)
    public void loadUserByUsernameWhenMailNotExist() {
        myUserDetailsService.loadUserByUsername("wrong@mail.wrg");
    }
}
