package in.pabreja.exercise.industrybuying.dataloaderbatch.listener;

import in.pabreja.exercise.industrybuying.dataloaderbatch.model.OutputFormatData;
import in.pabreja.exercise.industrybuying.dataloaderbatch.stereotype.IndustryBuyingComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@IndustryBuyingComponent
public class IbMessageListener implements JobExecutionListener {

    private static final Logger log = LoggerFactory.getLogger(IbMessageListener.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public IbMessageListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void beforeJob(JobExecution jobExecution) {

    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results");

            jdbcTemplate.query("SELECT m_id, m_phone FROM messagedata",
                    (rs, row) -> new OutputFormatData(
                            rs.getString(1),
                            rs.getString(2))
            ).forEach(ofd -> log.info("Found <" + ofd.getMsgId() + " , " + ofd.getPhone() + "> in the database."));
        }
    }
}
