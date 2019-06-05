package erp_F;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Pay_Panel extends JPanel {

	static JTable table;
	static DefaultTableModel hrTable;
	Pay_Panel_Plus pay_Plus;
	MemberMgr mgr;
	JButton addButton;
	JButton delButton;
	public Pay_Panel() {
		mgr = new MemberMgr();
		String[] row = {"글번호","사원번호","구분","대장명칭","지급일","직급","E-mail","상여금","지급총액"};
		String[][] col = new String[0][0];
		hrTable = new DefaultTableModel(col, row) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		table = new JTable();

		table.setModel(hrTable);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		// DefaultTableCellHeaderRenderer 생성 (가운데 정렬을 위한)
				DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
				// DefaultTableCellHeaderRenderer의 정렬을 가운데 정렬로 지정
				tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
				// 정렬할 테이블의 ColumnModel을 가져옴
				TableColumnModel tcmSchedule = table.getColumnModel();		 
				// 반복문을 이용하여 테이블을 가운데 정렬로 지정
				for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
				tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
				}
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane);
		panel.setPreferredSize(new Dimension(1300, 700));
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("급여대장\r\n\r\n");
		panel_1.add(lblNewLabel, BorderLayout.WEST);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		
		addButton = new JButton("+");
		
		addButton.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				addButton.setCursor(new  Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pay_Plus = new Pay_Panel_Plus();
				pay_Plus.table.setValueAt(mgr.getPaynum()+1, 0, 0);
			}
		});
		delButton = new JButton("-");
		addButton.setBackground(Color.WHITE);
		addButton.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		delButton.setBackground(Color.WHITE);
		delButton.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		
		delButton.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				delButton.setCursor(new  Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		
		delButton.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				mgr.deletePay(table);
				
				for(int i = 0; i<table.getRowCount();i++) {
					
					if(table.isRowSelected(i)) {
						hrTable.removeRow(i);
					}
				}
			}
		});
		addButton.setHorizontalAlignment(SwingConstants.RIGHT);
		JPanel panelB = new JPanel();
		panelB.setLayout(new FlowLayout());
		panelB.add(addButton);
		panelB.add(delButton);
		panel_1.add(panelB, BorderLayout.EAST);
		if(First_Frame.dept.equals("인사부") || First_Frame.job.equals("사장")) {
			mgr.getPayList();
		}else {
			mgr.getPaySingleList();
			addButton.setVisible(false);
			delButton.setVisible(false);
		}
	}

}
