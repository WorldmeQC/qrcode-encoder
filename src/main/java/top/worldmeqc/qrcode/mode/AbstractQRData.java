package top.worldmeqc.qrcode.mode;

import top.worldmeqc.qrcode.enums.Mode;
import top.worldmeqc.qrcode.utils.BitBuffer;

/**
 * QRData
 *
 * @author Kazuhiko Arase
 */
public abstract class AbstractQRData {

    private final Mode mode;
    private final String data;
    protected AbstractQRData(Mode mode, String data) {
        this.mode = mode;
        this.data = data;
    }

    public int getMode() {
        return mode.value;
    }

    public String getData() {
        return data;
    }

    public abstract int getLength();

    public abstract void write(BitBuffer buffer);

    public int getLengthInBits(int type) {
        return mode.getLengthInBits(type);
    }
}
