package erp_F;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class HR_5Panel extends JPanel {

	static JTable table;
	static DefaultTableModel table5;
	MemberMgr mgr;
	String[] content = {"","����","�������","����"};
	JComboBox contentCombo;
	JTextField btnConfirm;
	JCheckBox chkbox;
	String dept;
	String job;
	public HR_5Panel() {
		setBackground(Color.WHITE);
		String[] row = {"�����ȣ","����","�ֹι�ȣ","�����Ⱓ","����뵵","Ȯ��"};
		String[][] col = new String[0][0];
		table5 = new DefaultTableModel(col, row){
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column==4||column==5) return true;				
				return false;
			}	
		};
		
		contentCombo = new JComboBox(content);
		
		contentCombo.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				contentCombo.setCursor(new  Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		
		mgr = new MemberMgr();
		dept = mgr.getDept(Integer.parseInt((First_Frame.id)));
		job = mgr.getJob(Integer.parseInt((First_Frame.id)));
		if(dept.equals("�λ��")||job.equals("����")) {
			mgr.getConfirm();
		}else {
			mgr.getConfirmMe(Integer.parseInt((First_Frame.id)));
		}
		btnConfirm = new JTextField("Ȯ��");
		
		setPreferredSize(new Dimension(980, 525));
		setLayout(new BorderLayout(0, 0));
		JLabel lblNewLabel = new JLabel("�������\r\n\r\n");
		lblNewLabel.setBackground(Color.WHITE);
		add(lblNewLabel, BorderLayout.NORTH);
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setModel(table5);
		
		JScrollPane scrollPane = new JScrollPane(table);
		
		scrollPane.setFont(new Font("����", Font.BOLD, 14));
		scrollPane.setBackground(Color.WHITE);
		
		TableColumn selectColumn = table.getColumnModel().getColumn(4);//������		

		selectColumn.setCellEditor(new DefaultCellEditor(contentCombo));	//�޺��ڽ� ����
		table.setFont(new Font("����", Font.PLAIN, 13));

		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				int col= table.getSelectedColumn();
				//table.setValueAt("Ȯ��", row, col);
				
				//String s = table.getValueAt(row, col-1).toString();
				//System.out.println(s);				
				if(table.getValueAt(row, col-1)==null||table.getValueAt(row, col-1).toString()=="") {
					JOptionPane.showMessageDialog(null,"�뵵�� �����ϼ���");
				}else if(table.getValueAt(row, col-1)!=null&&col==5) {
					ConfirmDialog cd = new ConfirmDialog(table.getValueAt(row,1).toString(),table.getValueAt(row,2).toString(),table.getValueAt(row, 3).toString(),
								table.getValueAt(row, 4).toString(),mgr.getDept(Integer.parseInt(table.getValueAt(row,0).toString())), 
								mgr.getJob(Integer.parseInt(table.getValueAt(row,0).toString())) );
						cd.setLocationRelativeTo(null);
						cd.setVisible(true);
				}
			}
		});

		
		
		
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
		add(scrollPane);
	}
	
}