package machinelearning.decisiontree;


import java.util.HashMap;
import java.util.List;

import machinelearning.decisiontree.Feature.FeatureType;
import machinelearning.decisiontree.data.Leaf;
import machinelearning.decisiontree.data.Tree;
import machinelearning.general.Algorithm;
import machinelearning.general.DataObject;

/*
 * ? :  Le type de chacune des Features -> on ne le connaît pas d'avance ! 
 * 		Dans le cas du titanic, une String pour l'endroit d'embarcation, un plage de valeurs pour l'âge, etc.
 * T :  Le type de la valeur finale (la donnee que l'on cherche a prevoir). 
 * 		Dans le cas du titanic, un Integer 0 ou 1.
 * V : 	Le type de la structure de donnee d'entree choisie
 * On obtient un arbre du type
 * 
 * 						   -----------------0---------------
 * 						   |							   |
 * 						 Male							Female
 * 				  ---------1----------			  ---------0----------
 * 				  |		   |	     |			  |	  	   |		 |
 * 				x<18	18<x<50		50<x		 <16	16<x<60		60<x
 * 				  0        1         0			  1        0         1
 */

public final class DecisionTreeAlgorithm<T, V extends DataObject> implements Algorithm<Tree<Answer<FeatureType,T>>, V> {
	
	private int trustProbability;
	
	public DecisionTreeAlgorithm(int trustProbability){
		this.trustProbability = trustProbability;
	}
	
	@Override
	public Tree<Answer<?,T>> train(List<V> data, List<Feature<FeatureType>> features){
		String bestLabel = this.mostFrequent(data);
		if(bestLabel != null){
			// No need to split further
			return new Leaf(bestLabel);
		} else if(features.isEmpty()){
			// Cannot split further
			return new Leaf(bestLabel);
		} else{
			int[] scoreFeature = new int[features.size()];
			// Mieux vaut boucler sur les donnees et sous-boucler sur les features que l'inverse !
			for(V tmpData : data){
				for(Feature<FeatureType> f : features){				
					FeatureType dataFeature = tmpData.getValueForFeature(f);
					for(Object value : f.getPossibleValues()){
					}
				}
			}
		}
		return null;
	}
	
	@Override
	public Tree<Answer<FeatureType,T>> test(){
		return null;
	}
	
	private String mostFrequent(List<V> data){
		HashMap<String, Integer> frequency = new HashMap<>();
		int bestFrequency = -1;
		String bestLabel = "";
		for(V element : data){
			String tmpLabel = element.getLabel();
			int tmpFreq = 1;
			if(frequency.containsKey(tmpLabel)){
				tmpFreq = frequency.get(tmpLabel)+1;
				frequency.replace(tmpLabel, tmpFreq);
			}
			else
				frequency.put(tmpLabel, 1);
			if(tmpFreq > bestFrequency){
				bestFrequency = tmpFreq;
				bestLabel = tmpLabel;
			}
		}
		int numberOfElements = data.size();
		if(bestFrequency > numberOfElements * trustProbability)
			return bestLabel;
		else
			return null;
	}
}
