package erp_F;

public class TblsellBean {
	private String s_num;
	private String p_num;
	private int s_quantity;
	private String c_id;
	private String s_date;	//DATE≈∏¿‘
	private int s_manager;
	
	public String getSnum() {
		return s_num;
	}
	public void setSnum(String s_num) {
		this.s_num = s_num;
	}
	
	public String getPnum() {
		return p_num;
	}
	public void setPnum(String p_num) {
		this.p_num = p_num;
	}
	
	public int getSquantity() {
		return s_quantity;
	}
	public void setSquantity(int s_quantity) {
		this.s_quantity = s_quantity;
	}
	
	public String getCid() {
		return c_id;
	}
	public void setCid(String c_id) {
		this.c_id = c_id;
	}
	
	public String s_date() {
		return s_date;
	}
	public void setSdate(String s_date) {
		this.s_date = s_date;
	}
	
	public int getSmanager() {
		return s_manager;
	}
	public void setSmanager(int s_manager) {
		this.s_manager = s_manager;
	}
}
