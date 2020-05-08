package article;

/**
 * description:
 * date: 2020-05-04 10:50:30
 * @author: 飞拳
 */
public abstract class Packet {
    private Byte version = 0x000_000_01;

    /**
     * description: 指令
     * date: 2020-05-04 10:58:51
     * @author: 飞拳
     * @param
     * @return: java.lang.Byte
    */
    public abstract Byte getCommand();

    public Byte getVersion() {
        return version;
    }

    public void setVersion(Byte version) {
        this.version = version;
    }
}
