package com.jarvis.springbootappcache;

import com.jarvis.springbootappcache.cache.ApplicationCache;
import com.jarvis.springbootappcache.cache.CacheItem;
import com.jarvis.springbootappcache.cache.CacheManager;
import com.jarvis.springbootappcache.model.Vehicle;
import com.jarvis.springbootappcache.service.VehicleFactory;
import com.jarvis.springbootappcache.service.VehicleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class SpringBootAppCacheApplication {

	@Autowired
	private VehicleFactory vehicleFactory;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppCacheApplication.class, args);
	}

	@Scheduled(cron="*/5 * * * * *")
	public void test(){
		System.out.println("----------------Start----------------");
		Vehicle vehicle = vehicleFactory.getVehicleInstance(VehicleProvider.BUS);
		vehicle.move();
		ApplicationCache appCache = ApplicationCache.getInstance();
		appCache.put(CacheItem.NAME, vehicle.getName());
		System.out.println("Fetching vehicle from cache:"+ appCache.get(CacheItem.NAME));
		System.out.println("Clearing the cache");
		CacheManager.clearCache();
		System.out.println("Fetching vehicle from cache:"+ appCache.get(CacheItem.NAME));
		System.out.println("----------------End----------------");

	}
}
