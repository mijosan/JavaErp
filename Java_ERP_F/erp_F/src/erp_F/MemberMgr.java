package erp_F;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//DB와 연동 모든 기능 클래스 : 테이블명 + Mgr
public class MemberMgr {

	private DBConnectionMgr pool; //싱글톤

	public MemberMgr() {
		pool = DBConnectionMgr.getInstance();
	}
	//listDelete
	public boolean deleteImg(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "delete from tblimg where idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			int cnt = pstmt.executeUpdate();
			if (cnt == 1) flag = true; // idx가 primary키라서 하나밖에 삭제가안됨 그래서 1을 쓴거임
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	//개인정보 변경
		public void updatePrivacy(int id,int ps,int account, String email) {
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = null;
			boolean flag = false;
			try {
				
				con = pool.getConnection();
				
				//Query문(실행하기 전까지는 오류를 알 수 없다.)
				sql = "UPDATE tblemployee SET emp_birth2=?, emp_account = ?, emp_email = ? WHERE emp_num=?;";
				
				//쿼리문을 DB로 보내기 위해서 만들어야 하는 객체
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, ps);
				pstmt.setInt(2, account); // 첫번째 ?표에 -> '홍길동'
				pstmt.setString(3, email);
				pstmt.setInt(4, id);
		
				int cnt = pstmt.executeUpdate();//insert, update, delete  이코드가 실질적으로 실행
				if(cnt==1) flag = true;
			}catch(Exception e) {//예외가 일어나면 실행되는 영역
				e.printStackTrace();
			}finally {//정상 또는 예외에 관계없이 무조건 실행되는 영역
				//con은 반납, pstmt close(싱글톤이라서 메모리에서 사리지지않음 따라서 직접 닫아줘야함)
				pool.freeConnection(con,pstmt); 
			}
		}
		
		public int getNoticeNum2(String title){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			int num =0 ;
			try {
				con = pool.getConnection();
				sql = "select ntc_idx from tblnotice where ntc_title=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, title);
				rs = pstmt.executeQuery();
				
				rs.next();
				num = rs.getInt(1);
					return num;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return num;
		}
		//공지사항 기본키를 불러옴
				public int getNoticeNum(){
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					String sql = null;
					int num =0 ;
					try {
						con = pool.getConnection();
						sql = "select ntc_idx from tblnotice order by ntc_idx desc";
						pstmt = con.prepareStatement(sql);
						rs = pstmt.executeQuery();
						
						rs.next();
						num = rs.getInt(1);

							return num;
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						pool.freeConnection(con, pstmt, rs);
					}
					return num;
				}
	//입사일을 불러옴
		public String getBirth2(int num){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			String email = null;
			try {
				con = pool.getConnection();
				sql = "select emp_birth2 from tblemployee where emp_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				rs = pstmt.executeQuery();
				
					rs.next();
					email = rs.getString(1);

					return email;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return email;
		}
	//입사일을 불러옴
	public String getAccount(int num){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String email = null;
		try {
			con = pool.getConnection();
			sql = "select emp_account from tblemployee where emp_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
				rs.next();
				email = rs.getString(1);

				return email;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return email;
	}
	//입사일을 불러옴
			public String getHiredate(int num){
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql = null;
				String email = null;
				try {
					con = pool.getConnection();
					sql = "select emp_hiredate from tblemployee where emp_num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, num);
					rs = pstmt.executeQuery();
					
						rs.next();
						email = rs.getString(1);

						return email;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt, rs);
				}
				return email;
			}
	//생일을 불러옴
		public String getBirth(int num){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			String email = null;
			try {
				con = pool.getConnection();
				sql = "select emp_birth from tblemployee where emp_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				rs = pstmt.executeQuery();
				
					rs.next();
					email = rs.getString(1);

					return email;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return email;
		}
	//목록
		public String[] getBottomName(){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			String[] top = new String[10];
			try {
				con = pool.getConnection();
				sql = "select p_name from tblproduct where p_num between 200 and 209;";
				pstmt = con.prepareStatement(sql);
				int i=0;
				rs = pstmt.executeQuery();
					while(rs.next()) {
						top[i] = rs.getString(1);
						i=i+1;
					}
					return top;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return top;
		}
		//목록
		public String[] getShoesName(){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			String[] top = new String[10];
			try {
				con = pool.getConnection();
				sql = "select p_name from tblproduct where p_num between 1 and 106;";
				pstmt = con.prepareStatement(sql);
				int i=0;
				rs = pstmt.executeQuery();
					while(rs.next()) {
						top[i] = rs.getString(1);
						i=i+1;
					}
					return top;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return top;
		}
	//목록
	public String[] getTopName(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String[] top = new String[10];
		try {
			con = pool.getConnection();
			sql = "select p_name from tblproduct where p_num between 300 and 309;";
			pstmt = con.prepareStatement(sql);
			int i=0;
			rs = pstmt.executeQuery();
				while(rs.next()) {
					top[i] = rs.getString(1);
					i=i+1;
				}
				return top;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return top;
	}
	//Top 차트
	public int[] getBottom(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int[] top = new int[10];
		try {
			con = pool.getConnection();
			sql = "select p_quantity from tblproduct where p_num between 200 and 209;";
			pstmt = con.prepareStatement(sql);
			int i=0;
			rs = pstmt.executeQuery();
				while(rs.next()) {
					top[i] = rs.getInt(1);
					i=i+1;
				}
				return top;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return top;
	}
	//Top 차트
	public int[] getShoes(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int[] top = new int[10];
		try {
			con = pool.getConnection();
			sql = "select p_quantity from tblproduct where p_num between 1 and 106;";
			pstmt = con.prepareStatement(sql);
			int i=0;
			rs = pstmt.executeQuery();
				while(rs.next()) {
					top[i] = rs.getInt(1);
					i=i+1;
				}
				return top;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return top;
	}
	//Top 차트
			public int[] getTop(){
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql = null;
				int[] top = new int[20];
				try {
					con = pool.getConnection();
					sql = "select p_quantity from tblproduct where p_num between 300 and 309;";
					pstmt = con.prepareStatement(sql);
					int i=0;
					rs = pstmt.executeQuery();
						while(rs.next()) {
							top[i] = rs.getInt(1);
							i=i+1;
						}
						return top;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt, rs);
				}
				return top;
			}
	//상품 검색
	public void searchNum(DefaultTableModel hrTable,int num){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int idx=0;
		try {
			con = pool.getConnection();
			sql = "select* from tblproduct where p_num=? order by p_num desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
				
				while(rs.next()) {
					//num = rs.getInt(1);
					hrTable.addRow(new Object[] {rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6)});
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
	}
	public void searchName(DefaultTableModel hrTable,String name){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "select* from tblproduct where p_name=? or p_container=? order by p_num desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, name);

			rs = pstmt.executeQuery();
				
				while(rs.next()) {
					hrTable.addRow(new Object[] {rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6)});
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
	}
	public void searchDate(DefaultTableModel hrTable,String date){

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "select* from tblproduct where p_date=? order by p_num desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, date);

			rs = pstmt.executeQuery();
				
				while(rs.next()) {
					hrTable.addRow(new Object[] {rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6)});
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
	}
	
	//paynum을 불러옴
		public int getPaynum(){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			int num = 0;
			try {
				con = pool.getConnection();
				sql = "select paynum from tblpay order by paynum desc";
				pstmt = con.prepareStatement(sql);
	
				rs = pstmt.executeQuery();
				
					rs.next();
					num = rs.getInt(1);

					return num;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return num;
		}
		//상품번호를 불러옴
		public int getProductnum(){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			int num = 0;
			try {
				con = pool.getConnection();
				sql = "select p_num from tblproduct order by p_num desc";
				pstmt = con.prepareStatement(sql);
	
				rs = pstmt.executeQuery();
				
					rs.next();
					num = rs.getInt(1);

					return num;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return num;
		}
		
	//직책을 불러옴
	public String getJob(int num){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String job = null;
		try {
			con = pool.getConnection();
			sql = "select emp_job from tblemployee where emp_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
				rs.next();
				job = rs.getString(1);

				return job;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return job;
	}
	//이메일을 불러옴
	public String getEmail(int num){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String email = null;
		try {
			con = pool.getConnection();
			sql = "select emp_email from tblemployee where emp_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
				rs.next();
				email = rs.getString(1);

				return email;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return email;
	}
	//공지사항 내용을 불러옴
	public String getContent(int a){
		//System.out.println(a);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String content = null;
		try {
			con = pool.getConnection();
			sql = "select ntc_content from tblnotice";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
				int count = 0;
				while(rs.next()) {
					if(count==a) break;
			    	count = count+1;
				}
				content = rs.getString(1);

				return content;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return content;
	}
	//처음 제품 정보를 불러옴(생산부 전용)
	public void getProductList(DefaultTableModel hrTable){
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql = null;
				
				try {
					con = pool.getConnection();
					sql = "select* from tblproduct";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						hrTable.addRow(new Object[] {rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6)});
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt, rs);
			}
	}
	//처음 급여 계산을 불러옴(인사부 전용)
		public void getPayList(){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			
			try {
				con = pool.getConnection();
				sql = "select* from tblpay";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Pay_Panel.hrTable.addRow(new Object[] {rs.getString(1), rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9)});
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
		}
		//처음 급여 계산을 불러옴(타 부서사람)
				public void getPaySingleList(){
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					String sql = null;
					
					try {
						con = pool.getConnection();
						sql = "select* from tblpay where emp_num=?";
						pstmt = con.prepareStatement(sql);
						pstmt.setInt(1, Integer.parseInt(First_Frame.id));
						rs = pstmt.executeQuery();
						
						while(rs.next()) {
							Pay_Panel.hrTable.addRow(new Object[] {rs.getString(1), rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9)});
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						pool.freeConnection(con, pstmt, rs);
					}
				}
	//처음 공지사항 리스르틀 불러옴
	public void getTitleList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			con = pool.getConnection();
			sql = "select* from tblnotice";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				NoticeBoard.extable.addRow(new Object[] {rs.getString(2),rs.getString(3),rs.getString(4)});
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
	}

	//공지사항 getTitle
		public String getTitle(){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			String title = null;
			
			try {
				
				con = pool.getConnection();
				sql = "select ntc_title from tblnotice";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
			
				if (rs != null) 
				{
				  rs.beforeFirst();
				  rs.last();
				}	
				  title = rs.getString(1);
				  
				  return title;
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return title;
		}
	//메모 DB
	public String getMemo(int num){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String memo = null;
		
		try {
			con = pool.getConnection();
			sql = "select emp_memo from tblemployee where emp_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				memo = rs.getString(1);
				return memo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return memo;
	}
	
	//getName
	public String getName(int num){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String name = null;
		
		try {
			con = pool.getConnection();
			sql = "select emp_name from tblemployee where emp_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				name = rs.getString(1);
				return name;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return name;
	}
	//getDept
	public String getDept(int num){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String dept = null;
		
		try {
			con = pool.getConnection();
			sql = "select emp_dept from tblemployee where emp_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dept = rs.getString(1);
				return dept;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return dept;
	}
	
	//로그인 DB
	public boolean getMember(String id, String pw) {
		Connection con = null;  // 메소드안에 선언해야 Connection 클래스가 닫히기전에 엉뚱한걸 실행하는걸 방지함(안정적)
		PreparedStatement pstmt = null;
		ResultSet rs = null;//select의 결과물은 반드시 rs로 받는다.
		String sql = null;
		
		try {
			con = pool.getConnection();
			sql ="select* from tblemployee where emp_num=? and emp_birth2=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery(); //select -> Query //rs가 메모리상에 검색된  테이블?를 가리킴
			if(rs.next()) {//레코드가 있으면 true
				return true;
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con,pstmt,rs);
		}
		return false;
		
	}
	
	//Insert
	public boolean setMemo(String text,String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {//예외가 일어날 가능성 있는 코드의 영역
			
			//pool에서 Connection 객체를 빌려온다.
			con = pool.getConnection();
			
			//Query문(실행하기 전까지는 오류를 알 수 없다.)
			sql = "UPDATE tblemployee SET emp_memo = ? WHERE emp_num=?;";
			
			//쿼리문을 DB로 보내기 위해서 만들어야 하는 객체
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, text);
			pstmt.setString(2, id); // 첫번째 ?표에 -> '홍길동'
			/*홍길동,010-7777-8888, 산적 
			 values(?,?,?) -> values('홍길동','010-7777-8888','산적')*/
			
			//Query문 실행 -> 리턴값은 적용된 레코드 갯수
			int cnt = pstmt.executeUpdate();//insert, update, delete  이코드가 실질적으로 실행
			if(cnt==1) flag = true;
		}catch(Exception e) {//예외가 일어나면 실행되는 영역
			e.printStackTrace();
		}finally {//정상 또는 예외에 관계없이 무조건 실행되는 영역
			//con은 반납, pstmt close(싱글톤이라서 메모리에서 사리지지않음 따라서 직접 닫아줘야함)
			pool.freeConnection(con,pstmt); 
		}
		return flag;
	}
	public boolean setNotice(String title, String content) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {//예외가 일어날 가능성 있는 코드의 영역
			
			//pool에서 Connection 객체를 빌려온다.
			con = pool.getConnection();
			
			//Query문(실행하기 전까지는 오류를 알 수 없다.)
			sql = "INSERT INTO tblnotice  VALUES(?,?,?,?,?);";
			
			//쿼리문을 DB로 보내기 위해서 만들어야 하는 객체
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, null);
			pstmt.setString(2, title);
			pstmt.setString(3, First_Frame.name);
			
			Date d = new Date();
	        
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			pstmt.setString(4, sdf.format(d));
			pstmt.setString(5, content); // 첫번째 ?표에 -> '홍길동'
			
			/*홍길동,010-7777-8888, 산적 
			 values(?,?,?) -> values('홍길동','010-7777-8888','산적')*/
			
			//Query문 실행 -> 리턴값은 적용된 레코드 갯수
			int cnt = pstmt.executeUpdate();//insert, update, delete  이코드가 실질적으로 실행
			if(cnt>=1) flag = true;
		}catch(Exception e) {//예외가 일어나면 실행되는 영역
			e.printStackTrace();
		}finally {//정상 또는 예외에 관계없이 무조건 실행되는 영역
			//con은 반납, pstmt close(싱글톤이라서 메모리에서 사리지지않음 따라서 직접 닫아줘야함)
			pool.freeConnection(con,pstmt); 
		}
		return flag;
	}
	public boolean setPay(String div,int num, String name,String day,String job,String email,int bonus,int total) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {//예외가 일어날 가능성 있는 코드의 영역
			
			//pool에서 Connection 객체를 빌려온다.
			con = pool.getConnection();
			
			//Query문(실행하기 전까지는 오류를 알 수 없다.)
			sql = "INSERT INTO tblpay VALUES(?,?,?,?,?,?,?,?,?);";
			
			//쿼리문을 DB로 보내기 위해서 만들어야 하는 객체
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, null);
			pstmt.setInt(2, num);
			pstmt.setString(3, div);
			pstmt.setString(4, name);
			pstmt.setString(5, day);
			pstmt.setString(6, job);
			pstmt.setString(7, email);
			pstmt.setInt(8, bonus);
			pstmt.setInt(9, total);
			
			//Query문 실행 -> 리턴값은 적용된 레코드 갯수
			int cnt = pstmt.executeUpdate();//insert, update, delete  이코드가 실질적으로 실행
			if(cnt>=1) flag = true;
			
		}catch(Exception e) {//예외가 일어나면 실행되는 영역
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"입력한 형식을 확인해주세요");
			return false;
		}finally {//정상 또는 예외에 관계없이 무조건 실행되는 영역
			//con은 반납, pstmt close(싱글톤이라서 메모리에서 사리지지않음 따라서 직접 닫아줘야함)
			pool.freeConnection(con,pstmt); 
		}
		return true;
	}
	//set product_Panel
	public boolean setProduct(int pnum,String pname,int pquntitiy,int pprice,String container,String date) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {//예외가 일어날 가능성 있는 코드의 영역
			
			//pool에서 Connection 객체를 빌려온다.
			con = pool.getConnection();
			
			//Query문(실행하기 전까지는 오류를 알 수 없다.)
			sql = "INSERT INTO tblproduct VALUES(?,?,?,?,?,?);";
			
			//쿼리문을 DB로 보내기 위해서 만들어야 하는 객체
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pnum);
			pstmt.setString(2, pname);
			pstmt.setInt(3, pquntitiy);
			pstmt.setInt(4, pprice);
			pstmt.setString(5, container);
			pstmt.setString(6, date);

			//Query문 실행 -> 리턴값은 적용된 레코드 갯수
			int cnt = pstmt.executeUpdate();//insert, update, delete  이코드가 실질적으로 실행
			if(cnt>=1) flag = true;
		}catch(Exception e) {//예외가 일어나면 실행되는 영역
			e.printStackTrace();
		}finally {//정상 또는 예외에 관계없이 무조건 실행되는 영역
			//con은 반납, pstmt close(싱글톤이라서 메모리에서 사리지지않음 따라서 직접 닫아줘야함)
			pool.freeConnection(con,pstmt); 
		}
		return flag;
	}
	
	
	//listDelete
	public boolean deleteList(String title) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "delete from tblnotice where ntc_title=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			
			int cnt = pstmt.executeUpdate();
			if (cnt == 1) flag = true; // idx가 primary키라서 하나밖에 삭제가안됨 그래서 1을 쓴거임
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	//deletePay
		public void deletePay(JTable table) {
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = null;

			try {
	
				con = pool.getConnection();
				sql = "delete from tblpay where paynum=?";
				pstmt = con.prepareStatement(sql);
				
				for(int i = 0; i<table.getRowCount();i++) {
					if(table.isRowSelected(i)) {
						
						int num = Integer.parseInt(table.getValueAt(i, 0).toString());
						pstmt.setInt(1, num);
						pstmt.executeUpdate();
					}
				}
	
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
		}
		
		//deleteProduct
				public void deleteProduct(JTable table) {
					Connection con = null;
					PreparedStatement pstmt = null;
					String sql = null;

					try {
			
						con = pool.getConnection();
						sql = "delete from tblproduct where p_num=?";
						pstmt = con.prepareStatement(sql);
						
						for(int i = 0; i<table.getRowCount();i++) {
							if(table.isRowSelected(i)) {
								
								int num = Integer.parseInt(table.getValueAt(i, 0).toString());
								pstmt.setInt(1, num);
								pstmt.executeUpdate();
							}
						}
			
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						pool.freeConnection(con, pstmt);
					}
				}
	
	//Delete
	public boolean deleteMember(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "delete from tblMember where idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			int cnt = pstmt.executeUpdate();
			if (cnt == 1) flag = true; // idx가 primary키라서 하나밖에 삭제가안됨 그래서 1을 쓴거임
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	public void getConfirm(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			con = pool.getConnection();
			sql = "select emp_num, emp_name, emp_birth,emp_hireDate  from tblemployee";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
			Date currentTime = new Date ();
			String mTime = mSimpleDateFormat.format ( currentTime );
			while(rs.next()) {
				HR_5Panel.table5.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)+"~"+mTime,"","확인"});
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
	}
	
	public void getConfirmMe(int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			con = pool.getConnection();
			sql = "select emp_num, emp_name, emp_birth,emp_hireDate  from tblemployee where emp_num=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
			Date currentTime = new Date ();
			String mTime = mSimpleDateFormat.format ( currentTime );
			while(rs.next()) {
				HR_5Panel.table5.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)+"~"+mTime,"","확인"});
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
	}
	public Vector<TblemployeeBean> HelloPlus() {
		try {
		Vector<TblemployeeBean> vlist = new Vector<TblemployeeBean>();
		TblemployeeBean bean = new TblemployeeBean();
		bean.setEmpnum(Integer.parseInt(HelloPlus.table.getValueAt(0, 0).toString()));
		bean.setEmpname((String)HelloPlus.table.getValueAt(0, 1));
		bean.setEmpbirth1(Integer.parseInt(HelloPlus.table.getValueAt(0, 2).toString()));
		bean.setEmpbirth2(Integer.parseInt(HelloPlus.table.getValueAt(0, 3).toString()));
		bean.setEmpdept((String)HelloPlus.table.getValueAt(0, 4));
		bean.setEmphiredate((String)HelloPlus.table.getValueAt(0, 6));
		bean.setEmpaccount(Integer.parseInt(HelloPlus.table.getValueAt(0, 8).toString()));
		bean.setEmpjob((String)HelloPlus.table.getValueAt(0, 5));
		bean.setEmpmemo(null);
		bean.setEmp_email((String)HelloPlus.table.getValueAt(0, 7));
		
		vlist.add(bean);
		return vlist;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"입력한 형식을 확인해주세요");
			
		}
		return null;
		
		
	}
	
	// bean데이터를  테이블에 뿌림
	public void setHRTable(Vector<TblemployeeBean> vlist) {
		
		TblemployeeBean bean = new TblemployeeBean();
		for(int i = 0;i<vlist.size();i++) {
			bean = vlist.get(i);
			int num = bean.getEmp_num();
			String name = bean.getEmpname();
			
			//주민번호 합치기
			int birth = bean.getEmpbirth1();
			
			String dept= bean.getEmpdept();
			String hireDate = bean.getEmphiredate();
			int accout = bean.getEmpaccount();
			String job = bean.getEmpjob();
			String email = bean.getEmp_email();
			HR_Panel.hrTable.addRow(new Object[]  
					{num,name,birth,dept,job,hireDate,email,accout});
		}
	}
	
	// Vector<TblemployeeBean> 을 DB에 추가
	public void setHRList(Vector<TblemployeeBean> vlist) {

		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = null;
		
		try {
			con = pool.getConnection();
			sql = "INSERT INTO tblemployee VALUES(?,?,?,?,?,?,?,?,?,?);";
			pstmt = con.prepareStatement(sql);
			TblemployeeBean bean = new TblemployeeBean();
			
			for(int i = 0;i<vlist.size();i++) {
				bean = vlist.get(i);

				pstmt.setInt(1, bean.getEmp_num());
				pstmt.setString(2, bean.getEmpname());
				pstmt.setInt(3, bean.getEmpbirth1());
				pstmt.setInt(4, bean.getEmpbirth2());
				pstmt.setString(5, bean.getEmpdept());
				pstmt.setString(6, bean.getEmphiredate());
				pstmt.setInt(7, bean.getEmpaccount());
				pstmt.setString(8, bean.getEmpjob());
				pstmt.setString(9, null);
				pstmt.setString(10, bean.getEmp_email());
				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt);
		}
	}
	
	
	
	//DB 정보를 TblemployeeBean에 set //////////////////////////////////////////////////////////////////////
	public Vector<TblemployeeBean> setTblemployeeBean(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<TblemployeeBean> vlist = new Vector<TblemployeeBean>();
		
		try {
			con = pool.getConnection();
			sql = "select * from tblemployee";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			TblemployeeBean bean;
			
			while(rs.next()) {
				bean = new TblemployeeBean();
				bean.setEmpnum(rs.getInt(1));
				bean.setEmpname(rs.getString(2));
				bean.setEmpbirth1(rs.getInt(3));
				bean.setEmpbirth2(rs.getInt(4));
				bean.setEmpdept(rs.getString(5));
				bean.setEmphiredate(rs.getString(6));
				bean.setEmpaccount(rs.getInt(7));
				bean.setEmpjob(rs.getString(8));
				//메모는 없음
				bean.setEmpmemo(null);
				bean.setEmp_email(rs.getString(10));
				vlist.addElement(bean);
			}
			//System.out.println(vlist.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	
	public Vector<TblemployeeBean> setTblemployeeBean(int emp_num){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<TblemployeeBean> vlist = new Vector<TblemployeeBean>();
		int num = emp_num;
		
		try {
			con = pool.getConnection();
			sql = "select * from tblemployee where emp_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			TblemployeeBean bean;
			
			while(rs.next()) {
				bean = new TblemployeeBean();
				bean.setEmpnum(rs.getInt(1));
				bean.setEmpname(rs.getString(2));
				bean.setEmpbirth1(rs.getInt(3));
				bean.setEmpbirth2(rs.getInt(4));
				bean.setEmpdept(rs.getString(5));
				bean.setEmphiredate(rs.getString(6));
				bean.setEmpaccount(rs.getInt(7));
				bean.setEmpjob(rs.getString(8));
				//메모는 없음
				bean.setEmpmemo(null);
				bean.setEmp_email(rs.getString(10));
				vlist.addElement(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void deleteHR(JTable table) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			
			con = pool.getConnection();
			sql = "delete from tblemployee where emp_num=?";
			pstmt = con.prepareStatement(sql);
			
			for(int i = 0; i<table.getRowCount();i++) {
				if(table.isRowSelected(i)) {
					
					int num = Integer.parseInt(table.getValueAt(i, 0).toString());
					pstmt.setInt(1, num);
					pstmt.executeUpdate();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt);
		}
		
	}
	///////////////////////////////////////////////////////////////////////////////////////////

	public void getSell() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			con = pool.getConnection();
			sql = "select s_num, p_num, s_quantity, c_id, s_date, s_manager  from tblsell";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
			Date currentTime = new Date ();
			String mTime = mSimpleDateFormat.format ( currentTime );
			while(rs.next()) {
				Sell_Panel.sellTable.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6)});
			}		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
	}
	//상품번호 받아오기.
	public Vector<Integer> getPNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<Integer> vlist = new Vector<Integer>();
		try {
			con = pool.getConnection();
			sql = "select p_num  from tblproduct";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();				
			while(rs.next()) {
				int s;
				s = rs.getInt(1);
				vlist.addElement(s);
			}		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	//고객번호 받아오기
	public Vector<String> getCNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<String> vlist = new Vector<String>();
		try {
			con = pool.getConnection();
			sql = "select c_name  from tblcustomer";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();				
			while(rs.next()) {
				String s;
				s = rs.getString(1);
				vlist.addElement(s);
			}		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	//직원번호 받아오기
			public Vector<String> getENum() {
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql = null;
				Vector<String> vlist = new Vector<String>();
				try {
					con = pool.getConnection();
					sql = "select emp_name  from tblemployee where emp_dept='영업부'";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();				
					while(rs.next()) {
						String s;
						s = rs.getString(1);
						vlist.addElement(s);
					}		
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt, rs);
				}
				return vlist;
			}
			
			
			public boolean setSell(String snum, int pnum, int quantity, String customer,String date, String manager) {
				Connection con = null;
				PreparedStatement pstmt = null;
				String sql = null;
				boolean flag = false;
				try {//예외가 일어날 가능성 있는 코드의 영역
					
					//pool에서 Connection 객체를 빌려온다.
					con = pool.getConnection();
					
					//Query문(실행하기 전까지는 오류를 알 수 없다.)
					sql = "INSERT INTO tblsell VALUES(?,?,?,?,?,?);";
					
					//쿼리문을 DB로 보내기 위해서 만들어야 하는 객체
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, snum);
					pstmt.setInt(2, pnum);
					pstmt.setInt(3, quantity);
					pstmt.setString(4, customer);
					pstmt.setString(5, date);
					pstmt.setString(6, manager);
					
					//Query문 실행 -> 리턴값은 적용된 레코드 갯수
					int cnt = pstmt.executeUpdate();//insert, update, delete  이코드가 실질적으로 실행
					if(cnt>=1) flag = true;
				}catch(Exception e) {//예외가 일어나면 실행되는 영역
					e.printStackTrace();
					//JOptionPane.showMessageDialog(null,"입력한 형식을 확인해주세요.");
				}finally {//정상 또는 예외에 관계없이 무조건 실행되는 영역
					//con은 반납, pstmt close(싱글톤이라서 메모리에서 사리지지않음 따라서 직접 닫아줘야함)
					pool.freeConnection(con,pstmt); 
				}
				return flag;
			}
			
			public void getSellList(){
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql = null;
				
				try {
					con = pool.getConnection();
					sql = "select* from tblsell";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
						Sell_Panel.sellTable.addRow(new Object[] {rs.getString(1), rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6)});
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt, rs);
				}
			}
			
			//deletePay
			public void deleteSell(JTable table) {
				Connection con = null;
				PreparedStatement pstmt = null;
				String sql = null;

				try {
		
					con = pool.getConnection();
					sql = "delete from tblsell where s_num=?";
					pstmt = con.prepareStatement(sql);
					
					for(int i = 0; i<table.getRowCount();i++) {
						if(table.isRowSelected(i)) {
							
							int num = Integer.parseInt(table.getValueAt(i, 0).toString());
							pstmt.setInt(1, num);
							pstmt.executeUpdate();
						}
					}
		
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt);
				}
			}
			
			//deletePay
			public Vector<ChartBean> getPNQ(){
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql = null;
				Vector<ChartBean> vlist = new Vector<ChartBean>();
				try {			
					con = pool.getConnection();
					sql = "select p.p_name, s.s_quantity from tblproduct p, tblsell s where p.p_num= s.p_num";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery(sql);						
					while(rs.next()){
						ChartBean bean = new ChartBean();
						bean.setName(rs.getString(1));
						bean.setQuantity(rs.getInt(2));
						vlist.addElement(bean);
						}		
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt);
				}
				return vlist;
			}
			
			public Vector<ChartBean> getNCQ(){
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql = null;
				Vector<ChartBean> vlist = new Vector<ChartBean>();
				try {			
					con = pool.getConnection();
					sql = "select  s_manager, count(s_manager) from tblsell group by s_manager";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery(sql);						
					while(rs.next()){
						ChartBean bean = new ChartBean();
						bean.setName(rs.getString(1));
						bean.setCount(rs.getInt(2));
						vlist.addElement(bean);
						}		
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt);
				}
				return vlist;
			}
			public Vector<ChartBean> getCSQ(){
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql = null;
				Vector<ChartBean> vlist = new Vector<ChartBean>();
				try {			
					con = pool.getConnection();
					sql = "select  c_name, count(c_name) from tblsell group by c_name;";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery(sql);						
					while(rs.next()){
						ChartBean bean = new ChartBean();
						bean.setName(rs.getString(1));
						bean.setCount(rs.getInt(2));
						vlist.addElement(bean);
						}		
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt);
				}
				return vlist;
			}
			
			//고객목록
			public void getCustomerList(){
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql = null;
				
				try {
					con = pool.getConnection();
					sql = "select* from tblcustomer";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
						Sell3_panel.ctable.addRow(new Object[] {rs.getInt(1), rs.getString(2),rs.getString(3)});
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt, rs);
				}
			}
			public void setSell2(int cid, String cname, String cphone) {
				Connection con = null;
				PreparedStatement pstmt = null;
				String sql = null;
				boolean flag = false;
				try {//예외가 일어날 가능성 있는 코드의 영역
					
					//pool에서 Connection 객체를 빌려온다.
					con = pool.getConnection();
					
					//Query문(실행하기 전까지는 오류를 알 수 없다.)
					sql = "INSERT INTO tblcustomer VALUES(?,?,?);";
					
					//쿼리문을 DB로 보내기 위해서 만들어야 하는 객체
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, cid);
					pstmt.setString(2, cname);
					pstmt.setString(3, cphone);
				
					//Query문 실행 -> 리턴값은 적용된 레코드 갯수
					int cnt = pstmt.executeUpdate();//insert, update, delete  이코드가 실질적으로 실행
					
				}catch(Exception e) {//예외가 일어나면 실행되는 영역
					e.printStackTrace();
				}finally {//정상 또는 예외에 관계없이 무조건 실행되는 영역
					//con은 반납, pstmt close(싱글톤이라서 메모리에서 사리지지않음 따라서 직접 닫아줘야함)
					pool.freeConnection(con,pstmt); 
				}
				
			}
			//paynum을 불러옴
			public int getCnum(){
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql = null;
				int num = 0;
				try {
					con = pool.getConnection();
					sql = "select c_id from tblcustomer order by c_id desc";
					pstmt = con.prepareStatement(sql);
		
					rs = pstmt.executeQuery();
					
						rs.next();
						num = rs.getInt(1);

						return num;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt, rs);
				}
				return num;
			}
			//deleteCustomer
			public void deleteC(JTable table) {
				Connection con = null;
				PreparedStatement pstmt = null;
				String sql = null;

				try {
		
					con = pool.getConnection();
					sql = "delete from tblcustomer where c_id=?";
					pstmt = con.prepareStatement(sql);
					
					for(int i = 0; i<table.getRowCount();i++) {
						if(table.isRowSelected(i)) {
							
							int num = Integer.parseInt(table.getValueAt(i, 0).toString());
							pstmt.setInt(1, num);
							pstmt.executeUpdate();
						}
					}
		
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt);
				}
			}

			public void getHolidayList(){
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql = null;
				
				try {
					con = pool.getConnection();
					sql = "select * from tbldiligence";
					pstmt = con.prepareStatement(sql);
		
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
						Holiday_Panel.sellTable.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5)});
					}						
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt, rs);
				}				
			}
			
			public void addHoliday(String date, int eNum, String name, String content) {
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql = null;
				
				try {
					//Query문(실행하기 전까지는 오류를 알 수 없다.)
					con = pool.getConnection();
					sql = "INSERT INTO tbldiligence VALUES(?,?,?,?,?);";
					
					//쿼리문을 DB로 보내기 위해서 만들어야 하는 객체
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, null);
					pstmt.setString(2, date);
					pstmt.setInt(3, eNum);
					pstmt.setString(4, name);
					pstmt.setString(5, content);
				
					//Query문 실행 -> 리턴값은 적용된 레코드 갯수
					pstmt.executeUpdate();//insert, update, delete  이코드가 실질적으로 실행
									
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt, rs);
				}				
			}
			
			public void deleteH(JTable table) {
				Connection con = null;
				PreparedStatement pstmt = null;
				String sql = null;

				try {
					
					con = pool.getConnection();
					sql = "delete from tbldiligence where dil_num=?";
					pstmt = con.prepareStatement(sql);
					
					for(int i = 0; i<table.getRowCount();i++) {
						if(table.isRowSelected(i)) {
							
							int num = Integer.parseInt(table.getValueAt(i, 0).toString());
							pstmt.setInt(1, num);
							pstmt.executeUpdate();
						}
					}
		
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt);
				}
			}
			
			public int getHNum() {
				Connection con = null;
				PreparedStatement pstmt = null;
				String sql = null;
				ResultSet rs = null;
			
				
				try {
					con = pool.getConnection();
					sql = "select dil_num from tbldiligence order by dil_num desc";
					pstmt = con.prepareStatement(sql);
		
					rs = pstmt.executeQuery();
					
					rs.next();
					
					return rs.getInt(1);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt, rs);
				}
				return 0;
			}
			
			public Vector<CalendarBean> getCalendar(String title){
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql = null;
				Vector<CalendarBean> vlist = new Vector<CalendarBean>();
				try {			
					con = pool.getConnection();
					sql = "select * from agenda_data where agenda_date = ?";
					//delete from tbldiligence where dil_num=?
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, title);
					rs = pstmt.executeQuery();
					while(rs.next()){
						CalendarBean bean = new CalendarBean();
						bean.setDate(rs.getString(1));
						bean.setTitle(rs.getString(2));
						bean.setContent(rs.getString(3));
						vlist.addElement(bean);
						}		
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt);
				}
				return vlist;
			}
			
			public String getCContent(String title) {
				String s="";
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql = null;
				
				try {			
					con = pool.getConnection();
					sql = "select agenda_Content from agenda_data where agenda_Title = ?";
					//delete from tbldiligence where dil_num=?
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, title);
					rs = pstmt.executeQuery();
					rs.next();
					s = rs.getString(1);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt);
				}
				return s;
			}
			
			public void deleteCalendar(String date,String title) {
				Connection con = null;
				PreparedStatement pstmt = null;
				String sql = null;

				try {
					
					con = pool.getConnection();
					sql = "delete from agenda_data where agenda_date = ? and agenda_Title=?";
					pstmt = con.prepareStatement(sql);
					
				
					pstmt.setString(1, date);
					pstmt.setString(2, title);
					pstmt.executeUpdate();
					
		
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt);
				}
			}
			
			public boolean isCalendar(String date) {
				Connection con = null;
				PreparedStatement pstmt = null;
				String sql = null;
				boolean flag = false;
				ResultSet rs = null;
				try {
					con = pool.getConnection();
					sql = "select * from agenda_data where agenda_date=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, date);
					rs = pstmt.executeQuery();					
					if (rs.next()) flag = true; // idx가 primary키라서 하나밖에 삭제가안됨 그래서 1을 쓴거임
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt);
				}
				return flag;
			}
}

		

