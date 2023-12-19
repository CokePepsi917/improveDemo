package com.cokepepsi.streamsource.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author CokePepsi
 * @date 2023/11/9 17:12
 */
public interface StreamSource {
    String STREAM_OUTPUT = "streamOutput";

    @Output(StreamSource.STREAM_OUTPUT)
    MessageChannel getMessageChannel();
}
