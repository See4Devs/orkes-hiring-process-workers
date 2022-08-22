package io.orkes.samples.workers;

import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import org.springframework.stereotype.Component;


@Component
public class TechInterview implements Worker {
    @Override
    public String getTaskDefName() {
        return "technical_interview_orkes";
    }

    @Override
    public TaskResult execute(Task task) {

        TaskResult result = new TaskResult(task);
        try {
            boolean selected = Math.random() < 0.3;
            result.setStatus(TaskResult.Status.COMPLETED);
            result.addOutputData("selected", selected);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
