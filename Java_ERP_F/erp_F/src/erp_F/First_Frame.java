package erp_F;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class First_Frame extends JFrame implements Runnable, ActionListener{
	
	private JPanel contentPane;
	private CalendarPanel calendarPanel;

	private JPanel panel,panel_4,panel_5,panel_6,panel_7,panel_1;
	private JLabel lblNewLabel;		//시간 들어가있음.(우측상단)
	private JLabel lblNewLabel_7;
	private NoticeBoard noticeBoard;
	ImageIcon logoImage;
	private JButton btnNewButton_5;
	int todayY;
	int todayM;
	int todayD;
	static String id;
	static String email;
	static String job;
	static String name;
	static String dept;
	static String birth;
	static String birth2;
	static String account;
	static String hireDate;
	
	MemberMgr mgr;
	JButton btnNewButton_6;
	JTextArea textArea;
	HR_Panel hrPanel;
	PS_Panel psPanel;
	Sell_Panel sellPanel;
	Holiday_Panel holidayPanel;
	Calendar calendar = Calendar.getInstance();
	private login lg;

	DefaultTableModel weekTable = new DefaultTableModel(0, 7);
	DefaultTableModel dayTable = new DefaultTableModel(6, 7);
	
	public First_Frame(final String id) {
		this.id=id;
		mgr = new MemberMgr();
		
		birth = mgr.getBirth(Integer.parseInt(id));
		hireDate = mgr.getHiredate(Integer.parseInt(id));
		account = mgr.getAccount(Integer.parseInt(id));
		birth2 = mgr.getBirth2(Integer.parseInt(id));
		email = mgr.getEmail(Integer.parseInt(id));
		job = mgr.getJob(Integer.parseInt(id));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1450, 860);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel.add(panel_4, BorderLayout.CENTER);
		
		logoImage = new ImageIcon("erp_F/erp_logo.png");
		
		final JButton btnNewButton = new JButton(/*new ImageIcon("C:\\Java\\myJava\\erp_F\\erp_logo.png")*/);		
		btnNewButton.setText("                                                 ");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("C:\\Java\\erp_F\\src\\erp_F_images\\erp_logo.png"));
		btnNewButton.setMargin(new Insets(0, 0, 0, 0));
		btnNewButton.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
				dispose();
				new First_Frame(id);
		}
		});
		Border emptyBorder = BorderFactory.createEmptyBorder();
		panel_4.setLayout(new BorderLayout(0, 0));
		btnNewButton.setBorder(emptyBorder);
		panel_4.add(btnNewButton, BorderLayout.WEST);
		
		JLabel lblNewLabel_5 = new JLabel("                       ");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Java\\erp_F\\src\\erp_F_images\\graphic.png"));
		panel_4.add(lblNewLabel_5, BorderLayout.CENTER);
		
		lblNewLabel = new JLabel("TIME ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("돋움", Font.BOLD, 13));
		panel_4.add(lblNewLabel, BorderLayout.EAST);
		
		panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.textHighlight);
		panel.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(SystemColor.textHighlight);
		panel_5.add(panel_10, BorderLayout.WEST);
		
		final JButton btnNewButton_1 = new JButton("   인사/급여 관리   ");
		btnNewButton_1.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				btnNewButton_1.setCursor(new  Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 13));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBorder(emptyBorder);
		btnNewButton_1.setMargin(new Insets(30, 20, 0, 0));
		btnNewButton_1.setBackground(null);
		panel_10.add(btnNewButton_1);
		
		final JButton btnNewButton_2 = new JButton("생산/재고 관리   ");
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_2.setFont(new Font("굴림", Font.BOLD, 13));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBorder(emptyBorder);
		btnNewButton_2.setBackground(null);
		
		btnNewButton_2.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				btnNewButton_2.setCursor(new  Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		
		panel_10.add(btnNewButton_2);
		
		final JButton btnNewButton_3 = new JButton("영업/구매 관리");
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_3.setFont(new Font("굴림", Font.BOLD, 13));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBorder(emptyBorder);
		btnNewButton_3.setBackground(null);
		

		btnNewButton_3.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				btnNewButton_3.setCursor(new  Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		
		panel_10.add(btnNewButton_3);
		
		final JButton btnNewButton_0 = new JButton("   근태 관리");
		btnNewButton_0.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_0.setFont(new Font("굴림", Font.BOLD, 13));
		btnNewButton_0.setForeground(Color.WHITE);
		btnNewButton_0.setBorder(emptyBorder);
		btnNewButton_0.setBackground(null);
		

		btnNewButton_0.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				btnNewButton_0.setCursor(new  Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		
		panel_10.add(btnNewButton_0);
		
		JPanel panel_8 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel_8.setBackground(SystemColor.textHighlight);
		panel_5.add(panel_8, BorderLayout.EAST);
		
		final JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.setForeground(Color.WHITE);
		btnNewButton_7.setBorder(emptyBorder);
		btnNewButton_7.setBackground(null);
		btnNewButton_7.setIcon(new ImageIcon("C:\\Java\\erp_F\\src\\erp_F_images\\emailImage.png"));
		btnNewButton_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Inquiry_Dialog();
			}
		});
		btnNewButton_7.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				btnNewButton_7.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		panel_8.add(btnNewButton_7);
		
		JLabel label_1 = new JLabel("  \uBD80\uC11C : ");
		label_1.setForeground(Color.WHITE);
		panel_8.add(label_1,new FlowLayout(FlowLayout.RIGHT));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		dept = mgr.getDept(Integer.parseInt(id));
		JLabel lblNewLabel_2 = new JLabel(dept);
		lblNewLabel_2.setForeground(Color.WHITE);
		panel_8.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("       이름 : ");
		lblNewLabel_3.setForeground(Color.WHITE);
		panel_8.add(lblNewLabel_3);
		name= mgr.getName(Integer.parseInt(id));
		final JLabel lblNewLabel_4 = new JLabel(name+" 님"     );
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Privacy_Dialog();
			}
		});
		lblNewLabel_4.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				lblNewLabel_4.setCursor(new  Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		lblNewLabel_4.setForeground(Color.WHITE);
		panel_8.add(lblNewLabel_4);
		
		final JButton btnNewButton_4 = new JButton("");
		
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBorder(emptyBorder);
		btnNewButton_4.setBackground(null);
		btnNewButton_4.setIcon(new ImageIcon("C:\\Java\\myJava\\erp_F_images\\logout.png"));
		
		btnNewButton_4.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				btnNewButton_4.setCursor(new  Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				lg = new login();
				lg.setVisible(true);
			}
		});
		panel_8.add(btnNewButton_4);
		
		final JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		panel_6 = new JPanel();
		panel_2.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_6.add(panel_9, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("\r\n");
		panel_9.add(lblNewLabel_1);
		
		JPanel panel_11 = new JPanel();
		panel_6.add(panel_11, BorderLayout.SOUTH);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.WHITE);
		panel_11.add(panel_12, BorderLayout.CENTER);
		
		JLabel lblNewLabel_9 = new JLabel("\r\n");
		panel_12.add(lblNewLabel_9);
		noticeBoard = new NoticeBoard();
		//noticeBoard.setBounds(0, 0, 300, 500);
		
		panel_11.add(noticeBoard, BorderLayout.SOUTH);
		noticeBoard.table.getColumnModel().getColumn(0).setPreferredWidth(200);
		noticeBoard.table.getColumnModel().getColumn(1).setPreferredWidth(20);
		noticeBoard.table.getColumnModel().getColumn(2).setPreferredWidth(20);
		
		btnNewButton_5 = new JButton();
		

		btnNewButton_5.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				btnNewButton_5.setCursor(new  Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if(obj==btnNewButton_5) {				
				DefaultTableModel dm = (DefaultTableModel)NoticeBoard.table.getModel();
				while(dm.getRowCount() > 0)
				{
				    dm.removeRow(0);
				}
				mgr.getTitleList();
			}
			}
		});
		//btnNewButton_5.setEnabled(false);
		btnNewButton_5.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		btnNewButton_5.setText("\uACF5\uC9C0\uC0AC\uD56D");
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setIcon(new ImageIcon("C:\\Java\\myJava\\erp_F_images\\notice.png"));
		btnNewButton_5.setMargin(new Insets(0, 0, 0, 0));
		btnNewButton_5.setBorder(emptyBorder);
		panel_11.add(btnNewButton_5, BorderLayout.NORTH);
		
		panel_7 = new JPanel();
		panel_2.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		textArea = new JTextArea();
		textArea.setBackground(new Color(255, 228, 181));
		textArea.setRows(10);
		
		
		textArea.setText(mgr.getMemo(Integer.parseInt(id)));
		
		panel_7.add(textArea, BorderLayout.CENTER);
		
		btnNewButton_6 = new JButton("\uC800\uC7A5");
		btnNewButton_6.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_6.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.setIcon(new ImageIcon("C:\\Java\\myJava\\erp_F_images\\save.png"));
		btnNewButton_6.setMargin(new Insets(0, 0, 0, 0));
		btnNewButton_6.setBorder(emptyBorder);
		btnNewButton_6.addActionListener(this);
		
		btnNewButton_6.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				btnNewButton_6.setCursor(new  Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		
		panel_7.add(btnNewButton_6, BorderLayout.NORTH);
		
		final JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_8 = new JLabel("");
		panel_3.add(lblNewLabel_8, BorderLayout.NORTH);		
		
		calendarPanel = new CalendarPanel();		//달력패널 생성.
		panel_3.add(calendarPanel, BorderLayout.CENTER);
		calendarPanel.setLayout(new BorderLayout());
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		lblNewLabel_7 = new JLabel("Copyright   erp_F.     All Rights Reserved. ");
		lblNewLabel_7.setForeground(Color.WHITE);
		panel_1.add(lblNewLabel_7);
		mgr.getTitleList();
		psPanel = new PS_Panel();
		hrPanel = new HR_Panel();
		sellPanel = new Sell_Panel();
		holidayPanel=new Holiday_Panel();
		btnNewButton_1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(panel_3);
				contentPane.remove(panel_2);
				contentPane.remove(psPanel);
				contentPane.remove(sellPanel);
				contentPane.remove(holidayPanel);
				
				contentPane.add(hrPanel.tree,BorderLayout.WEST);
				contentPane.add(hrPanel,BorderLayout.CENTER);
				repaint();
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(panel_3);
				contentPane.remove(panel_2);
				contentPane.remove(hrPanel);
				contentPane.remove(hrPanel.tree);
				contentPane.remove(sellPanel);
				contentPane.remove(holidayPanel);
				
				contentPane.add(psPanel,BorderLayout.CENTER);
				repaint();
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(panel_3);
				contentPane.remove(panel_2);
				contentPane.remove(hrPanel.tree);
				contentPane.remove(hrPanel);
				contentPane.remove(psPanel);
				contentPane.remove(holidayPanel);
				
				contentPane.add(sellPanel,BorderLayout.CENTER);
				repaint();
			}
		});
		btnNewButton_0.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(panel_3);
				contentPane.remove(panel_2);
				contentPane.remove(hrPanel.tree);
				contentPane.remove(hrPanel);
				contentPane.remove(psPanel);
				contentPane.remove(sellPanel);
				
				contentPane.add(holidayPanel,BorderLayout.CENTER);
				repaint();
			}
		});
		setVisible(true);
		if(dept.equals("인사부") || dept.equals("영업부")) {
			btnNewButton_2.setVisible(false);
			if(job.equals("사장")) {
				btnNewButton_2.setVisible(true);
			}
		}
		if(dept.equals("인사부") || dept.equals("생산부")) {
			btnNewButton_3.setVisible(false);
			if(job.equals("사장")) {
				btnNewButton_3.setVisible(true);
			}
		}
		
		new Thread(this).start(); //스레드 시작 -> 시간
		
	}
		public void display(){

        Calendar cal=Calendar.getInstance();

        int y=cal.get(Calendar.YEAR);

        int m=cal.get(Calendar.MONTH)+1;
        
        int d=cal.get(Calendar.DATE);

        int h=cal.get(Calendar.HOUR);

        int min=cal.get(Calendar.MINUTE);

        int sec=cal.get(Calendar.SECOND);
        
        lblNewLabel.setText(" "+y+"년 "+m+"월 "+d+"일 "+h+"시 "+min+"분 "+sec+"초");
         
        }// 시간 메소드(우측 상단)
		
		public void run() {
			while(true)  {
                display();	//시간
                try{
                       Thread.sleep(1000);
                }catch(Exception ex){
                	ex.printStackTrace();
                }
			}
		}//run메소드
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(obj==btnNewButton_6) {
				mgr.setMemo(textArea.getText(),id);
			}
		}
	
}
