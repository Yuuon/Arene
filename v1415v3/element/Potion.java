package element;

/**
 * Une potion: un element donnant des bonus aux caracteristiques de celui qui
 * le ramasse.
 */
public class Potion extends Element {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur d'une potion avec un nom et une quantite de force et de charisme
	 * (ces quantites sont celles ajoutees lorsqu'un Personnage ramasse cette potion).
	 * @param nom
	 * @param force
	 * @param charisme
	 */
	public Potion(String nom, int force, int charisme,int reputation) {
		super(nom);
		ajouterCaract("force", force);
		ajouterCaract("charisme", charisme);
		ajouterCaract("reputation",reputation);
	} 
	
	/**
	 * Retourne la valeur du bonus de force.
	 * @return bonus de force
	 */
	public int getForce() {
		return getCaract("force");
	}
	
	/**
	 * Retourne la valeur du bonus de charisme.
	 * @return bonus de charisme
	 */
	public int getCharisme() {
		return getCaract("charisme");
	}
	public int getReputation() {
		// TODO Auto-generated method stub
		return getCaract("reputation");
	}

	
	public String toString(){
		return super.toString() + "[" + getForce() + "," + getCharisme() + ","+getReputation()+"]";
	}

	
}
