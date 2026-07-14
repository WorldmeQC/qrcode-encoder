package top.worldmeqc.qrcode.enums;

/**
 * 掩码样式
 *
 * @author Kazuhiko Arase
 */
public enum MaskPattern {

    /**
     * 掩码样式 000
     */
    PATTERN000(0, new MaskFunc() {
        @Override
        public boolean apply(int row, int col) {
            return (row + col) % 2 == 0;
        }
    }),

    /**
     * 掩码样式 001
     */
    PATTERN001(1, new MaskFunc() {
        @Override
        public boolean apply(int row, int col) {
            return row % 2 == 0;
        }
    }),

    /**
     * 掩码样式 010
     */
    PATTERN010(2, new MaskFunc() {
        @Override
        public boolean apply(int row, int col) {
            return col % 3 == 0;
        }
    }),

    /**
     * 掩码样式 011
     */
    PATTERN011(3, new MaskFunc() {
        @Override
        public boolean apply(int row, int col) {
            return (row + col) % 3 == 0;
        }
    }),

    /**
     * 掩码样式 100
     */
    PATTERN100(4, new MaskFunc() {
        @Override
        public boolean apply(int row, int col) {
            return (row / 2 + col / 3) % 2 == 0;
        }
    }),

    /**
     * 掩码样式 101
     */
    PATTERN101(5, new MaskFunc() {
        @Override
        public boolean apply(int row, int col) {
            return (row * col) % 2 + (row * col) % 3 == 0;
        }
    }),

    /**
     * 掩码样式 110
     */
    PATTERN110(6, new MaskFunc() {
        @Override
        public boolean apply(int row, int col) {
            return ((row * col) % 2 + (row * col) % 3) % 2 == 0;
        }
    }),

    /**
     * 掩码样式 111
     */
    PATTERN111(7, new MaskFunc() {
        @Override
        public boolean apply(int row, int col) {
            return ((row * col) % 3 + (row + col) % 2) % 2 == 0;
        }
    });

    public final int value;
    private final MaskFunc func;

    MaskPattern(int value, MaskFunc func) {
        this.value = value;
        this.func = func;
    }

    public boolean invoke(int row, int col) {
        return func.apply(row, col);
    }

    /**
     * 自定义函数接口（Java 7 没有 BiFunction）
     */
    public interface MaskFunc {
        boolean apply(int row, int col);
    }
}