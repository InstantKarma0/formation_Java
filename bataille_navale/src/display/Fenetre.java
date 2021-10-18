package display;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Fenetre extends JFrame {

	GridBagLayout grid = new GridBagLayout();

	public Fenetre(int[][] tb) {
		this.setTitle("Bataille Navale");
		this.setSize(400, 500);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setLayout(grid);
		
		JLabel test = new JLabel();

		GridBagConstraints constraint = new GridBagConstraints();
	
		test.setSize(20, 20);

		for (int i = 0; i < 10; i++) {
			constraint.gridx = Integer.valueOf(i);

			for (int y = 0; y < 10; y++) {
				test.setText(String.valueOf(tb[i][y]));
				constraint.gridy = y;

				panel.add(test, constraint);

			}
		}

	}

	public void fillGrid(int[][] tb) {

		
		
	}

}
