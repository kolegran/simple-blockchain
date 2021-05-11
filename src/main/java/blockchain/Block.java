package blockchain;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;

public class Block {

    private final String prevHash;
    private final long timestamp;
    private final String data; // actual data, any information having value, like a contract
    private final String currHash;

    public Block(String prevHash, String data) {
        this.prevHash = prevHash;
        this.data = data;
        this.timestamp = new Date().getTime();
        this.currHash = calculateHash();
    }

    public String getCurrHash() {
        return currHash;
    }

    public String getPrevHash() {
        return prevHash;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getData() {
        return data;
    }

    protected String calculateHash() {
        return DigestUtils.sha256Hex(prevHash + timestamp + data);
    }
}
