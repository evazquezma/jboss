package es.sisifo.jboss.monitor.modelo.info;

public class WebInfo {
	private long expiredSessions;
	private long rejectedSessions;
	private long maxActiveSessions;
	private long maxAliveTimeSessions;
	private long createdSessions;
	private long avgAliveTimeSessions;
	private String contexRoot;
	private String virtualHost;
	private long activeSessions;
	private long duplicateSessions;

	public long getExpiredSessions() {
		return expiredSessions;
	}

	public void setExpiredSessions(long expiredSessions) {
		this.expiredSessions = expiredSessions;
	}

	public long getRejectedSessions() {
		return rejectedSessions;
	}

	public void setRejectedSessions(long rejectedSessions) {
		this.rejectedSessions = rejectedSessions;
	}

	public long getMaxActiveSessions() {
		return maxActiveSessions;
	}

	public void setMaxActiveSessions(long maxActiveSessions) {
		this.maxActiveSessions = maxActiveSessions;
	}

	public long getMaxAliveTimeSessions() {
		return maxAliveTimeSessions;
	}

	public void setMaxAliveTimeSessions(long maxAliveTimeSessions) {
		this.maxAliveTimeSessions = maxAliveTimeSessions;
	}

	public long getCreatedSessions() {
		return createdSessions;
	}

	public void setCreatedSessions(long createdSessions) {
		this.createdSessions = createdSessions;
	}

	public long getAvgAliveTimeSessions() {
		return avgAliveTimeSessions;
	}

	public void setAvgAliveTimeSessions(long avgAliveTimeSessions) {
		this.avgAliveTimeSessions = avgAliveTimeSessions;
	}

	public String getContexRoot() {
		return contexRoot;
	}

	public void setContexRoot(String contexRoot) {
		this.contexRoot = contexRoot;
	}

	public String getVirtualHost() {
		return virtualHost;
	}

	public void setVirtualHost(String virtualHost) {
		this.virtualHost = virtualHost;
	}

	public long getActiveSessions() {
		return activeSessions;
	}

	public void setActiveSessions(long activeSessions) {
		this.activeSessions = activeSessions;
	}

	public long getDuplicateSessions() {
		return duplicateSessions;
	}

	public void setDuplicateSessions(long duplicateSessions) {
		this.duplicateSessions = duplicateSessions;
	}
}
