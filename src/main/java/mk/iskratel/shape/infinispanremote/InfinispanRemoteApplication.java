package mk.iskratel.shape.infinispanremote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class InfinispanRemoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfinispanRemoteApplication.class, args);
	}

}
