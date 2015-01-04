

import java.rmi.RemoteException;
import java.util.Random;

import controle.Console;
import element.Element;

import element.Potion_force;

public class TestPotionForce {

	/**
	 * @param args
	 * @throws RemoteException 
	 */
	public static void main(String[] args) {

		try {
			int port=5099;	//par defaut, port de l'arene=5099
			if (args.length!=0) port=Integer.parseInt(args[0]);
			String ipArene = "localhost";
			if (args.length!=0) if (args[1]!="") ipArene=args[1];
			Element anduril = new Potion_force("Force Potion", 5, 0,0);
	
			Random r = new Random();
			new Console(anduril, r.nextInt(100),r.nextInt(100), port,ipArene);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
