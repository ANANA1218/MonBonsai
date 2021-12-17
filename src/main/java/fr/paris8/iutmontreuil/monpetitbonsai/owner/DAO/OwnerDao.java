package fr.paris8.iutmontreuil.monpetitbonsai.owner.DAO;

import fr.paris8.iutmontreuil.monpetitbonsai.owner.OwnerEntity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OwnerDao extends JpaRepository<OwnerEntity, UUID> {

}