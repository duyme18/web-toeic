package BEAN;

public class Member {
	private int memberid;
	private String fullname;
	private String membername;
	private String memberpass;
	private int categorymemberid;

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getMemberpass() {
		return memberpass;
	}

	public void setMemberpass(String memberpass) {
		this.memberpass = memberpass;
	}

	public int getCategorymemberid() {
		return categorymemberid;
	}

	public void setCategorymemberid(int categorymemberid) {
		this.categorymemberid = categorymemberid;
	}
}
