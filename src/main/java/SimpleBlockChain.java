import java.util.ArrayList;
import java.util.List;

public class SimpleBlockChain {

    public static void main(String[] args) {

        final List<Block> blockchain = new ArrayList<>();

        blockchain.add(new Block("0", "genesis"));
        blockchain.add(new Block(blockchain.get(blockchain.size()-1).getCurrHash(), "onecoin"));
        blockchain.add(new Block(blockchain.get(blockchain.size()-1).getCurrHash(), "twocoin"));

        for (Block block : blockchain) {
            System.out.println(block.getCurrHash());
        }
    }
}
