package com.soojong.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;
import java.time.Duration;

public class ConsumerAuto {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers","peter-kafka01.foo.bar:9092,peter-kafka02.foo.bar:9092,peter-kafka02.foo.bar:9092");
        props.put("group.id", "peter-consumer01"); // 컨슈머 그룹
        props.put("enable.auto.commit","true"); // offset을 자동으로 commit하도록 함.
        props.put("auto.offset.reset","latest"); // offset이 없는경우는 가장 마지막의 오프셋값으로 설정
        props.put("key.deserializer" , "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer" , "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("peter-basic01")); // Consumer가 구독할 Topic을 지정한다.

        try {
            while(true){
                // poll(long)은 2.0버전이후 Deprecated, Duration을 사용해야한다.
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("Topic : %s , Partition : %d , Offset : %d, Key : %s, Value :%s\n",
                            record.topic(),record.partition(),record.offset(),record.key(),record.value());
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }finally {
            consumer.close();
        }

    }
}