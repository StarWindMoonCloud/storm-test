import java.util

import backtype.storm.task.{OutputCollector, TopologyContext}
import backtype.storm.topology.OutputFieldsDeclarer
import backtype.storm.topology.base.BaseRichBolt
import backtype.storm.tuple.Tuple

/**
 * Created by qili on 5/19/15.
 */
class ProcessBolt extends BaseRichBolt {
  override def prepare(map: util.Map[_, _], topologyContext: TopologyContext, outputCollector: OutputCollector): Unit = {
    val value = map.get("key").asInstanceOf[java.lang.Integer]
    println(value)
  }

  override def execute(tuple: Tuple): Unit = {}

  override def declareOutputFields(outputFieldsDeclarer: OutputFieldsDeclarer): Unit = {}
}
