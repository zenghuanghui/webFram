package com.xxxx.common.bean.output;

import com.xxxx.common.util.MessageRevieveUtil;

/**
 * 回复音乐消息
 * @author Administrator
 *
 */
public class MusicOutputMessage extends BaseOutMessage {
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}

	@Override
	public String getMsgType() {
		return MessageRevieveUtil.RESP_MESSAGE_TYPE_MUSIC.toString();
	}
}
