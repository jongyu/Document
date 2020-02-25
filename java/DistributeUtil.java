import java.util.ArrayList;
import java.util.List;

public class DistributeUtil {

    /**
     * 站点分发
     *
     * @param sites 站点
     * @param count 需要分发的数量
     * @return 分发完成的数据
     */
    @SuppressWarnings("unchecked")
    public static List[] distribution(List<String> sites, int count) {
        int minTaskCount = sites.size() / count;
        int remainTaskCount = sites.size() % count;
        int actualThreadCount = minTaskCount > 0 ? count : remainTaskCount;
        List[] taskListPerThread = new List[actualThreadCount];
        int taskIndex = 0;
        int remainIndex = remainTaskCount;
        for (int i = 0; i < taskListPerThread.length; i++) {
            taskListPerThread[i] = new ArrayList();
            if (minTaskCount > 0) {
                for (int j = taskIndex; j < minTaskCount + taskIndex; j++) {
                    taskListPerThread[i].add(sites.get(j));
                }
                taskIndex += minTaskCount;
            }
            if (remainIndex > 0) {
                taskListPerThread[i].add(sites.get(taskIndex++));
                remainIndex--;
            }
        }
        return taskListPerThread;
    }

}
