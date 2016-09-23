### Application.class

### 1、 @EnableScheduling
此注释可选，表明允许定时作业，详情参考
```
/**
 * The Scheduled annotation defines when a particular method runs. NOTE:
 * This example uses fixedRate, which specifies the interval between method
 * invocations measured from the start time of each invocation. There are
 * other options, like fixedDelay, which specifies the interval between
 * invocations measured from the completion of the task.
 * 
 * @Scheduled(initialDelay=1000, fixedRate=5000) :For fixed-delay and
 *                               fixed-rate tasks, an initial delay may be
 *                               specified indicating the
 *                               number of milliseconds to wait before the
 *                               first execution of the method.
 */
 
@Component
public class ScheduledTasks {
    private static final Logger           LOGGER     = LoggerFactory
            .getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
            "HH:mm:ss");
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        // 每隔 5 秒在控制台打印当前时间
        LOGGER.info("The time is now {}", dateFormat.format(new Date()));
    }

}
```
### 2、端口配置
如果默认使用 8080 端口可以写成如下形式
```
@SpringBootApplication
@EnableScheduling
public class Application{
	 public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
 }
```
示例中是将端口改成 8081，并且是不是用配置文件的形式，注意，此时不能在环境路径下包含任何名为 application 的文件，如 application。properties,application.xml 等，否则将默
认去读取配置文件
```
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableScheduling
public class Application extends SpringBootServletInitializer
        implements EmbeddedServletContainerCustomizer {
    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8081);
    }
}
```