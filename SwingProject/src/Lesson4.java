import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lesson4 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lesson4 window = new Lesson4();
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
	public Lesson4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Lesson4");
		frame.setBounds(100, 100, 800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel startPage = new JPanel();
		startPage.setBounds(0, 0, 794, 571);
		frame.getContentPane().add(startPage);
		startPage.setLayout(null);		
		
		JButton btnNext = new JButton("Go To Next");
		btnNext.setBounds(53, 171, 223, 244);
		startPage.add(btnNext);
		
		JPanel endPage = new JPanel();
		endPage.setBounds(0, 0, 794, 571);
		frame.getContentPane().add(endPage);
		endPage.setLayout(null);
		
		endPage.setVisible(false);
		JButton btnBefore = new JButton("Go To Before");
		btnBefore.setBounds(495, 166, 226, 256);
		endPage.add(btnBefore);
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				endPage.setVisible(true);
				startPage.setVisible(false);
			}
		});
		

		btnBefore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				endPage.setVisible(false);
				startPage.setVisible(true);
			}
		});				
	}
}
