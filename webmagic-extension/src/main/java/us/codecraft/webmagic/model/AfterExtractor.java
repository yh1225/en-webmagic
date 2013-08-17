package us.codecraft.webmagic.model;

import us.codecraft.webmagic.Page;

/**
 * 实现这个接口即可在抽取后进行后处理。<br>
 *
 * @author code4crafter@gmail.com <br>
 * Date: 13-8-3 <br>
 * Time: 上午9:42 <br>
 */
public interface AfterExtractor {

    public void afterProcess(Page page);
}
