package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonsaiDao extends JpaRepository<BonsaiEntity, String> {


}
