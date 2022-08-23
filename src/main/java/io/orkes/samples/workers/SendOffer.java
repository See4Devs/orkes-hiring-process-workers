package io.orkes.samples.workers;

import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import org.springframework.stereotype.Component;


@Component
public class SendOffer implements Worker {
    @Override
    public String getTaskDefName() {
        return "send_offer_interview_orkes";
    }

    @Override
    public TaskResult execute(Task task) {

        TaskResult result = new TaskResult(task);
        try {
            result.setStatus(TaskResult.Status.COMPLETED);
            result.addOutputData("emailOfferContent", "Dear Candidate, We were all very excited to meet and get to know you over the past few days. We have been impressed with your background and would like to formally offer you the Job. This is a full time position, You will be reporting to the head of Engineering. We would like to have your response by next week, In the meantime, please feel free to contact me via email or phone, should you have any questions.We are all looking forward to having you on our team.");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
