package com.zzus.blog.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wang wei
 * 2019/9/2 15:09
 */
@Component
@RabbitListener(queues = "notify.payment")
public class PaymentNotifyReceive {
    private final Logger logger = LoggerFactory.getLogger(getClass());


    @RabbitHandler
    public void receive(String msg) {
        logger.info("notify.payment receive message: "+msg);
    }
}
