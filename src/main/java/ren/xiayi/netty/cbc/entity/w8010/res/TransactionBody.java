package ren.xiayi.netty.cbc.entity.w8010.res;

public class TransactionBody {
	private String CREDIT_NO;//凭证号 Char(12) F
	private String DEAL_TYPE;// 处理方式 Char(1) F
	private String VALIDATE_CODE;// 验证码 varChar(30) T 新加，交易成功时返回
	private String INDIVIDUAL1;//自定义输出内容1 varChar(99) T
	private String INDIVIDUAL_NAME1;// 自定义输出名称2 varChar(99) T 分行自定义输出名称2

	public String getINDIVIDUAL_NAME1() {
		return INDIVIDUAL_NAME1;
	}

	public void setINDIVIDUAL_NAME1(String iNDIVIDUAL_NAME1) {
		INDIVIDUAL_NAME1 = iNDIVIDUAL_NAME1;
	}

	private String INDIVIDUAL_NAME2;// 自定义输出名称2 varChar(99) T 分行自定义输出名称2
	private String INDIVIDUAL2;//自定义输出内容2 varChar(99) T
	private String REM1;// 备注1 varChar(32) T
	private String REM2;//备注2 varChar(32) T
	private String CST_PAY_NO;

	public String getCST_PAY_NO() {
		return CST_PAY_NO;
	}

	public void setCST_PAY_NO(String cST_PAY_NO) {
		CST_PAY_NO = cST_PAY_NO;
	}

	public String getVALIDATE_CODE() {
		return VALIDATE_CODE;
	}

	public void setVALIDATE_CODE(String vALIDATE_CODE) {
		VALIDATE_CODE = vALIDATE_CODE;
	}

	public String getINDIVIDUAL1() {
		return INDIVIDUAL1;
	}

	public void setINDIVIDUAL1(String iNDIVIDUAL1) {
		INDIVIDUAL1 = iNDIVIDUAL1;
	}

	public String getINDIVIDUAL_NAME2() {
		return INDIVIDUAL_NAME2;
	}

	public void setINDIVIDUAL_NAME2(String iNDIVIDUAL_NAME2) {
		INDIVIDUAL_NAME2 = iNDIVIDUAL_NAME2;
	}

	public String getINDIVIDUAL2() {
		return INDIVIDUAL2;
	}

	public void setINDIVIDUAL2(String iNDIVIDUAL2) {
		INDIVIDUAL2 = iNDIVIDUAL2;
	}

	public String getREM1() {
		return REM1;
	}

	public void setREM1(String rEM1) {
		REM1 = rEM1;
	}

	public String getREM2() {
		return REM2;
	}

	public void setREM2(String rEM2) {
		REM2 = rEM2;
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

}
