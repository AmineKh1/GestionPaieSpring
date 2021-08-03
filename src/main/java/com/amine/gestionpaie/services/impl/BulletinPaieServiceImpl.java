package com.amine.gestionpaie.services.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amine.gestionpaie.dto.*;
import com.amine.gestionpaie.exception.EntityNotFoundException;
import com.amine.gestionpaie.exception.ErrorCodes;
import com.amine.gestionpaie.exception.InvalidEntityException;
import com.amine.gestionpaie.model.*;
import com.amine.gestionpaie.repository.AMORepository;
import com.amine.gestionpaie.repository.AncienneteListRepository;
import com.amine.gestionpaie.repository.BulletinPaieRepository;
import com.amine.gestionpaie.repository.CNSSRepository;
import com.amine.gestionpaie.repository.EmployeRepository;
import com.amine.gestionpaie.repository.IGRListRepository;
import com.amine.gestionpaie.repository.MutuelleRepository;
import com.amine.gestionpaie.services.AMOServices;
import com.amine.gestionpaie.services.AncienneteListServices;
import com.amine.gestionpaie.services.AvanceServices;
import com.amine.gestionpaie.services.BulletinPaieServices;
import com.amine.gestionpaie.services.CIMRServices;
import com.amine.gestionpaie.services.CNSSServices;
import com.amine.gestionpaie.services.ContratServices;
import com.amine.gestionpaie.services.CreditServices;
import com.amine.gestionpaie.services.EmployeServices;
import com.amine.gestionpaie.services.EnfantServices;
import com.amine.gestionpaie.services.FraisProServices;
import com.amine.gestionpaie.services.IGRListServices;
import com.amine.gestionpaie.services.IGRServices;
import com.amine.gestionpaie.services.MutuelleServices;
import com.amine.gestionpaie.services.PretServices;
import com.amine.gestionpaie.services.PrimeCourantServices;
import com.amine.gestionpaie.services.PrimeNoExoServices;
import com.amine.gestionpaie.services.PrimeNormalServices;
import com.amine.gestionpaie.validators.BulletinPaieValidator;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class BulletinPaieServiceImpl implements BulletinPaieServices{
	private BulletinPaieRepository bulletinPaieRepository;
	private EmployeRepository employeRepository;
	private AMOServices amoService;
	private CNSSServices cnssService;
	private AncienneteListServices ancienneteListService;
	private IGRListServices igrListService;
	private MutuelleServices mutuelleService;
	private ContratServices contratService;
	private PrimeNormalServices primeNormalService;
	private PretServices pretService;
	private EnfantServices enfantService;
	private CreditServices creditService;
	private AvanceServices avanceService;
	private PrimeCourantServices primeCourantService;
	private CIMRServices cimrService;
	private FraisProServices fraisProService;
	private PrimeNoExoServices primeNoExoService;
	private IGRServices igrService;
	private EmployeServices employeService;

	
	

	public BulletinPaieServiceImpl(BulletinPaieRepository bulletinPaieRepository, EmployeRepository employeRepository,
			AMOServices amoService, CNSSServices cnssService, AncienneteListServices ancienneteListService,IGRServices igrService,EmployeServices employeService,
			IGRListServices igrListService, MutuelleServices mutuelleService, ContratServices contratService,PrimeNormalServices primeNormalService, PretServices pretService,
			EnfantServices enfantService, CreditServices creditService,AvanceServices avanceService,CIMRServices cimrService,FraisProServices fraisProService, PrimeNoExoServices primeNoExoService) {
		this.bulletinPaieRepository = bulletinPaieRepository;
		this.employeRepository = employeRepository;
		this.amoService = amoService;
		this.cnssService = cnssService;
		this.ancienneteListService = ancienneteListService;
		this.igrListService = igrListService;
		this.mutuelleService = mutuelleService;
		this.contratService = contratService;
		this.primeNormalService= primeNormalService;
		this.pretService=pretService;
		this.enfantService=enfantService;
		this.creditService= creditService;
		this.avanceService=avanceService;
		this.cimrService=cimrService;
		this.fraisProService=fraisProService;
		this.primeNoExoService=primeNoExoService;
		this.igrService=igrService;
		}

	@Override
	public BulletinPaieDto save(BulletinPaieDto dto) {
		List<String> errors=BulletinPaieValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error("BulletinPaie is not valid",dto);
			throw new InvalidEntityException("Bulletin de paie n'est pas valide",ErrorCodes.BULLETINPAIE_NOT_VALID,errors);
			
		}
		Optional<Employe> employe=employeRepository.findById(dto.getEmployeBulletinpaie().getMatricule());
		if(employe.isEmpty()) {
			log.warn("Employe with iD {} was not found in the BD",dto.getEmployeBulletinpaie().getMatricule());
			throw new EntityNotFoundException("aucun Employe avec l'ID"+dto.getEmployeBulletinpaie().getMatricule()+"n'a ete trouvez dans la BDD",ErrorCodes.EMPLOYE_NOT_FOUND);
			
		}
		return BulletinPaieDto.fromEntity(bulletinPaieRepository.save(BulletinPaieDto.toEntity(dto)));
	}

	@Override
	public BulletinPaieDto findById(Long id) {
		if(id==null) {
			log.error("bulletin de paie ID is null");
			return null;
		}
		Optional<BulletinPaie> bulletinPaie= bulletinPaieRepository.findById(id);
		BulletinPaieDto dto= BulletinPaieDto.fromEntity(bulletinPaie.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucun BulletinPaie avec l'ID ="+id+"n'a ete trouve dans la base de données",ErrorCodes.BULLETINPAIE_NOT_FOUND));
	}

	@Override
	public List<BulletinPaieDto> findAllByIdEmploye(Long idEmploye) {
		if(idEmploye==null) {
			log.error("id employe is null");
			return null;
		}
		Optional<Employe> employe= employeRepository.findById(idEmploye);
		if(employe.isEmpty()) {
			log.warn("Employe with ID {} was not found in the DB",idEmploye);
			throw new EntityNotFoundException("aucun employe avec l'ID"+idEmploye+"n'a ete trouvez dans la BDD",ErrorCodes.EMPLOYE_NOT_FOUND);
		}
		return bulletinPaieRepository.findAllByemployeBulletinpaie(idEmploye).stream().map(BulletinPaieDto::fromEntity).collect(Collectors.toList());
	}
	@Override
		public BulletinPaieDto findByIdEmployefindByDate(Long idEmploye, Date date) {
			if(idEmploye==null) {
				log.error("Employe ID's null");
				return null;
			}
			if(date==null) {
				log.error("Bulletin Paie Date's null");
				return null;
			}
			Optional<Employe> employe= employeRepository.findById(idEmploye);
			if(employe.isEmpty()) {
				log.warn("Employe with ID {} was not found in the DB",idEmploye);
				throw new EntityNotFoundException("aucun employe avec l'ID"+idEmploye+"n'a ete trouve dans la BDD",ErrorCodes.EMPLOYE_NOT_FOUND);
			
			}
			Optional<BulletinPaie> bulletinPaie = bulletinPaieRepository.findByEmployeBulletinpaieAndDateSaisie(idEmploye, date);
			if (bulletinPaie.isEmpty()) {
				log.warn("bulletin paie with employe ID{} and date {} was not found in the DB",idEmploye,date);
				throw new EntityNotFoundException("Aucun bulletin de paie du employe avec l'id"+idEmploye+"et la date"+date+"n'a ete trouvez dans la base de données",ErrorCodes.BULLETINPAIE_NOT_FOUND);
			}
			BulletinPaieDto dto= BulletinPaieDto.fromEntity(bulletinPaie.get());
			//return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucun bulletin de paie du employe avec l'id"+idEmploye+"et la date"+date+"n'a ete trouvez dans la base de données",ErrorCodes.BULLETINPAIE_NOT_FOUND));
			return dto;

		}
	@Override
	public List<BulletinPaieDto> findAll() {
		return bulletinPaieRepository.findAll().stream().map(BulletinPaieDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		if(id==null) {
			log.error("BulletinPaie ID is null");
			return;
		}
		bulletinPaieRepository.deleteById(id);
	}
	@Override
		public void deleteAllByIdEmploye(Long idEmploye) {
			// TODO Auto-generated method stub
			if(idEmploye==null) {
				log.error("Employe ID is null");
				return;
			}
			Optional<Employe> employe= employeRepository.findById(idEmploye);
			if(employe.isEmpty()) {
				log.warn("Employe with ID {} was not found in the DB",idEmploye);
				throw new EntityNotFoundException("aucun employe avec l'ID"+idEmploye+"n'a ete trouve dans la BDD",ErrorCodes.EMPLOYE_NOT_FOUND);
			
			}
			bulletinPaieRepository.deleteAllByEmployeBulletinpaie(idEmploye);
		}

	
	 @Override
	public Double calculeSalaire(Long idEmploye,Date bulletinDate) {
		 if(bulletinDate==null) {
				log.error("Bulletin Paie Date's null");
				return null;
		}
		BulletinPaieDto bulletinPaie = findByIdEmployefindByDate(idEmploye,bulletinDate);
		int annee = bulletinPaie.getDateSaisie().getYear();
		AMODto amo = amoService.findByAnnee(annee);
		CNSSDto cnss= cnssService.findByAnnee(annee);
		MutuelleDto mutuelle= mutuelleService.findByAnnee(annee);
		FraisProDto fraisPro= fraisProService.findByAnnee(annee);
		IGRDto igrF=igrService.findByAnnee(annee);
		Collection<AncienneteListDto> ancienneteParametre= ancienneteListService.findAllByAnneeAnciennete(annee);
		Collection<IGRListDto> igrParametre= igrListService.findAllByAnneeIGR(annee);
		ContratDto contrat= contratService.findByEmployeContratAndDate(idEmploye, bulletinDate);
		Collection<PrimeNormalDto> prime= primeNormalService.findByPrimeEmployeAndDate(idEmploye, bulletinDate);
		Collection<PretDto> pret= pretService.findByPretEmployeAndDate(idEmploye, bulletinDate);
		Collection<EnfantDto> enfant= enfantService.findAllByIdEmployeEnfant(idEmploye);
		Collection<CreditDto> credit =creditService.findAllByIdEmployeAndDate(idEmploye, bulletinDate);
		Collection<AvanceDto> avance= avanceService.findByEmployeAvanceAndDateMoisA(idEmploye, bulletinDate);
		Collection<PrimeCourantDto> primeCourant= primeCourantService.findByPrimeEmployeAndDate(idEmploye, bulletinDate);
		Collection<PrimeNoExoDto> primeNoExo=primeNoExoService.findByPrimeEmployeAndDate(idEmploye, bulletinDate);
		CIMRDto cimr=cimrService.findByAnnee(annee);
		Double brutGlobal=null;
		Double salaireBase= contrat.getSalaireBase();
		Double tauxAnc=null;
		Double brutImposable;
		Long periode = contratService.CalculeAnciennete(contrat.getDateEmbauche(), bulletinDate);
		tauxAnc=ancienneteListService.caculBrutAnc(ancienneteParametre, periode);
		Double exoneration;
		Double fraisbasecalcul;
		exoneration=primeNormalService.calculSolePrime(prime);
		Double noExoneration;
		noExoneration=primeNoExoService.calculSolePrime(primeNoExo);
		
		brutGlobal= salaireBase+ exoneration;
		brutGlobal=brutGlobal+noExoneration;
		brutGlobal= brutGlobal+ (salaireBase*tauxAnc);
		brutGlobal= brutGlobal+ primeCourantService.calculSolePrime(primeCourant);
		
		brutImposable= brutGlobal-exoneration;
		fraisbasecalcul=(brutImposable-primeCourantService.calculSolePrime(primeCourant))*fraisProService.calculSalaireFraisPro(fraisPro, brutImposable);
		fraisbasecalcul=fraisProService.verifierPlafond(fraisPro, fraisbasecalcul);
		Double calculcnss;
		calculcnss=cnssService.calculSalaireCnss(cnss, brutImposable);
		Double calculamo;
		calculamo=amoService.calculSalaireAmo(amo,brutImposable);
		Double calculcimr;
		calculcimr=cimrService.calculSalaireCIMR(cimr, brutImposable);
		
		Double sni;
		sni=brutImposable-calculcnss-calculamo-calculcimr-fraisbasecalcul;
		IGRListDto ir;
		ir=igrListService.findIgr(igrParametre, sni);
		Double irBrut;
		irBrut=igrService.calculIrBrut(ir, sni);
		int nbrIr;
		nbrIr=enfantService.findMineur(enfant, bulletinDate);
		EmployeDto employe=employeService.findById(idEmploye);
		if(employe.getSituationFamiliale()==true) {
			nbrIr=nbrIr+1;
		}
		Double irNet;
		irNet=nbrIr*igrF.getFraisFamille();
		irNet=irBrut-irNet;
		sni=sni-irNet;
		 return sni;
	
	}

	

}
