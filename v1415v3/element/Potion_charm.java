package element;

public class Potion_charm extends Potion{
	private static final long serialVersionUID = 1L;
	public Potion_charm(String nom, int force, int charisme,int reputation) {
		super(nom, 0, charisme, 0);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString(){
		return super.nom + "[" + getCharisme() +"]";
	}
	
}
