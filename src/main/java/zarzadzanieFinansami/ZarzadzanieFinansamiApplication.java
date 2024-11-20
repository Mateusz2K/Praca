package zarzadzanieFinansami;

import model.Kategoria;
import model.Konto;
import model.Transakcja;
import model.TypTransakcjiEnum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@SpringBootApplication
public class ZarzadzanieFinansamiApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(ZarzadzanieFinansamiApplication.class, args);
		new Konto()

	}public String helloWorld (){
		return "Hello World!";
	}

}
