package element;


public class Baron extends Personnage{
	private static final long serialVersionUID = 1L;
	public Baron(String nom, int force, int charisme,int reputation, int gold) {
		super(nom, force, charisme, reputation, gold);
		
		// TODO Auto-generated constructor stub
	}
	/* Titre le plus bas, ne accept pas le ramille d'un leader qui charm <10,
	 * il a une base de force de 5, 
	 * 
	 */
	
}
