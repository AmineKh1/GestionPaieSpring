package com.amine.gestionpaie.interceptor;


import org.hibernate.EmptyInterceptor;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

public class Interceptor extends EmptyInterceptor {

  @Override
  public String onPrepareStatement(String sql) {
    if (StringUtils.hasLength(sql) && sql.toLowerCase().startsWith("select")) {
      // select utilisateu0_.
      final String entityName = sql.substring(7, sql.indexOf("."));
      final String idSociete = MDC.get("idSociete");
      if (StringUtils.hasLength(entityName)
          && !entityName.toLowerCase().contains("societe")
          && !entityName.toLowerCase().contains("roles")
          && StringUtils.hasLength(idSociete)) {

        if (sql.contains("where")) {
          sql = sql + " and " + entityName + ".idSociete = " + idSociete;
        } else {
          sql = sql + " where " + entityName + ".idSociete = " + idSociete;
        }
      }
    }
    return super.onPrepareStatement(sql);
  }
}
