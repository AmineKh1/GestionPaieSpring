package com.amine.gestionpaie.services;

import java.util.Date;
import java.util.List;

import com.amine.gestionpaie.dto.*;

public interface AMOServices {
	AMODto save(AMODto dto);
	AMODto findById(Long id);
	AMODto findByAnnee(int annee);
	List<AMODto> findAll();
	void delete(Long id);

	Double calculSalaireAmo(AMODto amo, Double salaireBase);


	
	

}
