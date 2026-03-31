package DataStructuresAndAlgorithms;

public class SimpleSnowflake {
    private static final long EPOCH = 1704067200000L; // 起始時間：2025-01-01
    private static final long SEQUENCE_BITS = 12L;    // 序列號位數
    private static final long SEQUENCE_MASK = (1 << SEQUENCE_BITS) - 1;

    private long lastTimestamp = -1L;
    private long sequence = 0L;

    public synchronized long nextId() {
        long timestamp = System.currentTimeMillis();

        if (timestamp == lastTimestamp) {
            sequence = (sequence + 1) & SEQUENCE_MASK;
            if (sequence == 0) {
                // 序列號用完了，等下一毫秒
                while (timestamp <= lastTimestamp) {
                    timestamp = System.currentTimeMillis();
                }
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        return ((timestamp - EPOCH) << SEQUENCE_BITS) | sequence;
    }

    public static void main(String[] args) {
        SimpleSnowflake gen = new SimpleSnowflake();
        for (int i = 0; i < 10; i++) {
            System.out.println(gen.nextId());
        }
    }
}

