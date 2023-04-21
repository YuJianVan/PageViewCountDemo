package com.fyj.quartzdemo.task;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.ee.jmx.jboss.QuartzService;

@Slf4j
public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        QuartzService quartzService = (QuartzService) SpringUtil.getBean("quartzServiceImpl");
        PageInfo<JobAndTriggerDto> jobAndTriggerDetails = quartzService.getJobAndTriggerDetails(1, 10);
        log.info("任务列表总数为：" + jobAndTriggerDetails.getTotal());
        log.info("Hello Job执行时间: " + DateUtil.now());
    }
}

