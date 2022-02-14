package fr.paris8.iutmontreuil.monpetitbonsai.authentification.Domaine;


import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Infrastructure.AuthorityEntity;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Infrastructure.AuthorityId;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Infrastructure.UserDao;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Infrastructure.UserEntity;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.UserMapper;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele.Bonsai;
import fr.paris8.iutmontreuil.monpetitbonsai.commons.infrastructure.*;
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
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserDao userDao;
    private final OwnerDAO ownerDAO;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityDAO authorityDao;


    public UserService(UserDao userDao, OwnerDAO ownerDAO, PasswordEncoder passwordEncoder, AuthorityDAO authorityDao) {
        this.userDao = userDao;
        this.ownerDAO = ownerDAO;
        this.passwordEncoder = passwordEncoder;
        this.authorityDao = authorityDao;
    }

    public List<User> findAll(){

        return userDao.findAll()
                .stream()
                .map(UserMapper::entityToUser)
                .collect(Collectors.toList());
    }

    public Optional<User> getMe() {
        AppUser credentials = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDao.findById(credentials.getId()).map(UserMapper::entityToUser);
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




    public Optional<UserEntity> updatePassword(UUID id, String newPassword) {
        Optional<UserEntity> user = userDao.findById(id);
        if (user.isPresent()) {
            user.get().setPassword(passwordEncoder.encode(newPassword));
            return Optional.of(userDao.save(user.get()));
        }
        return user;
    }


    public void updateAuthority(UUID id, String authority) {
        authorityDao.clear(id);
        authorityDao.save(new AuthorityEntity(new AuthorityId(id, authority)));
    }

    public void deleteById(UUID id) {
        userDao.deleteById(id);
    }


    public List<Owner> getOwners(){

        return ownerDAO.findAll()
                .stream()
                .map(OwnerMapper::EntityToOwner)
                .collect(Collectors.toList());
    }
}



