package ProiectP3Biblioteca;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DesignRealizeazaImprumut extends JFrame{
	
	JLabel etichetaTitlu;
	JLabel etichetaAtentionare;
	
	JLabel titluCarte;
	JLabel autorCarte;
	
	JTextField autor;
	JTextField titlu;

	JButton cautaCarte;
	
	public DesignRealizeazaImprumut(){
		
		JPanel panelRezlizeazaImprumut = new JPanel();
		panelRezlizeazaImprumut.setLayout(new BoxLayout(panelRezlizeazaImprumut, BoxLayout.Y_AXIS));
		
		
		this.setTitle("Imprumuta o carte");
		this.setSize(650, 500);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		etichetaTitlu=new JLabel("Imprumuta O CARTE");
		
		titluCarte=new JLabel("Titlul cartii:");
		autorCarte=new JLabel("Autor carte:");
		
		autor = new JTextField(20);
		titlu = new JTextField(20);

		cautaCarte= new JButton("CAUTA CARTEA DORITA");
		
		panelRezlizeazaImprumut.add(etichetaTitlu);
		panelRezlizeazaImprumut.add(titluCarte);
		panelRezlizeazaImprumut.add(titlu);
		panelRezlizeazaImprumut.add(autorCarte);
		panelRezlizeazaImprumut.add(autor);
		panelRezlizeazaImprumut.add(cautaCarte);
		
		ActionListener actC = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Carte>carti;
				carti=Functii.returneazaCartea(titlu.getText(), autor.getText());
				if(carti.size()==0)
				{
					JOptionPane.showMessageDialog(DesignRealizeazaImprumut.this,
                            "ACEASTA CARETE NU ESTE DISPONIBILA, ASIGURATI-VA CA ATI INTRODUS CORECT TITLUL SI AUTORUL",
                            "CARTEA NU E DISPONIBILA",
                            JOptionPane.ERROR_MESSAGE);
						titlu.setText("");
						autor.setText("");
				}
				else {
					DesignAlegeCarteImprumut d = new DesignAlegeCarteImprumut(carti);
					setVisible(false);
					d.setVisible(true);
				}
			}
		};

		cautaCarte.addActionListener(actC);
		this.add(panelRezlizeazaImprumut);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
}
