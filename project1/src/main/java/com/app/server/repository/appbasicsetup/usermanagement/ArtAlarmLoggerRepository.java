package com.app.server.repository.appbasicsetup.usermanagement;
import com.app.shared.appbasicsetup.usermanagement.ArtLogConfig;

import com.app.shared.appbasicsetup.usermanagement.ArtLogSeverity;

import java.util.List;

public interface ArtAlarmLoggerRepository {
	public void saveLoggerConfig(ArtLogConfig awsLogConfig);

	public void updateLoggerConfig(ArtLogConfig awsLogConfig);

	public void mergeSeverity(ArtLogSeverity radLogSeverity);

	public ArtLogSeverity getBySeverityId(int severityId);

	public void persistSeverity(ArtLogSeverity awsLogSeverity);

	public List<ArtLogConfig> findAll();

	public List<ArtLogSeverity> getBySeverity(Integer severity);
}
