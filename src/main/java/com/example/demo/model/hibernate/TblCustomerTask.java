package com.example.demo.model.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "MPOCPOCOD_TASK")
public class TblCustomerTask implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private TblCustomerInstance tblCustomerInstance;
	private String refId;
	private String externalRefId;
	private String name;
	private String state;
	private int seq;
	private String externalSystem;
	private String type;
	private String protocal;
	
	private String protocalAttribute;
	private String requestParam;
	private String responseParam;
	
	private Date requestDate;
	private Date stateDate;
	private Date responseDate;
	private Date createdDate;
	private Date lastUpdateDate;
	private String createdBy;
	private String lastUpdateBy;
	private String errorMsg ;
	private String errorRefId ;

	private String instanceId ;
	

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 30)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "instance_id", nullable = false)
	public TblCustomerInstance getTblCustomerInstance() {
		return this.tblCustomerInstance;
	}

	public void setTblCustomerInstance(TblCustomerInstance tblCustomerInstance) {
		this.tblCustomerInstance = tblCustomerInstance;
	}
	
	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "state", nullable = false, length = 10)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "seq", nullable = false, precision = 131089, scale = 0)
	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	@Column(name = "external_system", length = 20)
	public String getExternalSystem() {
		return this.externalSystem;
	}

	public void setExternalSystem(String externalSystem) {
		this.externalSystem = externalSystem;
	}

	@Column(name = "type", length = 10)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "protocal", length = 10)
	public String getProtocal() {
		return this.protocal;
	}

	public void setProtocal(String protocal) {
		this.protocal = protocal;
	}

	@Column(name = "protocal_attribute")
	public String getProtocalAttribute() {
		return protocalAttribute;
	}

	public void setProtocalAttribute(String protocalAttribute) {
		this.protocalAttribute = protocalAttribute;
	}

	@Column(name = "request_param")
	public String getRequestParam() {
		return requestParam;
	}

	public void setRequestParam(String requestParam) {
		this.requestParam = requestParam;
	}

	@Column(name = "response_param")
	public String getResponseParam() {
		return responseParam;
	}

	public void setResponseParam(String responseParam) {
		this.responseParam = responseParam;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "request_date", length = 29)
	public Date getRequestDate() {
		return this.requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "state_date", length = 29)
	public Date getStateDate() {
		return this.stateDate;
	}

	public void setStateDate(Date stateDate) {
		this.stateDate = stateDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "response_date", length = 29)
	public Date getResponseDate() {
		return this.responseDate;
	}

	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", length = 29)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update_date", length = 29)
	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	@Column(name = "created_by", nullable = false, length = 30)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "last_update_by", nullable = false, length = 30)
	public String getLastUpdateBy() {
		return this.lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	@Column(name = "error_msg")
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Column(name = "instance_id",insertable=false, updatable=false)
	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	@Column(name = "ref_id")
	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	@Column(name = "external_ref_id")
	public String getExternalRefId() {
		return externalRefId;
	}

	public void setExternalRefId(String externalRefId) {
		this.externalRefId = externalRefId;
	}

	@Column(name = "error_ref_id")
	public String getErrorRefId() {
		return errorRefId;
	}

	public void setErrorRefId(String errorRefId) {
		this.errorRefId = errorRefId;
	}
	
	
	

}
