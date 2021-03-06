package PT2020.polinom.PolinomProject;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class CalcView extends JFrame {
	public static void main(String[] args) {
		final JFrame f = new JFrame("Calculator Polinoame");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600, 300);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JLabel l1 = new JLabel("Introduceti polinoamele");
		final JTextField tf1 = new JTextField(20);
		final JTextField tf3 = new JTextField(20);
		JLabel l2 = new JLabel("Rezultatul e");
		JLabel l3 = new JLabel(
				"Date de intrare trebuie introduse dupa formatul urmator: a1x^n+a2x^n-1+...+a(n-1)x^1+anx^0");
		final JTextField tf2 = new JTextField(30);
		p4.add(l3);
		p1.add(l1);
		p1.add(tf1);
		p1.add(tf3);
		p3.add(l2);
		p3.add(tf2);
		JButton b1 = new JButton("+");
		JButton b2 = new JButton("-");
		JButton b3 = new JButton("*");
		JButton b4 = new JButton("/");
		JButton b5 = new JButton("'");
		JButton b6 = new JButton("S");
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		JPanel p = new JPanel();
		p.add(p4);
		p.add(p1);
		p.add(p2);
		p.add(p3);
		final ArrayList<Monom> L1 = new ArrayList<Monom>();
		final ArrayList<Monom> L2 = new ArrayList<Monom>();
		ArrayList<Monom> rezl = new ArrayList<Monom>();
		final Polinom Pol1 = new Polinom(L1);
		final Polinom Pol2 = new Polinom(L2);
		final Polinom rez = new Polinom(rezl);
		final Operatii op = new Operatii(Pol1, Pol2, rez);

		b1.addActionListener(new ActionListener() {
			String text1;
			String text2;
			public void actionPerformed(ActionEvent e) {
				text1 = (String) tf1.getText();
				text2 = (String) tf3.getText();
				try {
					Pol1.prelucrareString(text1, L1);
					Pol2.prelucrareString(text2, L2);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(f, "Datele introduse sunt incorecte");
					return;
				}
				Pol1.sortare(L1);
				Pol1.setPol(L1);
				Pol2.sortare(L2);
				Pol2.setPol(L2);
				op.add(Pol1, Pol2, rez);
				rez.sortare(rez.getPol());
				text1 = "";
				for (Monom item : rez.getPol()) {
					if (item.getCoef() != 0) {
						if (item.getCoef() < 0) {
							text1 = text1 + String.valueOf(item.getCoef()) + "x^" + String.valueOf(item.getPow());
						} else if (item.getPow() == rez.getPol().get(0).getPow()) {
							text1 = text1 + String.valueOf(item.getCoef()) + "x^" + String.valueOf(item.getPow());
						} else {
							text1 = text1 + '+' + String.valueOf(item.getCoef()) + "x^" + String.valueOf(item.getPow());
						}
					}
				}
				tf2.setText(text1);
			}
		});

		b2.addActionListener(new ActionListener() {
			String text1 = "";
			String text2 = "";

			public void actionPerformed(ActionEvent e) {
				text1 = (String) tf1.getText();
				text2 = (String) tf3.getText();
				try {
					Pol1.prelucrareString(text1, L1);
					Pol2.prelucrareString(text2, L2);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(f, "Datele introduse sunt incorecte");
					return;
				}
				Pol1.sortare(L1);
				Pol1.setPol(L1);
				Pol2.sortare(L2);
				Pol2.setPol(L2);
				op.sub(Pol1, Pol2, rez);
				rez.sortare(rez.getPol());
				text1 = "";
				for (Monom item : rez.getPol()) {
					if (item.getCoef() != 0) {
						if (item.getCoef() < 0) {
							text1 = text1 + String.valueOf(item.getCoef()) + "x^" + String.valueOf(item.getPow());
						} else if (item.getPow() == rez.getPol().get(0).getPow()) {
							text1 = text1 + String.valueOf(item.getCoef()) + "x^" + String.valueOf(item.getPow());
						} else {
							text1 = text1 + '+' + String.valueOf(item.getCoef()) + "x^" + String.valueOf(item.getPow());
						}
					}
				}
				if (text1 == "") {
					text1 = "0";
				}
				tf2.setText(text1);
			}
		});

		b5.addActionListener(new ActionListener() {
			String text1 = "";

			public void actionPerformed(ActionEvent e) {
				text1 = (String) tf1.getText();
				try {
					Pol1.prelucrareString(text1, L1);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(f, "Datele introduse sunt incorecte");
					return;
				}
				Pol1.sortare(L1);
				Pol1.setPol(L1);
				op.deriv(Pol1, rez);
				rez.sortare(rez.getPol());
				text1 = "";
				for (Monom item : rez.getPol()) {
					if (item.getCoef() != 0) {
						if (item.getCoef() < 0) {
							text1 = text1 + String.valueOf(item.getCoef()) + "x^" + String.valueOf(item.getPow());
						} else if (item.getPow() == rez.getPol().get(0).getPow()) {
							text1 = text1 + String.valueOf(item.getCoef()) + "x^" + String.valueOf(item.getPow());
						} else {
							text1 = text1 + '+' + String.valueOf(item.getCoef()) + "x^" + String.valueOf(item.getPow());
						}
					}
				}
				tf2.setText(text1);
			}
		});

		b3.addActionListener(new ActionListener() {
			String text1 = "";
			String text2;

			public void actionPerformed(ActionEvent e) {
				text1 = (String) tf1.getText();
				text2 = (String) tf3.getText();
				try {
					Pol1.prelucrareString(text1, L1);
					Pol2.prelucrareString(text2, L2);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(f, "Datele introduse sunt incorecte");
					return;
				}
				Pol1.sortare(L1);
				Pol1.setPol(L1);
				Pol2.sortare(L2);
				Pol2.setPol(L2);
				op.mult(Pol1, Pol2, rez);
				rez.sortare(rez.getPol());
				text1 = "";
				for (Monom item : rez.getPol()) {
					if (item.getCoef() != 0) {
						if (item.getCoef() < 0) {
							text1 = text1 + String.valueOf(item.getCoef()) + "x^" + String.valueOf(item.getPow());
						} else if (item.getPow() == rez.getPol().get(0).getPow()) {
							text1 = text1 + String.valueOf(item.getCoef()) + "x^" + String.valueOf(item.getPow());
						} else {
							text1 = text1 + '+' + String.valueOf(item.getCoef()) + "x^" + String.valueOf(item.getPow());
						}
					}
				}
				tf2.setText(text1);
			}
		});

		b6.addActionListener(new ActionListener() {
			String text1 = "";

			public void actionPerformed(ActionEvent e) {
				text1 = (String) tf1.getText();
				try {
					Pol1.prelucrareString(text1, L1);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(f, "Datele introduse sunt incorecte");
					return;
				}
				Pol1.sortare(L1);
				Pol1.setPol(L1);
				op.integrare(Pol1, rez);
				rez.sortare(rez.getPol());
				text1 = "";
				for (Monom item : rez.getPol()) {
					if (item.getCoef() != 0) {
						if (item.getCoef() < 0) {
							text1 = text1 + String.valueOf(item.getCoef()) + '/' + String.valueOf(item.getPow()) + "x^"
									+ String.valueOf(item.getPow());
						} else if (item.getPow() == rez.getPol().get(0).getPow()) {
							text1 = text1 + String.valueOf(item.getCoef()) + '/' + String.valueOf(item.getPow()) + "x^"
									+ String.valueOf(item.getPow());
						} else {
							text1 = text1 + '+' + String.valueOf(item.getCoef()) + '/' + String.valueOf(item.getPow())
									+ "x^" + String.valueOf(item.getPow());
						}
					}
				}
				tf2.setText(text1);
			}
		});
		b4.addActionListener(new ActionListener() {
			String text1 = "";

			public void actionPerformed(ActionEvent e) {
				text1 = "Operatie necunoscuta";
				tf2.setText(text1);
			}
		});
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		f.setContentPane(p);
		f.setVisible(true);
	}
}
