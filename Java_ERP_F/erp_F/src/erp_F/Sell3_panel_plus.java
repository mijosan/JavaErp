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
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Sell3_panel_plus extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JTable plus;
	static DefaultTableModel table;
	MemberMgr mgr;
	
	public Sell3_panel_plus() {
		mgr = new MemberMgr();
		setTitle("�ŷ�ó ���");
		setBounds(100, 100, 600, 119);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
			
		String[] row = {"����ȣ","���̸�(ȸ���)","����ó"};
		String[][] col = new String[1][0];
		
		table = new DefaultTableModel(col, row);
		
		setPreferredSize(new Dimension(980, 525));
		
		
		plus = new JTable();
		plus.getTableHeader().setReorderingAllowed(false);
		plus.getTableHeader().setResizingAllowed(false);
		plus.setModel(table);
		add(new JScrollPane(plus), BorderLayout.CENTER);
		
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			final JButton okButton = new JButton("�ۼ�");
			okButton.setBackground(Color.WHITE);
			okButton.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
			
			okButton.addMouseMotionListener(new MouseMotionListener() {
				
				@Override
				public void mouseMoved(MouseEvent e) {
					okButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				
				@Override
				public void mouseDragged(MouseEvent e) {
				}
			});
			okButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
					String cname, cphone;
					int cid;
					cid = Integer.parseInt(plus.getValueAt(0, 0).toString());
					cname = String.valueOf(plus.getValueAt(0, 1));
					cphone = String.valueOf(plus.getValueAt(0, 2));
		
					mgr.setSell2(cid,cname,cphone);
					Sell3_panel.ctable.addRow(new Object[] {cid,cname,cphone});
					setVisible(false);
					dispose();
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(null,"�Է��� ������ Ȯ�����ּ���");
					}
				}
			});
			
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);
		}
		{
			final JButton cancelButton = new JButton("���");
			
			cancelButton.addMouseMotionListener(new MouseMotionListener() {
				
				@Override
				public void mouseMoved(MouseEvent e) {
					cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				
				@Override
				public void mouseDragged(MouseEvent e) {
				}
			});
			cancelButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
				}
			});

			cancelButton.setBackground(Color.WHITE);
			cancelButton.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
			buttonPane.add(cancelButton);
		}
		setVisible(true);
	}

}
