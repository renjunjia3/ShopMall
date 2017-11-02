package wiki.qd.newshop.event;

/**
 * 切换tab的event
 */
public class TabSelectedEvent {
    public int position;

    public TabSelectedEvent(int position) {
        this.position = position;
    }
}