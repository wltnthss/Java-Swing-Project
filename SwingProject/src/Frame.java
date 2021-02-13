import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();		
		panel.add(new JLabel("Java Swing"));
		
		frame.add(panel);
		
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(840, 840/12*9));
		frame.setSize(840, 840/12*9);				
		frame.setLocationRelativeTo(null);						// 프레임 가운데 위치
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 윈도우 X버튼 클릭 시 종료
		frame.setResizable(false);
	}
}
