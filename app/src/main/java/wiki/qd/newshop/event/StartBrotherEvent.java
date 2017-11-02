package wiki.qd.newshop.event;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * 跳转界面的evevnt
 * Created by scene
 */
public class StartBrotherEvent {
    public SupportFragment targetFragment;

    public StartBrotherEvent(SupportFragment targetFragment) {
        this.targetFragment = targetFragment;
    }
}