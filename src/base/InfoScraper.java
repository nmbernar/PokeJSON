package base;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class InfoScraper {
	
	private static final int numPokes = 718;

	public static void main(String[] args) {
		
		//Loops through each pokemon page
		/*for(int i = 1; i < 10; i++){
			Pokemon poke = scrapePage(i);
			System.out.println(poke.toString());
		} Current times out around after 8 times, probably shouldn't try to DOS site*/
	}

	public static Type parseStringForType(String type){
		switch(type){
		case "Bug":
			return Type.Bug;
		case "Dark":
			return Type.Dark;
		case "Dragon":
			return Type.Dragon;
		case "Electric":
			return Type.Electric;
		case "Fairy":
			return Type.Fairy;
		case "Fighting":
			return Type.Fighting;
		case "Fire":
			return Type.Fire;
		case "Flying":
			return Type.Flying;
		case "Ghost":
			return Type.Ghost;
		case "Grass":
			return Type.Grass;
		case "Ground":
			return Type.Ground;
		case "Ice":
			return Type.Ice;
		case "Normal":
			return Type.Normal;
		case "Poison":
			return Type.Poison;
		case "Psychic":
			return Type.Psychic;
		case "Rock":
			return Type.Rock;
		case "Steel":
			return Type.Steel;
		case "Water":
			return Type.Water;
		default:
			return null;
		}
		
	}
	
	public static float parseElementForWeight(Element weight){
		String weight2 = weight.text();
		
		int beginWeight = weight2.indexOf("(");
		int endWeight = weight2.indexOf(" k");
		
		weight2 = weight2.substring(beginWeight+1, endWeight);
		return Float.valueOf(weight2);
	}
	
	public static float parseElementForHeight(Element height){
		String height2 = height.text();
		
		int beginHeight = height2.indexOf("(");
		int endHeight = height2.indexOf("m");
		
		height2 = height2.substring(beginHeight+1, endHeight);
		return Float.valueOf(height2);
	}
	
	public static int parseElementForCapRate(Element capRate){
		String capRate2 = capRate.text();
		int endCap = capRate2.indexOf("(");
		
		capRate2 = capRate2.substring(0, endCap-1);
		return Integer.valueOf(capRate2);
	}
	
	public static int parseElementForExpGrowth(Element growth){
		String growth2 = growth.text();
		
		switch(growth2){
		case "Erratic":
			return 600000;
		case "Fast":
			return 800000;
		case "Medium Fast":
			return 1000000;
		case "Medium Slow":
			return 1059860;
		case "Slow":
			return 1250000;
		case "Fluctuating":
			return 1640000;
		default:
			return 0;
		}
	}
	
	public static Pokemon scrapePage(int id){
		Pokemon poke = new Pokemon();
		String stringId = String.valueOf(id);
		
		//TODO: Do the loop de loop 
		try {
			Document doc = Jsoup.connect("http://pokemondb.net/pokedex/" + String.valueOf(id)).get();
			
			//name
			Element name = doc.select("h1").first();
			poke.setName(name.text());
			
			//national dex number
			Element dexnum = doc.select("strong").first();
			poke.setDexNumber(Integer.valueOf(dexnum.text()));
			
			//Type
			Elements type = doc.select("#svtabs_basic_" + stringId + " > div:nth-child(1) > div:nth-child(2) > table > tbody > tr:nth-child(2) > td > a.type-icon:nth-child(1)");
			Type primary = parseStringForType(type.text());
			poke.setPrimaryType(primary);
			
			Elements type2 = doc.select("#svtabs_basic_" + stringId + " > div:nth-child(1) > div:nth-child(2) > table > tbody > tr:nth-child(2) > td > a.type-icon:nth-child(2)");
			if(!type2.equals(null)){
				//Pokemon has two types
				Type secondary = parseStringForType(type2.text());
				poke.setSecondaryType(secondary);
			}
			
			//Base stats total
			Element total = doc.select(".num-total").first();
			poke.setTotal(Integer.valueOf(total.text()));
			
			//HP
			Element hp = doc.select("#svtabs_basic_" + stringId + " > div:nth-child(2) > div.col.span-8 > table > tbody > tr:nth-child(1) > td:nth-child(2)").first();
			poke.setHp(Integer.valueOf(hp.text()));
			
			//Attack
			Element attack = doc.select("#svtabs_basic_" + stringId + " > div:nth-child(2) > div.col.span-8 > table > tbody > tr:nth-child(2) > td:nth-child(2)").first();
			poke.setAtt(Integer.valueOf(attack.text()));
			
			//Defense
			Element defense = doc.select("#svtabs_basic_" + stringId + " > div:nth-child(2) > div.col.span-8 > table > tbody > tr:nth-child(3) > td:nth-child(2)").first();
			poke.setDef(Integer.valueOf(defense.text()));
			
			//Special Attack
			Element specAttack = doc.select("#svtabs_basic_" + stringId + " > div:nth-child(2) > div.col.span-8 > table > tbody > tr:nth-child(4) > td:nth-child(2)").first();
			poke.setSpatt(Integer.valueOf(specAttack.text()));
			
			//Special Def
			Element specDefense = doc.select("#svtabs_basic_" + stringId + " > div:nth-child(2) > div.col.span-8 > table > tbody > tr:nth-child(5) > td:nth-child(2)").first();
			poke.setSpdef(Integer.valueOf(specDefense.text()));
			
			//Speed
			Element speed = doc.select("#svtabs_basic_" + stringId + " > div:nth-child(2) > div.col.span-8 > table > tbody > tr:nth-child(6) > td:nth-child(2)").first();
			poke.setSpd(Integer.valueOf(speed.text()));
			
			//Height
			Element height = doc.select("#svtabs_basic_" + stringId + " > div:nth-child(1) > div:nth-child(2) > table > tbody > tr:nth-child(4) > td").first();
			float metricHeight = parseElementForHeight(height);
			poke.setHeight(metricHeight);
			
			//Weight
			Element weight = doc.select("#svtabs_basic_" + stringId + " > div:nth-child(1) > div:nth-child(2) > table > tbody > tr:nth-child(5) > td").first();
			float metricWeight = parseElementForWeight(weight);
			poke.setWeight(metricWeight);
			
			//Catch rate
			Element catchRate = doc.select("#svtabs_basic_" + stringId + " > div:nth-child(1) > div.col.desk-span-4.lap-span-12 > div > div:nth-child(1) > table > tbody > tr:nth-child(2) > td").first();
			int cRate = parseElementForCapRate(catchRate);
			poke.setCapRate(cRate);
			
			//Exp growth
			Element growth = doc.select("#svtabs_basic_" + stringId + " > div:nth-child(1) > div.col.desk-span-4.lap-span-12 > div > div:nth-child(1) > table > tbody > tr:nth-child(5) > td").first();
			int xpGrowth = parseElementForExpGrowth(growth);
			poke.setExpGrowth(xpGrowth);
			
			/*
			//Effort Values
			Element evs = doc.select("#svtabs_basic_" + stringId + " > div:nth-child(1) > div.col.desk-span-4.lap-span-12 > div > div:nth-child(1) > table > tbody > tr:nth-child(4) > td").first();
			poke.setEvs(Integer.valueOf(evs.text()));
			*/
			//Figure out how to handle mega forms
			
			//Set stats
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return poke;
	}
	
}
