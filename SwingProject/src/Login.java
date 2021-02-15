import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame{
	
	public Login() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("ID : ");
		JLabel pswrd = new JLabel("Password : ");
		JTextField txtID = new JTextField(10);
		JPasswordField txtpass = new JPasswordField(10);
		JButton logBtn = new JButton("Log In");
		
		panel.add(label);
		panel.add(txtID);
		panel.add(pswrd);
		panel.add(txtpass);
		panel.add(logBtn);
		
		logBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = "Hi";
				String pass = "1234";
				
				if(e.getSource() == logBtn) {
					if(txtID.getText().equals(id) && txtpass.getText().equals(pass)) {
						JOptionPane.showMessageDialog(null, "로그인 성공");
					}
					else {
						JOptionPane.showMessageDialog(null, "로그인 실패");
					}
				}
			}
		});
		add(panel);
		
		setVisible(true);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Login();
	}
}
