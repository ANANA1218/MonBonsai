package fr.paris8.iutmontreuil.monpetitbonsai.authentification.Domaine;


import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Infrastructure.AuthorityEntity;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Infrastructure.AuthorityId;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Infrastructure.UserDao;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Infrastructure.UserEntity;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.UserMapper;
import fr.paris8.iutmontreuil.monpetitbonsai.commons.infrastructure.BonsaiDao;
import fr.paris8.iutmontreuil.monpetitbonsai.commons.infrastructure.OwnerDAO;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.Owner;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.Repository.OwnerRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> findAll(){

        return userDao.findAll()
                .stream()
                .map(UserMapper::entityToUser)
                .collect(Collectors.toList());
    }



    @Transactional
    public void create(UserCreationRequest userCreationRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userCreationRequest.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userCreationRequest.getPassword()));
        UserEntity savedUser = userDao.save(userEntity);

        List<AuthorityEntity> authorities = new ArrayList<>();
        authorities.add(new AuthorityEntity(AuthorityId.getDefaultAuthority(savedUser.getId())));
        savedUser.setAuthorities(authorities);

        userDao.save(savedUser);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        UserEntity user = userDao.findByUsername(s);
        List<String> authoritiesList = userDao.findAuthorityByUserId(user.getId());
        String authorities = String.join(",", authoritiesList);
        return new AppUser(user.getId(), user.getUsername(), user.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
    }


    public List<Owner> getOwners(){
        AppUser credentials = (AppUser) SecurityContextHolder.getContext().getAuthentication().getCredentials();
        UserEntity userEntityCurrent = userDao.getById(credentials.getId());

        if(userEntityCurrent.getAuthorities().get(0).getAuthority().equals("ADMIN")){
            OwnerDAO ownerDao = null;
            BonsaiDao bonsaiDao = null;
            OwnerRepository ownerRepository = new OwnerRepository(ownerDao, bonsaiDao);
            return ownerRepository.findAll();
        }

        return null;
    }
}


