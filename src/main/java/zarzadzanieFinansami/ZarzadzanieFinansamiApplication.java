package zarzadzanieFinansami;

import model.Konto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZarzadzanieFinansamiApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(ZarzadzanieFinansamiApplication.class, args);
		new Konto()

	}public String helloWorld (){
		return "Hello World!";
	}

}
