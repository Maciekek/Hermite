import java.util.Scanner;

public class Hermite {

	private static int iloscElementow;
	private static int iloscElementowX;
	private static int parzystaIloscElementow;
	private static float[] rowX = new float[20];
	private static float[] rowY = new float[20];
	public static void pobierzDane(float[] x, float[] y, float[] yP) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Witaj uzytkowniku!");
		System.out.println("Podaja ilosc elementow");
		iloscElementowX = in.nextInt();
		iloscElementow = iloscElementowX+2;
		// Wypelnianie tablicy x
		for (int i = 0; i < iloscElementowX; i++) {

			System.out.println("Podaj wartosc x dla x" + i + ":");
			x[i] = in.nextInt();

		}

		// Wypelnianie tablicy y
		for (int i = 0; i < iloscElementowX; i++) {

			System.out.println("Podaj wartosci y dla x" + i + ":");
			y[i] = in.nextInt();

		}

		// Wypelnianie tablicy yP
		if(!(iloscElementowX%2 == 0)){
			parzystaIloscElementow  = (iloscElementowX / 2)+1;
		}else{
			parzystaIloscElementow  = (iloscElementowX / 2);
		}
		
		System.out.println(parzystaIloscElementow);
		for (int i = 0; i <= parzystaIloscElementow; i++) {
			if(!(parzystaIloscElementow <= i)){
				System.out.println("Podaj wartosci yP dla x" + 2 * i + ":");

				yP[2 * i] = in.nextInt();
			}
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

	
	public static void wylicz(float[] yP) {
		int licznikPrzejsc = 0;
		int licznikDlaPrim = 0;
		float wynik  = 0;
		while(licznikPrzejsc != iloscElementowX+1) {
			
			
			for (int i = 0; i< iloscElementow-1; i++){
				
				float licznik = rowY[i+1]-rowY[i];
				float mianownik = rowX[i+1+licznikPrzejsc]-rowX[i];
				if (mianownik == 0) {
					
					wynik = yP[licznikDlaPrim];
					rowY[i] = wynik;
					licznikDlaPrim+=2;
				}
				else {
					
					wynik = licznik / mianownik;
					rowY[i]=wynik;
				}
//				System.out.println("----");
//				System.out.println(wynik + "    i    " + i);
				
			}
			
			System.out.println();
			for (int i = 0; i< iloscElementow-1; i++)
				System.out.print(rowY[i] + " ");
			System.out.println();
			licznikPrzejsc++;
			iloscElementow--;
			
		}
	}
	
	
	
	public static void budujTabele(float[] x, float[] y, float[] yP){ 
		
		int licznik= 0;
		for (int i = 0; i < iloscElementowX+parzystaIloscElementow; i++) {
			
			System.out.print(x[i]);
			System.out.println("  " + y[i]);
			if (i%2 == 0) {
				rowX[licznik] = x[i];
				rowY[licznik] = y[i];
				licznik++;
				rowX[licznik] = x[i];
				rowY[licznik] = y[i];
//				System.out.println(i);
//				System.out.println(rowX[licznik] + "   "   + rowY[i]);
//				System.out.println(rowX[licznik+1] + "   "   + rowY[i+1]);
				licznik++;
			}
			else {
				rowX[licznik] = x[i];
				rowY[licznik] = y[i];
//				System.out.println(rowX[licznik+1] + "   "   + rowY[licznik+1]);
				licznik++;
			}
		}
		System.out.println("---------------");
		for (int i = 0; i < iloscElementowX+2; i++) {
			
			System.out.println(rowX[i] + "    "   + rowY[i]);
		}
	}
	
	public static void  main(String[] arg) {
		
		float[] x = new float[10];
		float[] y = new float[10];
		float[]yP = new float[10];
		pobierzDane(x, y, yP);
		budujTabele(x, y, yP);
		pokazKolumnyDoAlgorytmu(rowX, rowY);		
	
		wylicz(yP);
	}

}
