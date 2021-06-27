package com.example.msgProducer.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;


@Configuration
@RequiredArgsConstructor
public class ArtemisConfiguration {

    public static final String SLACK_QUEUE = "slack.queue";

    public static final String DELAY_HEADER = "x-delay";
    public static final String NUM_ATTEMPT_HEADER = "x-num-attempt";
    public static final long   RETRY_BACKOFF = 5000;


}


//    public static final String ROUTE_EMAIL_QUEUE = "msg.email";
//    public static final String ROUTE_SLACK_QUEUE = "msg.slack";
//    public static final String ROUTE_SMS_QUEUE = "msg.sms";
//
//    public static final String TOPIC_EXCHANGE = "topicExchange";
//    public static final String FANOUT_EXCHANGE = "fanoutExchange";
//    public static final String DELAYED_EXCHANGE = "delayedExchange";
//
//    public static final String DELAY_QUEUE_NAME = "delayed.queue";
//
//    public static final String DELAY_HEADER = "x-delay";
//    public static final String NUM_ATTEMPT_HEADER = "x-num-attempt";
//    public static final long   RETRY_BACKOFF = 5000;
//
//
//    private final ConnectionFactory connectionFactory;
//
//    @Bean
//    public AmqpAdmin amqpAdmin() {
//        return new RabbitAdmin(this.connectionFactory);
//    }
//
//    @Bean
//    public RabbitTemplate rabbitTemplate() {
//        final RabbitTemplate template = new RabbitTemplate(this.connectionFactory);
//        template.setMessageConverter(messageConverter());
//        return template;
//    }
//
//    @Bean
//    public MessageConverter messageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
//
//    @Bean
//    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
//        final SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConnectionFactory(this.connectionFactory);
//        factory.setMessageConverter(messageConverter());
////        factory.setConcurrentConsumers(3);
////        factory.setMaxConcurrentConsumers(10);
//        return factory;
//    }
//
//
//    //Queues
//    @Bean
//    public Queue emailQueue() {
//        return new Queue(ROUTE_EMAIL_QUEUE, true);
//    }
//
//    @Bean
//    public Queue slackQueue() {
//        return new Queue(ROUTE_SLACK_QUEUE, true);
//    }
//
//    @Bean
//    public Queue smsQueue() {
//        return new Queue(ROUTE_SMS_QUEUE, true);
//    }
//
//    @Bean
//    public Queue delayedQueue() {
//        return new Queue(DELAY_QUEUE_NAME, true);
//    }
//
//
//    //Exchanges
//    @Bean
//    public TopicExchange topicExchange(){
//        return new TopicExchange(TOPIC_EXCHANGE);
//    }
//
//    @Bean
//    public FanoutExchange fanoutExchange(){
//        return new FanoutExchange(FANOUT_EXCHANGE);
//    }
//
//    @Bean
//    public DirectExchange delayedExchange() {
//        return (DirectExchange) ExchangeBuilder.directExchange(DELAYED_EXCHANGE)
//                .delayed().build();
//    }
//
//    //TopicExchange bindings
//    @Bean
//    public Binding emailTopicBinding() {
//        return BindingBuilder.bind(emailQueue()).to(topicExchange()).with(ROUTE_EMAIL_QUEUE);
//    }
//
//    @Bean
//    public Binding slackTopicBinding() {
//        return BindingBuilder.bind(slackQueue()).to(topicExchange()).with(ROUTE_SLACK_QUEUE);
//    }
//
//    @Bean
//    public Binding smsTopicBinding() {
//        return BindingBuilder.bind(smsQueue()).to(topicExchange()).with(ROUTE_SMS_QUEUE);
//    }
//
//
//    //FanoutExchange bindings
//    @Bean
//    public Binding emailFanoutBinding() {
//        return BindingBuilder.bind(emailQueue()).to(fanoutExchange());
//    }
//
//    @Bean
//    public Binding slackFanoutBinding() {
//        return BindingBuilder.bind(slackQueue()).to(fanoutExchange());
//    }
//
//    @Bean
//    public Binding smsFanoutBinding() {
//        return BindingBuilder.bind(smsQueue()).to(fanoutExchange());
//    }
//
//    //DirectExchange bindings [Delayed]
//
//    @Bean
//    public Binding delayedSlackBinding() {
//        return BindingBuilder.bind(delayedQueue()).to(delayedExchange()).with(DELAY_QUEUE_NAME);
//    }
//}
