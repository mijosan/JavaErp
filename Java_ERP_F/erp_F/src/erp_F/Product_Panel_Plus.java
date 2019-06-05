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

public class Product_Panel_Plus extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JTable plus;
	static DefaultTableModel table;

	MemberMgr mgr;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public Product_Panel_Plus() {
		mgr = new MemberMgr();
		setTitle("생산 관리");
		setBounds(100, 100, 600, 119);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
			
		String[] row = {"제품번호","제품이름","제품수량","제품단가","제품창고","생산날짜"};
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
			final JButton okButton = new JButton("작성");
			okButton.setBackground(Color.WHITE);
			okButton.setFont(new Font("함초롬돋움", Font.BOLD, 12));
			
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
					String pname, container, date;
					int pnum, pquntitiy, pprice;
					
					pnum = Integer.parseInt(plus.getValueAt(0, 0).toString());
					pname = String.valueOf(plus.getValueAt(0, 1));
					pquntitiy = Integer.parseInt(plus.getValueAt(0, 2).toString());
					pprice = Integer.parseInt(plus.getValueAt(0, 3).toString());
					container = String.valueOf(plus.getValueAt(0, 4));
					date = String.valueOf(plus.getValueAt(0, 5));
			
					mgr.setProduct(pnum,pname,pquntitiy,pprice,container,date);

					PS_Panel.hrTable.addRow(new Object[] {pnum,pname,pquntitiy,pprice,container,date});				
					
					setVisible(false);
					dispose();
					} catch(Exception e1) {
						JOptionPane.showMessageDialog(null,"입력한 형식을 확인해주세요");
					}
				}
			});
			
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);
		}
		{
			final JButton cancelButton = new JButton("취소");
			cancelButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
				}
			});
			
			cancelButton.addMouseMotionListener(new MouseMotionListener() {
				
				@Override
				public void mouseMoved(MouseEvent e) {
					cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				
				@Override
				public void mouseDragged(MouseEvent e) {
				}
			});
			cancelButton.setBackground(Color.WHITE);
			cancelButton.setFont(new Font("함초롬돋움", Font.BOLD, 12));
			cancelButton.setActionCommand("Cancel");
			buttonPane.add(cancelButton);
		}
		setVisible(true);
	}

}
