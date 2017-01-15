package ren.xiayi.netty.cbc.entity.w0106.req;

/**
 * 查看银行联号
 */

public class TX extends ren.xiayi.netty.cbc.entity.req.TX {

	private TransactionBody TX_INFO;

	public TransactionBody getTX_INFO() {
		return TX_INFO;
	}

	public void setTX_INFO(TransactionBody tX_INFO) {
		TX_INFO = tX_INFO;
	}
}
