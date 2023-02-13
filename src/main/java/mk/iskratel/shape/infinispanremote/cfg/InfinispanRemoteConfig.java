package mk.iskratel.shape.infinispanremote.cfg;

import org.infinispan.client.hotrod.configuration.ClientIntelligence;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.configuration.RemoteCacheConfiguration;
import org.infinispan.client.hotrod.configuration.RemoteCacheConfigurationBuilder;
import org.infinispan.spring.starter.remote.InfinispanRemoteCacheCustomizer;
import org.infinispan.spring.starter.remote.InfinispanRemoteConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfinispanRemoteConfig {

  @Value("${infinispan.url}")
  private String infinispanUrl;

  @Value("${infinispan.port}")
  private Integer infinispanPort;

  @Value("${infinispan.user}")
  private String infinispanUser;

  @Value("${infinispan.password}")
  private String infinispanPassword;

  @Bean
  public InfinispanRemoteConfigurer infinispanRemoteConfigurer() {
    return () -> new ConfigurationBuilder()
        .addServer().host(infinispanUrl).port(infinispanPort)
        .security().authentication().username(infinispanUser).password(infinispanPassword)
        .build();
  }

  @Bean
  public ConfigurationBuilder addServers() {
    return new ConfigurationBuilder()
        .addServers(String.format(infinispanUrl, infinispanPort))
        .clientIntelligence(ClientIntelligence.BASIC);
  }

//  @Bean
//  public RemoteCacheConfiguration addCache() {
//    return new ConfigurationBuilder()
//        .remoteCache("another-cache")
//        .configuration("<distributed-cache name=\"another-cache\"/>")
//        .create();
//  }

  @Bean
  public InfinispanRemoteCacheCustomizer customizer() {
    return c -> c.tcpKeepAlive(false);
  }

}
