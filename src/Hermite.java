import java.util.Scanner;

public class Hermite {

	private static int iloscElementow = 5;
	public static void pobierzDane(float[] x, float[] y, float[] yP) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Witaj uzytkowniku!");
		System.out.println("Podaja ilosc elementow");
		iloscElementow = in.nextInt();
		
		// Wypelnianie tablicy x
		for (int i = 0; i < iloscElementow; i++) {

			System.out.println("Podaj wartosc x dla x" + i + ":");
			x[i] = in.nextInt();

		}

		// Wypelnianie tablicy y
		for (int i = 0; i < iloscElementow; i++) {

			System.out.println("Podaj wartosci y dla x" + i + ":");
			y[i] = in.nextInt();

		}

		// Wypelnianie tablicy yP

		int parzystaIloscElementow  = (iloscElementow / 2) + 1;

		for (int i = 0; i < parzystaIloscElementow; i++) {

			System.out.println("Podaj wartosci yP dla x" + 2 * i + ":");

			yP[2 * i] = in.nextInt();
		}
		in.close();
	}

	public static void pokazTabelke(float[] x, float[] y, float[] yP) {
		
		System.out.println("Tabelka wartosci:");
		System.out.print("x:     ");
		for (int i = 0; i < iloscElementow; i++) {

			System.out.print("  |"+ x[i]);
			
			
			
		
		}
		System.out.println();
		System.out.print("f(x):  ");
		for (int i = 0; i < iloscElementow; i++) {
			System.out.print("  |" + y[i]);
			

		}
		System.out.println();
		System.out.print("f'(x): ");
		for (int i = 0; i < iloscElementow; i++) {
			System.out.print("  |" + yP[i] );
			
		}
	}
	
	public static void pokazKolumnyDoAlgorytmu(float[] x, float[] y){
		System.out.println();
		System.out.println("kolumna do algorytmu dla ulatwienia widoku");
		System.out.println("x   |    y");
		System.out.println("----------");
		for (int i = 0; i < iloscElementow; i++) {
			System.out.print("" + x[i]);
			System.out.print("   |    " + y[i] );
			System.out.println();
		}
		
	}

	
	public static void wylicz(float[] x, float[] y, float[] yP) {
		int licznikPrzejsc = 0;
		int licznikDlaPrim = 0;
		float wynik  = 0;
		while(licznikPrzejsc != 4) {
			
			
			for (int i = 0; i< iloscElementow-1; i++){
				
				float licznik = y[i+1]-y[i];
				float mianownik = x[i+1+licznikPrzejsc]-x[i];
				
				if (mianownik == 0) {
					
					wynik = yP[licznikDlaPrim];
					y[i] = wynik;
					licznikDlaPrim++;
				}
				else {
					
					wynik = licznik / mianownik;
					y[i]=wynik;
				}
//				System.out.println("----");
//				System.out.println(wynik + "    i    " + i);
				
			}
			
			System.out.println();
			for (int i = 0; i< iloscElementow-1; i++)
				System.out.print(y[i] + " ");
			System.out.println();
			//pokazKolumnyDoAlgorytmu(x, y);
			licznikPrzejsc++;
			iloscElementow--;
			
		}
	}
	

	
	public static void  main(String[] arg) {
		

		
		float[] x = {0,0,1,2,2};
		float[] y = {0,0,1,2,2};
		float[] yP = {1,-1,1};
		
		pokazKolumnyDoAlgorytmu(x, y);
	
		wylicz(x,y, yP );
	}

}
