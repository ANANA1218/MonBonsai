package fr.paris8.iutmontreuil.monpetitbonsai.commons.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PruningDao extends JpaRepository<PruningEntity, UUID> {
}