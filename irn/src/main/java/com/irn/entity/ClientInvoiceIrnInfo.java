package com.irn.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client_invoice_irn_info")
public class ClientInvoiceIrnInfo {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "client_invoice_id")
	private int clientInvoiceId;
	@Column(name = "ack_no")
	private String ackNo;
	@Column(name = "ack_date")
	private Date ackDate;
	@Column(name = "irn")
	private String irn;
	@Column(name = "signed_invoice")
	private String signedInvoice;
	@Column(name = "signed_qr_code")
	private String signedQrCode;
	@Column(name = "cancel_date")
	private Date cancelDate;
	@Column(name = "cancel_reason")
	private String cancelReason;
	@Column(name = "cancel_remark")
	private String cancelRemark;
	@Column(name = "is_active")
	private Boolean isActive;
	@Column(name = "created_on")
	private Date createdOn;
	@Column(name = "created_by")
	private int createdBy;
	@Column(name = "updated_on")
	private Date updatedOn;
	@Column(name = "updated_by")
	private int updatedBy;

	public ClientInvoiceIrnInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientInvoiceIrnInfo(int id, int clientInvoiceId, String ackNo, Date ackDate, String irn,
			String signedInvoice, String signedQrCode, Date cancelDate, String cancelReason, String cancelRemark,
			Boolean isActive, Date createdOn, int createdBy, Date updatedOn, int updatedBy) {
		super();
		this.id = id;
		this.clientInvoiceId = clientInvoiceId;
		this.ackNo = ackNo;
		this.ackDate = ackDate;
		this.irn = irn;
		this.signedInvoice = signedInvoice;
		this.signedQrCode = signedQrCode;
		this.cancelDate = cancelDate;
		this.cancelReason = cancelReason;
		this.cancelRemark = cancelRemark;
		this.isActive = isActive;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.updatedOn = updatedOn;
		this.updatedBy = updatedBy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClientInvoiceId() {
		return clientInvoiceId;
	}

	public void setClientInvoiceId(int clientInvoiceId) {
		this.clientInvoiceId = clientInvoiceId;
	}

	public String getAckNo() {
		return ackNo;
	}

	public void setAckNo(String ackNo) {
		this.ackNo = ackNo;
	}

	public Date getAckDate() {
		return ackDate;
	}

	public void setAckDate(Date ackDate) {
		this.ackDate = ackDate;
	}

	public String getIrn() {
		return irn;
	}

	public void setIrn(String irn) {
		this.irn = irn;
	}

	public String getSignedInvoice() {
		return signedInvoice;
	}

	public void setSignedInvoice(String signedInvoice) {
		this.signedInvoice = signedInvoice;
	}

	public String getSignedQrCode() {
		return signedQrCode;
	}

	public void setSignedQrCode(String signedQrCode) {
		this.signedQrCode = signedQrCode;
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getCancelRemark() {
		return cancelRemark;
	}

	public void setCancelRemark(String cancelRemark) {
		this.cancelRemark = cancelRemark;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "ClientInvoiceIrnInfo [id=" + id + ", clientInvoiceId=" + clientInvoiceId + ", ackNo=" + ackNo
				+ ", ackDate=" + ackDate + ", irn=" + irn + ", signedInvoice=" + signedInvoice + ", signedQrCode="
				+ signedQrCode + ", cancelDate=" + cancelDate + ", cancelReason=" + cancelReason + ", cancelRemark="
				+ cancelRemark + ", isActive=" + isActive + ", createdOn=" + createdOn + ", createdBy=" + createdBy
				+ ", updatedOn=" + updatedOn + ", updatedBy=" + updatedBy + "]";
	}

}
