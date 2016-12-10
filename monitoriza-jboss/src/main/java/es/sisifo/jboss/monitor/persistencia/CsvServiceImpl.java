package es.sisifo.jboss.monitor.persistencia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;

import es.sisifo.jboss.monitor.modelo.info.ServerInfo;

public class CsvServiceImpl {
	
	public void appendToFile (ServerInfo serverInfo, String filePath) {	
		System.out.println("Exportando fila a fichero " + filePath);
		final Path csvPath = Paths.get(filePath);
		try {
			inicializaFicheroSiNoExiste(csvPath);
			
			final String lineaFichero = generarLineaFichero(serverInfo);
		    Files.write(csvPath, lineaFichero.getBytes(), StandardOpenOption.APPEND);
		}
		catch (IOException e) {
			System.out.println("Error al escribir fichero " + filePath);
		    e.printStackTrace();
		}			
	}



	private String generarLineaFichero(ServerInfo serverInfo) {
		final StringBuilder sb = new StringBuilder();
		sb.append(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(serverInfo.getDate())).append(";");
		sb.append(serverInfo.getName()).append(";");
		sb.append(serverInfo.getNodeName()).append(";");
		sb.append(serverInfo.getHeapInfo().getInit()).append(";");
		sb.append(serverInfo.getHeapInfo().getUsed()).append(";");
		sb.append(serverInfo.getHeapInfo().getCommited()).append(";");
		sb.append(serverInfo.getHeapInfo().getMax()).append(";");
		
		sb.append(serverInfo.getNonHeapInfo().getInit()).append(";");
		sb.append(serverInfo.getNonHeapInfo().getUsed()).append(";");
		sb.append(serverInfo.getNonHeapInfo().getCommited()).append(";");
		sb.append(serverInfo.getNonHeapInfo().getMax()).append(";");
		
		sb.append(serverInfo.getEjbInfo().getActiveCount()).append(";");
		sb.append(serverInfo.getEjbInfo().getCompletedTaskCount()).append(";");
		sb.append(serverInfo.getEjbInfo().getCurrentThreadCount()).append(";");
		sb.append(serverInfo.getEjbInfo().getQueueSize()).append(";");		
		
		
		sb.append(serverInfo.getDespliegueInfo().getDespliegue()).append(";");
		sb.append(serverInfo.getDespliegueInfo().getWebInfo().getExpiredSessions()).append(";");
		sb.append(serverInfo.getDespliegueInfo().getWebInfo().getRejectedSessions()).append(";");
		sb.append(serverInfo.getDespliegueInfo().getWebInfo().getMaxActiveSessions()).append(";");
		sb.append(serverInfo.getDespliegueInfo().getWebInfo().getMaxAliveTimeSessions()).append(";");
		sb.append(serverInfo.getDespliegueInfo().getWebInfo().getCreatedSessions()).append(";");
		sb.append(serverInfo.getDespliegueInfo().getWebInfo().getAvgAliveTimeSessions()).append(";");
		sb.append(serverInfo.getDespliegueInfo().getWebInfo().getContexRoot()).append(";");
		sb.append(serverInfo.getDespliegueInfo().getWebInfo().getVirtualHost()).append(";");
		sb.append(serverInfo.getDespliegueInfo().getWebInfo().getActiveSessions()).append(";");
		sb.append(serverInfo.getDespliegueInfo().getWebInfo().getDuplicateSessions());
		sb.append("\n");
		return sb.toString();
	}
	
	

	private void inicializaFicheroSiNoExiste(Path csvPath) throws IOException {
		if (Files.exists(csvPath)){
			return;
		}
			
		System.out.println("Se crea el fichero vacío " + csvPath);
		Files.createFile(csvPath);
		
		final StringBuilder cab = new StringBuilder();		
		cab.append("Fecha").append(";");
		cab.append("Server name").append(";");
		cab.append("Node name").append(";");
		cab.append("Heap Init").append(";");
		cab.append("Heap Use").append(";");
		cab.append("Heap Commit").append(";");
		cab.append("Heap Max").append(";");
		cab.append("Non Heap Init").append(";");
		cab.append("Non Heap Use").append(";");
		cab.append("Non Heap Commit").append(";");
		cab.append("Non Heap Max").append(";");
		cab.append("EJB Active").append(";");
		cab.append("EJB Completed Task").append(";");
		cab.append("EJB Thread Count").append(";");
		cab.append("EJB Queue Size").append(";");
		cab.append("Deployment").append(";");
		cab.append("Session Expired").append(";");
		cab.append("Session Rejected").append(";");
		cab.append("Session Max Active").append(";");
		cab.append("Session Max Alive").append(";");
		cab.append("Session Created").append(";");				
		cab.append("Session Avg Alived").append(";");
		cab.append("Session Context Root").append(";");
		cab.append("Session Virtual Host").append(";");
		cab.append("Session Active").append(";");
		cab.append("Session Duplicate").append("\n");				
		
		Files.write(csvPath, cab.toString().getBytes(), StandardOpenOption.APPEND);
	}				
}
