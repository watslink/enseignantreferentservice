package com.sd.enseignantreferantservice.security;


import com.sd.enseignantreferantservice.model.EnseignantReferent;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MyUserDetails implements UserDetails {

    private EnseignantReferent enseignantReferent;

    public MyUserDetails(EnseignantReferent enseignantReferent) {
        this.enseignantReferent = enseignantReferent;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("User"));
        return authorities;
    }

    @Override
    public String getPassword() {
        return enseignantReferent.getMotDePasse();
    }

    @Override
    public String getUsername() {
        return enseignantReferent.getIdentifiant();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enseignantReferent.isEnabled();
    }
}
