package ren.xiayi.netty.cbc.entity.w0100.req;

public class TransactionBody {
	private String ACC_NO;//帐号 varChar(32) F 查询帐号

	public String getACC_NO() {
		return ACC_NO;
	}

	public void setACC_NO(String aCC_NO) {
		ACC_NO = aCC_NO;
	}
}
