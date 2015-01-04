package element;


import interaction.Deplacements;
import interfaceGraphique.VueElement;

import java.rmi.RemoteException;
import java.util.Hashtable;

public class Fairy extends Personnage{
	private static final long serialVersionUID = 1L;
	public Fairy(String nom, int force, int charisme,int reputation,int gold) {
		super(nom, force, charisme, reputation, gold);
		
		// TODO Auto-generated constructor stub
	}
	/* Fairy est un classe special, qui ne combattre ni rallier pas
	 * Elle a un attribute(Force, Charisme) au hasard 
	 * Quand elle interagir une autre personne normale
	 * elle donne un de son attribute comme un cadeau
	 * et puis se disparait.
	 */

	public void strategie(VueElement ve, Hashtable<Integer,VueElement> voisins, Integer refRMI) throws RemoteException {
		
        Deplacements deplacements = new Deplacements(ve,voisins);
		deplacements.seDirigerVers(0);
	}


}
