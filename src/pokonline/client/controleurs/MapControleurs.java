package pokonline.client.controleurs;

import java.util.ArrayList;

import pokonline.client.modeles.AssetManager;
import pokonline.client.modeles.MapModeles;

public class MapControleurs {
	public static ArrayList<MapModeles> allmaps = new ArrayList<>();
	public static MapModeles m1 = new MapModeles("finalvillage.tmx","finalvillage",false); 
	public static MapModeles m2 = new MapModeles("grotte1.tmx","grotte1",false);
	public static MapModeles m3 = new MapModeles("pokemon_center.tmx","pokemon_center",false);
	public static MapModeles m4 = new MapModeles("grotted1.tmx","grotted1",false);
	
	public static void initMap() {
		m1.addPkmns(AssetManager.bpkmnAltaria);m1.addPkmns(AssetManager.bpkmnGalie);
		
	}
	
	public static MapModeles searchMap(String name) {
		for(MapModeles m : allmaps) {
			if(m.getName().equals(name)) {
				return m;
			}
		}
		return null;
	}


}
