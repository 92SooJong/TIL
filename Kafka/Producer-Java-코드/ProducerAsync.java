package com.soojong.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

public class ProducerAsync {
    public static void main(String[] args) {

        Properties props = new Properties();
        // Broker 정보를 정의한다.
        props.put("bootstrap.servers","peter-kafka01.foo.bar:9092,peter-kafka02.foo.bar:9092,peter-kafka02.foo.bar:9092");
        // Record의 key와 value는 문자이기 때문에 전송시 byte로 변환해야한다.
        // 각각 serializer로 kafka에서 제공하는 StringSerializer를 사용하도록 한다.
        props.put("key.serializer" , "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer" , "org.apache.kafka.common.serialization.StringSerializer");

        // 위의 설정값을 가지는 Producer를 생성한다.
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        try {
            for(int i=0; i<3; i++){
                // Producer가 보낼 Record를 생성한다.
                ProducerRecord<String, String> record = new ProducerRecord<>("peter-basic01",
                        "Hello This is Async Kafka Record - " + i);
                // Producer는 Record를 전송하고 결과값을 콜백 인스턴스가 처리하도록 한다. (비동기방식)
                producer.send(record, new PeterProducerCallback(record));

            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            producer.close();
        }

    }
}
