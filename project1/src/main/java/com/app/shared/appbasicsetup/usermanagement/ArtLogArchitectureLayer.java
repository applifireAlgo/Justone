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
@Table(name = "art_log_architecture_layer_m")
@Cache(alwaysRefresh= true)
@JsonIdentityInfo(generator = PropertyGenerator.class, property = "id")
public class ArtLogArchitectureLayer implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "UUIDGenerator")
	private String id;
	
	@Id
	@Column(name = "layerId")
	private Integer layerId;

	@Column(name = "layer")
	private String layer;
	
//	@Column(name = "log_config_id")
//	private String logConfigId;

	public ArtLogArchitectureLayer() {
		super();
	}
	
	public ArtLogArchitectureLayer(String id, Integer layerId, String layer/*, String logConfigId*/) {
		super();
		this.id = id;
		this.layerId = layerId;
		this.layer = layer;
//		this.logConfigId = logConfigId;
	}

	public Integer getLayerId() {
		return layerId;
	}

	public void setLayerId(Integer integer) {
		this.layerId = integer;
	}

	public String getLayer() {
		return layer;
	}

	public void setLayer(String layer) {
		this.layer = layer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/*public String getLogConfigId() {
		return logConfigId;
	}

	public void setLogConfigId(String logConfigId) {
		this.logConfigId = logConfigId;
	}*/

	@Override
	public String toString() {
		return "ArtLogArchitectureLayer [id=" + id + ", layerId=" + layerId + ", layer=" + layer + /*", logConfigId=" + logConfigId +*/ "]";
	}

	public String toJSON() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"layerId\":" + "\"" + getLayerId() + "\"");
		sb.append(",\"layer\":" + "\"" + getLayer() + "\"");
//		sb.append("\"logConfigId\":" + "\"" + getLogConfigId() + "\"");
		sb.append("}");
		return sb.toString();
	}
}
