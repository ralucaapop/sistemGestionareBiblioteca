package Design;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Utilitar.FunctiiBibliotecar;

public class DesignRevizuiesteRezervari extends JFrame {

	JButton rev;
	
	
	public DesignRevizuiesteRezervari(){
		
		this.setTitle("Revizuieste Rezervari");
		this.setSize(650, 500);
	
		JPanel revizuiri = new JPanel();
		revizuiri.setLayout(new BoxLayout(revizuiri, BoxLayout.Y_AXIS));
		
		Color maroonColor = new Color(128, 0, 0);
		Color whiteColor = new Color(248, 250, 229);
		
		getContentPane().setBackground(whiteColor); 
		revizuiri.setBackground(whiteColor);

        Color maroonColor1 = new Color(128, 0, 0);
        
        Color darkGreenColor = new Color(0, 100, 0);

        Font titleFont = new Font("Arial", Font.BOLD, 20);
        Font labelFont = new Font("Arial", Font.PLAIN, 14);
        		
		rev = new JButton("REVIZUIESTE REZERVARILE");
		
		ActionListener actRev = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FunctiiBibliotecar.revizuiesteRezervari();
				JOptionPane.showMessageDialog(DesignRevizuiesteRezervari.this,
                        "REVIZUIRE EFECTUATA",
                        "REVIZUIRE EFECTUATA",
                        JOptionPane.INFORMATION_MESSAGE);
				DesignOptiuniBibliotecar cit = new DesignOptiuniBibliotecar();
				setVisible(false);
				cit.setVisible(true);
			}
		};
		rev.setAlignmentX(Component.CENTER_ALIGNMENT);
		rev.setBackground(darkGreenColor);
		rev.setForeground(whiteColor);
		rev.setFocusPainted(false); 


		setLayout(new GridBagLayout()); 
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.CENTER;
        add(revizuiri, gbc);
		rev.addActionListener(actRev);
		revizuiri.add(rev);
		this.add(revizuiri);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
