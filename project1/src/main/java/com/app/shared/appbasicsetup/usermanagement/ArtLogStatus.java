package com.app.shared.appbasicsetup.usermanagement;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Cache;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

@Entity
@Table(name = "art_log_status_m")
@Cache(alwaysRefresh= true)
@JsonIdentityInfo(generator = PropertyGenerator.class, property = "id")
public class ArtLogStatus implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "UUIDGenerator")
	private String id;
	
	@Id
	@Column(name = "statusId")
	private Integer statusId;

	@Column(name = "status")
	private String status;
	
	public ArtLogStatus() {
		super();
	}
	
	public ArtLogStatus(String id, Integer statusId, String status) {
		super();
		this.id = id;
		this.statusId = statusId;
		this.status = status;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ArtLogStatus [id=" + id + ", statusId=" + statusId + ", status=" + status + "]";
	}

	public String toJSON() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"statusId\":" + "\"" + getStatusId() + "\"");
		sb.append(",\"status\":" + "\"" + getStatus() + "\"");
		sb.append("}");
		return sb.toString();
	}
}
