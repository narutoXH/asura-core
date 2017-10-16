package org.asura.core.util;

import org.asura.core.util.cache.MemCache;
import org.asura.core.util.cache.MemHost;
import org.asura.core.util.cache.RedisCache;
import org.asura.core.util.cache.SimpleCache;
import org.asura.core.util.cache.SoftCache;
import org.asura.core.util.redis.RedisHandler;

public class CacheUtil {

	public static <K, V> SimpleCache<K, V> getSimpleCache(int capacity) {
		return new SimpleCache<K, V>(capacity);
	}

	public static <K, V> SoftCache<K, V> getSoftCache() {
		return new SoftCache<K, V>();
	}

	public static <K, V> MemCache<String, V> getMemCache(MemHost... hosts) {
		return new MemCache<String, V>(hosts);
	}

	public static RedisCache getRedisCache(RedisHandler handler, String cacheKey) {
		return new RedisCache(handler, cacheKey);
	}
}
