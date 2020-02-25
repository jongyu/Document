# Mongo配置

## 去除_class
```java
@Configuration
public class MongoConfig {

    @Bean
    public MappingMongoConverter converter(MongoDbFactory dbFactory, MongoMappingContext context, BeanFactory beanFactory) {
        DefaultDbRefResolver dbRefResolver = new DefaultDbRefResolver(dbFactory);
        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, context);
        converter.setCustomConversions(beanFactory.getBean(CustomConversions.class));
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return converter;
    }

}
```
