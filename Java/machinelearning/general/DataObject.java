package general;

import decisiontree.Feature;

public interface DataObject {

	public String getLabel();
	
	public int classificationForFeature(Feature<?> feature);
}
