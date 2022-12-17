package com.github.juliavasconcelos161.clients.service;

import com.github.juliavasconcelos161.clients.exception.RegistratedClientException;
import com.github.juliavasconcelos161.clients.model.entities.UserLogin;
import com.github.juliavasconcelos161.clients.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    public UserLogin saveUser(UserLogin userLogin)
    {
        boolean exists = repository.existsByUsername(userLogin.getUsername());
        if(exists)
        {
            throw new RegistratedClientException(userLogin.getUsername());
        }
        return repository.save(userLogin);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        UserLogin userLogin = repository
                        .findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));
        return User
                .builder()
                .username(userLogin.getUsername())
                .password(userLogin.getPassword())
                .roles("USER")
                .build();
    }
}
