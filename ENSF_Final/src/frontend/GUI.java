package frontend;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.border.EtchedBorder;
import java.awt.CardLayout;

public class GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		
		frame.setSize(1280,728);
		frame.setResizable(false);
		frame.setBounds(100, 100, 1280, 728);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1280, 728);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel closeBtn = new JLabel("New label");
		closeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				closeBtn.setIcon(new ImageIcon(GUI.class.getResource("/images/closebtn3.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				closeBtn.setIcon(new ImageIcon(GUI.class.getResource("/images/closebtn2.png")));
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				closeBtn.setIcon(new ImageIcon(GUI.class.getResource("/images/closebtn2.png")));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				closeBtn.setIcon(new ImageIcon(GUI.class.getResource("/images/closebtn1.png")));
			}
		});
		closeBtn.setIcon(new ImageIcon(GUI.class.getResource("/images/closebtn1.png")));
		closeBtn.setBounds(1257, 6, 20,20);
		panel.add(closeBtn);
		
		JLabel minBtn = new JLabel("New label");
		minBtn.setIcon(new ImageIcon(GUI.class.getResource("/images/minbtn1.png")));
		minBtn.setBounds(1228, 6, 20, 20);
		minBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				minBtn.setIcon(new ImageIcon(GUI.class.getResource("/images/minbtn3.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				minBtn.setIcon(new ImageIcon(GUI.class.getResource("/images/minbtn2.png")));
				frame.setState(JFrame.ICONIFIED);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				minBtn.setIcon(new ImageIcon(GUI.class.getResource("/images/minbtn2.png")));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				minBtn.setIcon(new ImageIcon(GUI.class.getResource("/images/minbtn1.png")));
			}
		});
		
		JLabel coursesLbl = new JLabel("Courses");
		coursesLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				coursesLbl.setForeground(Color.white);
				//TODO: select courses tab
			}
		});
//		coursesLbl.setIcon(new ImageIcon(GUI.class.getResource("/images/courses1.png")));
		coursesLbl.setBounds(0, 268, 221, 34);
		coursesLbl.setFont(new Font("Sans",Font.TRUETYPE_FONT,18));
		coursesLbl.setForeground(new Color(169, 169, 169));
		coursesLbl.setHorizontalAlignment(JLabel.CENTER);
		panel.add(coursesLbl);
		
		JLabel assignmentsLbl = new JLabel("Assignments");
		assignmentsLbl.setHorizontalAlignment(SwingConstants.CENTER);
		assignmentsLbl.setForeground(new Color(169, 169, 169));
		assignmentsLbl.setFont(new Font("Sans",Font.TRUETYPE_FONT,18));
		assignmentsLbl.setBounds(0, 304, 221, 34);
		panel.add(assignmentsLbl);
		
		JLabel dropboxLbl = new JLabel("Assignments");
		dropboxLbl.setHorizontalAlignment(SwingConstants.CENTER);
		dropboxLbl.setForeground(new Color(169, 169, 169));
		dropboxLbl.setFont(new Font("Dialog", Font.PLAIN, 18));
		dropboxLbl.setBounds(0, 341, 221, 34);
		panel.add(dropboxLbl);
		
		JLabel gradesLbl = new JLabel("Assignments");
		gradesLbl.setHorizontalAlignment(SwingConstants.CENTER);
		gradesLbl.setForeground(new Color(169, 169, 169));
		gradesLbl.setFont(new Font("Dialog", Font.PLAIN, 18));
		gradesLbl.setBounds(0, 376, 221, 34);
		panel.add(gradesLbl);
		panel.add(minBtn);
		
		JPanel tabs = new JPanel();
		tabs.setBounds(227, 41, 1041, 675);
		panel.add(tabs);
		tabs.setLayout(new CardLayout(0, 0));
		tabs.add(new WelcomePage());
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 1280, 728);
		background.setIcon(new ImageIcon(GUI.class.getResource("/images/main3.png")));
		panel.add(background);
	}
}
		
	