import java.util.Scanner;

public class Hermite {

	private static int iloscElementow;
	private static int iloscElementowX;
	private static int parzystaIloscElementow;
	private static int rozmiarTablicy = 20;
	private static float[] rowX = new float[rozmiarTablicy];
	private static float[] rowY = new float[rozmiarTablicy];
	static float[] wynik = new float[rozmiarTablicy];
	static float[] wynikPoSumowaniu = new float[rozmiarTablicy];
	private static float[] wspolczynnikWielomianu = new float[rozmiarTablicy];

	public static void pobierzDane(float[] x, float[] y, float[] yP) {

		Scanner in = new Scanner(System.in);
		System.out.println("Witaj uzytkowniku!");
		System.out.println("Podaja ilosc elementow x: ");
		iloscElementowX = in.nextInt();
		// iloscElementowX = 3;
		// Wypelnianie tablicy x
		for (int i = 0; i < iloscElementowX; i++) {

			boolean dodanoX = false;

			while (!dodanoX) {

				System.out.println("Podaj wartosc x dla x" + i + ":");
				boolean jestWTablicy = false;
				int wprowadzonyX = in.nextInt();

				for (int j = 0; j < i; j++) {

					if (x[j] == wprowadzonyX) {
						jestWTablicy = true;
						break;
					}
				}

				if (!jestWTablicy) {

					x[i] = wprowadzonyX;
					dodanoX = true;
				} else {
					System.out.println("Taki x juz zostal wpisany!");
				}
			}
			// x[0] = 0;
			// x[1] = 1;
			// x[2] = 2;

			// x[0] = 0;
			// x[1] = 1;
			// x[2] = -1;
		}

		// Wypelnianie tablicy y
		for (int i = 0; i < iloscElementowX; i++) {

			System.out.println("Podaj wartosci y dla x" + i + ":");
			y[i] = in.nextInt();
			// y[0] = 0;
			// y[1] = 1;
			// y[2] = 2;

			// y[0] = 2;
			// y[1] = 5;
			// y[2] = 7;

		}

		// Wypelnianie tablicy yP
		if (!(iloscElementowX % 2 == 0)) {
			parzystaIloscElementow = (iloscElementowX / 2) + 1;
		} else {
			parzystaIloscElementow = (iloscElementowX / 2);
		}

		System.out.println(parzystaIloscElementow);
		for (int i = 0; i <= parzystaIloscElementow; i++) {

			// yP[0] = 1;
			// yP[1] = 0;
			// yP[2] = -1;
			if (!(parzystaIloscElementow <= i)) {
				System.out.println("Podaj wartosci yP dla x" + 2 * i + ":");

				yP[2 * i] = in.nextInt();
			}
		}
		iloscElementow = iloscElementowX + parzystaIloscElementow;
		in.close();
	}

	public static void pokazTabelke(float[] x, float[] y, float[] yP) {

		System.out.println("Tabelka wartosci:");
		System.out.print("x:     ");
		for (int i = 0; i < iloscElementow; i++) {

			System.out.print("  |" + x[i]);

		}
		System.out.println();
		System.out.print("f(x):  ");
		for (int i = 0; i < iloscElementow; i++) {
			System.out.print("  |" + y[i]);

		}
		System.out.println();
		System.out.print("f'(x): ");
		for (int i = 0; i < iloscElementow; i++) {
			System.out.print("  |" + yP[i]);

		}
	}

	public static void pokazKolumnyDoAlgorytmu(float[] x, float[] y) {
		System.out.println();
		System.out.println("kolumna do algorytmu dla ulatwienia widoku");
		System.out.println("x   |    y");
		System.out.println("----------");
		for (int i = 0; i < iloscElementow; i++) {
			System.out.print("" + x[i]);
			System.out.print("   |    " + y[i]);
			System.out.println();
		}

	}

	public static void wylicz(float[] yP, float[] y) {
		int numer = 1;
		int licznikPrzejsc = 0;
		int licznikDlaPrim = 0;
		float wynik = 0;
		wspolczynnikWielomianu[0] = y[0];
		while (licznikPrzejsc != iloscElementowX + 1) {

			for (int i = 0; i < iloscElementowX + parzystaIloscElementow - 1; i++) {

				float licznik = rowY[i + 1] - rowY[i];
				float mianownik = rowX[i + 1 + licznikPrzejsc] - rowX[i];
				if (mianownik == 0) {

					wynik = yP[licznikDlaPrim];
					rowY[i] = wynik;
					licznikDlaPrim += 2;
				} else {

					wynik = licznik / mianownik;
					rowY[i] = wynik;
				}

			}
			for (int i = 0; i < iloscElementow - 1; i++) {
				System.out.print(rowY[i] + " ");
			}

			System.out.println();

			wspolczynnikWielomianu[numer++] = rowY[0];
			System.out.println();
			licznikPrzejsc++;
			iloscElementow--;

		}
	}

	public static void budujTabele(float[] x, float[] y, float[] yP) {

		int licznik = 0;
		for (int i = 0; i < iloscElementowX + parzystaIloscElementow; i++) {

			if (i % 2 == 0) {
				rowX[licznik] = x[i];
				rowY[licznik] = y[i];
				licznik++;
				rowX[licznik] = x[i];
				rowY[licznik] = y[i];
				licznik++;
			} else {
				rowX[licznik] = x[i];
				rowY[licznik] = y[i];
				licznik++;
			}
		}
		// System.out.println("---------------");
		// for (int i = 0; i < iloscElementowX + 2; i++) {
		//
		// System.out.println(rowX[i] + "    " + rowY[i]);
		// }
	}

	private static void zbudujWielomian(float[] wspolczynnikWielomianu,
			float[] tabX) {
		int licznikPrzebiegu = 1;
		float[] Wx = new float[rozmiarTablicy];
		float[] Vx = new float[2];
		wynikPoSumowaniu[0] = wspolczynnikWielomianu[0];

		for (int i = 1; i < Wx.length - 1; i++) {
			int licznik = i;

			if (licznikPrzebiegu == 1) {
				Wx[--licznik] = wspolczynnikWielomianu[i];
				Vx[0] = 1;
				Vx[1] = tabX[licznik];

				mnozenie(Wx, Vx);

			}

			if (licznikPrzebiegu != 1) {
				int licznikX0 = 0;
				Wx[0] = wspolczynnikWielomianu[i];
				// System.out
				// .println("\nUstawiam wartosc "
				// + wspolczynnikWielomianu[i] + "na indeksie: "
				// + licznik);
				Vx[0] = 1;

				for (int k = 0; k < licznikPrzebiegu; k++) {
					Vx[1] = tabX[licznikX0];
					mnozenie(Wx, Vx);
					for (int j = 0; j < Wx.length; j++) {
						Wx[j] = wynik[j];
					}
					licznikX0++;
					Wx[0] = 0;
				}

			}

			for (int j = 1; j < Wx.length; j++) {
				wynikPoSumowaniu[j] += wynik[j];

			}
			licznikPrzebiegu++;
			for (int k = 0; k < Wx.length; k++) {
				Wx[k] = 0;
				wynik[k] = 0;
			}
		}

		System.out.println("\n \n WIELOMIAN");
		for (float x : wynikPoSumowaniu) {
			System.out.print(x + ", ");
		}
		System.out.println("\n Wielomian");
		for (int i = 0; i < Wx.length; i++) {
			System.out.print(wynikPoSumowaniu[i] + "x^" + i + " + ");
		}

	}

	private static void mnozenie(float[] Wx, float[] Vx) {
		// //Logi kontrolne
		// System.out.println("Elementy w tabeli Wx: ");
		// for (float x : Wx) {
		// System.out.print(x + ", ");
		// }
		//
		// System.out.println("\n \nElementy w tabeli Vx: ");
		// for (float x : Vx) {
		// System.out.print(x + ", ");
		// }

		wynik[0] = (-1) * Wx[0] * Vx[1];
		for (int i = 1; i <= iloscElementowX + 2; i++) {
			int licznik = i;

			if (i == iloscElementowX + 1) { // maksymalny wspolczynnik
				wynik[i] = Wx[--licznik];
				// System.out.println(wynik[i]);
			} else {
				// System.out.println();
				wynik[i] = Wx[--licznik] - Wx[i] * Vx[1];
				// System.out.println(wynik[i]);
			}
		}
		// System.out.println("\n \nElementy w tabeli Wynik: ");
		// for (float x : wynik) {
		// System.out.print(x + ", ");
		// }

	}

	public static void calkuj(float[] wynikPoSumowaniu) {

	
		for (int i = 0; i < wynikPoSumowaniu.length; i++) {

			float wylicz = (float) (1.0 / (i + 1));
			wynikPoSumowaniu[i] = roundOff((wynikPoSumowaniu[i] * wylicz),2);

		}

	}

	public static void drukujWynik(float[] wynikPoSumowaniu) {

		System.out.println();
		System.out.println("\n\n\n\nWynik po calkowaniu :");
		for (int i = 0; i < wynikPoSumowaniu.length; i++) {

			if(wynikPoSumowaniu[i] !=0)
				System.out.print(wynikPoSumowaniu[i] + "x^" + (i + 1) + " + ");
		}

	}
	
	public static float roundOff(float x, int position)
	{
        float a = x;
        double temp = Math.pow(10.0, position);
        a *= temp;
        a = Math.round(a);
        return (a / (float)temp);
    }

	public static void main(String[] arg) {
		float[] x = new float[rozmiarTablicy];
		float[] y = new float[rozmiarTablicy];
		float[] yP = new float[rozmiarTablicy];
		pobierzDane(x, y, yP);
		budujTabele(x, y, yP);
		pokazKolumnyDoAlgorytmu(rowX, rowY);

		wylicz(yP, y);

		zbudujWielomian(wspolczynnikWielomianu, rowX);
		calkuj(wynikPoSumowaniu);
		drukujWynik(wynikPoSumowaniu);
	}

}
