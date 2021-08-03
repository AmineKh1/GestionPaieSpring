package com.amine.gestionpaie.repository;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amine.gestionpaie.dto.BulletinPaieDto;
import com.amine.gestionpaie.model.*;

public interface BulletinPaieRepository extends JpaRepository<BulletinPaie, Long>{

	Collection<BulletinPaie> findAllByemployeBulletinpaie(Long idEmploye);

	void deleteAllByEmployeBulletinpaie(Long idEmploye);

	Optional<BulletinPaie> findByEmployeBulletinpaieAndDateSaisie(Long idEmploye, Date date);

}
