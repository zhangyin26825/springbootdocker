package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@SpringBootApplication
@RestController
@EnableRedisHttpSession
public class Application {

	@RequestMapping("/")
	public String home(HttpServletRequest request,Integer name) {
		HttpSession session = request.getSession();
		System.out.println("传入的参数为"+name);
		String key="hello";
		Integer count = (Integer)session.getAttribute(key);
		System.out.println("当前session中的值为"+count);
		if (count == null) {
			session.setAttribute(key,1);
			return "session中没有值";
		}else {
			Integer value=count+1;
			session.setAttribute(key,value);
			System.out.println("设置session中的值为"+value);
			return  "设置session中的值为"+value;
		}

	}


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
