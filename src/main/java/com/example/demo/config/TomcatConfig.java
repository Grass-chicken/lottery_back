package com.example.demo.config;

import com.example.demo.util.tools.IocUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * 端口映射
 * 使可以继续使用 http 访问
 *
 * @Author:王景阳
 * @DateTime:2022/7/14 18:06
 */
@Configuration
public class TomcatConfig {

    @Bean
    public IocUtil iocUtil() {
        return IocUtil.getInstance();
    }
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> builder
                .serializerByType(LocalDateTime.class, localDateTimeJsonSerializer())
                .deserializerByType(LocalDateTime.class, localDateTimeJsonDeserializer());
    }

    /**
     * NOTICE: 注意使用 秒级 时间戳
     */
    private JsonSerializer<LocalDateTime> localDateTimeJsonSerializer() {
        return new JsonSerializer<LocalDateTime>() {
            @Override
            public void serialize(LocalDateTime dateTime, JsonGenerator generator, SerializerProvider provider) throws IOException {
                if (dateTime != null) {
                    long epochSecond = dateTime.toEpochSecond(ZoneOffset.ofHours(8));
                    generator.writeNumber(epochSecond);
                }
            }
        };
    }

    /**
     * NOTICE: 注意使用 秒级 时间戳
     */
    private JsonDeserializer<LocalDateTime> localDateTimeJsonDeserializer() {
        return new JsonDeserializer<LocalDateTime>() {
            @Override
            public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
                long epochSecond = parser.getValueAsLong();
                return LocalDateTime.ofEpochSecond(epochSecond, 0, ZoneOffset.ofHours(8));
            }
        };
    }
}
