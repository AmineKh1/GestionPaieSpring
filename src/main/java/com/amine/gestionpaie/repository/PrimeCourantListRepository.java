package com.amine.gestionpaie.repository;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.amine.gestionpaie.dto.PrimeCourantDto;
import com.amine.gestionpaie.model.PrimeCourant;
import com.amine.gestionpaie.model.PrimeCourantList;

public interface PrimeCourantListRepository extends JpaRepository<PrimeCourantList,Long>{
	@Query(value="SELECT MAX(d) FROM primecourantlist WHERE d.collectionprimecourant=:prime and d.LastModifiedDate<(DATE(:date)")
	PrimeCourantList findByCollectionPrimeCourantAndDate(Long prime, Date date);

	PrimeCourantList findByCollectionPrimeCourant(Long idPrime);

}
