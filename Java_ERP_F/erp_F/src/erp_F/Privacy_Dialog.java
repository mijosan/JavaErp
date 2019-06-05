package erp_F;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Privacy_Dialog extends JDialog {
	private JTextField textField;
	private JTextField textField_2;
	private JPasswordField passwordField;
	MemberMgr mgr;
	public Privacy_Dialog() {
	
		mgr = new MemberMgr();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		getContentPane().setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		setTitle("\uAC1C\uC778\uC815\uBCF4");
		setBounds(600, 100, 371, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("- \uAC1C\uC778\uC815\uBCF4");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		lblNewLabel.setBounds(12, 10, 57, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\uC774\uB984");
		label.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		label.setBounds(76, 36, 57, 15);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\uC544\uC774\uB514");
		label_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		label_1.setBounds(76, 86, 57, 15);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		label_2.setBounds(76, 136, 57, 15);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\uC0DD\uC77C");
		label_3.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		label_3.setBounds(76, 186, 57, 15);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\uBD80\uC11C");
		label_4.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		label_4.setBounds(76, 236, 57, 15);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\uC785\uC0AC\uC77C");
		label_5.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		label_5.setBounds(76, 286, 57, 15);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("\uACC4\uC88C\uBC88\uD638");
		label_6.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		label_6.setBounds(76, 336, 57, 15);
		getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("\uC9C1\uCC45");
		label_7.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		label_7.setBounds(76, 386, 57, 15);
		getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("\uC544\uC774\uD53C");
		label_8.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		label_8.setBounds(76, 486, 57, 15);
		getContentPane().add(label_8);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(12, 10, 332, 15);
		getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("nameLable");
		lblNewLabel_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		lblNewLabel_1.setText(First_Frame.name);
		lblNewLabel_1.setBounds(186, 36, 121, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblIdLabel = new JLabel("idLabel");
		lblIdLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		lblIdLabel.setText(First_Frame.id);
		lblIdLabel.setBounds(186, 86, 111, 15);
		getContentPane().add(lblIdLabel);
		
		JLabel lblBirthLabel = new JLabel("birthLabel");
		lblBirthLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		lblBirthLabel.setText(First_Frame.birth);
		lblBirthLabel.setBounds(186, 186, 111, 15);
		getContentPane().add(lblBirthLabel);
		
		JLabel lblDeptlabel = new JLabel("deptLabel");
		lblDeptlabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		lblDeptlabel.setText(First_Frame.dept);
		lblDeptlabel.setBounds(186, 236, 121, 15);
		getContentPane().add(lblDeptlabel);
		
		JLabel lblHirelabel = new JLabel("hireLabel");
		lblHirelabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		lblHirelabel.setText(First_Frame.hireDate);
		lblHirelabel.setBounds(186, 286, 111, 15);
		getContentPane().add(lblHirelabel);
		
		JLabel lblJoblabel = new JLabel("JobLabel");
		lblJoblabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		lblJoblabel.setText(First_Frame.job);
		lblJoblabel.setBounds(186, 386, 131, 15);
		getContentPane().add(lblJoblabel);
		
		JLabel label_9 = new JLabel("\uC774\uBA54\uC77C");
		label_9.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		label_9.setBounds(76, 436, 57, 15);
		getContentPane().add(label_9);
		
		JButton button = new JButton("\uC801\uC6A9");
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				mgr.updatePrivacy(Integer.parseInt(First_Frame.id),Integer.parseInt(passwordField.getText()),Integer.parseInt(textField.getText()), textField_2.getText());
				}catch(NumberFormatException en) {
					JOptionPane.showMessageDialog(null,"¿‘∑¬«— «¸Ωƒ¿ª »Æ¿Œ«ÿ¡÷ººø‰");
				}catch(Exception en) {			
					en.printStackTrace();
				}				
				setVisible(false);
				dispose();
			}
		});
		
		button.setBackground(Color.WHITE);
		button.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 12));
		button.setBounds(148, 528, 97, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\uB2EB\uAE30");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		button_1.setBounds(247, 528, 97, 23);
		button_1.setBackground(Color.WHITE);
		button_1.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 12));
		getContentPane().add(button_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 517, 332, 2);
		getContentPane().add(separator);
		
		textField = new JTextField();
		textField.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		textField.setText(First_Frame.account);
		textField.setBounds(186, 333, 158, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		textField_2.setText(First_Frame.email);
		textField_2.setColumns(10);
		textField_2.setBounds(186, 433, 158, 21);
		getContentPane().add(textField_2);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		passwordField.setText(First_Frame.birth2);
		passwordField.setBounds(186, 135, 158, 21);
		getContentPane().add(passwordField);
		
		try {
		InetAddress add = InetAddress.getLocalHost();

		JLabel label_10 = new JLabel((String) null);
		label_10.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		label_10.setText(add.getHostAddress());
		label_10.setBounds(186, 486, 121, 15);
		getContentPane().add(label_10);
		}catch(Exception e) {
			
		}
		
	}
}
