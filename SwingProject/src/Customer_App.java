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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;


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
		
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(197, 94, 216, 45);
		welcomPanel.add(lblNewLabel);
		
		textId = new JTextField();
		textId.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textId.setToolTipText("Enter ID");
		textId.setBounds(219, 161, 216, 29);
		welcomPanel.add(textId);
		textId.setColumns(10);
		
		textps = new JPasswordField();
		textps.setBounds(219, 200, 216, 29);
		welcomPanel.add(textps);
		
		JLabel lblNewLabel_1 = new JLabel("ID : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(166, 161, 51, 29);
		welcomPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PS :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(166, 200, 51, 29);
		welcomPanel.add(lblNewLabel_1_1);
		
		JButton btnLogIn = new JButton("");
		btnLogIn.setIcon(new ImageIcon("C:\\Users\\sonjisu\\Desktop\\btn\\btn.png"));
		btnLogIn.setPressedIcon(new ImageIcon("C:\\Users\\sonjisu\\Desktop\\btn\\btn_click.png"));
		btnLogIn.setBounds(272, 239, 86, 29);
		btnLogIn.addActionListener(new ActionListener() {	
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textId.getText().equals("son") && (textps.getText().equals("1234"))) {
					System.out.println("Welcom son");
					welcomPanel.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Failed Log In");
				}
			}
		});
		
		welcomPanel.add(btnLogIn);
		frame.setSize(welcomPanel.getWidth(), welcomPanel.getHeight());	
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

