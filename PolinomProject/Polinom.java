package PT2020.polinom.PolinomProject;

import java.util.*;

public class Polinom {
	private ArrayList<Monom> Pol = new ArrayList<Monom>();

	public Polinom(ArrayList<Monom> Pol) {
		this.Pol = Pol;
	}

	public ArrayList<Monom> getPol() {
		return Pol;
	}

	public void setPol(ArrayList<Monom> pol) {
		Pol = pol;
	}

	public void prelucrareString(String s, ArrayList<Monom> Pol) {
		Pol.removeAll(Pol);
		int maxpow = 0;
		for (int i = 0; i < s.length(); i++) {
			String nr = "";
			Monom a = new Monom(0, 0);
			if ((s.charAt(i) > 'a') && (s.charAt(i) < 'z')) {
				if (i == 0 || s.charAt(i - 1) == '+') {
					nr = "+1";
				} else if (s.charAt(i - 1) == '-') {
					nr = "-1";
				} else {
					int j = i - 1;
					while (((j >= 0) && ((s.charAt(j) >= '0') && (s.charAt(j) <= '9') && (s.charAt(j + 1) != '-')))|| (s.charAt(j) == '-')) {
						nr = s.charAt(j) + nr;
						j--;
						if (j == -1) {
							break;
						}
					}
				}
				a.setCoef(Integer.parseInt(nr));
				int j = i + 2;
				nr = "";
				while (j <= s.length() && s.charAt(j) != '-' && s.charAt(j) != '+') {
					nr = nr + s.charAt(j);
					j++;
					if (j == s.length()) {
						break;
					}
				}
				a.setPow(Integer.parseInt(nr));
				if (maxpow < a.getPow()) {
					maxpow = a.getPow();
				}
				Pol.add(a);
			}
		}
	}

	public void sortare(ArrayList<Monom> Lista) {
		Collections.sort(Lista, new Comparator<Monom>() {

			public int compare(Monom m1, Monom m2) {
				return (m2.getPow() - m1.getPow());
			}
		});
		int maxpow = Lista.get(0).getPow();
		for (int i1 = 0; i1 < maxpow; i1++) {
			boolean con = false;
			for (int j = 0; j < Pol.size(); j++) {
				if (Pol.get(j).getPow() == i1) {
					con = true;
				}
			}
			if (con == false)
				Pol.add(new Monom(0, i1));
		}
		Collections.sort(Lista, new Comparator<Monom>() {

			public int compare(Monom m1, Monom m2) {
				return (m2.getPow() - m1.getPow());
			}
		});
	}
}
