package io.orkes.samples.workers;

        import com.netflix.conductor.client.worker.Worker;
        import com.netflix.conductor.common.metadata.tasks.Task;
        import com.netflix.conductor.common.metadata.tasks.TaskResult;
        import org.springframework.stereotype.Component;


@Component
public class RejectionEmail implements Worker {
    @Override
    public String getTaskDefName() {
        return "rejection_interview_orkes";
    }

    @Override
    public TaskResult execute(Task task) {

        TaskResult result = new TaskResult(task);
        try {
            result.setStatus(TaskResult.Status.COMPLETED);
            result.addOutputData("emailContent", "Dear Candidate, Thank you for taking the time to meet with our team. It was a pleasure to learn more about your skills and accomplishments. Unfortunately, our team did not select you for further consideration.");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
