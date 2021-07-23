package pokonline.client.modeles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import pokonline.client.controleurs.MapControleurs;
import pokonline.client.pokemon.pokemon;

public class MapModeles {
	private boolean encounter;
	private TiledMap map;
	private String name;
	private ArrayList<pokemon> pkmns = new ArrayList<>();
	public MapModeles(String filemapname,String name,boolean encounter) {
		this.encounter = encounter;
		try {
			this.loadFile("map/" + filemapname);
			this.map = new TiledMap("map/" + filemapname);
			MapControleurs.allmaps.add(this);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.name = name;
		// TODO Auto-generated constructor stub
	}
	public boolean isEncounter() {
		return encounter;
	}
	public void setEncounter(boolean encounter) {
		this.encounter = encounter;
	}
	public TiledMap getMap() {
		return map;
	}
	public void setMap(TiledMap map) {
		this.map = map;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void loadFile(String path) {
		ArrayList<String> allLines = new ArrayList<>();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(path));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String line = "";
		boolean needReWrite = false;
		try {
			while ((line = in.readLine()) != null)
			{	
				String temp = new String(line);
				if(line.contains("transition") && !line.contains("width")){
					temp = "";
				    for(int i = 0; i < line.length(); i++) 
				    {
				    	if(line.charAt(i) == '>') {
				    		temp += " width=" +'"'+30+'"'+ " height="+'"'+30+'"';
				    		needReWrite = true;
				    	}
				    	else {
				    		temp += line.charAt(i);
				    	}
					}
				    temp += '>';
				    System.out.println("Re write the file : " + path);
				}
				allLines.add(temp);  
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(needReWrite) {
			this.writeIntoFiles(path, allLines);
		}
		
		
	}
	public void writeIntoFiles(String path, ArrayList<String> vec) {
		FileWriter myWriter = null;
		try {
			myWriter = new FileWriter(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < vec.size();i++) {
			try {
				myWriter.write(vec.get(i) + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			myWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<pokemon> getPkmns() {
		return pkmns;
	}
	public void setPkmns(ArrayList<pokemon> pkmns) {
		this.pkmns = pkmns;
	}
	public void addPkmns(pokemon pkmn) {
		this.pkmns.add(pkmn);
	}

}
