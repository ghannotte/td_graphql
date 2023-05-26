package hannotte_td_graphql.domain;

public class Player { //Cette classe me permet de définir le format de ma table player
	
	private String id; //Je définis les différentes collones

	private String name;
	
	private String firstname;
	
	private String team;
	
	private String position;

	public String getId() {//Je définis les methodes pour lire une collone
		return id;
	}

	public void setId(String id) {//Je définis les methodes insérer la donnée dans une collone
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
