import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;


public class Customer_App {

	private JFrame frame;
	private JTextField textId;
	private JPasswordField textps;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_App window = new Customer_App();
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
	public Customer_App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		

		frame = new JFrame();
		ImagePanel welcomPanel = new ImagePanel(new ImageIcon("C:/ai_SJS/java/workspace/SwingProject/image/business.jpg").getImage());
		frame.getContentPane().add(welcomPanel, BorderLayout.SOUTH);		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, 37, 884, 559);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome This is Main Panel");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(199, 10, 492, 64);
		mainPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(89, 212, 267, 45);
		welcomPanel.add(lblNewLabel);
		
		textId = new JTextField();
		textId.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textId.setToolTipText("Enter ID");
		textId.setBounds(140, 278, 216, 29);
		welcomPanel.add(textId);
		textId.setColumns(10);
		
		textps = new JPasswordField();
		textps.setBounds(140, 317, 216, 29);
		welcomPanel.add(textps);
		
		JLabel lblNewLabel_1 = new JLabel("ID : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(89, 278, 51, 29);
		welcomPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PS :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(89, 317, 51, 29);
		welcomPanel.add(lblNewLabel_1_1);
		
		JButton btnLogIn = new JButton("");
		btnLogIn.setIcon(new ImageIcon("C:\\Users\\sonjisu\\Desktop\\btn\\btn.png"));
		btnLogIn.setPressedIcon(new ImageIcon("C:\\Users\\sonjisu\\Desktop\\btn\\btn_click.png"));
		btnLogIn.setBounds(197, 356, 86, 29);
		btnLogIn.addActionListener(new ActionListener() {	
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textId.getText().equals("son") && (textps.getText().equals("1234"))) {
					System.out.println("Welcom son");
					welcomPanel.setVisible(false);
					mainPanel.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Failed Log In");
				}
			}
		});
		
		welcomPanel.add(btnLogIn);
		frame.setJMenuBar(menuBar());
		frame.setSize(welcomPanel.getWidth(), welcomPanel.getHeight());	
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public JMenuBar menuBar() {
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu aboutMenu = new JMenu("About");
		
		bar.add(fileMenu);
		bar.add(aboutMenu);
		
		JMenuItem openFile = new JMenuItem("Open");
		JMenuItem exit = new JMenuItem("Exit");
		
		fileMenu.add(openFile);
		fileMenu.addSeparator();
		fileMenu.add(exit);
		
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		return bar;
	}
}
	
	class ImagePanel extends JPanel{
		private Image img;
			
		public ImagePanel(Image img) {
			this.img = img;
			setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
			setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
			setLayout(null);
		}
		
		public int getWidth() {
			return img.getWidth(null);
		}
		public int getHeight() {
			return img.getHeight(null);
		}
					
		public void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}

