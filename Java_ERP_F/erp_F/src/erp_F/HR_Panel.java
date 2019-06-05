package erp_F;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
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
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class HR_Panel extends JPanel {

	JTable table;
	static DefaultTableModel hrTable;
	JPanel panel;
	static HR_5Panel hr5;
	//패널모음
	HR_Panel hrPanel;
	Pay_Panel PP;
	Retire_Panel retire;
	JTree tree;
	MemberMgr mgr;
	public HR_Panel() {
		
		mgr = new MemberMgr();
		
		setLayout(new BorderLayout(0, 0));
		
		tree = new JTree();
		tree.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("ERP_F") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("인사/급여 관리");
						node_1.add(new DefaultMutableTreeNode("인사기초"));
						node_1.add(new DefaultMutableTreeNode("급여대장"));
						node_1.add(new DefaultMutableTreeNode("퇴직정산"));
						node_1.add(new DefaultMutableTreeNode("증명관리"));
						
					add(node_1);
				}
			}
		));
		
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
				
				if(selectedNode == null) return;
				String nodeName = (String) selectedNode.getUserObject();
				if(nodeName.equals("인사기초")) {
					removeAll();
					
					hrPanel = new HR_Panel();
					add(hrPanel,BorderLayout.CENTER);
					add(tree,BorderLayout.WEST);
					repaint();
				}
				if(nodeName.equals("증명관리")) {
					removeAll();
					
					add(tree,BorderLayout.WEST);
					hr5 = new HR_5Panel();
					add(hr5,BorderLayout.CENTER);
					repaint();
				}
				if(nodeName.equals("급여대장")) {
					removeAll();
					
					add(tree,BorderLayout.WEST);
					PP = new Pay_Panel();
					add(PP,BorderLayout.CENTER);
					repaint();
				}
				if(nodeName.equals("퇴직정산")) {
					removeAll();
					
					add(tree,BorderLayout.WEST);
					retire = new Retire_Panel();
					add(retire,BorderLayout.CENTER);
					repaint();
			}
			}
		});
		
		String[] row = {"사번","성명","생년월일","부서","직급","입사일자","E-mail","계좌"};
		String[][] col = new String[0][0];
		
		hrTable = new DefaultTableModel(col, row) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		setPreferredSize(new Dimension(980, 525));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		table = new JTable();

		table.setModel(hrTable);
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
		
		//add(tree,BorderLayout.WEST);
		mgr.setHRTable(mgr.setTblemployeeBean());
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("인사기초\r\n\r\n");
		panel_1.add(lblNewLabel, BorderLayout.WEST);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		JPanel p = new JPanel();
		final JButton addButton = new JButton("+");
		
		addButton.setBackground(Color.WHITE);
		addButton.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		addButton.setHorizontalAlignment(SwingConstants.RIGHT);
		
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
	
			@Override
			public void actionPerformed(ActionEvent e) {
				HelloPlus hello = new HelloPlus();
				hello.setVisible(true);
			}
		});
		
		final JButton deleteButton = new JButton("-");
		deleteButton.setBackground(Color.WHITE);
		deleteButton.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		deleteButton.setHorizontalAlignment(SwingConstants.RIGHT);
		if(First_Frame.dept.equals("생산부") || First_Frame.dept.equals("영업부")) {
			addButton.setVisible(false);
			deleteButton.setVisible(false);
		}
		
		deleteButton.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				deleteButton.setCursor(new  Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		deleteButton.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				mgr.deleteHR(table);
				
				for(int i = 0; i<table.getRowCount();i++) {
					
					if(table.isRowSelected(i)) {
						hrTable.removeRow(i);
					}
				}
				
			}
		});
		////////////////////////////////////////////////////////////////////////////////////////////
		p.add(addButton);
		p.add(deleteButton);
		panel_1.add(p, BorderLayout.EAST);
	}
}
