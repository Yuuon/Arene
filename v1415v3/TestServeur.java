import java.net.InetAddress;
import java.text.DateFormat;
import java.util.Date;

import serveur.Arene;

/**
 * Lancement de l'Arene. A lancer en premier. Arguments : numero de port et duree de vie (en millisecondes)
 */
public class TestServeur {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) {
		
		try {
			int port=5099;	//par defaut, port=5099
			int taillePile = 1; //par defaut les elements arrivent directement, pas de pile
			long duree = 1000*60*30;//30 minutes
			if (args.length!=0) {
				port=Integer.parseInt(args[0]);
				taillePile = Integer.parseInt(args[1]);
			}
			//String ipNameArene = "ouvea.edu.ups-tlse.fr"; // le nom de la machine sur laquelle tourne l'arene
			String ipNameArene = "localhost"; // le nom de la machine sur laquelle tourne l'arene
			
			System.out.println("Creation du registre RMI sur le port "+port+"...");
			java.rmi.registry.LocateRegistry.createRegistry(port);
		    
		    System.out.println("Creation du serveur sur le port "+port+"...");
		    Arene arene = new Arene(port, ipNameArene,taillePile, duree);
		    long temps_depart = System.currentTimeMillis();
		    if (args.length==3) {duree = Long.parseLong(args[2]);} // en millisecondes
		    while((System.currentTimeMillis()- temps_depart) < duree) {
		    	System.out.println("[Arene sur "+InetAddress.getLocalHost().getCanonicalHostName()+":"+port+"] "
		    			+DateFormat.getTimeInstance().format(new Date())
		    			+" ("+arene.countClients()+" clients)"
		    			+"\n");
		    	arene.printElements();
		    	
		    	try {
		    		Thread.sleep(1000*1); //delai = 1 minute
		    	} catch (InterruptedException e) {e.printStackTrace();}
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
