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
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Sell_Panel_Plus extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JTable plus;
	static DefaultTableModel table;
	MemberMgr mgr;
	Vector<Integer> plist;	
	Vector<String> clist;	
	Vector<String> elist;	
	JComboBox<String> pnumCombo;
	JComboBox<String> cnumCombo;
	JComboBox<String> enumCombo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Sell_Panel_Plus dialog = new Sell_Panel_Plus();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Sell_Panel_Plus() {
		mgr = new MemberMgr();
		setTitle("판매 등록");
		setBounds(100, 100, 600, 119);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		pnumCombo = new JComboBox<String>();
		cnumCombo = new JComboBox<String>();
		enumCombo = new JComboBox<String>();
		
		String[] row = {"판매번호","상품번호","수량","구매처","판매날짜","담당자"};
		String[][] col = new String[1][0];
		
		table = new DefaultTableModel(col, row) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return true;
			}
		};
		
		setPreferredSize(new Dimension(980, 525));
		
		
		plus = new JTable();
		plus.getTableHeader().setReorderingAllowed(false);
		plus.getTableHeader().setResizingAllowed(false);
		plus.setModel(table);
		getpnum();	//상품번호
		getcnum();	//고객
		getename();
		add(new JScrollPane(plus), BorderLayout.CENTER);
		TableColumn selectColumn = plus.getColumnModel().getColumn(1);//상품코드 삽입할 열선택				
		TableColumn selectColumn1 = plus.getColumnModel().getColumn(3);//고객코드 삽입할 열선택				
		TableColumn selectColumn2 = plus.getColumnModel().getColumn(5);//회원코드 삽입할 열선택				
		selectColumn.setCellEditor(new DefaultCellEditor(pnumCombo));
		selectColumn1.setCellEditor(new DefaultCellEditor(cnumCombo));
		selectColumn2.setCellEditor(new DefaultCellEditor(enumCombo));
		
		
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
					String snum, customer, sdate,manager;
					int 	pnum, quantity;
					snum = String.valueOf(plus.getValueAt(0, 0));
					pnum = Integer.parseInt(plus.getValueAt(0, 1).toString());
					quantity = Integer.parseInt(plus.getValueAt(0, 2).toString());
					customer = String.valueOf(plus.getValueAt(0, 3));
					sdate = String.valueOf(plus.getValueAt(0, 4));
					manager =String.valueOf(plus.getValueAt(0, 5));
					
						if(mgr.setSell(snum,pnum,quantity,customer,sdate,manager))
						Sell_Panel.sellTable.addRow(new Object[] {snum,pnum,quantity,customer,sdate,manager});
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null,"입력한 형식을 확인해주세요.");
					}
					
					//Sell_Panel.sellTable.addRow(new Object[] {snum,pnum,quantity,customer,sdate,manager});
					
					setVisible(false);
					dispose();
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
	public void getpnum() {
		plist = mgr.getPNum();	//상품번호 불러옴		
		for (int i = 0; i < plist.size(); i++) {
			String bean = String.valueOf(plist.get(i));
			pnumCombo.addItem(bean);		//콤보박스에 add	
		}
	}
	public void getcnum() {
		clist = mgr.getCNum();//고객번호 불러옴				
			for (int i = 0; i < clist.size(); i++) {
				String bean = String.valueOf(clist.get(i));
				cnumCombo.addItem(bean);	//콤보박스에 add				
		}
	}
	public void getename() {
		elist = mgr.getENum();//고객번호 불러옴				
			for (int i = 0; i < elist.size(); i++) {
				String bean = String.valueOf(elist.get(i));
				enumCombo.addItem(bean);	//콤보박스에 add				
		}
	}
}
