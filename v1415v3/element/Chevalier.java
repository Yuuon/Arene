package element;

import interaction.Actions;
import interaction.Deplacements;
import interfaceGraphique.VueElement;

import java.awt.Point;
import java.awt.Toolkit;
import java.rmi.RemoteException;
import java.util.Hashtable;
import java.util.Random;

import utilitaires.Calculs;



public class Chevalier extends Personnage{
	private static final long serialVersionUID = 1L;
	public Chevalier(String nom, int force, int charisme,int reputation,int gold) {
		super(nom, force, charisme, reputation, gold);
		// TODO Auto-generated constructor stub
	}
	/* Chevalier cherche son master donc il y aucun limite pour lui
	 * il peut etre rallie tout des personnes qui a un Titre, sauf Chevalier soi-meme
	 * apres il ajoute un equipe, la force d'equipe augmente par 1.
	 */
	public void strategie(VueElement ve, Hashtable<Integer,VueElement> voisins, Integer refRMI) throws RemoteException {
        Actions actions = new Actions(ve, voisins); //je recupere les voisins (distance < 10)
        Deplacements deplacements = new Deplacements(ve,voisins);
        if (0 == voisins.size()) { // je n'ai pas de voisins, j'erre
        	parler("J'erre...", ve);
        	Toolkit kit=Toolkit.getDefaultToolkit();
			int height=(kit.getScreenSize().height)/2;
			int width=(kit.getScreenSize().width)/2;
			Random r=new Random();
			int x=r.nextInt(width);
			int y=r.nextInt(height);
			int i=r.nextInt(5);
			int a=0,b=0;
			
			switch(i){
			case 0: a=0;b=y;break;
			case 1: a=x;b=0;break;
			case 2: a=width;b=y;break;
			default: a=x;b=height;
			}
			Point p=new Point(a,b);
			deplacements.seDirigerVers(p);
			
			
			
        	 //Type:Wanderer
            
        
        }else{
			VueElement cible = Calculs.chercherElementProche(ve, voisins);
			
			int distPlusProche = Calculs.distanceChebyshev(ve.getPoint(), cible.getPoint());
			int refPlusProche = cible.getRef();
			
			
			
			
	        	if((getLeader() == -1 || getLeader() != ((Personnage) cible.getControleur().getElement()).getLeader()) && // pas dans la meme equipe
						ve.getControleur().getElement().getCaract("negatif")==1){
					System.out.println("Il vaut mieux que je me retire");
					Toolkit kit=Toolkit.getDefaultToolkit();
					int height=kit.getScreenSize().height;
					int width=kit.getScreenSize().width;
					Random r=new Random();
					int x=r.nextInt(width);
					int y=r.nextInt(height);
					Point p=new Point(x,y);
					parler("Je me retire",ve);
					deplacements.seDirigerVers(p);
					ve.getControleur().getElement().ajouterCaract("negatif", 0);
				}else 
			
			
			if((getLeader() == -1 || getLeader() != ((Personnage) cible.getControleur().getElement()).getLeader()) && // pas dans la meme equipe
					getLeader() != refPlusProche && // un leader de l'autre
					((Personnage) cible.getControleur().getElement()).getLeader() != refRMI
					) { 

	        	System.out.println("Je m'occupe de l'element le plus proche");
				
				// le plus proche est a proximite
				if (distPlusProche <= 2) { 
					if(cible.getControleur().getElement() instanceof Potion) { // si la cible est une potion
						//ramassage
						parler("Je tente de ramasser une potion", ve);
						actions.ramasser(refRMI, refPlusProche, ve.getControleur().getArene());
						
					} else if(cible.getControleur().getElement() instanceof Personnage) { // si la cible est un personnage
						//jeu
						parler("Je joue avec " + refPlusProche, ve);
						actions.interaction(refRMI, refPlusProche, ve.getControleur().getArene());
					}
					
				} else { // je vais vers le plus proche
		        	parler("Je vais vers mon voisin " + refPlusProche, ve);
		        	deplacements.seDirigerVers(refPlusProche);
				}
			} else {
	        	parler("J'erre...", ve);
	        	deplacements.seDirigerVers(0); //errer
			}
        }
	}
}

