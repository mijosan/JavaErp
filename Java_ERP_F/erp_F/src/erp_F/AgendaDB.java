package erp_F;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class AgendaDB extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JTextField agendaTitle;
	private JButton saveButton;
	private JLabel console;
	private JLabel label_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}

	/**
	 * Create the dialog.
	 */
	// ºˆ¡§∫Œ∫–
	public AgendaDB(CalendarPanel calendarPanel, ModalityType modalityType, String sqlDay) {
		super();
		setTitle(sqlDay);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		// ø©±‚±Ó¡ˆ

		setBounds(100, 100, 315, 303);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblNewLabel = new JLabel("\uC77C  \uC815");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		lblNewLabel.setBounds(23, 39, 57, 15);
		contentPanel.add(lblNewLabel);
		
		label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		label_1.setBounds(22, 39, 14, 15);
		contentPanel.add(label_1);

		agendaTitle = new JTextField();
		agendaTitle.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				do_agendaTitle_caretUpdate(arg0);
			}
		});
		
		console = new JLabel("\uC81C\uBAA9\uC744 \uC785\uB825\uD574 \uC8FC\uC138\uC694.");
		console.setForeground(Color.GRAY);
		console.setHorizontalAlignment(SwingConstants.CENTER);
		console.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		console.setBounds(167, 8, 120, 19);
		contentPanel.add(console);
		agendaTitle.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		agendaTitle.setBounds(78, 35, 198, 31);
		contentPanel.add(agendaTitle);
		agendaTitle.setColumns(10);
		{
			JButton cancelButton = new JButton("\uCDE8\uC18C");
			cancelButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
			cancelButton.setBounds(217, 233, 70, 23);
			contentPanel.add(cancelButton);
			cancelButton.setBackground(SystemColor.control);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					do_cancelButton_actionPerformed(arg0);
				}
			});
			cancelButton.setActionCommand("Cancel");
		}

		saveButton = new JButton("\uC800\uC7A5");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_saveButton_actionPerformed(e);
				} catch (ClassNotFoundException | SQLException e1) {					
					e1.printStackTrace();
				}
			}
		});
		saveButton.setBackground(SystemColor.control);
		saveButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		saveButton.setBounds(144, 233, 70, 23);
		contentPanel.add(saveButton);
		saveButton.setEnabled(false);
		
		JLabel label = new JLabel("\uB0B4  \uC6A9");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		label.setBounds(23, 90, 57, 15);
		contentPanel.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(33, 115, 243, 108);
		contentPanel.add(textField);
	}

	protected void do_cancelButton_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}

	// ¿œ¡§ √ﬂ∞°«œ±‚
	protected void do_saveButton_actionPerformed(ActionEvent e) throws ClassNotFoundException, SQLException {
		// String url = "jdbc:mariadb://localhost:3306/java";
		String url =  "jdbc:mysql://113.198.238.105/erp_f?useUnicode=true&characterEncoding=EUC_KR";
		// String driverClass = "org.mariadb.jdbc.Driver";
		String driverClass = "org.gjt.mm.mysql.Driver";

		String dbuid = "user";
		String dbpwd = "1234";

		Class.forName(driverClass);

		Connection connection = DriverManager.getConnection(url, dbuid, dbpwd);
			try {
				if (!agendaTitle.getText().equals("")) {
					 String sql = "INSERT INTO agenda_data (`agenda_date`, `agenda_Title`,`agenda_Content`) VALUES ("+
				"'"+getTitle()+"' , '" + agendaTitle.getText()+"' , '" + textField.getText()+"')";
	
					/*String sql = "INSERT INTO AGENDA_DATA VALUES (SEQUENCE_AGENDA.NEXTVAL, '" + getTitle() + "', '"
							+ agendaTitle.getText() + "', '" + agendaText.getText() + "')";*/
	
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					preparedStatement.executeUpdate();
					connection.close();
					dispose();					
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}		
		}
	

	// saveπˆ∆∞ ∫Ò»∞º∫»≠/»∞º∫»≠
	protected void do_agendaTitle_caretUpdate(CaretEvent arg0) {
		if (!agendaTitle.getText().equals("")) {
			saveButton.setEnabled(true);
			console.setText("");
		} else {
			saveButton.setEnabled(false);
			console.setText("¡¶∏Ò¿ª ¿‘∑¬«ÿ ¡÷ººø‰.");
		}
	}
}
