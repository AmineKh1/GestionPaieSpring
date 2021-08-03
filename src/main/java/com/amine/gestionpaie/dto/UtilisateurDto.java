package com.amine.gestionpaie.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.amine.gestionpaie.model.utilisateurs.Roles;
import com.amine.gestionpaie.model.utilisateurs.Utilisateur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UtilisateurDto {
	private Long idUtilisateur;
	private String email;
	private String mdp;

	private List<RolesDto> roles;
	private SocieteDto societe;
	public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
		if(utilisateur==null) {
			return null;
		}
		return UtilisateurDto.builder()
				.email(utilisateur.getEmail())
				.mdp(utilisateur.getMdp())

				.societe(SocieteDto.fromEntity(utilisateur.getSociete()))

				.roles(
			            utilisateur.getRoles() != null ?
			                utilisateur.getRoles().stream()
			                    .map(RolesDto::fromEntity)
			                    .collect(Collectors.toList()) : null
			        )

				.build();
	}
	public static Utilisateur toEntity(UtilisateurDto utilisateurDto) {
		if(utilisateurDto == null) {
			return null;
		}
		Utilisateur utilisateur= new Utilisateur();
		utilisateur.setEmail(utilisateurDto.getEmail());
		utilisateur.setMdp(utilisateurDto.getMdp());

		return utilisateur;
	}

}
