package hannotte_td_graphql.domain;

public class Player { //Cette classe me permet de d�finir le format de ma table player
	
	private String id; //Je d�finis les diff�rentes collones

	private String name;
	
	private String firstname;
	
	private String team;
	
	private String position;

	public String getId() {//Je d�finis les methodes pour lire une collone
		return id;
	}

	public void setId(String id) {//Je d�finis les methodes ins�rer la donn�e dans une collone
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}		

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}	

	public String getPlayer() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}	
	
}
