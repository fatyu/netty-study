package ren.xiayi.netty.cbc.entity.w0100.res;

public class TransactionBody {
	private String ACC_NO;//帐号		varChar(32) F 同请求报文中的帐号
	private String BALANCE;// 余额 Decimal(16,2) T
	private String BALANCE1;// 可用余额 Decimal(16,2) T
	private String INTEREST;// 帐户利息 Decimal(16,2) T
	private String INTEREST_RATE;// 帐户利率 Decimal(6,4) T
	private String ACC_STATUS;// 帐户状态 Char(20) F
	private String RESV_NAME1;// 自定义名称1 varChar(99) T 分行自定义输出名称1
	private String RESV1;// 自定义内容1 varChar(99) T 分行自定义输出内容1
	private String RESV_NAME2;// 自定义名称2 varChar(99) T 分行自定义输出名称2
	private String RESV2;// 自定义内容2 varChar(99) T 分行自定义输出内容2
	private String REM1;//备注1 varChar(32) T
	private String REM2;//备注2 varChar(32) T

	public String getACC_NO() {
		return ACC_NO;
	}

	public void setACC_NO(String aCC_NO) {
		ACC_NO = aCC_NO;
	}

	public String getBALANCE() {
		return BALANCE;
	}

	public void setBALANCE(String bALANCE) {
		BALANCE = bALANCE;
	}

	public String getBALANCE1() {
		return BALANCE1;
	}

	public void setBALANCE1(String bALANCE1) {
		BALANCE1 = bALANCE1;
	}

	public String getINTEREST() {
		return INTEREST;
	}

	public void setINTEREST(String iNTEREST) {
		INTEREST = iNTEREST;
	}

	public String getINTEREST_RATE() {
		return INTEREST_RATE;
	}

	public void setINTEREST_RATE(String iNTEREST_RATE) {
		INTEREST_RATE = iNTEREST_RATE;
	}

	public String getACC_STATUS() {
		return ACC_STATUS;
	}

	public void setACC_STATUS(String aCC_STATUS) {
		ACC_STATUS = aCC_STATUS;
	}

	public String getRESV_NAME1() {
		return RESV_NAME1;
	}

	public void setRESV_NAME1(String rESV_NAME1) {
		RESV_NAME1 = rESV_NAME1;
	}

	public String getRESV1() {
		return RESV1;
	}

	public void setRESV1(String rESV1) {
		RESV1 = rESV1;
	}

	public String getRESV_NAME2() {
		return RESV_NAME2;
	}

	public void setRESV_NAME2(String rESV_NAME2) {
		RESV_NAME2 = rESV_NAME2;
	}

	public String getRESV2() {
		return RESV2;
	}

	public void setRESV2(String rESV2) {
		RESV2 = rESV2;
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

}
