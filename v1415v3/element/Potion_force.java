package element;

public class Potion_force extends Potion{

	private static final long serialVersionUID = 1L;

	public Potion_force(String nom,int force,int charisme,int reputation) {
		super(nom, force, 0, 0);
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString(){
		return super.nom + "[" + getForce() + "]";
	}

}
