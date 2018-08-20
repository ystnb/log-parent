package yt.cn.log.common.utils;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration  
@EnableCaching//开启注解
public class RedisUtilConfig {
	 @Bean
	    public CacheManager cacheManager(RedisTemplate<?,?> redisTemplate) {
	       CacheManager cacheManager = new RedisCacheManager(redisTemplate);
	       return cacheManager;
	    }

	 @Bean
	 public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
	     RedisTemplate redisTemplate = new StringRedisTemplate(factory);
	     StringRedisSerializer stringRedisSerializer =new StringRedisSerializer();
	     redisTemplate.setValueSerializer(stringRedisSerializer);
	     redisTemplate.setKeySerializer(stringRedisSerializer);
	     redisTemplate.setHashKeySerializer(stringRedisSerializer);
	     redisTemplate.setHashValueSerializer(stringRedisSerializer);
	     redisTemplate.afterPropertiesSet();
	     return redisTemplate;
	 }
	 /*   @Bean
		public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
			RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
			redisTemplate.setConnectionFactory(redisConnectionFactory);
	 
			// 使用Jackson2JsonRedisSerialize 替换默认序列化
			Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
	 
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.setVisibility(PropertyAccessor.ALL, Visibility.ANY);
			objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
	 
			jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
	 
			// 设置value的序列化规则和 key的序列化规则
			redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
			redisTemplate.setKeySerializer(new StringRedisSerializer());
	 
			redisTemplate.setHashKeySerializer(jackson2JsonRedisSerializer);
			redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
	 
			redisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);
			redisTemplate.setEnableDefaultSerializer(true);
			redisTemplate.afterPropertiesSet();
			return redisTemplate;
		}*/

}
