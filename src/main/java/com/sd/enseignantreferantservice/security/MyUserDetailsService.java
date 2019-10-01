package com.sd.enseignantreferantservice.security;

import com.sd.enseignantreferantservice.business.serviceInterface.EnseignantReferentService;
import com.sd.enseignantreferantservice.model.EnseignantReferent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    EnseignantReferentService enseignantReferentService;

    @Override
    public UserDetails loadUserByUsername(String identifiant) throws UsernameNotFoundException {
        EnseignantReferent ensRef = enseignantReferentService.getByIdentifiant(identifiant);
        if (ensRef == null) {
            throw new UsernameNotFoundException(identifiant);
        }
        return new MyUserDetails(ensRef);
    }
}
