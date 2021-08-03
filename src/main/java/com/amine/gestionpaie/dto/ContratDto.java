
package com.amine.gestionpaie.dto;

import java.util.Date;

import com.amine.gestionpaie.model.Contrat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContratDto {
	private long idContrat;
	private Date dateEmbauche;

	private Double salaireBase;
	private String typeContrat;
	private String profession;
	private EmployeDto employeContrat;
	private Integer idSociete;
	public static ContratDto fromEntity(Contrat contrat) {
		if(contrat == null) {
			return null;
		}
		return ContratDto.builder()
				.idContrat(contrat.getIdContrat())
				.dateEmbauche(contrat.getDateEmbauche())

				.salaireBase(contrat.getSalaireBase())
				.typeContrat(contrat.getTypeContrat())
				.profession(contrat.getProfession())
				.employeContrat(EmployeDto.fromEntity(contrat.getEmployeContrat()))
				.build();	
		}
	public static Contrat toEntity(ContratDto contratDto) {
		if(contratDto == null) {
			return null;
		}
		Contrat contrat = new Contrat();
		contrat.setIdContrat(contratDto.getIdContrat());
		contrat.setDateEmbauche(contratDto.getDateEmbauche());

		contrat.setSalaireBase(contratDto.getSalaireBase());
		contrat.setTypeContrat(contratDto.getTypeContrat());
		contrat.setProfession(contratDto.getProfession());
		contrat.setEmployeContrat(EmployeDto.toEntity(contratDto.getEmployeContrat()));
		return contrat;
	}

}
