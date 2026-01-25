package org.example.recs_shreyoshi.services;



import org.example.recs_shreyoshi.models.CustomUserDetails;
import org.example.recs_shreyoshi.models.User;
import org.example.recs_shreyoshi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;



//    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
//
//        User user = userRepository.findByEmail(email);   // still called username here by Spring
//
//
//        return new org.springframework.security.core.userdetails.User(
//                user.getEmail(),
//                user.getPassword(),
//                Collections.singleton(user::getRole)
//        );
//    }

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//
//        return new org.springframework.security.core.userdetails.User(
//                user.getEmail(),
//                user.getPassword(),
//                getAuthorities(user.getRole())
//        );
//    }
//
//    private List<GrantedAuthority> getAuthorities(Role role) {
//        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
//    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new CustomUserDetails(user);
    }



}
