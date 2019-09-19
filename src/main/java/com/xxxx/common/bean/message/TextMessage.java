package com.xxxx.common.bean.message;


import com.xxxx.common.util.MessageRevieveUtil;

/**
 * 文本消息
 * @author Administrator
 *
 */
public class TextMessage extends BaseMessage {
	//文本消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	@Override
	public String getMsgType() {
		return MessageRevieveUtil.TEXT_MESSAGE.toString();
	}

}
