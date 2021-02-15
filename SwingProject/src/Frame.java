import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();		
		JLabel label = new JLabel("Some text");
		JButton button1 = new JButton("Click me!!");
		JTextArea txtArea = new JTextArea();
		JTextField txtField = new JTextField();
		
		panel.setLayout(new BorderLayout());
		
		panel.add(label, BorderLayout.NORTH);
		panel.add(button1, BorderLayout.WEST);
		panel.add(txtArea, BorderLayout.CENTER); 
		
		frame.add(panel);
		
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(840, 840/12*9));
		frame.setSize(840, 840/12*9);				
		frame.setLocationRelativeTo(null);						// 프레임 가운데 위치
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 윈도우 X버튼 클릭 시 종료
		frame.setResizable(false);
	}
}
