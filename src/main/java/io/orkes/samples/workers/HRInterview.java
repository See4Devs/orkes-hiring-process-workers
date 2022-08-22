package io.orkes.samples.workers;
import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import org.springframework.stereotype.Component;

@Component
public class HRInterview implements Worker {
    @Override
    public String getTaskDefName() {
        return "hr_interview_orkes";
    }

    @Override
    public TaskResult execute(Task task) {

        TaskResult result = new TaskResult(task);
        String name = (String) task.getInputData().get("name");
        String street = (String) task.getInputData().get("firstname");
        String city = (String) task.getInputData().get("age");
        String state = (String) task.getInputData().get("position");

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
