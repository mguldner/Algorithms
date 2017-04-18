package general;

import java.util.List;

import decisiontree.Feature;

/*
 * T : type de retour de l'aglorithme
 * U : type d'input de l'algorithme
 */

public interface Algorithm<U extends DataObject, T> {

	T train(List<U> data, List<Feature<?>> features);
	
	T test();
}
