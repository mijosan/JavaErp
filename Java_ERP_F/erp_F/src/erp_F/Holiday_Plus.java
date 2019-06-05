package erp_F;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class Holiday_Plus extends JDialog {

	private final JPanel contentPanel = new JPanel();
	static JTextField textField;
	MemberMgr mgr;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public Holiday_Plus() {
		setTitle("근태 등록");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 576, 118);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		mgr = new MemberMgr();
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setBounds(126, 44, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			
				JButton okButton = new JButton("\uD655\uC778");
				
				okButton.setBackground(Color.WHITE);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				JButton cancelButton = new JButton("\uCDE8\uC18C");
				cancelButton.setBackground(Color.WHITE);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				final JDateChooser dateChooser = new JDateChooser();
			    dateChooser.setBounds(85, 15, 113, 20);
			   getContentPane().add(dateChooser);
			   
			   JLabel lblNewLabel = new JLabel("\uADFC\uD0DC\uC77C\uC815");
			   lblNewLabel.setForeground(Color.WHITE);
			   lblNewLabel.setBounds(23, 17, 57, 15);
			   getContentPane().add(lblNewLabel);
			   
			   textField = new JTextField();
			   textField.setBounds(250, 15, 113, 21);
			   getContentPane().add(textField);
			   textField.setColumns(10);
			   
			   JLabel lblNewLabel_1 = new JLabel("\uC131\uBA85");
			   lblNewLabel_1.setForeground(Color.WHITE);
			   lblNewLabel_1.setBounds(220, 18, 34, 15);
			   getContentPane().add(lblNewLabel_1);
			   
			   final JComboBox comboBox = new JComboBox();
			   comboBox.setBackground(Color.WHITE);
			   comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "\uAD6D\uBC29\uC758\uC758\uBB34", "\uACBD\uC870\uC0AC\uD734\uAC00", "2018\uB144\uC5F0\uCC28", "2017\uB144\uC5F0\uCC28"}));
			   comboBox.setBounds(430, 14, 113, 23);
			   getContentPane().add(comboBox);
			   
			   JLabel label = new JLabel("\uADFC\uD0DC\uD56D\uBAA9");
			   label.setForeground(Color.WHITE);
			   label.setBounds(373, 18, 57, 15);
			   getContentPane().add(label);
			   
			   JPanel panel = new JPanel();
			   panel.setBackground(SystemColor.textHighlight);
			   panel.setBorder(new EmptyBorder(0, 0, 0, 0));
			   panel.setBounds(0, 10, 559, 33);
			   getContentPane().add(panel);
			   
			   okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							String date = sdf.format(dateChooser.getDate() );		
							mgr.addHoliday(date, Integer.parseInt(First_Frame.id), First_Frame.name, String.valueOf(comboBox.getSelectedItem()));
							
							Holiday_Panel.sellTable.addRow(new Object[] {mgr.getHNum(),date, Integer.parseInt(First_Frame.id), First_Frame.name, String.valueOf(comboBox.getSelectedItem())});;							
							dispose();
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null,"다시 시도하세요");
						}
						
					}
				});
			   cancelButton.addActionListener(new ActionListener() {// 삭제버튼
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						
					} catch (Exception e2) {
						
					}
				}
			});
	}
}
