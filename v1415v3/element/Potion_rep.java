package element;

public class Potion_rep extends Potion{
	private static final long serialVersionUID = 1L;
	public Potion_rep(String nom, int force, int charisme,int reputation) {
		super(nom, 0, 0, reputation);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString(){
		return super.nom + "[" +getReputation()+"]";
	}
}
