package com.app.shared.appbasicsetup.usermanagement;
import java.io.Serializable;

import javax.persistence.Basic;
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
@Table(name = "art_log_severity_m")
@Cache(alwaysRefresh= true)
@JsonIdentityInfo(generator = PropertyGenerator.class, property = "severityId")
public class ArtLogSeverity implements Serializable {
	@Id()
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(generator="UUIDGenerator")
	@Basic(optional = false)
	@Column(name = "severityId")
	private String severityId;

	@Column(name = "label")
	private String label;

	@Column(name = "severity")
	private Integer severity;

	public ArtLogSeverity() {
		super();
	}

	public ArtLogSeverity(String severityId, String label) {
		this.severityId = severityId;
		this.label = label;
	}

	public String getSeverityId() {
		return severityId;
	}

	public void setSeverityId(String severityId) {
		this.severityId = severityId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getSeverity() {
		return severity;
	}

	public void setSeverity(Integer severity) {
		this.severity = severity;
	}

	@Override
	public String toString() {
		return "ArtLogSeverity [severityId=" + severityId + ", label=" + label + "]";
	}

	public String toJSON() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"attributeName\":" + "\"" + getSeverity() + "\"");
		sb.append(",\"attributeValue\":" + "\"" + getLabel() + "\"");
		sb.append(",\"attributeId\":" + "\"" + getSeverityId() + "\"");
		sb.append("}");
		return sb.toString();
	}
	
	public String toSeverityDetails(){
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"severity\":" + "\"" + getSeverity() + "\"");
		sb.append(",\"label\":" + "\"" + getLabel() + "\"");
		sb.append("}");
		return sb.toString();
	
	}

}
