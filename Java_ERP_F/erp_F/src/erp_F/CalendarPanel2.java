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
import java.text.SimpleDateFormat;
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


public class CalendarPanel2 extends JPanel{

	private JTable dayViewTable;
	private JLabel label;
	private JButton leftButton;
	private JButton rightButton;
	private JTable weekBarTable;
	private JButton todayButton;


	
	private boolean focus = false;

	int todayY;
	int todayM;
	int todayD;

	Calendar calendar = Calendar.getInstance();

	DefaultTableModel weekTable = new DefaultTableModel(0, 7);
	DefaultTableModel dayTable = new DefaultTableModel(6, 7);
	
	private JLabel console;


	public CalendarPanel2() {
		setFont(new Font("굴림", Font.PLAIN, 12));
		setBounds(100, 100, 250, 250);
		
		
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
		label.setBounds(30, 10, 200, 54);
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
		leftButton.setBounds(5, 17, 46, 46);
		
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
		rightButton.setBounds(220, 17, 46, 46);
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
		todayButton.setBounds(200, 61, 79, 23);
		todayButton.setOpaque(false);
		todayButton.setBorderPainted(false);
		todayButton.setFocusable(false);
		this.add(todayButton);



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
		weekBarTable.setRowHeight(23);
		weekBarTable.setFillsViewportHeight(true);
		weekBarTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		weekBarTable.setBounds(12, 85, 250, 23);

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
				dayViewTable.setRowHeight(20);
				dayViewTable.setBounds(12, 107,250, 120);
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
			
			dayViewTable.setValueAt(" " + day, row, col);
						
			String sqlYear = calendar.get(Calendar.YEAR) + "";
			String sqlMonth = (calendar.get(Calendar.MONTH) + 1) + "";
			String sqlDay = day + "";
			if (sqlMonth.length() == 1) {sqlMonth = "0" + sqlMonth;}
			if (sqlDay.length() == 1) {sqlDay = "0" + sqlDay;}

			String sqlInput = sqlYear + sqlMonth + sqlDay;
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
					
			String sqlInput = sqlYear +"-"+ sqlMonth +"-"+ sqlDay;
			System.out.println(sqlInput);
			Retire_Panel.textField_1.setText(sqlInput);
			Retire_Panel.dia.setVisible(false);

			
		}	
		
	}

}
 
