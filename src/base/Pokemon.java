package base;

public class Pokemon {
	private String name;
	private int dexNumber;
	private Type primaryType;
	private Type secondaryType;
	private int total;
	private int hp;
	private int att;
	private int def;
	private int spatt;
	private int spdef;
	private int spd;
	private float height;
	private float weight;
	private int capRate;
	private int expGrowth;
	private int evs;
	
	public Pokemon(){

	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getDexNumber() {
		return dexNumber;
	}


	public void setDexNumber(int dexNumber) {
		this.dexNumber = dexNumber;
	}


	public Type getPrimaryType() {
		return primaryType;
	}


	public void setPrimaryType(Type primaryType) {
		this.primaryType = primaryType;
	}


	public Type getSecondaryType() {
		return secondaryType;
	}


	public void setSecondaryType(Type secondaryType) {
		this.secondaryType = secondaryType;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}


	public int getAtt() {
		return att;
	}


	public void setAtt(int att) {
		this.att = att;
	}


	public int getDef() {
		return def;
	}


	public void setDef(int def) {
		this.def = def;
	}


	public int getSpatt() {
		return spatt;
	}


	public void setSpatt(int spatt) {
		this.spatt = spatt;
	}


	public int getSpdef() {
		return spdef;
	}


	public void setSpdef(int spdef) {
		this.spdef = spdef;
	}


	public int getSpd() {
		return spd;
	}


	public void setSpd(int spd) {
		this.spd = spd;
	}


	public float getHeight() {
		return height;
	}


	public void setHeight(float height) {
		this.height = height;
	}


	public float getWeight() {
		return weight;
	}


	public void setWeight(float weight) {
		this.weight = weight;
	}


	public int getCapRate() {
		return capRate;
	}


	public void setCapRate(int capRate) {
		this.capRate = capRate;
	}


	public int getExpGrowth() {
		return expGrowth;
	}


	public void setExpGrowth(int expGrowth) {
		this.expGrowth = expGrowth;
	}


	public int getEvs() {
		return evs;
	}


	public void setEvs(int evs) {
		this.evs = evs;
	}

	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", dexNumber=" + dexNumber
				+ ", primaryType=" + primaryType + ", secondaryType="
				+ secondaryType + ", total=" + total + ", hp=" + hp + ", att="
				+ att + ", def=" + def + ", spatt=" + spatt + ", spdef="
				+ spdef + ", spd=" + spd + ", height=" + height + ", weight="
				+ weight + ", capRate=" + capRate + ", expGrowth=" + expGrowth
				+ ", evs=" + evs + "]";
	}
	
	
	
}

