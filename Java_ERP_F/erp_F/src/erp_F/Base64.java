package erp_F;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 *  table sql
 *  
 * create table tblimg(
 *     idx int auto_increment primary key,
 *     img MEDIUMBLOB
 * );
 *  
 * */

public class Base64 extends JFrame{
	private DBConnectionMgr pool;
	JPanel mainPnl;
	JPanel southPnl;
	JTextField tf;
	JButton btn;
	JButton btnGet;
	Image img;
	JLabel background;	
	JLabel notice;
	FileDialog fileDialog;
	private JButton btnNewButton;
	
	public Base64() {	

		pool = DBConnectionMgr.getInstance();
		fileDialog = new FileDialog(this, "파일 열기",  FileDialog.LOAD);
		mainPnl = new JPanel();
		southPnl = new JPanel();
		tf = new JTextField(20);
		btn = new JButton("insert");
		btnGet = new JButton("select");
		notice = new JLabel("<html><body>C:\\Downloads\\aa.png ←이런식으로 입력후 insert<br> ex) 1 ← 불러올 때는 데이터베이스의 idx 값을 입력후 select </body></html>");
		
		getContentPane().add(notice,BorderLayout.NORTH);
		tf.setText("상단의 사용법 확인!!"); 
		
		
		try {
			img = ImageIO.read(new File("C:\\Java\\erp_F\\src\\erp_F_images\\그림1.png"));
			background = new JLabel(new ImageIcon(img));
		} catch (IOException e) {
			tf.setText("failed!");
			e.printStackTrace();
		}		
		
		btnNewButton = new JButton("New button");
		mainPnl.add(btnNewButton);
		
		mainPnl.add(background);		

		getContentPane().add(mainPnl);
		
		southPnl.add(tf);
		southPnl.add(btn);
		southPnl.add(btnGet);
		
		getContentPane().add(southPnl,BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 300);
		this.setVisible(false);

	}
	
	public void writeImg(int num,String imgName) {
		
		File file = new File(imgName);
        FileInputStream input=null;
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			
			con = pool.getConnection();
			
			sql = "insert into tblimg values (?,?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			pstmt.setBinaryStream(2, input);			
			
			int cnt = pstmt.executeUpdate();
			if(cnt==1) tf.setText("OK!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt);
		}						
 
	}
	
	public Image readImg(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			con = pool.getConnection();
			sql = "select img from tblimg where idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			File file = new File("this.png");
            FileOutputStream output = new FileOutputStream(file);            
            
            	if (rs.next()) {
                InputStream input = rs.getBinaryStream(1);
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }
                try {
        			return img = ImageIO.read(new File(file.getAbsolutePath()));	
        		} catch (Exception e) {
        			e.printStackTrace();
        		}		
            }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return null;
	}
}