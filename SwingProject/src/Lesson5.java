import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Lesson5 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Table Prac");
		JPanel panel = new JPanel();
		String[] headings = new String[] {"Id", "Name", "Country"};
		Object[][] data = new Object[][] {
			{"1", "Daniel", "Korea"},
			{"2", "Sunny", "France"},
			{"3", "John", "Japan"}
		};
		
		JTable table = new JTable(data, headings);
		table.setPreferredScrollableViewportSize(new Dimension(700, 600));		// 테이블 사이즈
		table.setFillsViewportHeight(true);										// setVisible과 유사함
		
		panel.add(new JScrollPane(table));
		
		frame.add(panel);
		
		frame.setVisible(true);
		frame.setSize(800, 640);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
