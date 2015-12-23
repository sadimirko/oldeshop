import java.util.*;

public class Eshop {
	private static final Scanner sc = new Scanner(System.in);
	
	private static Produkty zoznamProduktov = new Produkty();
	private static Objednavky zoznamObjednavok = new Objednavky();
	private static Uzivatelia zoznamUzivatelov = new Uzivatelia();
	private static int i = 0;
	private static int j = 0;
	private static int k = 0;
	private static Uzivatel prihlaseny = new Uzivatel(); 

	public static void run() {
		System.out.println("Vytajte v nasom Eshope");

		sc.useLocale(Locale.US);
		String znak = new String();
		Eshop.menu();
		while (!znak.equals("0")) {
			System.out.println("************************************************");
			znak = sc.nextLine();
			switch (znak) {
			case "1":
				System.out.println("*--- Produkty---*");
				System.out.println(zoznamProduktov.toString());
				break;
			case "2":
				System.out.println("*--- Pridanie produktu---*");
				pridajPr();
				System.out.println(zoznamProduktov.toString());
				break;
			case "3":
				System.out.println("*--- Zmazanie produktu---*");
				ZmazPr();
				System.out.println(zoznamProduktov.toString());
				break;
			case "4":
				System.out.println("*--- Objednavky ---*");
				System.out.println(zoznamObjednavok.toString());
				break;
			case "5":
				System.out.println("*--- Pridanie objednavky ---*");
				pridajOb();
				System.out.println(zoznamObjednavok.toString());
				break;
			case "6":
				System.out.println("*--- Vypisanie uzivatelov ---*");
				System.out.println(zoznamUzivatelov.toString());
				break;
			case "7":
				System.out.println("*--- pridaj uzivatela ---*");
				pridajUz();
				System.out.println(zoznamUzivatelov.toString());
				break;		
			case "9":
				menu();
				break;		
			default:
				System.out.println("Zadaj znova.");
				break;
			}	
		}
		System.out.println("*---Dovidenia.---*");
	}

	public static void pridajUz() {
		String meno;
		String priezvisko;
		System.out.println("Zadaj meno");
		meno = sc.nextLine();
		System.out.println("Zadaj priezvisko");
		priezvisko = sc.nextLine();
		Uzivatel uzivatel = new Uzivatel(j++, meno, priezvisko, false);
		zoznamUzivatelov.pridajUzivatela(uzivatel);
	}
	
	public static void pridajOb() {
		
		Uzivatel zakaznik = prihlaseny; 
		List <Produkt> objednane = new ArrayList<Produkt>();		
		System.out.println();
		Integer znak = 99;
		while (znak != (0)){
			System.out.println("*---Vyber produkt ktory chces pridat do objednavky---* ");
			System.out.println();
			System.out.println(zoznamProduktov.toString());
			System.out.println("Zadaj cislo produktu");
			znak = sc.nextInt();
			objednane.add(zoznamProduktov.vyberProdukt(znak));
			System.out.println("chces pridat dalsi  ak nie stlac 0");
			znak = sc.nextInt();
		}
		Objednavka nova = new Objednavka(k++, objednane, false, zakaznik);
		zoznamObjednavok.pridajObjednavku(nova);
	}

	public static void pridajPr() {
		String nazov;
		String popis;
		double cena;
		System.out.println("Zadaj nazov produktu");
		nazov = sc.nextLine();
		System.out.println("Zadaj popis produktu");
		popis = sc.nextLine();
		System.out.println("Zadaj cenu produktu");
		cena = sc.nextDouble();
		Produkt produkt = new Produkt(i++, nazov, popis, cena);
		zoznamProduktov.pridajProdukt(produkt);
	}
	public static void ZmazPr() {
		int znak;
		System.out.println("*---Vyber produkt ktory chces zmazat---* ");
		System.out.println();
		System.out.println(zoznamProduktov.toString());
		System.out.println("Zadaj cislo produktu ktory chces zmazat");
		znak = sc.nextInt();
		zoznamProduktov.zmazProdukt(znak);
		System.out.println("Produkt cislo "+znak+"bol zmazany");
	}
	
	public static void menu(){
		System.out.println();
		System.out.println("*****************   MENU   *********************");
		System.out.println("Stlacte 1 - vypisanie produktov");
		System.out.println("Stlacte 2 - pridanie produktu");
		System.out.println("Stlacte 3 - zmazanie produktu");
		System.out.println("Stlacte 4 - vypisanie objednavok");
		System.out.println("Stlacte 5 - pridanie objednavky");
		System.out.println("Stlacte 6 - vypisanie uzivatelov");
		System.out.println("Stlacte 7 - pridaj uzivatela");
		System.out.println("Stlacte 9 - zobrazenie Menu");
		System.out.println("Ak chcete skoncit stlacte 0.");
	}
}
