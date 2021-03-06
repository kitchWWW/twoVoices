import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class runner {

	public static void main(String[] args) {
		String  timeStamp = args[0];
		for(String s : args){
			System.out.println("arg: "+ s);
		}
		String[] xargs = args[1].replace("[","").replace("]","").split(",");
		String[] yargs = args[2].replace("[","").replace("]","").split(",");
		ArrayList<Insturment> insturments = new ArrayList<>();
		insturments.add(new Insturment("1","Voice Oohs","\"treble\"",false,false));
		insturments.add(new Insturment("2","Voice Oohs","\"treble\"",false,false));

		ArrayList<Note> oneTemp = MovementOne.generate(xargs,true);
		ArrayList<Note> twoTemp = MovementOne.generate(yargs,false);

		String oneFinal = Note.toString(oneTemp);
		String twoFinal = Note.toString(twoTemp);

		ArrayList<String> finalPart = new ArrayList<>();
		finalPart.add(oneFinal);
		finalPart.add(twoFinal);

		buildParts(timeStamp,"twoVoices", finalPart,insturments);
		//System.out.println("Done?");
	}

	private static void buildParts(String timeStamp, String title,
		ArrayList<String> parts, ArrayList<Insturment> insturments){
		try {
			ArrayList<String> longParts = new ArrayList<>();
			for(int index = 0; index < insturments.size(); index++){
				String newPart = "";
				File partFile = new File("templates/part.ly");
		        Scanner ps = new Scanner(partFile);
				while (ps.hasNextLine()) {
		            String i = ps.nextLine();

		            if(i.startsWith("%part")){
		            	newPart+= parts.get(index) +"\n";

		            }else if(i.startsWith("%name")){
		            	newPart+= insturments.get(index).name +"\n";

		            }else if(i.startsWith("%clef")){
		            	newPart+= insturments.get(index).staff +"\n";
		            
		            }else if(i.contains("%midi")){
		            	i = i.substring(0,i.indexOf("%midi"));
		            	newPart+= i+""+insturments.get(index).midi +"\"\n";

		            }else{
		            	newPart+=i + "\n";
		            }
		        }
		        longParts.add(newPart);
			}
			
			String res = "";
			File file = new File("templates/score.ly");
	        Scanner sc = new Scanner(file);

	        while (sc.hasNextLine()) {
	            String i = sc.nextLine();
	            if(i.startsWith("%part")){
	            	i = i.substring(5);
	            	int index = Integer.parseInt(i);
	            	if(index < longParts.size()){
	            		res+= longParts.get(index) +"\n";
	            	}
	            }else if(i.startsWith("%timeStamp")){
	            	res+= timeStamp +"\n";
	            }
	            else{
	            	res+=i + "\n";
	            }
	        }
        	sc.close();
			PrintWriter writer = new PrintWriter("out/"+timeStamp+"/"+title+"Score.ly", "UTF-8");
			writer.println(res);
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("I guess we give up now...");
		}
	}

}
