package com.irn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.irn.entity.ClientInvoiceIrnInfo;

public interface ClientInvoiceIrnInfoDao extends JpaRepository<ClientInvoiceIrnInfo, Integer> {

	@Query(value = "SELECT c FROM ClientInvoiceIrnInfo c where clientInvoiceId=:id")
	public ClientInvoiceIrnInfo getIrnByClientInvoiceId(int id);

	@Query(value = "SELECT c FROM ClientInvoiceIrnInfo c where irn=:irn")
	public ClientInvoiceIrnInfo getInvoiceInfoByIrn(String irn);
}
