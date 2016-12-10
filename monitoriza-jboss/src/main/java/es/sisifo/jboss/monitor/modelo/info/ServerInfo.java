package es.sisifo.jboss.monitor.modelo.info;

import java.util.Date;

public class ServerInfo {
	private String nodeName;
	private String name;
	private Date date;
	private MemoryInfo heapInfo;
	private MemoryInfo nonHeapInfo;
	private EJBInfo ejbInfo;
	private DespliegueInfo despliegueInfo;
	
	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public MemoryInfo getHeapInfo() {
		return heapInfo;
	}

	public void setHeapInfo(MemoryInfo heapInfo) {
		this.heapInfo = heapInfo;
	}

	public MemoryInfo getNonHeapInfo() {
		return nonHeapInfo;
	}

	public void setNonHeapInfo(MemoryInfo nonHeapInfo) {
		this.nonHeapInfo = nonHeapInfo;
	}

	public EJBInfo getEjbInfo() {
		return ejbInfo;
	}

	public void setEjbInfo(EJBInfo ejbInfo) {
		this.ejbInfo = ejbInfo;
	}

	public DespliegueInfo getDespliegueInfo() {
		return despliegueInfo;
	}

	public void setDespliegueInfo(DespliegueInfo despliegueInfo) {
		this.despliegueInfo = despliegueInfo;
	}

}
