package mk.iskratel.shape.infinispanremote.service.impl;

import mk.iskratel.shape.infinispanremote.service.IRemoteCacheService;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RemoteCacheServiceImpl implements IRemoteCacheService {

  @Value("${cache.name}")
  private String cacheName;

  private RemoteCacheManager remoteCacheManager;

  public RemoteCacheServiceImpl(RemoteCacheManager remoteCacheManager) {
    this.remoteCacheManager = remoteCacheManager;
  }

  @Override
  @Cacheable(value = "test-darko", key = "#id", unless = "#result==null")
  public String getName(String id) {
    return remoteCacheManager.getCache(cacheName).get(id).toString();
  }

  @Override
  @CachePut(value = "test-darko", key = "#id", condition="#id != null")
  public void createName(String name) {
    String id = UUID.randomUUID().toString();
    RemoteCache<String, String> cache = remoteCacheManager.getCache(cacheName);
    cache.put(id, name);
  }

}
