package com.amine.gestionpaie.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amine.gestionpaie.dto.AncienneteListDto;
import com.amine.gestionpaie.model.anneeConfig.*;

public interface AncienneteListRepository extends JpaRepository< AncienneteList, Long>{

	List<AncienneteList> findAllByAnciennete(Long idAnciennete);

	void deleteAllByAnciennete(Long idAnciennete);

	Optional<AncienneteList> findByAncienneteIdannees(Long idAnciennete);

	Optional<AncienneteList> findByAncienneteAnnees(int annee);

	Optional<AncienneteList> findAllByAncienneteAnnees(int annee);

}
