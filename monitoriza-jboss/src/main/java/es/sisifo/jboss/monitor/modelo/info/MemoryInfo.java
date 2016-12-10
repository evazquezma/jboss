package es.sisifo.jboss.monitor.modelo.info;

public class MemoryInfo {
	private long init;
	private long used;
	private long commited;
	private long max;

	public long getInit() {
		return init;
	}

	public void setInit(long init) {
		this.init = init;
	}

	public long getUsed() {
		return used;
	}

	public void setUsed(long used) {
		this.used = used;
	}

	public long getCommited() {
		return commited;
	}

	public void setCommited(long commited) {
		this.commited = commited;
	}

	public long getMax() {
		return max;
	}

	public void setMax(long max) {
		this.max = max;
	}
}
