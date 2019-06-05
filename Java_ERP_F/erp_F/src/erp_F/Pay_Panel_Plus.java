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

public class Pay_Panel_Plus extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JTable plus;
	static DefaultTableModel table;
	MemberMgr mgr;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Pay_Panel_Plus dialog = new Pay_Panel_Plus();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Pay_Panel_Plus() {
		mgr = new MemberMgr();
		setTitle("급여 대장");
		setBounds(100, 100, 600, 119);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
			
		String[] row = {"글번호","사원번호","구분","대장명칭","지급일","직급","E-mail","상여금","지급총액"};
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
					String a, g, d, date, job, email;
					int money, bonus, num;
					a = String.valueOf(plus.getValueAt(0, 0));
					num = Integer.parseInt(plus.getValueAt(0, 1).toString());
					g = String.valueOf(plus.getValueAt(0, 2));
					d = String.valueOf(plus.getValueAt(0, 3));
					date = String.valueOf(plus.getValueAt(0, 4));
					job = String.valueOf(plus.getValueAt(0, 5));
					email = String.valueOf(plus.getValueAt(0, 6));
					bonus = Integer.parseInt(plus.getValueAt(0, 7).toString());
					money = Integer.parseInt(plus.getValueAt(0, 8).toString());
					boolean flag = mgr.setPay(g,num,d,date,job,email,bonus,money);
					if(flag) {
					Pay_Panel.hrTable.addRow(new Object[] {a,num,g,d,date,job,email,bonus,money});
					}
					setVisible(false);
					dispose();
					}catch(Exception e2) {
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
			cancelButton.setBackground(Color.WHITE);
			cancelButton.setFont(new Font("함초롬돋움", Font.BOLD, 12));
			cancelButton.setActionCommand("Cancel");
			cancelButton.addMouseMotionListener(new MouseMotionListener() {
				
				@Override
				public void mouseMoved(MouseEvent e) {
					cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				
				@Override
				public void mouseDragged(MouseEvent e) {
				}
			});
			buttonPane.add(cancelButton);
		}
		setVisible(true);
	}

}
