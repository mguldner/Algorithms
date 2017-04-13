package machinelearning.general;

import machinelearning.decisiontree.Feature;
import machinelearning.decisiontree.Feature.FeatureType;

public interface DataObject {

	public String getLabel();
	
	public Object getValueForFeature(Feature<FeatureType> f);
}
