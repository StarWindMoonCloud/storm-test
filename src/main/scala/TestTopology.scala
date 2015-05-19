import backtype.storm.utils.Utils
import backtype.storm.{LocalCluster, StormSubmitter, Config}
import backtype.storm.testing.TestWordSpout
import backtype.storm.topology.TopologyBuilder

/**
 * Created by qili on 5/19/15.
 */
object TestTopology {
  def main(args: Array[String]): Unit = {
    val builder: TopologyBuilder = new TopologyBuilder
    builder.setSpout("word", new TestWordSpout, 10)
    builder.setBolt("test", new ProcessBolt).shuffleGrouping("word")
    val conf: Config = new Config
    conf.setDebug(true)
    conf.put("key", new java.lang.Integer(1))

    val cluster: LocalCluster = new LocalCluster
    cluster.submitTopology("test", conf, builder.createTopology)
    Utils.sleep(10000)
    cluster.killTopology("test")
    cluster.shutdown
  }
}
