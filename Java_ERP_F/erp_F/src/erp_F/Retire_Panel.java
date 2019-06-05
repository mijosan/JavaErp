package erp_F;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

public class Retire_Panel extends JPanel {
	int emp_num = Integer.parseInt(First_Frame.id);
	MemberMgr mgr;
	Vector<TblemployeeBean> vlist;
	JLabel label_10;
	CalendarPanel2 cal;
	static JDialog dia;
	static TextField textField_1;

	/**
	 * Create the panel.
	 */
	public Retire_Panel() {
		
		dia = new JDialog();
		cal = new CalendarPanel2();
		
		dia.setBounds(100, 100, 290, 300);
		mgr = new MemberMgr();
		
		vlist = new Vector<TblemployeeBean>();
		
		vlist = mgr.setTblemployeeBean(emp_num);	//vlist에 사번에 맞는 직원 데이터bean 넣음
		
		setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(980, 525));
		JPanel panel = new JPanel();
		panel.setForeground(Color.PINK);
		panel.setBackground(SystemColor.info);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(0, 89, 555, 82);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.LIGHT_GRAY);
		panel_6.setBounds(0, 0, 180, 82);
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel label = new JLabel("\uC785\uC0AC\uC77C     ");
		label.setForeground(Color.WHITE);
		label.setBounds(63, 10, 74, 33);
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_6.add(label);
		
		TextField textField = new TextField();
		textField.setBackground(Color.WHITE);
		textField.setBounds(43, 43, 94, 23);
		textField.setColumns(10);
		textField.setText(vlist.get(0).getEmphiredate());
		textField.setEditable(false);
		panel_6.add(textField);
		
	
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.LIGHT_GRAY);
		panel_7.setBounds(180, 0, 180, 82);
		panel_2.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel label_1 = new JLabel("\uD1F4\uC0AC\uC77C");
		label_1.setBackground(Color.LIGHT_GRAY);
		label_1.setForeground(Color.WHITE);
	//	label_1.setAlignment(Label.CENTER);
		label_1.setBounds(43, 8, 77, 33);
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_7.add(label_1);
		
		textField_1 = new TextField();
		textField_1.setBounds(43, 43, 94, 23);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		panel_7.add(textField_1);
		
		JButton button_1 = new JButton("선택");
		button_1.setBounds(143, 43, 26, 23);
		button_1.setBackground(Color.WHITE);
		button_1.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dia.getContentPane().add(cal);
				dia.setVisible(true);
				
			}
		});
		
		panel_7.add(button_1);
		
		final JLabel label_14 = new JLabel("\uB0A0\uC9DC \uD615\uC2DD\uC5D0 \uB9DE\uCDB0 \uC785\uB825\uD558\uC138\uC694");
		label_14.setBounds(366, 20, 179, 62);
		panel_2.add(label_14);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(0, 199, 555, 131);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_2 = new JLabel("\uC6D4\uAE09(\uC138\uC804)");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Dialog", Font.BOLD, 14));
		label_2.setBounds(37, 30, 78, 23);
		panel_3.add(label_2);
		
		final TextField textField_2 = new TextField();
		textField_2.setBounds(37, 75, 401, 29);
		textField_2.setColumns(40);
		panel_3.add(textField_2);
		
		JLabel label_3 = new JLabel("   \uC6D0");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Dialog", Font.BOLD, 19));
		label_3.setBounds(444, 75, 35, 29);
		panel_3.add(label_3);
		
		final JLabel label_21 = new JLabel("");
		label_21.setBounds(136, 38, 243, 15);
		panel_3.add(label_21);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.textHighlight);
		panel_5.setBounds(0, 421, 555, 104);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel label_4 = new JLabel("\uC5F0\uAC04\uC0C1\uC5EC\uAE08");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Dialog", Font.BOLD, 12));
		label_4.setBounds(38, 10, 69, 23);
		panel_5.add(label_4);
		
		JLabel label_5 = new JLabel("\uC5F0\uCC28\uC218\uB2F9");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Dialog", Font.BOLD, 12));
		label_5.setBounds(268, 10, 69, 23);
		panel_5.add(label_5);
		
		final TextField textField_3 = new TextField();
		textField_3.setBounds(38, 46, 133, 23);
		textField_3.setText("0");
		panel_5.add(textField_3);
		
		final TextField textField_4 = new TextField();
		textField_4.setText("0");
		textField_4.setBounds(268, 46, 120, 23);
		panel_5.add(textField_4);
		
		final JButton button = new JButton("\uC785\uB825");
		button.setBackground(Color.WHITE);
		button.setBounds(469, 15, 76, 79);
		//////////////////////////////////////////////////////////////////////////////
		
		button.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				button.setCursor(new  Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
					
					Date hireDate =  format.parse(vlist.get(0).getEmphiredate());
					format.setLenient(false);
					
					try {
						format.parse(textField_1.getText());
						label_14.setText("올바른 형식입니다.");
						label_14.setForeground(Color.BLACK);
					} catch (Exception e2) {

						label_14.setText("날짜형식 을 맞추어 주세요");
						label_14.setForeground(Color.RED);
					}
					
					Date retireDate = format.parse(textField_1.getText());
					
			
					long calDate = (retireDate.getTime() - hireDate.getTime())/(24*60*60*1000);

					try {
						Integer.parseInt(textField_2.getText());	//월급
					}catch (Exception e1) {
						label_21.setText("숫자로 입력하여 주세요. ");
						label_21.setForeground(Color.RED);
					}
					int salary = Integer.parseInt(textField_2.getText());	//월급
					int bonus = Integer.parseInt(textField_3.getText());	//상여금
					int benefit = Integer.parseInt(textField_4.getText());	//수당
					
					bonus = (bonus + benefit) /12 * 3;
					int averge_salary = (bonus + salary)/90;
					long retire_money = averge_salary * 30 * calDate / 365;
					label_10.setText(String.valueOf(retire_money));
					System.out.println(retire_money);
				} catch (Exception e2) {

				}
				
			}
		});
		//////////////////////////////////////////////////////////////////////////////
		panel_5.add(button);
		
		JLabel label_9 = new JLabel("   \uC6D0");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Dialog", Font.BOLD, 19));
		label_9.setBounds(170, 46, 35, 29);
		panel_5.add(label_9);
		
		JLabel label_13 = new JLabel("   \uC6D0");
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Dialog", Font.BOLD, 19));
		label_13.setBounds(386, 46, 35, 29);
		panel_5.add(label_13);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.info);
		panel_1.setBounds(556, 2, 448, 525);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panel_8.setBounds(0, 0, 470, 139);
		panel_1.add(panel_8);
		panel_8.setLayout(null);
		panel_8.setBackground(SystemColor.textHighlight);
		
		JLabel label_7 = new JLabel("\uC608\uC0C1\uD1F4\uC9C1\uAE08");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("굴림", Font.BOLD, 15));
		label_7.setBounds(12, 10, 82, 26);
		panel_8.add(label_7);
		
		JLabel label_8 = new JLabel("\uC608\uC0C1\uAE08\uC561");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Dialog", Font.BOLD, 27));
	//	label_8.setAlignment(Label.CENTER);
		label_8.setBounds(24, 80, 162, 26);
		panel_8.add(label_8);
		
		JLabel label_12 = new JLabel("\u25B6");
		label_12.setBounds(-6, 52, 82, 29);
		panel_8.add(label_12);
		label_12.setForeground(SystemColor.info);
		label_12.setFont(new Font("굴림", Font.BOLD, 30));
		
		label_10 = new JLabel("000");
		label_10.setBounds(277, 86, 110, 23);
		panel_8.add(label_10);
		//label_10.setAlignment(Label.RIGHT);
		label_10.setForeground(SystemColor.window);
		label_10.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel label_11 = new JLabel("\uC6D0");
		label_11.setBounds(395, 80, 35, 29);
		panel_8.add(label_11);
		label_11.setForeground(SystemColor.window);
		label_11.setFont(new Font("Dialog", Font.BOLD, 19));
		
		JLabel label_15 = new JLabel("\uC0C1\uC5EC\uAE08 :\r\n");
		label_15.setForeground(Color.BLACK);
		label_15.setFont(new Font("Dialog", Font.BOLD, 14));
		label_15.setBounds(10, 198, 398, 33);
		panel_1.add(label_15);
		
		JLabel label_16 = new JLabel("(12\uAC1C\uC6D4 \uC911\uC5D0 \uC9C0\uAE09\uBC1B\uC740 \uC0C1\uC5EC\uAE08/12\uAC1C\uC6D4) * 3\uAC1C\uC6D4");
		label_16.setForeground(Color.BLACK);
		label_16.setFont(new Font("Dialog", Font.BOLD, 14));
		label_16.setBounds(10, 230, 398, 33);
		panel_1.add(label_16);
		
		JLabel label_17 = new JLabel("\uD3C9\uADE0 \uC784\uAE08 :");
		label_17.setForeground(Color.BLACK);
		label_17.setFont(new Font("Dialog", Font.BOLD, 14));
		label_17.setBounds(10, 273, 398, 33);
		panel_1.add(label_17);
		
		JLabel label_18 = new JLabel("(\uC0C1\uC5EC\uAE08 + \uD1F4\uC0AC\uC804 3\uAC1C\uC6D4 \uAE09\uC5EC\uC758 \uD3C9\uADE0) / \uD1F4\uC0AC\uC804 3\uAC1C\uC6D4\uC758 \uC77C\uC218");
		label_18.setForeground(Color.BLACK);
		label_18.setFont(new Font("Dialog", Font.BOLD, 14));
		label_18.setBounds(10, 300, 398, 33);
		panel_1.add(label_18);
		
		JLabel label_19 = new JLabel("\uD1F4\uC9C1\uAE08 :");
		label_19.setForeground(Color.BLACK);
		label_19.setFont(new Font("Dialog", Font.BOLD, 14));
		label_19.setBounds(10, 347, 398, 33);
		panel_1.add(label_19);
		
		JLabel label_20 = new JLabel("(\uD3C9\uADE0\uC784\uAE08 * 30\uC77C * \uC7AC\uC9C1\uC77C\uC218) / 365");
		label_20.setForeground(Color.BLACK);
		label_20.setFont(new Font("Dialog", Font.BOLD, 14));
		label_20.setBounds(10, 379, 398, 33);
		panel_1.add(label_20);
		
		JLabel lblNewLabel = new JLabel("\uC120\uD0DD \uC785\uB825");
		lblNewLabel.setForeground(SystemColor.controlText);
		lblNewLabel.setBounds(10, 362, 171, 26);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		
		JLabel label_6 = new JLabel("\uD544\uC218 \uC785\uB825");
		label_6.setForeground(SystemColor.controlText);
		label_6.setFont(new Font("굴림", Font.BOLD, 15));
		label_6.setBounds(10, 53, 82, 26);
		panel.add(label_6);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBackground(Color.LIGHT_GRAY);
		separator.setBounds(0, 351, 520, 1);
		panel.add(separator);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(SystemColor.textHighlight);
		panel_4.setBounds(0, 1, 555, 42);
		panel.add(panel_4);

	}
}
