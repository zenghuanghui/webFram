package com.xxxx.common.bean.output;

import com.xxxx.common.util.MessageRevieveUtil;

/**
 * 回复视频消息
 * 
 * @author Administrator
 *
 */
public class VideoOutPutMessage extends BaseOutMessage {
	private Video Video;

	public Video getVideo() {
		return Video;
	}

	public void setVideo(Video video) {
		Video = video;
	}

	@Override
	public String getMsgType() {
		return MessageRevieveUtil.RESP_MESSAGE_TYPE_VIDEO.toString();
	}
}
