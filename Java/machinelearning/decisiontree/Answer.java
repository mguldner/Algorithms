package machinelearning.decisiontree;

import machinelearning.general.exception.UnallowedValueException;

/*
 * T : Le type de la reponse pour la caracteristique concernee
 * U : Le type de la reponse que l'on souhaite prevoir
 */

public class Answer<T, U> {

	private Feature<T> question;
	private T value;
	private U label;
	
	public Answer(Feature<T> question, T value, U label){
		this.question = question;
		this.value = value;
		this.label = label;
	}
	
	public Answer(Feature<T> question){
		this.question = question;
	}
	
	public void setValue(T value) throws UnallowedValueException{
		if(this.question.getPossibleValues().contains(value))
			this.value = value;
		else
			throw new UnallowedValueException("The value '" + value + "' for the question '" + this.question.getName() + "' is not allowed.");
	}
	
	public T getValue(){
		return this.value;
	}
	
	public U getLabel(){
		return this.label;
	}
}
