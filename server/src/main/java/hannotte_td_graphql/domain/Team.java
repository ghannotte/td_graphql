package hannotte_td_graphql.domain;

public class Team {//Cette classe me permet de d�finir le format de ma table Team

	private String id;//Je d�finis les diff�rentes collones

	private String name;
	
	private String city;

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}	
	
}
