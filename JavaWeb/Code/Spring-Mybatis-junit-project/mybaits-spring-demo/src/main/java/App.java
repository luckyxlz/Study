import com.lucky.config.SpringConfig;
import com.lucky.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService bean = ctx.getBean(AccountService.class);
        System.out.println(bean.findById(2));


    }
}
