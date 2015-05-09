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
		/*
		for(int i = 0; i < numPokes; i++){
			Pokemon poke = scrapPage(i);
		}*/
		scrapePage(1);
	}

	public Type parseStringForType(String type){
		
		
		return null;
	}
	
	public float parseElementForWeight(Element weight){
		
		return 0;
	}
	
	public float parseElementForHeight(Element height){
		
		return 0;
	}
	
	public int parseElementForCapRate(String capRate){
		
		return 0;
	}
	
	public int parseElementForExpGrowth(Element growth){
		
		return 0;
	}
	
	public static String scrapePage(int id){
		//TODO: Do the loop de loop 
		try {
			Document doc = Jsoup.connect("http://pokemondb.net/pokedex/" + String.valueOf(id)).get();
			
			//name
			Element name = doc.select("h1").first();
			
			//national dex number
			Element dexnum = doc.select("strong").first();
			
			//Type
			Elements type = doc.select("#svtabs_basic_1 > div:nth-child(1) > div:nth-child(2) > table > tbody > tr:nth-child(2) > td > a.type-icon");
			if(type.size() > 1){
				//Pokemon has two types
				//primary type.get(0).text();
				//secondary type.get(1).text();
			}
			
			//Base stats total
			Element total = doc.select(".num-total").first();
			
			//HP
			Element hp = doc.select("#svtabs_basic_1 > div:nth-child(2) > div.col.span-8 > table > tbody > tr:nth-child(1) > td:nth-child(2)").first();
			
			//Attack
			Element attack = doc.select("#svtabs_basic_1 > div:nth-child(2) > div.col.span-8 > table > tbody > tr:nth-child(2) > td:nth-child(2)").first();
			
			//Defense
			Element defense = doc.select("#svtabs_basic_1 > div:nth-child(2) > div.col.span-8 > table > tbody > tr:nth-child(3) > td:nth-child(2)").first();
			
			//Special Attack
			Element specAttack = doc.select("#svtabs_basic_1 > div:nth-child(2) > div.col.span-8 > table > tbody > tr:nth-child(4) > td:nth-child(2)").first();
			
			//Special Def
			Element specDefense = doc.select("#svtabs_basic_1 > div:nth-child(2) > div.col.span-8 > table > tbody > tr:nth-child(5) > td:nth-child(2)").first();
			
			//Speed
			Element speed = doc.select("#svtabs_basic_1 > div:nth-child(2) > div.col.span-8 > table > tbody > tr:nth-child(6) > td:nth-child(2)").first();
			
			//Height
			Element height = doc.select("#svtabs_basic_1 > div:nth-child(1) > div:nth-child(2) > table > tbody > tr:nth-child(4) > td").first();
			
			//Weight
			Element weight = doc.select("#svtabs_basic_1 > div:nth-child(1) > div:nth-child(2) > table > tbody > tr:nth-child(5) > td").first();
			
			//Catch rate
			Element catchRate = doc.select("#svtabs_basic_1 > div:nth-child(1) > div.col.desk-span-4.lap-span-12 > div > div:nth-child(1) > table > tbody > tr:nth-child(2) > td").first();
			
			//Exp growth
			Element growth = doc.select("#svtabs_basic_1 > div:nth-child(1) > div.col.desk-span-4.lap-span-12 > div > div:nth-child(1) > table > tbody > tr:nth-child(5) > td").first();
		
			//Effort Values
			Element evs = doc.select("#svtabs_basic_1 > div:nth-child(1) > div.col.desk-span-4.lap-span-12 > div > div:nth-child(1) > table > tbody > tr:nth-child(4) > td").first();
		
			//Figure out how to handle mega forms
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
