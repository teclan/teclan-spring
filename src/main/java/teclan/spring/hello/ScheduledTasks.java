package teclan.spring.hello;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
