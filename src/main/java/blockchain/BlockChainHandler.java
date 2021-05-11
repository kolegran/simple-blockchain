package blockchain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BlockChainHandler {

    private final Logger logger = LoggerFactory.getLogger(BlockChainHandler.class);

    public boolean isChainValid(List<Block> blockChain) {

        final int size = blockChain.size();
        for (int i = 1; i < size; i++) {

            final Block currentBlock = blockChain.get(i);
            if (compareHashes(currentBlock.getCurrHash(), currentBlock.calculateHash())) {
                logger.error("Current Hashes not equal");
                throw new HashesAreNotEqualException();
            }

            final Block prevBlock = blockChain.get(i - 1);
            if (compareHashes(prevBlock.getCurrHash(), currentBlock.getPrevHash())) {
                logger.error("Previous Hashes not equal");
                throw new HashesAreNotEqualException();
            }
        }
        return true;
    }

    private boolean compareHashes(String currentHash, String hash) {
        return !currentHash.equals(hash);
    }

    private static final class HashesAreNotEqualException extends RuntimeException {
    }
}
