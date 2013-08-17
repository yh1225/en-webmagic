package us.codecraft.webmagic.model;

import us.codecraft.webmagic.Task;

/**
 * @author code4crafter@gmail.com <br>
 * Date: 13-8-3 <br>
 * Time: 上午9:34 <br>
 */
public interface PageModelPipeline<T> {

    public void process(T obj, Task task);

}
