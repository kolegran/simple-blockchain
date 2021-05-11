package blockchain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BlockChainCreator {

    public static List<Block> getBlockChain() {
        final List<Block> blockchain = new ArrayList<>();
        blockchain.add(new Block("0", "genesis"));
        blockchain.add(new Block(blockchain.get(blockchain.size() - 1).getCurrHash(), "onecoin"));
        blockchain.add(new Block(blockchain.get(blockchain.size() - 1).getCurrHash(), "twocoin"));
        return blockchain;
    }

    @Test
    void createApproximateBlockChain() {
        final List<Block> blockChain = getBlockChain();
        new BlockChainHandler().isChainValid(blockChain);

        final List<String> hashes = blockChain.stream()
            .map(Block::getCurrHash)
            .collect(Collectors.toList());

        System.out.println(hashes);
    }
}
