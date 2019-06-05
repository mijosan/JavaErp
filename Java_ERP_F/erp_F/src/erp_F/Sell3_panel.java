package erp_F;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
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
import javax.swing.table.DefaultTableModel;

public class Sell3_panel extends JPanel implements ActionListener{

	static JTable table;
	static DefaultTableModel ctable;
	MemberMgr mgr;
	JScrollPane scrollPane;
	JLabel label;
	private JPanel panel;
	private JButton addBtn;
	private JButton delBtn;
	private JPanel panel_1;
	Sell3_panel_plus spp; 
	public Sell3_panel() {
		String[] row = {"고객번호","고객이름(회사명)","연락처"};
		String[][] col = new String[0][0];
		mgr = new MemberMgr();
		ctable = new DefaultTableModel(col, row) {
			@Override
			public boolean isCellEditable(int row, int column) {				
				return false;
			}			
		};
		
		setLayout(new BorderLayout(0, 0));
		table = new JTable();
		table.setModel(ctable);
		mgr.getCustomerList();
		scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
		
		panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		label = new JLabel("거래처 등록");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(label, BorderLayout.WEST);
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		addBtn = new JButton("+");
		addBtn.setBackground(Color.WHITE);
		addBtn.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		addBtn.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				addBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		panel_1.add(addBtn);
		
		delBtn = new JButton("-");
		delBtn.setBackground(Color.WHITE);
		delBtn.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		delBtn.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				delBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		panel_1.add(delBtn);
		addBtn.addActionListener(this);
		delBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==addBtn) {
			spp = new Sell3_panel_plus();
			spp.table.setValueAt(mgr.getCnum()+1, 0, 0);
		}else if(obj==delBtn) {
			
			mgr.deleteC(table);
			
			for(int i = 0; i<table.getRowCount();i++) {
				
				if(table.isRowSelected(i)) {
					ctable.removeRow(i);
				}
			}
		}
	}

}
