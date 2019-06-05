package erp_F;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class ConfirmDialog extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	/**
	 * Create the dialog.
	 */
	public ConfirmDialog(String name, String birth, String date, String reason, String dept, String job) {
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 0, 760, 783);
		getContentPane().setLayout(null);
		
			JLabel label = new JLabel("\uC7AC\uC9C1\uC99D\uBA85\uC11C");
			label.setBounds(12, 52, 684, 33);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 25));
			getContentPane().add(label);
		
		
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setBounds(0, 708, 751, 33);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			
				final JButton okButton = new JButton("»Æ¿Œ");				
				okButton.setBounds(607, 5, 65, 23);
				okButton.setBackground(Color.WHITE);
				okButton.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 12));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				
				okButton.addMouseMotionListener(new MouseMotionListener() {
					
					@Override
					public void mouseMoved(MouseEvent e) {
						okButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					
					@Override
					public void mouseDragged(MouseEvent e) {
					}
				});
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
					dispose();
					}
				});
				getRootPane().setDefaultButton(okButton);
			
			
				final JButton cancelButton = new JButton("√Îº“");
				cancelButton.setBounds(668, 5, 73, 23);
				cancelButton.setBackground(Color.WHITE);
				cancelButton.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 12));
				cancelButton.setActionCommand("Cancel");
				
				cancelButton.addMouseMotionListener(new MouseMotionListener() {
					
					@Override
					public void mouseMoved(MouseEvent e) {
						cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					
					@Override
					public void mouseDragged(MouseEvent e) {
					}
				});
				
				buttonPane.add(cancelButton);
			
		
		Border border1 = BorderFactory.createEmptyBorder();
		JLabel lblNewLabel = new JLabel("\uC131\uBA85");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 15));
		lblNewLabel.setBounds(37, 168, 97, 59);
		getContentPane().add(lblNewLabel);
		
		JLabel label1 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 15));
		label1.setBounds(335, 177, 83, 41);
		label1.setBorder(border1);
		getContentPane().add(label1);
		

		JLabel lblEmail = new JLabel("\uC7AC\uC9C1\uAE30\uAC04");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 15));
		lblEmail.setBounds(37, 238, 90, 65);
		lblEmail.setBorder(border1);
		getContentPane().add(lblEmail);
		
		JLabel label_2 = new JLabel("\uBD80\uC11C");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 15));
		label_2.setBounds(37, 313, 90, 59);
		label_2.setBorder(border1);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\uC9C1\uCC45");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 15));
		label_3.setBounds(335, 322, 83, 41);
		label_3.setBorder(border1);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\uC6A9\uB3C4");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 15));
		label_4.setBounds(37, 382, 90, 59);
		label_4.setBorder(border1);
		getContentPane().add(label_4);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(37, 161, 647, 3);
		separator.setBorder(border1);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(37, 234, 647, 3);
		getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(37, 307, 647, 3);
		getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(37, 378, 647, 3);
		getContentPane().add(separator_3);
		
		textField = new JTextField();//¿Ã∏ß
		textField.setFont(new Font("±º∏≤", Font.PLAIN, 14));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText(name);
		textField.setBackground(Color.WHITE);
		textField.setEditable(false);
		textField.setBounds(139, 162, 177, 73);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		textField.setBorder(border);		
		 

		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("±º∏≤", Font.PLAIN, 14));
		textField_1.setText(birth);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(444, 162, 240, 73);
		textField_1.setBorder(border);	
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText(date);
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("±º∏≤", Font.PLAIN, 14));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(139, 235, 545, 73);
		textField_2.setBorder(border);	
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText(dept);
		textField_3.setFont(new Font("±º∏≤", Font.PLAIN, 14));
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(139, 308, 177, 71);
		textField_3.setBorder(border);	
		getContentPane().add(textField_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setBackground(Color.BLACK);
		separator_4.setBounds(37, 446, 647, 3);
		getContentPane().add(separator_4);
		
		textField_4 = new JTextField();//øÎµµ
		textField_4.setText(reason+" ¡¶√‚øÎ");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("±º∏≤", Font.PLAIN, 14));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(139, 378, 545, 69);
		textField_4.setBorder(border);	
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setText(job);
		textField_5.setFont(new Font("±º∏≤", Font.PLAIN, 14));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBackground(Color.WHITE);
		textField_5.setBounds(444, 308, 240, 71);
		textField_5.setBorder(border);	
		getContentPane().add(textField_5);
		
		JLabel lblNewLabel_1 = new JLabel("\uC0C1\uAE30\uC640 \uAC19\uC774 \uC7AC\uC9C1\uD558\uACE0 \uC788\uC74C\uC744 \uC99D\uBA85\uD569\uB2C8\uB2E4.");
		lblNewLabel_1.setFont(new Font("±º∏≤", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(221, 478, 347, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel label_5 = new JLabel("2018\uB144 11\uC6D4 13\uC77C");
		label_5.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(270, 528, 215, 15);
		getContentPane().add(label_5);
		
		JLabel lblNewLabel_2 = new JLabel("\uD68C\uC0AC\uBA85 : ERP_F");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("±º∏≤", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(310, 580, 133, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel label_6 = new JLabel("\uB300\uD45C\uC790 : \uCD5C\uD0DC\uC0B0");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("±º∏≤", Font.PLAIN, 14));
		label_6.setBounds(320, 619, 117, 15);
		getContentPane().add(label_6);
	}
}
