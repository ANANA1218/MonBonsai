package fr.paris8.iutmontreuil.Owner.Infrastructure.Repository.DAO;


import fr.paris8.iutmontreuil.Owner.Infrastructure.Repository.Entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OwnerDAO extends JpaRepository<OwnerEntity, UUID> {

}