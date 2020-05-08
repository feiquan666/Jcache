package practice;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * description:
 * date: 2020-04-30 18:37:58
 * @author: 飞拳
 */
public class UnixTime {
    private final long value;

    public UnixTime(long value) {
        this.value = value;
    }

    public UnixTime(){
        this(System.currentTimeMillis() / 1000L + 2208988800L);
    }

    public long getValue(){
        return value;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date((getValue() - 2208988800L) * 1000L);
        return simpleDateFormat.format(date);
    }
}
