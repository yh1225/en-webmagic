package us.codecraft.webmagic.model;

import us.codecraft.webmagic.selector.Selector;

/**
 * @author code4crafter@gmail.com <br>
 * Date: 13-8-1 <br>
 * Time: 下午9:48 <br>
 */
class Extractor {

    protected Selector selector;

    protected final Source source;

    protected final boolean notNull;

    protected final boolean multi;

    static enum Source {Html, Url, RawHtml}

    public Extractor(Selector selector, Source source, boolean notNull, boolean multi) {
        this.selector = selector;
        this.source = source;
        this.notNull = notNull;
        this.multi = multi;
    }

    Selector getSelector() {
        return selector;
    }

    Source getSource() {
        return source;
    }

    boolean isNotNull() {
        return notNull;
    }

    boolean isMulti() {
        return multi;
    }

    void setSelector(Selector selector) {
        this.selector = selector;
    }
}
