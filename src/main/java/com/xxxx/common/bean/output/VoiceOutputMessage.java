package com.xxxx.common.bean.output;

import com.xxxx.common.util.MessageRevieveUtil;

/**
 * 语音回复消息
 * @author Administrator
 *
 */
public class VoiceOutputMessage extends BaseOutMessage{
    private Voice voice;
    
	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	@Override
	public String getMsgType() {
		return MessageRevieveUtil.RESP_MESSAGE_TYPE_VOICE.toString();
	}
}
