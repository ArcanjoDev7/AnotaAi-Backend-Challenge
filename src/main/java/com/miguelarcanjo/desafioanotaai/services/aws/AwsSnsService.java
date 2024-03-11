package com.miguelarcanjo.desafioanotaai.services.aws;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.Topic;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AwsSnsService {
    AmazonSNS snsCLient;
    Topic catalogTopic;

    public AwsSnsService(AmazonSNS snsCLient, @Qualifier("catalogEventsTopic") Topic catalogTopic){
        this.snsCLient = snsCLient;
    }
    public void publish(MessageDTO message){
        this.snsCLient.publish(catalogTopic.getTopicArn(), message.toString());
    }
}
