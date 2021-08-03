package com.amine.gestionpaie.dto;

import java.util.Date;

import com.amine.gestionpaie.model.BulletinPaie;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BulletinPaieDto {
	private Long idBulletin;
	private Date dateSaisie;
	private EmployeDto employeBulletinpaie;

	public static BulletinPaieDto fromEntity(BulletinPaie bulletinPaie) {
		if(bulletinPaie == null) {
			return null;
		}
		return BulletinPaieDto.builder()
				.idBulletin(bulletinPaie.getIdBulletin())
				.dateSaisie(bulletinPaie.getDateSaisie())
				.employeBulletinpaie(EmployeDto.fromEntity(bulletinPaie.getEmployeBulletinpaie()))
				.build();
	}
	public static BulletinPaie toEntity(BulletinPaieDto bulletinPaieDto) {
		if(bulletinPaieDto == null) {
			return null;
		}
		BulletinPaie bulletinPaie= new BulletinPaie();
		bulletinPaie.setIdBulletin(bulletinPaieDto.getIdBulletin());
		bulletinPaie.setDateSaisie(bulletinPaieDto.getDateSaisie());
		bulletinPaie.setEmployeBulletinpaie(EmployeDto.toEntity(bulletinPaieDto.getEmployeBulletinpaie()));
		return bulletinPaie;
	}

}
