package ren.xiayi.netty.utils;

import java.util.UUID;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

import ren.xiayi.netty.cbc.entity.w0100.req.TX;
import ren.xiayi.netty.cbc.entity.w0100.req.TransactionBody;

public class XmlUtils {

	public static String toXml(XStream xStream, Object obj) {
		String data = xStream.toXML(obj);
		StringBuffer str = new StringBuffer();
		str.append("<?xml version=\"1.0\" encoding=\"GB18030\" standalone=\"yes\" ?>").append(data);
		return str.toString();
	}

	@SuppressWarnings("rawtypes")
	public static XStream setAliasType(XStream xStream, String type, Class clazz) {
		xStream.aliasType(type, clazz);
		return xStream;
	}

	public static XStream getXStream() {
		return XStreamFactory.getXStream();
	}

	public static void main(String[] args) {
		TX tx = new TX();
		tx.setCUST_ID(UUID.randomUUID().toString());
		tx.setLANGUAGE("CN");
		tx.setPASSWORD(UUID.randomUUID().toString());
		tx.setREQUEST_SN(UUID.randomUUID().toString());
		tx.setUSER_ID(UUID.randomUUID().toString());
		tx.setTX_CODE(UUID.randomUUID().toString());
		TransactionBody body = new TransactionBody();
		body.setACC_NO(UUID.randomUUID().toString());
		tx.setTX_INFO(body);
		XStream xStream = setAliasType(getXStream(), "TX", TX.class);
		String string = toXml(xStream, tx);
		System.out.println(string);
		TX xmlStrToBean = (TX) xStream.fromXML(string);
		System.out.println(xmlStrToBean.getTX_INFO().getACC_NO());
	}

	static class XStreamFactory {
		public static XStream getXStream() {
			return new XStream(new DomDriver("GB18030", new XmlFriendlyNameCoder("-_", "_")));
		}
	}
}
