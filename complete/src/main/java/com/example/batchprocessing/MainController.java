package com.example.batchprocessing;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    @Qualifier("importUserJob")
    Job job;

    @GetMapping("/greeting")
    public String greeting() {
        return "Hello";
    }

    @GetMapping("/run")
    public void runJob() throws Exception {
        System.out.println("Job from controller started");
        JobParameters jobParameters =
                new JobParametersBuilder()
                        .addLong("time",System.currentTimeMillis()).toJobParameters();
        jobLauncher.run(job, jobParameters);

    }


}
