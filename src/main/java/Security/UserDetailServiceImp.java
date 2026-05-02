package Security;

import Repository.userRepository;
import lombok.RequiredArgsConstructor;
import models.users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImp implements UserDetailsService {
private final userRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        users user=userRepo.findByusername(username)
                .orElseThrow(()->new UsernameNotFoundException("Did not find username: "+ username));
        return new UserPrincipal(user);
    }
}
