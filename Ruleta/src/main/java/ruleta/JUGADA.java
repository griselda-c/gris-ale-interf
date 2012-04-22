package ruleta;

public enum JUGADA {

	V0("0", 0),V1("1", 1),	V2("2", 2),	V3("3", 3),	V4("4", 4),	V5("5", 5),
	V6("6", 6),	V7("7", 7),	V8("8", 8),	V9("9", 9),	V10("10", 10),	V11("11", 11),
	V12("12", 12),	V13("13", 13),	V14("14", 14),	V15("15", 15),	V16("16", 16),	V17("17", 17),
	V18("18", 18),	V19("19", 19),	V20("20", 20),	V21("21", 21),	V22("22", 22),	V23("23", 23),
	V24("24", 24),	V25("25", 25),	V26("26", 26),	V27("27", 27),	V28("28", 28),	V29("29", 29),
	V30("30", 30),	V31("31", 31),	V32("32", 32),	V33("33", 33),	V34("34", 34),	V35("35", 35),
	V36("36", 36),	PAR("Par", 37),	IMPAR("Impar", 38);
	
	private String nombre;
	private int valor;
	
	private JUGADA(String nombre, int valor) {
		this.nombre = nombre;
		this.valor = valor;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}