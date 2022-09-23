package com.irn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.irn.entity.ClientIrnCredential;

@Repository
public interface ClientCredentialDao extends JpaRepository<ClientIrnCredential, Integer> {

	@Query("SELECT c FROM ClientIrnCredential c where c.companyId= :companyId")
	public ClientIrnCredential getbyClientId(Integer companyId);

}
