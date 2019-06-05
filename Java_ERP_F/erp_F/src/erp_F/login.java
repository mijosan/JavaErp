package erp_F;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class login extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	MemberMgr mgr;
	JButton btnEnter;
	JLabel lblNewLabel;
	Dust_Panel dp;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public login() {
		dp =  new Dust_Panel();
		mgr = new MemberMgr();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 400, 260);
		setTitle("ERP_F Login");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblLogin = new JLabel("");
		lblLogin.setIcon(new ImageIcon("C:\\Java\\myJava\\erp_F_images\\logo.png"));
		lblLogin.setFont(new Font("����", Font.BOLD, 20));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblLogin, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setSize(new Dimension(300,300));
		panel.setLayout(new GridLayout(2,1));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2);
		
		Color color = new Color(11, 96, 174);
		panel_2.setLayout(null);
		JLabel lblID = new JLabel("ID  ");
		lblID.setBounds(115, 24, 23, 15);
		lblID.setFont(new Font("����", Font.BOLD, 12));
		lblID.setForeground(color);
		panel_2.add(lblID);
		
		textField = new JTextField();
		textField.setBounds(143, 21, 116, 21);
		textField.setBackground(SystemColor.activeCaption);
		textField.setForeground(color);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblPwd = new JLabel("P/W");
		lblPwd.setBounds(106, 8, 27, 15);
		lblPwd.setFont(new Font("����", Font.BOLD, 12));
		lblPwd.setForeground(color);
		
		panel_3.add(lblPwd);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(143, 5, 116, 21);
		passwordField.setBackground(SystemColor.activeCaption);
		passwordField.setColumns(10);
		passwordField.addActionListener(this);
		passwordField.setForeground(color);
		panel_3.add(passwordField);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		contentPane.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_4.add(panel_1, BorderLayout.CENTER);
		
		btnEnter = new JButton("");
		btnEnter.setIcon(new ImageIcon("C:\\Java\\erp_F\\src\\erp_F_images\\login.png"));
		Border emptyBorder = BorderFactory.createEmptyBorder();
		btnEnter.setBorder(emptyBorder);
		btnEnter.addActionListener(this);
		btnEnter.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				btnEnter.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		panel_1.add(btnEnter);
		
		lblNewLabel = new JLabel("");
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel, BorderLayout.SOUTH);
		
		JLabel label = new JLabel("");
		contentPane.add(label, BorderLayout.WEST);
		
		JLabel label_1 = new JLabel("");
		contentPane.add(label_1, BorderLayout.EAST);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==btnEnter || obj==passwordField) {
			if(mgr.getMember(textField.getText(), passwordField.getText())) {
				new First_Frame(textField.getText());
				setVisible(false);
				dp.setVisible(true);
			}else {
				lblNewLabel.setForeground(Color.red);
				lblNewLabel.setBackground(Color.WHITE);
				lblNewLabel.setText("로그인 정보가 틀렸습니다.");
			}
		}
	}
	
}
