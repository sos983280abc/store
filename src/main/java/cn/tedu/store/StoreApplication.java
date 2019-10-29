package cn.tedu.store;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Configuration
@SpringBootApplication
@MapperScan("cn.tedu.store.mapper")
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}

	
	/*//如果传输过大文件需要加这个方法但这个方法麻烦不推荐
	 @Bean
		public MultipartConfigElement getMultipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize(DataSize.ofMegabytes(100));
		factory.setMaxRequestSize(DataSize.ofMegabytes(100));
		MultipartConfigElement element = factory.createMultipartConfig();
		return element;
	}*/
}
