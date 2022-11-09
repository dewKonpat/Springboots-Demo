package com.example.demo.model.hibernate;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@Table(name = "MPOCPOCOD_INSTANCE")
public class TblCustomerInstance {

	private String id;
	private String uri;
	private String method;
	private String state;
	private String mobileNo;
	private String orderType;
	private String chargeType;
	private String channel;
	private String location;
	private String customerAccount;
	private String billingAccount;
	private String billingSystem;
	private String chargingSystem;
	private Date submittedDate;
	private Date stateDate;
	private Date completedDate;
	private Date createdDate;
	private Date lastUpdateDate;
	private String createdBy;
	private String lastUpdateBy;
	private String privateIdType;
	private String privateIdValue;
	private String publicIdType;
	private String publicIdValue;
	private String errorRefId;
	private List<TblCustomerTask> tblCustomerTasks;
	
	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 50)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "URI", length = 100)
	public String getUri() {
		return this.uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Column(name = "METHOD", length = 10)
	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Column(name = "STATE", nullable = false, length = 10)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "MOBILE_NO", length = 10)
	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Column(name = "ORDER_TYPE", length = 20)
	public String getOrderType() {
		return this.orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	@Column(name = "CHARGE_TYPE", length = 20)
	public String getChargeType() {
		return this.chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	@Column(name = "CHANNEL", length = 20)
	public String getChannel() {
		return this.channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	@Column(name = "LOCATION", length = 10)
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "CUSTOMER_ACCOUNT", length = 20)
	public String getCustomerAccount() {
		return this.customerAccount;
	}

	public void setCustomerAccount(String customerAccount) {
		this.customerAccount = customerAccount;
	}

	@Column(name = "BILLING_ACCOUNT", length = 20)
	public String getBillingAccount() {
		return this.billingAccount;
	}

	public void setBillingAccount(String billingAccount) {
		this.billingAccount = billingAccount;
	}

	@Column(name = "BILLING_SYSTEM", length = 10)
	public String getBillingSystem() {
		return this.billingSystem;
	}

	public void setBillingSystem(String billingSystem) {
		this.billingSystem = billingSystem;
	}

	@Column(name = "CHARGING_SYSTEM", length = 10)
	public String getChargingSystem() {
		return this.chargingSystem;
	}

	public void setChargingSystem(String chargingSystem) {
		this.chargingSystem = chargingSystem;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SUBMITTED_DATE", length = 29)
	public Date getSubmittedDate() {
		return this.submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "STATE_DATE", length = 29)
	public Date getStateDate() {
		return this.stateDate;
	}

	public void setStateDate(Date stateDate) {
		this.stateDate = stateDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "COMPLETED_DATE", length = 29)
	public Date getCompletedDate() {
		return this.completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE", length = 29)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_UPDATE_DATE", length = 29)
	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	@Column(name = "CREATED_BY", nullable = false, length = 30)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "LAST_UPDATE_BY", nullable = false, length = 30)
	public String getLastUpdateBy() {
		return this.lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tblCustomerInstance")
	public List<TblCustomerTask> getTblCustomerTasks() {
		return tblCustomerTasks;
	}

	public void setTblCustomerTasks(List<TblCustomerTask> tblCustomerTasks) {
		this.tblCustomerTasks = tblCustomerTasks;
	}


	@Column(name = "PRIVATE_ID_TYPE")
	public String getPrivateIdType() {
		return privateIdType;
	}

	public void setPrivateIdType(String privateIdType) {
		this.privateIdType = privateIdType;
	}

	@Column(name = "PUBLIC_ID_TYPE")
	public String getPublicIdType() {
		return publicIdType;
	}

	public void setPublicIdType(String publicIdType) {
		this.publicIdType = publicIdType;
	}

	@Column(name = "PRIVATE_ID_VALUE")
	public String getPrivateIdValue() {
		return privateIdValue;
	}

	public void setPrivateIdValue(String privateIdValue) {
		this.privateIdValue = privateIdValue;
	}

	@Column(name = "PUBLIC_ID_VALUE")
	public String getPublicIdValue() {
		return publicIdValue;
	}

	public void setPublicIdValue(String publicIdValue) {
		this.publicIdValue = publicIdValue;
	}

	
	@Column(name = "error_ref_id")
	public String getErrorRefId() {
		return errorRefId;
	}

	public void setErrorRefId(String errorRefId) {
		this.errorRefId = errorRefId;
	}

}
