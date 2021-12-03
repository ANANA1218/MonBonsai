package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.DAO;

import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele.Bonsai_Repotting;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.BonsaiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface Repotting_DAO extends JpaRepository<Bonsai_Repotting, UUID> {


}


