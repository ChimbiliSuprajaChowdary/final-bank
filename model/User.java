package model;

public class User {
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password1=" + password1 + ", age=" + age + ", phoneNumber="
				+ phoneNumber + ", address=" + address + ", proofId=" + proofId + ", bankBalance=" + bankBalance
				+ ", loanStatus=" + loanStatus + "]";
	}
	private String userName;
	private String password1;
	private int age;
	private String phoneNumber;
	private String address;
	private String proofId;
	private long bankBalance;
	private String loanStatus="N/A";
	private long requestedLoan ;
	private long ApprovedLoan=0;
	
	public long getApprovedLoan() {
		return ApprovedLoan;
	}
	public void setApprovedLoan(long approvedLoan) {
		ApprovedLoan = approvedLoan;
	}
	public long getRequestedLoan() {
		return requestedLoan;
	}
	public void setRequestedLoan(long requestedLoan) {
		this.requestedLoan = requestedLoan;
	}
	public User(String userName, String password1, int age, String phoneNumber, String address, String proofId,
			long bankBalance) {
		super();
		this.userName = userName;
		this.password1 = password1;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.proofId = proofId;
		this.bankBalance = bankBalance;
		this.loanStatus = "N/A";
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getBankBalance() {
		return bankBalance;
	}
	public void setBankBalance(long bankBalance) {
		this.bankBalance = bankBalance;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProofId() {
		return proofId;
	}
	public void setProofId(String proofId) {
		this.proofId = proofId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password) {
		this.password1 = password;
	}
}
