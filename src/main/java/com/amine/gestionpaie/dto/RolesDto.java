package com.amine.gestionpaie.dto;


import com.amine.gestionpaie.model.utilisateurs.Roles;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolesDto {

  private Long idRoles;

  private String roleName;

  @JsonIgnore
  private UtilisateurDto utilisateur;

  public static RolesDto fromEntity(Roles roles) {
    if (roles == null) {
      return null;
    }
    return RolesDto.builder()
        .idRoles(roles.getIdroles())
        .roleName(roles.getRoleName())
        .build();
  }

  public static Roles toEntity(RolesDto dto) {
    if (dto == null) {
      return null;
    }
    Roles roles = new Roles();
    roles.setIdroles(dto.getIdRoles());
    roles.setRoleName(dto.getRoleName());
    roles.setUtilisateur(UtilisateurDto.toEntity(dto.getUtilisateur()));
    return roles;
  }

}
