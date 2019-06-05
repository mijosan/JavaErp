package erp_F;

public class TblproductBean {
	private String p_num;
	private String p_name;
	private int p_quantity;
	private int p_price;
	private String p_container;
	private String p_date;
	
	public String getPnum() {
		return p_num;
	}
	public void setPnum(String p_num) {
		this.p_num = p_num;
	}
	
	public String getPname() {
		return p_name;
	}
	public void setPname(String p_name) {
		this.p_name = p_name;
	}
	
	public int getPquantity() {
		return p_quantity;
	}
	public void setPquantity(int p_quantity) {
		this.p_quantity = p_quantity;
	}
	
	public int getPprice() {
		return p_price;
	}
	public void setPprice(int p_price) {
		this.p_price = p_price;
	}
	
	public String getPcontainer() {
		return p_container;
	}
	public void setPcontainer(String p_container) {
		this.p_container = p_container;
	}
	
	public String getPdate() {
		return p_date;
	}
	public void setPdate(String p_date) {
		this.p_date = p_date;
	}
}