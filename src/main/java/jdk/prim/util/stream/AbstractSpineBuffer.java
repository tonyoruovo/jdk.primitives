package jdk.prim.util.stream;

/**
 * @see java.util.stream.AbstractSpinedBuffer
 */
abstract class AbstractSpinedBuffer {
    /**
     * @see java.util.stream.AbstractSpinedBuffer#MIN_CHUNK_POWER
     */
    public static final int MIN_CHUNK_POWER = 4;

    /**
     * @see java.util.stream.AbstractSpinedBuffer#MIN_CHUNK_SIZE
     */
    public static final int MIN_CHUNK_SIZE = 1 << MIN_CHUNK_POWER;

    /**
     * @see java.util.stream.AbstractSpinedBuffer#MAX_CHUNK_POWER
     */
    public static final int MAX_CHUNK_POWER = 30;

    /**
     * @see java.util.stream.AbstractSpinedBuffer#MIN_SPINE_SIZE
     */
    public static final int MIN_SPINE_SIZE = 8;


    /**
     * @see java.util.stream.AbstractSpinedBuffer#initialChunkPower
     */
    protected final int initialChunkPower;

    /**
     * @see java.util.stream.AbstractSpinedBuffer#elementIndex
     */
    protected int elementIndex;

    /**
     * @see java.util.stream.AbstractSpinedBuffer#spineIndex
     */
    protected int spineIndex;

    /**
     * @see java.util.stream.AbstractSpinedBuffer#priorElementCount
     */
    protected long[] priorElementCount;

    /**
     * @see java.util.stream.AbstractSpinedBuffer#AbstractSpinedBuffer()
     */
    protected AbstractSpinedBuffer() {
        this.initialChunkPower = MIN_CHUNK_POWER;
    }

    /**
     * @see java.util.stream.AbstractSpinedBuffer#AbstractSpinedBuffer(int)
     */
    protected AbstractSpinedBuffer(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+ initialCapacity);

        this.initialChunkPower = Math.max(MIN_CHUNK_POWER,
                Integer.SIZE - Integer.numberOfLeadingZeros(initialCapacity - 1));
    }

    /**
     * @see java.util.stream.AbstractSpinedBuffer#isEmpty()
     */
    public boolean isEmpty() {
        return (spineIndex == 0) && (elementIndex == 0);
    }

    /**
     * @see java.util.stream.AbstractSpinedBuffer#count
     */
    public long count() {
        return (spineIndex == 0)
                ? elementIndex
                : priorElementCount[spineIndex] + elementIndex;
    }

    /**
     * @see java.util.stream.AbstractSpinedBuffer#chunkSize(int)
     */
    protected int chunkSize(int n) {
        int power = (n == 0 || n == 1)
                ? initialChunkPower
                : Math.min(initialChunkPower + n - 1, MAX_CHUNK_POWER);
        return 1 << power;
    }

    /**
     * @see java.util.stream.AbstractSpinedBuffer#clear
     */
    public abstract void clear();
}
