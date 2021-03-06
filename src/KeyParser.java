import java.util.ArrayList;
import java.util.Random;


public class KeyParser {

	public KeyParser(){}

	public ArrayList<Key> parseToKey (String keyString){
		ArrayList<Key> keyKey = new ArrayList<Key>();
		for (String keyPair:keyString.split("|")){
			if (keyPair.length()>4){
				int start = Integer.parseInt(keyPair.split(",")[0]);
				int twist = Integer.parseInt(keyPair.split(",")[1]);
				Key tempKeyPair = new Key(start, twist);
				keyKey.add(tempKeyPair);
			}
		}
		return keyKey;
	}

	public String parseToString(ArrayList<Key> keyKey){
		StringBuilder sb = new StringBuilder();
		for (Key key: keyKey){
			sb.append(key.toString());
			sb.append("|");
		}
		return sb.toString();
	}

	public ArrayList<Key> randomKeyGenerator (){
		ArrayList<Key> randomKey = new ArrayList<Key>();
		Random generator = new Random();
		int start;
		int twist;
		twist = generator.nextInt(95);
		randomKey.add(new Key(0, twist));
		for (int i = 0; i<9; i++){
			start = generator.nextInt(100);
			twist = generator.nextInt(95); 
			randomKey.add(new Key(start,twist));
		}
		
		return randomKey;
	}


}
