package com.soojong.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

public class ProducerSync {
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
                        "Hello This is Kafka Record - " + i);
                // Producer는 Record를 전송하고 Broker로부터 응답을 기다린다. Broker에서 에러가 발생하지 않으면 metadata를 얻는다.
                RecordMetadata metadata = producer.send(record).get();
                // 출력
                System.out.printf("Topic : %s , Partition : %d , Offset : %d, Key : %s, Received Message :%s\n",
                        metadata.topic(),metadata.partition(),metadata.offset(),record.key(),record.value());

            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            producer.close();
        }

    }
}
