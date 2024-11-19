package com.guillermodelamora.portafolioPersonal.security;

import com.guillermodelamora.portafolioPersonal.entity.User;
import com.guillermodelamora.portafolioPersonal.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    UserServiceImpl userService;

    private Optional<User> userDetail;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Dentro de loadUserByUsername", username);
        userDetail = userService.getUserByUsername(username); // userDAO.findByEmail(username);

        if (!Objects.isNull(userDetail)) {
            return new org.springframework.security.core.userdetails.User(
                    userDetail.get().getEmail(),
                    userDetail.get().getPassword(),
                    new ArrayList<>()
            );
        } else {
            throw  new UsernameNotFoundException("User no encontrado");
        }
    }

    public Optional<User> getUserDetail() {
        return userDetail;
    }
}
