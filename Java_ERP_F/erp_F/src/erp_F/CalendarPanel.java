package erp_F;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dialog.ModalityType;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;



public class CalendarPanel extends JPanel{

	private JTable dayViewTable;
	private JLabel label;
	private JButton leftButton;
	private JButton rightButton;
	private JTable weekBarTable;
	private JButton todayButton;
	private JButton addButton;
	String url =  "jdbc:mysql://113.198.238.105:3306/erp_f?useUnicode=true&characterEncoding=EUC_KR";
	String driverClass = "org.gjt.mm.mysql.Driver";
	String dbuid = "user";
	String dbpwd = "1234";
	
	Connection connection ;
	
	
	private boolean focus = false;

	int todayY;
	int todayM;
	int todayD;
	MemberMgr mgr;
	Calendar calendar = Calendar.getInstance();

	DefaultTableModel weekTable = new DefaultTableModel(0, 7);
	DefaultTableModel dayTable = new DefaultTableModel(6, 7);
	
	private JLabel console;

	/*public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalendarPanel frame = new CalendarPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public CalendarPanel() {
		setFont(new Font("굴림", Font.PLAIN, 12));
		setBounds(100, 100, 530, 525);
		mgr = new MemberMgr();
		
		this.setBackground(new Color(255, 255, 255));
		this.setLayout(new BorderLayout(0, 0));
		this.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent arg0) {
				do_contentPane_mouseWheelMoved(arg0);
			}
		});
		
		// 요일 표시 테이블
		String[] weekColumns = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
		weekTable.addRow(weekColumns);
		
		// 가운데 정렬 renderer
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(JLabel.CENTER);

		// 일요일 빨간색
		DefaultTableCellRenderer sunRed = new DefaultTableCellRenderer();
		sunRed.setForeground(Color.RED);
		sunRed.setHorizontalAlignment(JLabel.CENTER);

		// 토요일 파란색
		DefaultTableCellRenderer satBlue = new DefaultTableCellRenderer();
		satBlue.setForeground(Color.BLUE);
		satBlue.setHorizontalAlignment(JLabel.CENTER);

		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		label.setBounds(270, 10, 384, 54);
		this.add(label);

		DefaultTableCellRenderer top = new DefaultTableCellRenderer();
		top.setVerticalAlignment(SwingConstants.TOP);

		// 날짜 일요일 빨간색
		DefaultTableCellRenderer sunDateRed = new DefaultTableCellRenderer();
		sunDateRed.setForeground(Color.RED);
		sunDateRed.setVerticalAlignment(SwingConstants.TOP);

		// 날짜 토요일 파란색
		DefaultTableCellRenderer satDateBlue = new DefaultTableCellRenderer();
		satDateBlue.setForeground(Color.BLUE);
		satDateBlue.setVerticalAlignment(SwingConstants.TOP);
		
        leftButton = new JButton("<");
        
		leftButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_leftButton_actionPerformed(e);
			}
		});
		leftButton.setFont(new Font("굴림", Font.PLAIN, 16));
		leftButton.setBounds(322, 17, 46, 46);
		
		// 버튼 투명화
		leftButton.setOpaque(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setBorderPainted(false);
		leftButton.setFocusable(false);
		
		leftButton.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				leftButton.setCursor(new  Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		
		this.add(leftButton);

		rightButton = new JButton(">");
		
		rightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rightButton_actionPerformed(e);
			}
		});
		rightButton.setFont(new Font("굴림", Font.PLAIN, 16));
		rightButton.setBounds(566, 17, 46, 46);
		rightButton.setOpaque(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setBorderPainted(false);
		rightButton.setFocusable(false);
		

		rightButton.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				rightButton.setCursor(new  Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		
		this.add(rightButton);

		todayButton = new JButton("\uC624\uB298");
		todayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_todayButton_actionPerformed(e);
			}
		});

		todayButton.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				todayButton.setCursor(new  Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		
		todayButton.setBackground(SystemColor.control);
		todayButton.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		todayButton.setBounds(827, 61, 79, 23);
		todayButton.setOpaque(false);
		todayButton.setBorderPainted(false);
		todayButton.setFocusable(false);
		this.add(todayButton);

		addButton = new JButton("\uFF0B");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_addButton_actionPerformed(e);
				
			}
		});
		
		addButton.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				addButton.setCursor(new  Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		
		addButton.setBackground(SystemColor.control);
		addButton.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		addButton.setBounds(902, 61, 60, 23);
		addButton.setOpaque(false);
		addButton.setFocusable(false);
		addButton.setBorderPainted(false);
		this.add(addButton);

		weekBarTable = new JTable(weekTable) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
			
		};

		weekBarTable.setEnabled(false);
		weekBarTable.setRowSelectionAllowed(false);
		weekBarTable.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		weekBarTable.setBackground(new Color(220, 220, 220));
		weekBarTable.setRowHeight(25);
		weekBarTable.setFillsViewportHeight(true);
		weekBarTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		weekBarTable.setBounds(12, 85, 950, 23);

		weekBarTable.getColumnModel().getColumn(1).setCellRenderer(center);
		weekBarTable.getColumnModel().getColumn(2).setCellRenderer(center);
		weekBarTable.getColumnModel().getColumn(3).setCellRenderer(center);
		weekBarTable.getColumnModel().getColumn(4).setCellRenderer(center);
		weekBarTable.getColumnModel().getColumn(5).setCellRenderer(center);
		weekBarTable.getColumnModel().getColumn(0).setCellRenderer(sunRed);
		weekBarTable.getColumnModel().getColumn(6).setCellRenderer(satBlue);
		this.add(weekBarTable);
		
				// 날짜 표시 테이블
				dayViewTable = new JTable(dayTable) {
					private static final long serialVersionUID = 1L;
		
					public boolean isCellEditable(int row, int column) {
						
						return false;
					};
					
				};
				dayViewTable.setCellSelectionEnabled(true);
				dayViewTable.setColumnSelectionAllowed(true);
				
				dayViewTable.addMouseMotionListener(new MouseMotionListener() {
					
					@Override
					public void mouseMoved(MouseEvent e) {
						dayViewTable.setCursor(new  Cursor(Cursor.HAND_CURSOR));
					}
					
					@Override
					public void mouseDragged(MouseEvent e) {
					}
				});
				
				
				dayViewTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						do_dayViewTable_mouseClicked(e);
					}					
				});
				dayViewTable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
				dayViewTable.setBorder(new LineBorder(new Color(0, 0, 0)));
				dayViewTable.setFillsViewportHeight(true);
				dayViewTable.setRowHeight(102);
				dayViewTable.setBounds(12, 107, 950, 585);
				dayViewTable.getColumnModel().getColumn(0).setCellRenderer(top);
				dayViewTable.getColumnModel().getColumn(1).setCellRenderer(top);
				dayViewTable.getColumnModel().getColumn(2).setCellRenderer(top);
				dayViewTable.getColumnModel().getColumn(3).setCellRenderer(top);
				dayViewTable.getColumnModel().getColumn(4).setCellRenderer(top);
				dayViewTable.getColumnModel().getColumn(5).setCellRenderer(top);
				dayViewTable.getColumnModel().getColumn(6).setCellRenderer(top);
				dayViewTable.getColumnModel().getColumn(0).setCellRenderer(sunDateRed);
				dayViewTable.getColumnModel().getColumn(6).setCellRenderer(satDateBlue);		
				
				this.add(dayViewTable);
				
				console = new JLabel("");
				console.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
				console.setHorizontalAlignment(SwingConstants.RIGHT);
				console.setBounds(12, 472, 500, 15);
				this.add(console);

		
				todayY = calendar.get(Calendar.YEAR);
				todayM = calendar.get(Calendar.MONTH);
				todayD = calendar.get(Calendar.DATE);
				
				// 실행시 날짜 뿌리면서 오늘로 포커싱
				refresh();				
				todayFocus();
			

	}

	// 달력 소스
	protected void refresh() {

		label.setText((calendar.get(Calendar.YEAR) + "년   ") + (calendar.get(Calendar.MONTH) + 1) + "월");
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);
		int endDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				dayViewTable.setValueAt("", i, j);
			}
		}

		for (int day = 1, row = 0, col = dayWeek - 1; day < endDay + 1; day++, col++) {
			if (col % 7 == 0) {
				col = 0;
				row += 1;
			}
			
			
			

			  //set TableCellRenderer into a specified JTable column class
			//dayViewTable.setDefaultRenderer(String[].class, renderer);

			   //or, set TableCellRenderer into a specified JTable column
	
			dayViewTable.setValueAt(" " + day, row, col);
						
			String sqlYear = calendar.get(Calendar.YEAR) + "";
			String sqlMonth = (calendar.get(Calendar.MONTH) + 1) + "";
			String sqlDay = day + "";
			if (sqlMonth.length() == 1) {sqlMonth = "0" + sqlMonth;}
			if (sqlDay.length() == 1) {sqlDay = "0" + sqlDay;}

			String sqlInput = sqlYear + sqlMonth + sqlDay;
			
			try {						
				connection = DriverManager.getConnection(url, dbuid, dbpwd);
				Class.forName(driverClass);
				String sql = "SELECT agenda_Title FROM agenda_data WHERE agenda_date = '" + sqlInput + "'";
				
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet rs = preparedStatement.executeQuery(sql);
				//<span style="background-color: #FFFF00">Yellow text.</span>
				String head="<html><body>";
				String tail="</body></html>";
				String str="";
				String br = "<br>";
				String highlight = "<span style=\"background-color: #FFFF00\">";
				String highlight2 = "</span>";
				if(rs!=null) {
					str = day+br;
				while(rs.next()) {
					//str = day+br;
					str = str+highlight+rs.getString(1)+highlight2;//이줄만 추가	
					str += br;
				//dayViewTable.setValueAt(str, row, col);				
				}
				str = head+str+tail;
				dayViewTable.setValueAt(str, row, col);				
				}
				connection.close();
			}
				
			catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
		
		}
	}

	
	
	// < 버튼 입력시
	protected void do_leftButton_actionPerformed(ActionEvent e) {
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, calendar.get(Calendar.DATE));
		refresh();
	}

	// > 버튼 입력시
	protected void do_rightButton_actionPerformed(ActionEvent e) {
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE));
		refresh();
	}

	// 마우스 휠 구현
	protected void do_contentPane_mouseWheelMoved(MouseWheelEvent arg0) {
		int notches = arg0.getWheelRotation();
		if (notches < 0) {
			do_leftButton_actionPerformed(null);
		} else {
			do_rightButton_actionPerformed(null);
		}
		refresh();
	}

	// 오늘 버튼 클릭
	protected void do_todayButton_actionPerformed(ActionEvent e) {
		calendar.set(todayY, todayM, todayD);		
		refresh();
		todayFocus();
	}

	// 오늘로 포커싱 하기
	protected void todayFocus() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				String s = String.valueOf(dayViewTable.getValueAt(i, j));
				
				s = s.trim();
				
				int idx = s.indexOf("<br>");
				if(s.length()<=3&&s.length()>0) {
					if(todayD==Integer.parseInt(s)) {
						dayViewTable.changeSelection(i, j, false, false);
						dayViewTable.requestFocus();						
						}
					}
				
				if(s.length()>3) {
					s = s.substring(12, idx);
					if(todayD==Integer.parseInt(s)) {
						dayViewTable.changeSelection(i, j, false, false);
						dayViewTable.requestFocus();						
					}					
				}
				focus = true;
				//System.out.println(s.substring(12, idx));
				//System.out.println(idx);
				/*if(s.length()>0&&idx!=-1) {
					
					//System.out.println(s.substring(0,idx+1));
					if(s.length()==1&&s.equals(todayD)) {	//일정이없는 한자리일때
						dayViewTable.changeSelection(i, j, false, false);
						dayViewTable.requestFocus();
					}
					if(s.length()==2&&Integer.valueOf(s.substring(0))==todayD) {	//일정이없는 두자일일때
						dayViewTable.changeSelection(i, j, false, false);
						dayViewTable.requestFocus();
					}
					
					if(s.length()>3&&Integer.valueOf(s.substring(0,idx))==todayD) {	
						dayViewTable.changeSelection(i, j, false, false);
						dayViewTable.requestFocus();
					}
				}
				if (s.substring(1,4).equals(todayD)) {
					dayViewTable.changeSelection(i, j, false, false);
					dayViewTable.requestFocus();
				}*/
			}
		}

	}

	// 더블클릭 이벤트
	protected void do_dayViewTable_mouseClicked(MouseEvent e) {
		
		focus = true;
		if (e.getClickCount() == 2) {
		int row = dayViewTable.getSelectedRow();
		int col = dayViewTable.getSelectedColumn();

		String day = dayViewTable.getValueAt(row, col).toString();
		
		String sqlYear = calendar.get(Calendar.YEAR) + "";
		String sqlMonth = (calendar.get(Calendar.MONTH) + 1) + "";
		
		if(day.length()<=3) {
			day = day;
		}
		int idx = day.indexOf("<br>");
		if(day.length()>3) {
			day = day.substring(12, idx);						
			}					
		String sqlDay = day.trim();
		
		if (sqlMonth.length() == 1) {
			sqlMonth = "0" + sqlMonth;
		}
		if (sqlDay.length() == 1) {
			sqlDay = "0" + sqlDay;
		}
				
		String sqlInput = sqlYear + sqlMonth + sqlDay;
		if(mgr.isCalendar(sqlInput)) {
			CalendarDialog agenda = new CalendarDialog(this, ModalityType.MODELESS, sqlInput);
			agenda.setLocationRelativeTo(this);
			agenda.setVisible(true);
		}else {
			addAgenda();
		}
		
		}
		/*if (e.getClickCount() == 2) {
			addAgenda();
		}*/		
	}

	// 일정추가 버튼
	protected void do_addButton_actionPerformed(ActionEvent e) {
		if (focus == true) {
			addAgenda();			
		}
	}

	// 일정추가 메서드
	protected void addAgenda() {

		int row = dayViewTable.getSelectedRow();
		int col = dayViewTable.getSelectedColumn();

		String day = dayViewTable.getValueAt(row, col).toString();
		
		String sqlYear = calendar.get(Calendar.YEAR) + "";
		String sqlMonth = (calendar.get(Calendar.MONTH) + 1) + "";
		
		if(day.length()<=3) {
			day = day;
		}
		int idx = day.indexOf("<br>");
		if(day.length()>3) {
			day = day.substring(12, idx);						
			}					
		String sqlDay = day.trim();
		
		if (sqlMonth.length() == 1) {
			sqlMonth = "0" + sqlMonth;
		}
		if (sqlDay.length() == 1) {
			sqlDay = "0" + sqlDay;
		}
				
		String sqlInput = sqlYear + sqlMonth + sqlDay;

		if(!day.equals("")) {
			AgendaDB addAgenda = new AgendaDB(this, ModalityType.MODELESS, sqlInput);
			addAgenda.setLocationRelativeTo(this);
			addAgenda.setVisible(true);
		}
		
	}	
}
 
