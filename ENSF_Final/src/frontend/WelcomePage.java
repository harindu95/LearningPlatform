package frontend;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class WelcomePage extends Tab {

		WelcomePage(){
			this.setLayout(new BorderLayout());
			JLabel background = new JLabel();
			background.setIcon(new ImageIcon(WelcomePage.class.getResource("/images/welcometab.png")));
			this.add(background, BorderLayout.CENTER);
				
		}
}
