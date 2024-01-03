package ProiectP3Biblioteca;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DesignAdaugCarte extends JFrame{

	JLabel titluPg;
	JLabel idCarte;
	JLabel titluCarte;
	JLabel genCarte;
	JLabel nrZileImpCarte;
	JLabel autorCarte;
	
	JTextField id;
	JTextField titlu;
	JTextField gen;
	JTextField autor;
	JTextField nrZile;
	
	JButton adauga;
	
	public DesignAdaugCarte() {
	
	JPanel panelAdaugaCarte = new JPanel();
	panelAdaugaCarte.setLayout(new BoxLayout(panelAdaugaCarte, BoxLayout.Y_AXIS));
	
	this.setTitle("Adauga carte noua in biblioteca");
	this.setSize(650, 500);
	this.setLayout(new FlowLayout(FlowLayout.LEFT));
	
	titluPg = new JLabel("Adauga o carte noua in biblioteca");
	
	idCarte=new JLabel("ID-ul cartii");
	titluCarte=new JLabel("Titlu cartii");
	autorCarte = new JLabel("Autorul cartii");
	genCarte = new JLabel("Genul Cartii");
	nrZileImpCarte= new JLabel("Numarul de zile de imprumut al cartii");
	
	id = new JTextField(20);
	titlu = new JTextField(20);
	gen = new JTextField(20);
	autor = new JTextField(20);
	nrZile= new JTextField(20);
	
	adauga = new JButton("AGAUGA O NOUA CARTE");
	
	panelAdaugaCarte.add(idCarte);
	panelAdaugaCarte.add(id);
	panelAdaugaCarte.add(titluCarte);
	panelAdaugaCarte.add(titlu);
	panelAdaugaCarte.add(genCarte);
	panelAdaugaCarte.add(gen);
	panelAdaugaCarte.add(autorCarte);
	panelAdaugaCarte.add(autor);
	panelAdaugaCarte.add(nrZileImpCarte);
	panelAdaugaCarte.add(nrZile);

	panelAdaugaCarte.add(adauga);
	
	ActionListener actAdd = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			int idCar=Integer.parseInt(id.getText());
			
			boolean ac=FunctiiBibliotecar.verificaIdCarte(idCar);
			
			if(ac==false)
			{
				JOptionPane.showMessageDialog(DesignAdaugCarte.this,
                        "ID INVALID",
                        "EROARE ADAUGARE CARTEs",
                        JOptionPane.ERROR_MESSAGE);
					id.setText("");
			}
			else if(ac)
			{
				FunctiiBibliotecar.adaugaCarteNoua(idCar, titlu.getText(), autor.getText(), gen.getText(), Integer.parseInt(nrZile.getText()));
				JOptionPane.showMessageDialog(DesignAdaugCarte.this,
                        "Carte adaugata cu succes",
                        "Carte adaugata",
                        JOptionPane.INFORMATION_MESSAGE);
					id.setText("");
				DesignOptiuniBibliotecar cit = new DesignOptiuniBibliotecar();
				setVisible(false);
				cit.setVisible(true);
			}
			
		}
	};
	
	adauga.addActionListener(actAdd);
	this.add(panelAdaugaCarte);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);

	}
}
