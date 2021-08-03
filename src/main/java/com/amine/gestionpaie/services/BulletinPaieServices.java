package com.amine.gestionpaie.services;

import java.util.Date;
import java.util.List;

import com.amine.gestionpaie.dto.BulletinPaieDto;



public interface BulletinPaieServices {
	BulletinPaieDto save(BulletinPaieDto dto);
	BulletinPaieDto findById(Long id);
	List<BulletinPaieDto> findAllByIdEmploye(Long IdEmploye);
	BulletinPaieDto findByIdEmployefindByDate(Long idEmploye, Date date);
	List<BulletinPaieDto> findAll();
	void delete(Long id);
	void deleteAllByIdEmploye(Long idEmploye);
	Double calculeSalaire(Long idEmploye,Date bulletinDate);
	

}
