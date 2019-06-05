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

public class Holiday_Panel extends JPanel {

	static JTable table;
	static DefaultTableModel sellTable;
	JPanel panel;
	HR_5Panel hr5;
	//�гθ���	
	JTree tree;
	JScrollPane scrollPane;
	MemberMgr mgr;
	String[] pnum;	
	Holiday_Plus hp;
	JPanel panel_1;
	JPanel panel_2;
	JButton addButton;
	JButton delButton;
	public Holiday_Panel() {
		
		setLayout(new BorderLayout(0, 0));
		mgr = new MemberMgr();
		tree = new JTree();
				
		
		tree.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("ERP_F") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("���� ����");
						node_1.add(new DefaultMutableTreeNode("���µ��/��ȸ"));										
						//node_1.add(new DefaultMutableTreeNode("������ȸ"));										
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
				if(nodeName.equals("�Ǹ���ȸ")) {
					/*panel.removeAll();
					s2p = new Sell2_Panel();
					panel.add(s2p,BorderLayout.CENTER);						
					repaint();*/
				}
				if(nodeName.equals("�Ǹŵ��")) {					
					/*panel.removeAll();					
					panel.add(scrollPane);
					panel.add(panel_1, BorderLayout.NORTH);					
					repaint();*/
				}
				if(nodeName.equals("�ŷ�ó���")) {
					/*panel.removeAll();	
					s3p = new Sell3_panel();
					panel.add(s3p);
					//panel.add(panel_1, BorderLayout.NORTH);					
					repaint();*/
				}
				
			}
		});
		add(tree,BorderLayout.WEST);

		String[] row = {"���¹�ȣ","��¥","���","�̸�","�����׸�"};
		String[][] col = new String[0][0];
		sellTable = new DefaultTableModel(col, row) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column==1) return true;
				return false;
			}
			
		};
		
		setPreferredSize(new Dimension(980, 525));		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		table = new JTable();
		table.setModel(sellTable);
		table.getTableHeader().setReorderingAllowed(false);	//��� ��ġ�ٲٱ� �Ұ�
		table.getTableHeader().setResizingAllowed(false);		//��� ������Ұ�
		// DefaultTableCellHeaderRenderer ���� (��� ������ ����)
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		// DefaultTableCellHeaderRenderer�� ������ ��� ���ķ� ����
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		// ������ ���̺��� ColumnModel�� ������
		TableColumnModel tcmSchedule = table.getColumnModel();		 
		// �ݺ����� �̿��Ͽ� ���̺��� ��� ���ķ� ����
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
		tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}
		mgr.getHolidayList();
		
		
		scrollPane = new JScrollPane(table);
		panel.add(scrollPane);
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.EAST);
		
		addButton = new JButton("+");
		panel_2.add(addButton);
		addButton.setBackground(Color.WHITE);
		addButton.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		addButton.setHorizontalAlignment(SwingConstants.RIGHT);
		
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
			@Override
			public void actionPerformed(ActionEvent e) {
			//spp = new Sell_Panel_Plus();
			hp = new Holiday_Plus();
			hp.textField.setText(First_Frame.name);
			}
		});
		
		delButton = new JButton("-");
		delButton.setHorizontalAlignment(SwingConstants.RIGHT);
		delButton.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		delButton.setBackground(Color.WHITE);
		
		delButton.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				delButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		panel_2.add(delButton);
		delButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mgr.deleteH(table);			
			for(int i = 0; i<table.getRowCount();i++) {
								
								if(table.isRowSelected(i)) {
									sellTable.removeRow(i);
								}
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("���� ���");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(lblNewLabel);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("���ʷҵ���", Font.BOLD, 13));
		
		if(First_Frame.dept.equals("������") || First_Frame.job.equals("����")) {			
		}else {			
			addButton.setVisible(false);
			delButton.setVisible(false);
		}
	}
	
}
