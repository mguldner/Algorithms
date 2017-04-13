package machinelearning.example.titanic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import machinelearning.decisiontree.Feature;
import machinelearning.decisiontree.Feature.FeatureType;
import machinelearning.decisiontree.data.Node;
import machinelearning.decisiontree.data.Tree;
import machinelearning.general.LossFunction;

public class RunExample {

	public static void main(String[] args) {
		ArrayList<Passenger> trainingSet = new ArrayList<Passenger>();
		HashMap<Integer, Boolean> trainingSetSurvivor = new HashMap<Integer, Boolean>();
		
		String trainingFile = "";
		try(BufferedReader br = new BufferedReader(new FileReader(trainingFile))){
			String line;
			while((line = br.readLine()) != null){
				String[] values = line.split(";");
				if("".equals(values[4]))
					values[4] = "-1";
				trainingSet.add(new Passenger(
						Integer.parseInt(values[0]),
						Integer.parseInt(values[2]),
						"M".equals(values[3]),
						Integer.parseInt(values[4]),
						Integer.parseInt(values[5]),
						Integer.parseInt(values[6]),
						values[7],
						Double.parseDouble(values[8]),
						values[9],
						values[10]));
				trainingSetSurvivor.put(Integer.parseInt(values[0]), "1".equals(values[1]));
			}
		}
		
		ArrayList<Passenger> testSet = new ArrayList<Passenger>();
		HashMap<Integer, Boolean> testSetSurvivor = new HashMap<Integer, Boolean>();
		String testFile = "";
		try(BufferedReader br = new BufferedReader(new FileReader(testFile))){
			String line;
			while((line = br.readLine()) != null){
				String[] values = line.split(";");
				if("".equals(values[4]))
					values[4] = "-1";
				testSet.add(new Passenger(
						Integer.parseInt(values[0]),
						Integer.parseInt(values[2]),
						"M".equals(values[3]),
						Integer.parseInt(values[4]),
						Integer.parseInt(values[5]),
						Integer.parseInt(values[6]),
						values[7],
						Double.parseDouble(values[8]),
						values[9],
						values[10]));
			}
		}
		// Liste a definir auparavant et a completer au fur et a mesure de la lecture des donnees d'entree
		ArrayList<String> possibleEmbarcations = new ArrayList<String>();
		possibleEmbarcations.add("Test");
		Feature<String> embarcation = new Feature<String>("Embarcation", possibleEmbarcations);
		List<Feature<FeatureType>> features = new ArrayList<Feature<FeatureType>>();
		features.add(embarcation);
		Tree<Answer> tree = new Node<Feature>();
		tree.setTrainingSet();
		tree.compute();
		prediction = tree.getTestResult(testSet);
		
		LossFunction lossFunction = new LossFunction();
		reality = ;
		lossFunction.getError(reality, prediction);
	}
}
