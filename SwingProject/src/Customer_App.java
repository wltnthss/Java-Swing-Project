 
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class Customer_App {

	private JFrame frame;
	private JTextField textId;
	private JPasswordField textps;
	private JTextField name;
	private JTextField age;
	private JTextField phone;
	private JTextField birthday;
	private JTextField search;

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
		
		/** 패널 구성 **/
		Customer customer = new Customer();
		frame = new JFrame();
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		ImagePanel welcomPanel = new ImagePanel(new ImageIcon("C:/ai_SJS/java/workspace/SwingProject/image/business.jpg").getImage());
		frame.getContentPane().add(welcomPanel, "name_152787985869300");		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, 37, 884, 559);
		frame.getContentPane().add(mainPanel, "name_152787997605300");
		mainPanel.setLayout(null);
		mainPanel.setVisible(false);
		
		JPanel tablePanel = new JPanel();
		frame.getContentPane().add(tablePanel, "name_152788009405700");
		frame.setJMenuBar(menuBar());
		frame.setSize(welcomPanel.getWidth(), welcomPanel.getHeight());	
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		String[][] data = customer.getCustomers(); 
		String[] headers = new String[] {"Name", "Phone", "Gender", "Age", "Note"};
		tablePanel.setLayout(null);
		JTable table = new JTable(data, headers);
		table.setRowHeight(30);
		table.setFont(new Font("Sanserif", Font.BOLD, 15));
		table.setAlignmentX(0);
		table.setSize(800, 400);
		table.setPreferredScrollableViewportSize(new Dimension(800, 400));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(43, 66, 802, 428);
		tablePanel.add(scrollPane);
		
		search = new JTextField();
		search.setFont(new Font("Tahoma", Font.PLAIN, 17));
		search.setBounds(43, 10, 802, 35);
		tablePanel.add(search);
		search.setColumns(10);
		search.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				// add Table Filter
				String val = search.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}			
		});
		
		TableColumnModel columnModels = table.getColumnModel();
		columnModels.getColumn(0).setPreferredWidth(100); 	// 첫 번째값 크기 조절
		columnModels.getColumn(2).setPreferredWidth(40);
		columnModels.getColumn(3).setPreferredWidth(10);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setVisible(false);
		welcomPanel.setVisible(false);
		tablePanel.setVisible(true);
		
		/** 패널 구성 완료 (welcomPanel, mainPanel, tablePanel) **/

		
		JLabel lblNewLabel_2 = new JLabel("Welcome This is Main Panel");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(199, 10, 492, 64);
		mainPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(137, 96, 131, 41);
		mainPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Age");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(137, 167, 131, 41);
		mainPanel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Gender");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_2.setBounds(137, 237, 131, 41);
		mainPanel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Phone");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_3.setBounds(465, 96, 134, 41);
		mainPanel.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Birthday");
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_4.setBounds(465, 167, 134, 41);
		mainPanel.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_4_1 = new JLabel("Note");
		lblNewLabel_3_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_4_1.setBounds(465, 237, 134, 41);
		mainPanel.add(lblNewLabel_3_4_1);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 18));
		name.setBounds(273, 96, 155, 41);
		mainPanel.add(name);
		name.setColumns(10);
		
		age = new JTextField();
		age.setFont(new Font("Tahoma", Font.PLAIN, 18));
		age.setColumns(10);
		age.setBounds(273, 167, 155, 41);
		mainPanel.add(age);
		
		phone = new JTextField();
		phone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		phone.setColumns(10);
		phone.setBounds(603, 96, 155, 41);
		mainPanel.add(phone);
		
		birthday = new JTextField();
		birthday.setFont(new Font("Tahoma", Font.PLAIN, 18));
		birthday.setColumns(10);
		birthday.setBounds(603, 167, 155, 41);
		mainPanel.add(birthday);
		
		JComboBox gender = new JComboBox(new String[] {"Male", "Female"});
		gender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		gender.setBackground(Color.WHITE);
		gender.setBounds(273, 237, 155, 41);
		mainPanel.add(gender);
		
		JTextArea note = new JTextArea();
		note.setFont(new Font("Tahoma", Font.PLAIN, 18));
		note.setBounds(601, 245, 156, 133);
		// JTextArea 부분의 선 표시 명령어
		note.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mainPanel.add(note);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameTxt = name.getText();
				String ageTxt = age.getText();
				String phoneTxt = phone.getText();
				String genderTxt = gender.getSelectedItem().toString();
				String noteTxt = note.getText();
//				Customer customer = new Customer(nameTxt, ageTxt);
				
				//customer.createCustomer(nameTxt, phoneTxt, genderTxt, ageTxt, noteTxt);
				JOptionPane.showMessageDialog(null, "Your data has been saved successfully");
				welcomPanel.setVisible(false);
				mainPanel.setVisible(false);
				tablePanel.setVisible(true);
			}
		});
		btnNewButton.setBounds(329, 427, 214, 61);
		mainPanel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(89, 173, 267, 45);
		welcomPanel.add(lblNewLabel);
		
		textId = new JTextField();
		textId.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textId.setToolTipText("Enter ID");
		textId.setBounds(140, 228, 216, 29);
		welcomPanel.add(textId);
		textId.setColumns(10);
		
		textps = new JPasswordField();
		textps.setBounds(140, 267, 216, 29);
		welcomPanel.add(textps);
		
		JLabel lblNewLabel_1 = new JLabel("ID : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(89, 228, 51, 29);
		welcomPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PS :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(89, 267, 51, 29);
		welcomPanel.add(lblNewLabel_1_1);
		
		JButton btnLogIn = new JButton("");
		btnLogIn.setIcon(new ImageIcon("C:\\Users\\sonjisu\\Desktop\\btn\\btn.png"));
		btnLogIn.setPressedIcon(new ImageIcon("C:\\Users\\sonjisu\\Desktop\\btn\\btn_click.png"));
		btnLogIn.setBounds(197, 306, 86, 29);
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
