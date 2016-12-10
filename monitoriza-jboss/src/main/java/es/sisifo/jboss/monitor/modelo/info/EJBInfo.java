package es.sisifo.jboss.monitor.modelo.info;

public class EJBInfo {
	private long activeCount;
	private long completedTaskCount;
	private long currentThreadCount;
	private long queueSize;

	public long getActiveCount() {
		return activeCount;
	}

	public void setActiveCount(long activeCount) {
		this.activeCount = activeCount;
	}

	public long getCompletedTaskCount() {
		return completedTaskCount;
	}

	public void setCompletedTaskCount(long completedTaskCount) {
		this.completedTaskCount = completedTaskCount;
	}

	public long getCurrentThreadCount() {
		return currentThreadCount;
	}

	public void setCurrentThreadCount(long currentThreadCount) {
		this.currentThreadCount = currentThreadCount;
	}

	public long getQueueSize() {
		return queueSize;
	}

	public void setQueueSize(long queueSize) {
		this.queueSize = queueSize;
	}
}
