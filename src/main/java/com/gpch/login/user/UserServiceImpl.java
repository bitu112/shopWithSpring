package com.gpch.login.user;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;
    @Autowired
    public UserServiceImpl(UserRepository userRepository,BCryptPasswordEncoder bCryptPasswordEncoder,UserDetailsService userDetailsService,AuthenticationManager authenticationManager){
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
    }
    @Override
    public void save(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
    @Override
    public void login(String username,String password){
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        if(token.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(token);
        }
    }
    @Override
    public  User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    @Override
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    @Override
    public User findById(long id){
        return userRepository.findById(id);
    }
}
