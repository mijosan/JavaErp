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
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class PS_Panel extends JPanel {

	static JTable table;
	static DefaultTableModel hrTable;
	//패널모음
	Product_Panel_Plus product_Plus;
	JTree tree;
	MemberMgr mgr;
	JButton addButton;
	JButton delButton;
	Product_lookup PL;
	JScrollPane scrollPane;
	JLabel lblNewLabel;
	JPanel panelB;
	Chart ct;
	private JPanel panel;
	JPanel panel_2;
	
	public PS_Panel() {
		PL = new Product_lookup();
		setLayout(new BorderLayout(0, 0));
		
		tree = new JTree();
		tree.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("ERP_F") {
				{
						DefaultMutableTreeNode node_1;
						node_1 = new DefaultMutableTreeNode("생산/재고 관리");
						node_1.add(new DefaultMutableTreeNode("생산관리"));
						node_1.add(new DefaultMutableTreeNode("생산관리 조회"));
						node_1.add(new DefaultMutableTreeNode("재고 차트"));
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

				if(nodeName.equals("생산관리")) {
					panel.removeAll();		
					
					panel.add(scrollPane,BorderLayout.CENTER);
					panel.add(panel_2,BorderLayout.NORTH);
					repaint();
				}
				if(nodeName.equals("생산관리 조회")) {
					panel.removeAll();
					
					PL = new Product_lookup();
					panel.add(PL,BorderLayout.CENTER);
					repaint();
				}
				if(nodeName.equals("재고 차트")) {
					panel.removeAll();
					
					ct = new Chart();
					panel.add(ct,BorderLayout.CENTER);
					repaint();
				}
			}
		});
		
		add(tree,BorderLayout.WEST);

		
		String[] row = {"제품번호","제품이름","제품수량","제품단가","제품창고","생산날짜"};
		String[][] col = new String[0][0];
		hrTable = new DefaultTableModel(col, row) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
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
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

		panel.setLayout(new BorderLayout(0, 0));
		scrollPane = new JScrollPane(table);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("생산관리");
		panel_2.add(lblNewLabel, BorderLayout.WEST);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		
		
		addButton = new JButton("+");
		
		addButton.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				product_Plus = new Product_Panel_Plus();
				product_Plus.table.setValueAt(mgr.getProductnum()+1, 0, 0);
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
				delButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		delButton.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				mgr.deleteProduct(table);
				
				for(int i = 0; i<table.getRowCount();i++) {
					
					if(table.isRowSelected(i)) {
						hrTable.removeRow(i);
					}
				}
			}
		});
		addButton.setHorizontalAlignment(SwingConstants.RIGHT);
		panelB = new JPanel();
		panel_2.add(panelB, BorderLayout.EAST);
		panelB.setLayout(new FlowLayout());
		panelB.add(addButton);
		panelB.add(delButton);
		mgr = new MemberMgr();
		mgr.getProductList(hrTable);
		
	}
}
