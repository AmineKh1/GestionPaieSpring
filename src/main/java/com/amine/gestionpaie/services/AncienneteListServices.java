package com.amine.gestionpaie.services;

import java.util.Collection;
import java.util.List;

import com.amine.gestionpaie.dto.*;

public interface AncienneteListServices {
	AncienneteListDto findById(Long id);
	
	List<AncienneteListDto> findAllByIdAnciennete(Long idAnciennete);
	Collection<AncienneteListDto> findAllByAnneeAnciennete(int annee);
	void delete(Long id);
	void deleteAllByIdAnciennete(Long idAnciennete);
	Double findAnnéecible(Long period);


	Double caculBrutAnc(Collection<AncienneteListDto> parametre, Long periode);

}
