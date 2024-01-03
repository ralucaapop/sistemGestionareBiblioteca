package ProiectP3Biblioteca;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DesignFaRezervare extends JFrame{

	JLabel etichetaTitlu;
	JLabel etichetaAtentionare;
	
	JLabel titluCarte;
	JLabel autorCarte;
	
	JTextField autor;
	JTextField titlu;

	JButton cautaCarte;
	
	public DesignFaRezervare(Cititor cititor) {
		JPanel panelFaRezervare = new JPanel();
		panelFaRezervare.setLayout(new BoxLayout(panelFaRezervare, BoxLayout.Y_AXIS));
		
		this.setTitle("Optiuni Cititor");
		this.setSize(650, 500);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		etichetaTitlu=new JLabel("REZERVA O CARTE");
		etichetaAtentionare = new JLabel("ATENTIE, REZERVARILE SUNT DISPONIBILE TIMP DE DOUA ZILE!!");
		
		titluCarte=new JLabel("Titlul cartii:");
		autorCarte=new JLabel("Autor carte:");
		
		autor = new JTextField(20);
		titlu = new JTextField(20);

		cautaCarte= new JButton("CAUTA CARTEA DORITA");
		
		panelFaRezervare.add(etichetaTitlu);
		panelFaRezervare.add(etichetaAtentionare);
		panelFaRezervare.add(titluCarte);
		panelFaRezervare.add(titlu);
		panelFaRezervare.add(autorCarte);
		panelFaRezervare.add(autor);
		panelFaRezervare.add(cautaCarte);
		
		

		ActionListener actC = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Carte>carti;
				carti=Functii.returneazaCartea(titlu.getText(), autor.getText());
				if(carti.size()==0)
				{
					JOptionPane.showMessageDialog(DesignFaRezervare.this,
                            "ACEASTA CARETE NU ESTE DISPONIBILA, ASIGURATI-VA CA ATI INTRODUS CORECT TITLUL SI AUTORUL",
                            "CARTEA NU E DISPONIBILA",
                            JOptionPane.ERROR_MESSAGE);
						titlu.setText("");
						autor.setText("");
				}
				else {
					DesignAlegeCarteRezervare cit = new DesignAlegeCarteRezervare(carti, cititor);
					setVisible(false);
					cit.setVisible(true);
				}
			}
		};

		cautaCarte.addActionListener(actC);
		this.add(panelFaRezervare);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
