package com.xxxx.common.bean.output;

import com.xxxx.common.util.MessageRevieveUtil;

/**
 * 图片输出内容
 * @author Administrator
 *
 */
public class ImageOutputMessage extends BaseOutMessage{
	private Image Image;
	public Image getImage() {
		return Image;
	}
	public void setImage(Image image) {
		Image = image;
	}
	@Override
	public String getMsgType() {
		return MessageRevieveUtil.RESP_MESSAGE_TYPE_IMAGE.toString();
	}
}
