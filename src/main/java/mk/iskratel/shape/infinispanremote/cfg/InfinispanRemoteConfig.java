package mk.iskratel.shape.infinispanremote.cfg;

import org.infinispan.client.hotrod.configuration.ClientIntelligence;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.configuration.RemoteCacheConfiguration;
import org.infinispan.client.hotrod.configuration.RemoteCacheConfigurationBuilder;
import org.infinispan.spring.starter.remote.InfinispanRemoteCacheCustomizer;
import org.infinispan.spring.starter.remote.InfinispanRemoteConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfinispanRemoteConfig {

  @Bean
  public InfinispanRemoteConfigurer infinispanRemoteConfigurer() {
    return () -> new ConfigurationBuilder()
        .addServer().host("localhost").port(11222)
        .addServer().host("localhost").port(11223)
        .security().authentication().username("admin").password("admin")
        .build();
  }

  @Bean
  public ConfigurationBuilder addServers() {
    return new ConfigurationBuilder()
        .addServers("localhost:11222; localhost:11223")
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
    return b -> b.tcpKeepAlive(false);
  }

}
