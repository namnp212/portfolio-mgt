package com.namnp.portfolio_service.service;

import com.namnp.portfolio_service.model.User;
import com.namnp.portfolio_service.model.UserPrincipal;
import com.namnp.portfolio_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if(user == null){
            System.out.println("User 404: " + username);
            throw new UsernameNotFoundException("User 404: " + username);
        }
        return new UserPrincipal(userRepository.findByUserName(username));
    }
}
