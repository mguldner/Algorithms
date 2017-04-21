package example.titanic;

import java.util.List;

import decisiontree.Feature;
import example.titanic.features.Frame;
import general.DataObject;

public class Passenger implements DataObject{

	private Integer passengerId;
	private Integer pClass;
	private Boolean isMale;
	private Integer age;
	private Integer sibSpNb;
	private Integer parChNb;
	private String ticket;
	private Double fare;
	private String cabin;
	private String embarked;
	private Integer survived;
	
	public Passenger(int passengerId, int pClass, boolean isMale, int age,
			int sibSpNb, int parChNb, String ticket, double fare, String cabin, String embarked) {
		super();
		this.passengerId = passengerId;
		this.pClass = pClass;
		this.isMale = isMale;
		this.age = age;
		this.sibSpNb = sibSpNb;
		this.parChNb = parChNb;
		this.ticket = ticket;
		this.fare = fare;
		this.cabin = cabin;
		this.embarked = embarked;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public int getpClass() {
		return pClass;
	}

	public boolean isMale() {
		return isMale;
	}

	public int getAge() {
		return age;
	}

	public int getSibSpNb() {
		return sibSpNb;
	}

	public int getParChNb() {
		return parChNb;
	}

	public String getTicket() {
		return ticket;
	}

	public double getFare() {
		return fare;
	}

	public String getCabin() {
		return cabin;
	}

	public String getEmbarked() {
		return embarked;
	}

	@Override
	public String getLabel() {
		return survived.toString();
	}

	/*
	 * Compare la liste des features avec les valeurs de l'objet et retourne l'index associé
	 */
	@Override
	public int classificationForFeature(Feature<?> feature) {
		switch(feature.getName()){
		case "pClass":
			return feature.getPossibleValues().indexOf(this.pClass);
		case "isMale":
			return feature.getPossibleValues().indexOf(this.isMale);
		case "age":
			List<Frame> frameAgeList = (List<Frame>) feature.getPossibleValues();
			int indexAge = -1;
			for(int i=0; i<frameAgeList.size(); i++){
				if(this.age>=frameAgeList.get(i).getMin() && this.age<frameAgeList.get(i).getMax())
					indexAge = i;
			}
			return indexAge;
		case "sibSpNb":
			return feature.getPossibleValues().indexOf(this.sibSpNb);
		case "parChNb":
			return feature.getPossibleValues().indexOf(this.parChNb);
		case "fare":
			List<Frame> frameFareList = (List<Frame>) feature.getPossibleValues();
			int indexFare = -1;
			for(int i=0; i<frameFareList.size(); i++){
				if(this.fare>=frameFareList.get(i).getMin() && this.fare<=frameFareList.get(i).getMax())
					indexFare = i;
			}
			return indexFare;
		case "embarked":
			return feature.getPossibleValues().indexOf(this.embarked);
		default:
			System.err.println("Erreur : Passenger.java, methode compare, default case du switch");
		}
		return -1;
	}
}
