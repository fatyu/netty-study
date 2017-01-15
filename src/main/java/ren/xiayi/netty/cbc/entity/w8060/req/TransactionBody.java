package ren.xiayi.netty.cbc.entity.w8060.req;

public class TransactionBody {
	private String TRAN_TYPE;//交易类型 Char(1) F 0-建行转他行,预留标志位，以后可扩展
	private String PAY_ACCNO;// 转出账号 varChar(32) F
	private String RECV_ACCNO;// 转入账号 varChar(32) F
	private String RECV_ACC_NAME;// 转入账户名称 varChar(60) F
	private String RECV_UBANKNO;// 转入账户联行号 varChar(12) T TRAN_TYPE=0时，必须输入
	private String RECV_OPENACC_DEPT;// 转入账户开户机构名称 varChar(60) T TRAN_TYPE=0时，必须输入
	private Double AMOUNT;// 金额 Decimal(16,2) F
	private String CUR_TYPE;// 币种 Char(2) F
	private String USEOF;// 用途 Char(38) F
	private String SIGN_INFO;// 签名信息 varChar(254) T
	private String SIGNCERT;// 签名CA信息 varChar(254) T 客户采用socket连接时，

	public String getTRAN_TYPE() {
		return TRAN_TYPE;
	}

	public void setTRAN_TYPE(String tRAN_TYPE) {
		TRAN_TYPE = tRAN_TYPE;
	}

	public String getPAY_ACCNO() {
		return PAY_ACCNO;
	}

	public void setPAY_ACCNO(String pAY_ACCNO) {
		PAY_ACCNO = pAY_ACCNO;
	}

	public String getRECV_ACCNO() {
		return RECV_ACCNO;
	}

	public void setRECV_ACCNO(String rECV_ACCNO) {
		RECV_ACCNO = rECV_ACCNO;
	}

	public String getRECV_ACC_NAME() {
		return RECV_ACC_NAME;
	}

	public void setRECV_ACC_NAME(String rECV_ACC_NAME) {
		RECV_ACC_NAME = rECV_ACC_NAME;
	}

	public String getRECV_UBANKNO() {
		return RECV_UBANKNO;
	}

	public void setRECV_UBANKNO(String rECV_UBANKNO) {
		RECV_UBANKNO = rECV_UBANKNO;
	}

	public String getRECV_OPENACC_DEPT() {
		return RECV_OPENACC_DEPT;
	}

	public void setRECV_OPENACC_DEPT(String rECV_OPENACC_DEPT) {
		RECV_OPENACC_DEPT = rECV_OPENACC_DEPT;
	}

	public Double getAMOUNT() {
		return AMOUNT;
	}

	public void setAMOUNT(Double aMOUNT) {
		AMOUNT = aMOUNT;
	}

	public String getCUR_TYPE() {
		return CUR_TYPE;
	}

	public void setCUR_TYPE(String cUR_TYPE) {
		CUR_TYPE = cUR_TYPE;
	}

	public String getUSEOF() {
		return USEOF;
	}

	public void setUSEOF(String uSEOF) {
		USEOF = uSEOF;
	}

	public String getSIGN_INFO() {
		return SIGN_INFO;
	}

	public void setSIGN_INFO(String sIGN_INFO) {
		SIGN_INFO = sIGN_INFO;
	}

	public String getSIGNCERT() {
		return SIGNCERT;
	}

	public void setSIGNCERT(String sIGNCERT) {
		SIGNCERT = sIGNCERT;
	}

}
