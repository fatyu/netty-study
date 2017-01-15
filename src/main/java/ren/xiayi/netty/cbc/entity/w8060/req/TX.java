package ren.xiayi.netty.cbc.entity.w8060.req;

/**
 * 跨行转账
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
