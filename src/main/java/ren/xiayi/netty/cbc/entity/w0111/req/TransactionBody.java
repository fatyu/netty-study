package ren.xiayi.netty.cbc.entity.w0111.req;

public class TransactionBody {
	private String SOURCE;// 要下载的文件名称 varChar(128) F 要下载的文件名，如：CBB1172476199728
	private String FILEPATH = "B2B.customer.bill";//文件路径 varChar(1) F 一般输入：B2B.customer.bill
	private String LOCAL_REMOTE = "0"; //;下载路径标志 varChar(1) F 在网银文件服务器下载为0，在网银后端系统下载为1，一般0

	public String getSOURCE() {
		return SOURCE;
	}

	public void setSOURCE(String sOURCE) {
		SOURCE = sOURCE;
	}

	public String getFILEPATH() {
		return FILEPATH;
	}

	public void setFILEPATH(String fILEPATH) {
		FILEPATH = fILEPATH;
	}

	public String getLOCAL_REMOTE() {
		return LOCAL_REMOTE;
	}

	public void setLOCAL_REMOTE(String lOCAL_REMOTE) {
		LOCAL_REMOTE = lOCAL_REMOTE;
	}

}
