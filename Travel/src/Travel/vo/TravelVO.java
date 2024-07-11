package Travel.vo;

import java.util.Date;

public class TravelVO {
	private String custNo;
	private String custName;
	private String custSex;
	private String custPhone;
	private String custMoney;
	private Date creationDate;

	public String getCustNo() {
		return custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustSex() {
		return custSex;
	}

	public void setCustSex(String custSex) {
		this.custSex = custSex;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getCustMoney() {
		return custMoney;
	}

	public void setCustMoney(String custMoney) {
		this.custMoney = custMoney;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	@Override
	public String toString() {
		return "TravelVO [custNo=" + custNo + ", custName=" + custName + ", custSex =" + custSex + ", custPhone=" + custPhone + 
				", custMoney=" + custMoney + ", creationDate=" + creationDate + "]";
	}
	
	public String briefShow() {
		return custNo + "  " + custName + "  " + custSex + "  " + custPhone + "  " + custMoney;
	}
	
}
