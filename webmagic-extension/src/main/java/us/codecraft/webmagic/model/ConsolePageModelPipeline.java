package us.codecraft.webmagic.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import us.codecraft.webmagic.Task;

/**
 * @author code4crafter@gmail.com <br>
 * Date: 13-8-3 <br>
 * Time: 下午3:41 <br>
 */
public class ConsolePageModelPipeline implements PageModelPipeline {
    @Override
    public void process(Object o, Task task) {
        System.out.println(ToStringBuilder.reflectionToString(o));
    }
}
