package erp_F;

public class TblemployeeBean {
	private int emp_num;
	private String emp_name;
	private int emp_birth1;
	private int emp_birth2;
	private String emp_dept;
	private String emp_hiredate;
	private int emp_account;
	private String emp_job;
	private String emp_memo;
	private String emp_email;
	
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	public String getEmpmemo() {
		return emp_memo;
	}
	public void setEmpmemo(String emp_memo) {
		this.emp_memo = emp_memo;
	}
	public int getEmp_num() {
		return emp_num;
	}
	public void setEmpnum(int emp_num) {
		this.emp_num = emp_num;
	}
	public String getEmpname() {
		return emp_name;
	}
	public void setEmpname(String emp_name) {
		this.emp_name = emp_name;
	}
	public int getEmpbirth1() {
		return emp_birth1;
	}
	public void setEmpbirth1(int emp_birth1) {
		this.emp_birth1 = emp_birth1;
	}
	public int getEmpbirth2() {
		return emp_birth2;
	}
	public void setEmpbirth2(int emp_birth2) {
		this.emp_birth2 = emp_birth2;
	}
	public String getEmpdept() {
		return emp_dept;
	}
	public void setEmpdept(String emp_dept) {
		this.emp_dept = emp_dept;
	}
	public String getEmphiredate() {
		return emp_hiredate;
	}
	public void setEmphiredate(String emp_hiredate) {
		this.emp_hiredate = emp_hiredate;
	}
	public int getEmpaccount() {
		return emp_account;
	}
	public void setEmpaccount(int emp_account) {
		this.emp_account = emp_account;
	}
	public String getEmpjob() {
		return emp_job;
	}
	public void setEmpjob(String emp_job) {
		this.emp_job = emp_job;
	}
}