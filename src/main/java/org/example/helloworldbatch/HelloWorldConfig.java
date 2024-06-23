package org.example.helloworldbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
public class HelloWorldConfig {
    @Bean
    public Job sayHelloWorldJob(JobRepository jobRepository, Step sayHelloWorldStep) {
        return new JobBuilder("sayHelloWorldJob", jobRepository)
                .start(sayHelloWorldStep)
                .build();
    }

    @Bean
    public Step sayHelloWorldStep(JobRepository jobRepository, DataSourceTransactionManager transactionManager) {
        return new StepBuilder("sayHelloWorldStep", jobRepository)
                .tasklet(
                        (contribution, chunkContext) -> {
                            System.out.println("Hello, World!");
                            return RepeatStatus.FINISHED;
                        },
                        transactionManager
                )
                .tasklet(new HelloWorldTasklet(), transactionManager)
                .build();
    }
}
