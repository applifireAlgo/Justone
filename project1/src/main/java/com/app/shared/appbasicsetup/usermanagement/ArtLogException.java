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
@Table(name = "art_log_exception_m")
@Cache(alwaysRefresh= true)
@JsonIdentityInfo(generator = PropertyGenerator.class, property = "id")
public class ArtLogException implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "UUIDGenerator")
	private String id;
	
	@Id
	@Column(name = "exceptionId")
	private Integer exceptionId;

	@Column(name = "exception")
	private String exception;
	
	@Column(name = "exceptionName")
	private String exceptionName;
	
	@Column(name = "rootException")
	private String rootException;
	
	@ManyToOne
	@JoinColumn(name = "id", referencedColumnName = "id",insertable=false,updatable=false)
	private ArtLogEvents artLogEvents;

	public ArtLogException() {
		super();
	}
	
	public ArtLogException(String id, Integer exceptionId, String exception, String rootException) {
		super();
		this.id = id;
		this.exceptionId = exceptionId;
		this.exception = exception;
		this.rootException = rootException;
	}

	public ArtLogEvents getArtLogEvents() {
		return artLogEvents;
	}

	public void setArtLogEvents(ArtLogEvents artLogEvents) {
		this.artLogEvents = artLogEvents;
	}

	public Integer getExceptionId() {
		return exceptionId;
	}

	public void setExceptionId(Integer exceptionId) {
		this.exceptionId = exceptionId;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRootException() {
		return rootException;
	}

	public void setRootException(String rootException) {
		this.rootException = rootException;
	}

	public String getExceptionName() {
		return exceptionName;
	}

	public void setExceptionName(String exceptionName) {
		this.exceptionName = exceptionName;
	}

	@Override
	public String toString() {
		return "ArtLogException [id=" + id + ", exceptionId=" + exceptionId + ", exception=" + exception + ", exceptionName="
				+ exceptionName + ", rootException=" + rootException + "]";
	}

	public String toJSON() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"exceptionId\":" + "\"" + getExceptionId() + "\"");
		sb.append(",\"exceptionName\":" + "\"" + getExceptionName() + "\"");
		sb.append(",\"exception\":" + "\"" + getException() + "\"");
		sb.append(",\"rootException\":" + "\"" + getRootException() + "\"");
		sb.append("}");
		return sb.toString();
	}
	
}
