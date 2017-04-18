package example.titanic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import decisiontree.Feature;
import decisiontree.Feature.FeatureType;
import decisiontree.data.Node;
import decisiontree.data.Tree;
import example.titanic.features.Frame;
import general.LossFunction;

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
		// Listes a definir auparavant et a completer au fur et a mesure de la lecture des donnees d'entree
		ArrayList<String> possibleEmbarcations = new ArrayList<String>();
		possibleEmbarcations.add("C");
		possibleEmbarcations.add("Q");
		possibleEmbarcations.add("S");
		Feature<String> embarcation = new Feature<String>("embarked", possibleEmbarcations);
		
		ArrayList<Integer> possiblePClasses = new ArrayList<Integer>();
		possiblePClasses.add(1);
		possiblePClasses.add(2);
		possiblePClasses.add(3);
		Feature<Integer> passengerClass = new Feature<Integer>("pClass", possiblePClasses);
		
		ArrayList<Frame> possibleAges = new ArrayList<Frame>();
		possibleAges.add(new Frame(0,18));
		possibleAges.add(new Frame(18,50));
		possibleAges.add(new Frame(50,100));
		Feature<Frame> age = new Feature<Frame>("age", possibleAges);
		
		List<Feature<?>> features = new ArrayList<Feature<?>>();
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
