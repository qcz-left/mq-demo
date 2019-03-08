package com.qcz.demo;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qcz.demo.common.Constant;

/**
 * RabbitMq配置
 * @author changzhongq
 * @time 2019年2月20日 下午4:35:40
 */
@Configuration
public class RabbitMqConfigurer {

	@Autowired
	private ConnectionFactory connectionFactory;

	@Bean
	public Queue demoQueue() {
		return new Queue(Constant.QUEUE_NAME, true);
	}

	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(Constant.EXCHANGE_NAME);
	}

	@Bean
	public Binding binding() {
		return BindingBuilder.bind(demoQueue()).to(topicExchange()).with("demo-routing-key");
	}

	/**
	 * 消息发送接收 模板
	 * @return
	 */
	@Bean
	public RabbitTemplate rabbitTemplate() {
		return new RabbitTemplate(connectionFactory);
	}
}
