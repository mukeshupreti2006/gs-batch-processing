package com.example.batchprocessing;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class cleanTasklet  implements Tasklet {

   @Autowired
   public DataSource dataSource;


    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

       new JdbcTemplate(dataSource).execute("DELETE  FROM PEOPLE ;");
        return RepeatStatus.FINISHED;
    }
}
