package Travel.vo;

import java.util.Date;

public class TravelVO {
	private String custNo;
	private String custName;
	private String custSex;
	private String custPhone;
	private String custMoney;
	private Date creationDate;
	
	// 국가 정보 변수로 만들어야함.
	private String cName; // 도시이름
	private String cCurrency; //도시통화
	private String cMonth; //추천 달
	private String cVisa; //비자유무
	private String cContents; //도시내용
	
	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcCurrency() {
		return cCurrency;
	}

	public void setcCurrency(String cCurrency) {
		this.cCurrency = cCurrency;
	}

	public String getcMonth() {
		return cMonth;
	}

	public void setcMonth(String cMonth) {
		this.cMonth = cMonth;
	}

	public String getcVisa() {
		return cVisa;
	}

	public void setcVisa(String cVisa) {
		this.cVisa = cVisa;
	}

	public String getcContents() {
		return cContents;
	}

	public void setcContents(String cContents) {
		this.cContents = cContents;
	}

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
