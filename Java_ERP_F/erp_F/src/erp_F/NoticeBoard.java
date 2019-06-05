package erp_F;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NoticeBoard extends JPanel{
	static JTable table;
	JButton btnNewButton;
	JButton btnNewButton_1;
	static DefaultTableModel extable;
	MemberMgr mgr;
	static String title;


	public NoticeBoard() {
		
		mgr = new MemberMgr();
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("\uC791\uC131");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if(obj==btnNewButton) {
					WriteNotice wn = new WriteNotice();
					wn.setVisible(true);
				}
			}
		});
		

		btnNewButton.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				btnNewButton.setCursor(new  Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("\uC0AD\uC81C");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		
		
		btnNewButton_1.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				btnNewButton_1.setCursor(new  Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
					int row = table.getSelectedRow();
					int col = table.getSelectedColumn();
					
					String day = table.getValueAt(row, col).toString();
					mgr.deleteList(day);
					mgr.deleteImg(mgr.getNoticeNum()+1);//이미지삭제
					System.out.println(mgr.getNoticeNum()+1);
				
					DefaultTableModel dm = (DefaultTableModel)table.getModel();
					while(dm.getRowCount() > 0)
					{
					    dm.removeRow(0);
					}
					mgr.getTitleList();
				
			}
		});
		panel.add(btnNewButton_1);
		
		///////직책별 Enable
		if(mgr.getJob(Integer.parseInt(First_Frame.id)).equals("사장")) {
			
		}else if(mgr.getJob(Integer.parseInt(First_Frame.id)).equals("부장")) {
			
		}else if(mgr.getJob(Integer.parseInt(First_Frame.id)).equals("대리")) {
			btnNewButton.setVisible(false);
			btnNewButton_1.setVisible(false);
		}else if(mgr.getJob(Integer.parseInt(First_Frame.id)).equals("사원")) {
			btnNewButton.setVisible(false);
			btnNewButton_1.setVisible(false);
		}
		table = new JTable();
		table.setDragEnabled(false);
		
		table.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				table.setCursor(new  Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Object obj = e.getSource();
				if(e.getClickCount() == 2) {
					int row = table.getSelectedRow();
					int col = table.getSelectedColumn();
					
					title = table.getValueAt(row, col).toString();
					String name = table.getValueAt(row, col + 1).toString();
					String day1 = table.getValueAt(row, col + 2).toString();
					
					if (!title.equals("")) {
						try {
						ReadNotice rn = new ReadNotice(title,name,day1,row);
						rn.setLocationRelativeTo(null);
						rn.setVisible(true);
						}catch(Exception e1) {
							ReadNotice2 rn2 = new ReadNotice2(title,name,day1,row);
							rn2.setLocationRelativeTo(null);
							rn2.setVisible(true);
						}
					}
				}
			}
		});
     
		String[] row = {"제목","작성자","날짜"};
		String[][] col = new String[0][0];

		extable = new DefaultTableModel(col,row) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table.setModel(extable);
		
		setPreferredSize(new Dimension(450, 365));
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
}