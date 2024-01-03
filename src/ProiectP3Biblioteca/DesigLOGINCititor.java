package ProiectP3Biblioteca;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class DesigLOGINCititor extends JFrame {

	JLabel etichetaTitlu1;
	JLabel etichetaCNP;
	JLabel etichetaParola;
	JTextField cnp;
	JTextField parola;
	JButton LOGIN;
	
	public DesigLOGINCititor() {
		
		JPanel panelLoginCititor = new JPanel();
		panelLoginCititor.setLayout(new BoxLayout(panelLoginCititor, BoxLayout.Y_AXIS));
	
		etichetaTitlu1=new JLabel("INTRA IN CONTUL TAU");
		etichetaCNP = new JLabel("Introdu CNP-UL");
		etichetaCNP.setPreferredSize(new Dimension(60,12));

		etichetaParola = new JLabel("IntroduParola");
		etichetaParola.setPreferredSize(new Dimension(60,12));
		
		LOGIN = new JButton("LOGIN");

		cnp= new JTextField(13);
		parola = new JTextField(20);
		
		etichetaTitlu1.setHorizontalAlignment(SwingUtilities.RIGHT);

		panelLoginCititor.add(etichetaTitlu1);
		panelLoginCititor.add(etichetaCNP);
		panelLoginCititor.add(cnp);
		panelLoginCititor.add(etichetaParola);
		panelLoginCititor.add(parola);
		panelLoginCititor.add(LOGIN);

		this.setTitle("OptiuniCititor");
		this.setSize(650, 500);
		
		
		ActionListener actLOGIN = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cnpCititor=cnp.getText();
				String parolaCititor = parola.getText();
				boolean ac=Functii.verificaAutentificare(cnpCititor, parolaCititor);
				boolean cnpV=Functii.verificaCNPAuth(cnpCititor);
				
				if(cnpV==false)
				{
					JOptionPane.showMessageDialog(DesigLOGINCititor.this,
                            "CNP INVALID",
                            "EROARE AUTENTIFICARE",
                            JOptionPane.ERROR_MESSAGE);
						cnp.setText("");
						parola.setText("");
				}
				else if(ac)
				{
					Cititor cititor = new Cititor(cnpCititor, parolaCititor);
					DesignOptiuniCititor cit = new DesignOptiuniCititor(cititor);
					setVisible(false);
					cit.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(DesigLOGINCititor.this,
                            "Parola incorecta",
                            "EROARE AUTENTIFICARE",
                            JOptionPane.ERROR_MESSAGE);
					cnp.setText("");
					parola.setText("");
				}
			}
		};
		
		LOGIN.addActionListener(actLOGIN);

        this.add(panelLoginCititor);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
