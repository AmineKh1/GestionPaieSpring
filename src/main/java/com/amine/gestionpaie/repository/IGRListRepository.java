package com.amine.gestionpaie.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amine.gestionpaie.dto.IGRListDto;
import com.amine.gestionpaie.model.anneeConfig.*;

public interface IGRListRepository extends JpaRepository< IGRList, Long>{

	Optional<IGRList> findByIgrIdannees(Long idIGR);

	List<IGRList> findAllByIgr(Long idIGR);

	void deleteAllByIgr(Long idIGR);

	Optional<IGRList> findByIgrAnnees(int annee);

	Collection<IGRList> findAllByIgrAnnees(int annee);

}
