package com.qcz.demo.moudle.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.qcz.demo.common.Constant;

/**
 * 
 * @author changzhongq
 * @time 2019年2月23日 下午8:39:11
 */
@Component
public class DemoService {

	private static final Logger Logger = LoggerFactory.getLogger(DemoService.class);

	@RabbitListener(queues = Constant.QUEUE_NAME)
	public void doSomething(byte[] b) {
		Logger.info(new String(b));
	}

}
