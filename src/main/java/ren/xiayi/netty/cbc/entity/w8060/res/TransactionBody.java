package ren.xiayi.netty.cbc.entity.w8060.res;

public class TransactionBody {
	private String CREDIT_NO;//凭证号 Char(12) F
	private String DEAL_TYPE;// 处理方式 Char(1) F
	private Double FEE;//手续费// Decimal(16,2) T
	private String VALID_CODE;// 验证码 varChar(30) T
	private String CST_PAY_NO;

	public String getCST_PAY_NO() {
		return CST_PAY_NO;
	}

	public void setCST_PAY_NO(String cST_PAY_NO) {
		CST_PAY_NO = cST_PAY_NO;
	}

	public String getCREDIT_NO() {
		return CREDIT_NO;
	}

	public void setCREDIT_NO(String cREDIT_NO) {
		CREDIT_NO = cREDIT_NO;
	}

	public String getDEAL_TYPE() {
		return DEAL_TYPE;
	}

	public void setDEAL_TYPE(String dEAL_TYPE) {
		DEAL_TYPE = dEAL_TYPE;
	}

	public Double getFEE() {
		return FEE;
	}

	public void setFEE(Double fEE) {
		FEE = fEE;
	}

	public String getVALID_CODE() {
		return VALID_CODE;
	}

	public void setVALID_CODE(String vALID_CODE) {
		VALID_CODE = vALID_CODE;
	}

}
