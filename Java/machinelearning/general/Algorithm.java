package machinelearning.general;

import java.util.List;

import machinelearning.decisiontree.Feature;
import machinelearning.decisiontree.Feature.FeatureType;

/*
 * T : type de retour de l'aglorithme
 * U : type d'input de l'algorithme
 */

public interface Algorithm<T,U extends DataObject> {

	T train(List<U> data, List<Feature<FeatureType>> features);
	
	T test();
}
