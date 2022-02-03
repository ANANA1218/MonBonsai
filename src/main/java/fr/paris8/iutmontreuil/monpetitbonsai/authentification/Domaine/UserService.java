package fr.paris8.iutmontreuil.monpetitbonsai.authentification.Domaine;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Infrastructure.AuthorityEntity;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Infrastructure.AuthorityId;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Infrastructure.UserDao;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Infrastructure.UserEntity;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.UserMapper;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class UserService implements UserDetailsService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }


    @Transactional
    public UserEntity create(UserCreationRequest userCreationRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userCreationRequest.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userCreationRequest.getPassword()));
        UserEntity savedUser = userDao.save(userEntity);


        List<AuthorityEntity> authorities = new ArrayList<>();
        authorities.add(new AuthorityEntity(AuthorityId.getDefaultAuthority(savedUser.getId())));
        savedUser.setAuthorities(authorities);

        return userDao.save(savedUser);
    }


    public List<UserEntity> findAll() {
        return userDao.findAll();
    }

    public Optional<UserEntity> getById(UUID id) {
        return userDao.findById(id);
    }



    @Override
    public UserDetails loadUserByUsername(String s) {
        UserEntity user = userDao.findByUsername(s);
        List<String> authoritiesList = userDao.findAuthorityByUserId(user.getId());
        String authorities = String.join(",", authoritiesList);
        return new AppUser(user.getId(), user.getUsername(), user.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
    }


}



