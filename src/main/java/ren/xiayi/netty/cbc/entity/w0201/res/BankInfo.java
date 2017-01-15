package ren.xiayi.netty.cbc.entity.w0201.res;

public class BankInfo {

	private String BANK_CODE;// 银行联行号 Char(12) F
	private String BANK_NAME;// 银行名称 varchar(60) F

	public String getBANK_CODE() {
		return BANK_CODE;
	}

	public void setBANK_CODE(String bANK_CODE) {
		BANK_CODE = bANK_CODE;
	}

	public String getBANK_NAME() {
		return BANK_NAME;
	}

	public void setBANK_NAME(String bANK_NAME) {
		BANK_NAME = bANK_NAME;
	}

}
