package com.example.task_management.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.task_management.entities.User;

import com.example.task_management.repositories.UserRepository;
/* Spring security understands UserDetails not my custom user.
This service tells Spring: when you give me a username I know how to find the user  */
@Service
public class CustomUserDetailsService implements UserDetailsService{
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    // this method will be called in login 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username) // search user in database
                    .orElseThrow(()->new UsernameNotFoundException("User not found"));
        return new CustomUserDetails(user); // basically transform database user to CustomUserDetails
    }
    
}
