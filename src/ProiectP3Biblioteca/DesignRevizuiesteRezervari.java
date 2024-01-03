package ProiectP3Biblioteca;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DesignRevizuiesteRezervari extends JFrame {

	JButton rev;
	
	
	public DesignRevizuiesteRezervari(){
		
		this.setTitle("Revizuieste Rezervari");
		this.setSize(650, 500);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JPanel revizuiri = new JPanel();
		revizuiri.setLayout(new BoxLayout(revizuiri, BoxLayout.Y_AXIS));
		
		
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
		rev.addActionListener(actRev);
		revizuiri.add(rev);
		this.add(revizuiri);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
