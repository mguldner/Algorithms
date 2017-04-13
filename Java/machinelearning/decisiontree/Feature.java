package machinelearning.decisiontree;

import java.util.List;

/*
 * Name : le nom de la caracteristique concernee
 * Value : les valeurs possibles pour la caracteristique concernee
 */

public class Feature<T> {

	public enum FeatureType{
		INTEGER, STRING, BOOLEAN, DOUBLE
	}
	
	private String name;
	private List<T> possibleValues;
	
	public Feature(String name, List<T> possibleValues){
		this.name = name;
		this.possibleValues = possibleValues;
	}

	public String getName() {
		return name;
	}

	public List<T> getPossibleValues() {
		return possibleValues;
	}
}