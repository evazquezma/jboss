package es.sisifo.jboss.monitor.modelo.info;

import java.util.Date;

public class DespliegueInfo {
	private String despliegue;	
	private WebInfo webInfo;
	
	public String getDespliegue() {
		return despliegue;
	}

	public void setDespliegue(String despliegue) {
		this.despliegue = despliegue;
	}

	public WebInfo getWebInfo() {
		return webInfo;
	}

	public void setWebInfo(WebInfo webInfo) {
		this.webInfo = webInfo;
	}
}
