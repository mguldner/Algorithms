package machinelearning.example.titanic;

import machinelearning.decisiontree.Feature;
import machinelearning.decisiontree.Feature.FeatureType;
import machinelearning.general.DataObject;

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

	@Override
	public Object getValueForFeature(Feature<FeatureType> f) {
		switch(f.getName()){
		case "passengerId":
			return this.passengerId;
		}
		return null;
	}
}
