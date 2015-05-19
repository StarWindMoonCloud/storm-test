import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.testing.TestWordSpout;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.utils.Utils;

/**
 * Created by qili on 5/19/15.
 */
public class TestTopologyJava {
    public static void main(String[] args) {
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("word", new TestWordSpout(), 10);
        builder.setBolt("test", new ProcessBolt()).shuffleGrouping("word");
        Config conf = new Config();
        conf.setDebug(true);
        conf.put("key", new java.lang.Integer(1));

        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("test", conf, builder.createTopology());
        Utils.sleep(10000);
        cluster.killTopology("test");
        cluster.shutdown();
    }
}
