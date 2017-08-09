import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class MovementOne {

	public static ArrayList<Note> generate(String[] arg,boolean up){

		ArrayList<Note> mvmtOne = new ArrayList<>();

		for(String s : arg){
			int i = Integer.parseInt(s) - 1;
			if(!up){
				i = 12-i;
			}
			mvmtOne.add(new Note(60+i,4,""));
		}
		
		return mvmtOne;
	}

}