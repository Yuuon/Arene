package element;

/**
 * Une potion: un element donnant des bonus aux caracteristiques de celui qui
 * le ramasse.
 */
public class Gold extends Element {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur d'une potion avec un nom et une quantite de force et de charisme
	 * (ces quantites sont celles ajoutees lorsqu'un Personnage ramasse cette potion).
	 * @param nom
	 * @param force
	 * @param charisme
	 */
	
	public Gold(String nom, int force, int charisme,int reputation,int gold) {
		super(nom);
		ajouterCaract("force", 0);
		ajouterCaract("charisme", 0);
		ajouterCaract("reputation",0);
		ajouterCaract("gold",gold);
	} 
	
	/**
	 * Retourne la valeur du bonus de force.
	 * @return bonus de force
	 */
	public int getForce() {
		return getCaract("force");
	}
	public int getGold() {
		return getCaract("gold");
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
		return super.toString() + "[" + getGold() +"]";
	}

	
}
