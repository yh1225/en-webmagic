package us.codecraft.webmagic.model;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 基于Pipeline的扩展点，用于实现注解格式的Pipeline。<br>
 * 与PageModelPipeline是一对多的关系(原谅作者没有更好的名字了)。<br>
 * @author code4crafter@gmail.com <br>
 * Date: 13-8-2 <br>
 * Time: 上午10:47 <br>
 */
class ModelPipeline implements Pipeline {

    private Map<Class, PageModelPipeline> pageModelPipelines = new ConcurrentHashMap<Class, PageModelPipeline>();

    public ModelPipeline() {
    }

    public ModelPipeline put(Class clazz, PageModelPipeline pageModelPipeline) {
        pageModelPipelines.put(clazz, pageModelPipeline);
        return this;
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        for (Map.Entry<Class, PageModelPipeline> classPageModelPipelineEntry : pageModelPipelines.entrySet()) {
            Object o = resultItems.get(classPageModelPipelineEntry.getKey().getCanonicalName());
            if (o != null) {
                Annotation annotation = classPageModelPipelineEntry.getKey().getAnnotation(ExtractBy.class);
                if (annotation == null || !((ExtractBy) annotation).multi()) {
                    classPageModelPipelineEntry.getValue().process(o, task);
                } else {
                    List<Object> list = (List<Object>) o;
                    for (Object o1 : list) {
                        classPageModelPipelineEntry.getValue().process(o1, task);
                    }
                }
            }
        }
    }

	public Map<Class, PageModelPipeline> getPageModelPipelines() {
		return pageModelPipelines;
	}
}
