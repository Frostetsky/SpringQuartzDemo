package demo.app.quartz.config;

import demo.app.quartz.scheduled.ScheduleTask;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.config.ScheduledTask;

/**
 * @see ScheduledTask
 */
@Configuration
public class QuartzConfiguration {

    @Bean
    public JobDetail scheduledJob() {
        return JobBuilder.newJob(ScheduleTask.class)
                .storeDurably()
                .withIdentity("anofl")
                .withDescription("anofl test")
                .build();
    }

    @Bean
    public Trigger scheduledTrigger(JobDetail jobDetail) {
        return TriggerBuilder.newTrigger()
                .withIdentity("for anofl trigger")
                .forJob(jobDetail)
                .withSchedule(CronScheduleBuilder.cronSchedule("0 * * * * ?"))
                .build();
    }
}
