package org.example.blogginapi.Security;

import lombok.RequiredArgsConstructor;
import org.example.blogginapi.Repository.userRepository;
import org.example.blogginapi.models.users;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final userRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    public void register(UserAuthDto dto){
        if(userRepo.findByusername(dto.username()).isPresent()){
            throw new RuntimeException("Username already used");
        }
        users newUser=new users();
        newUser.setUsername(dto.username());
        newUser.setPassword(passwordEncoder.encode(dto.password()));
        newUser.setEmail(dto.email());
        userRepo.save(newUser);
    }

}
