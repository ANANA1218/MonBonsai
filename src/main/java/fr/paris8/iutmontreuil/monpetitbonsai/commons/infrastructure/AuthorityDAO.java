package fr.paris8.iutmontreuil.monpetitbonsai.commons.infrastructure;

import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Infrastructure.AuthorityEntity;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Infrastructure.AuthorityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.UUID;

public interface AuthorityDAO extends JpaRepository<AuthorityEntity, AuthorityId> {
    @Modifying
    @Transactional
    @Query(value = "delete from authorities where id=?1", nativeQuery = true)
    int clear(@Param("user_id") UUID userId);
}