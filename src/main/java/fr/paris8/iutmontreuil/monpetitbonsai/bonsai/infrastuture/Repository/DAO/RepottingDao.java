package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.DAO;

import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.Entity.RepottingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepottingDao extends JpaRepository<RepottingEntity, UUID> {
}
