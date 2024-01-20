package Design;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ProiectP3Biblioteca.Cititor;
import Utilitar.Functii;

public class DesignSchimbaParolaCititor extends JFrame{

		JLabel labelParola;
		JTextField parolaNoua;
		JButton schimbaParola;
		
		public DesignSchimbaParolaCititor(Cititor cititor) {
			
			JPanel panelSchimbaParola = new JPanel();
			panelSchimbaParola.setLayout(new BoxLayout(panelSchimbaParola, BoxLayout.Y_AXIS));
			
			Color maroonColor = new Color(128, 0, 0);
			Color whiteColor = new Color(248, 250, 229);
				
			getContentPane().setBackground(whiteColor); 
			panelSchimbaParola.setBackground(whiteColor);

		    Color maroonColor1 = new Color(128, 0, 0);
		        
		    Color darkGreenColor = new Color(0, 100, 0);

		    Font titleFont = new Font("Arial", Font.BOLD, 20);
		    Font labelFont = new Font("Arial", Font.PLAIN, 14);
		        
			this.setSize(650, 500);
			this.setTitle("Schimba Parola");
			
			labelParola = new JLabel("NOUA PAROLA");
			labelParola.setFont(titleFont);
			labelParola.setForeground(maroonColor);
			labelParola.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			parolaNoua= new JTextField(20);
			
			
			schimbaParola=new JButton("Selecteaza");

			schimbaParola.setAlignmentX(Component.CENTER_ALIGNMENT);
			schimbaParola.setBackground(darkGreenColor);
			schimbaParola.setForeground(whiteColor);
			
			panelSchimbaParola.add(labelParola);
			panelSchimbaParola.add(parolaNoua);
			panelSchimbaParola.add(schimbaParola);
			
			
			
			ActionListener actSP = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Functii.schimbaParolaCititor(parolaNoua.getText(), cititor.getCNPCititor());
						JOptionPane.showMessageDialog(DesignSchimbaParolaCititor.this,
		                        "Parola schimbata",
		                        "Parola schimbata cu succes adaugata",
		                        JOptionPane.INFORMATION_MESSAGE);
						DesignOptiuniCititor d = new DesignOptiuniCititor(cititor);
						setVisible(false);
						d.setVisible(true);
				}
			};
			
			
			schimbaParola.addActionListener(actSP);
			setLayout(new GridBagLayout());

			 
		       
		    GridBagConstraints gbc = new GridBagConstraints();
		    gbc.gridx = 0;
		    gbc.gridy = 0;
		    gbc.fill = GridBagConstraints.CENTER;
		    add(panelSchimbaParola, gbc);

			
			this.add(panelSchimbaParola);
	        this.setLocationRelativeTo(null);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
		}
}
