package com.amine.gestionpaie.services;

import java.util.List;

import com.amine.gestionpaie.dto.CIMRDto;

public interface CIMRServices {
	CIMRDto save(CIMRDto dto);
	CIMRDto findById(Long id);
	CIMRDto findByAnnee(int annee);
	List<CIMRDto> findAll();
	void delete(Long id);

	Double calculSalaireCIMR(CIMRDto  cimr,Double salaire);

}
