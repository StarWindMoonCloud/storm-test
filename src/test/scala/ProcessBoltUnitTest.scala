import backtype.storm.Config
import backtype.storm.task.OutputCollector
import backtype.storm.topology.OutputFieldsDeclarer
import backtype.storm.tuple.{Values, Tuple}
import org.mockito.ArgumentCaptor
import org.mockito.Mockito._
import org.specs2.mutable.Specification

/**
 * Created by qili on 5/19/15.
 */
class ProcessBoltUnitTest extends Specification {
  "test ProcessBolt" in {
    val testBolt: ProcessBolt = new ProcessBolt
    val tuple: Tuple = mock(classOf[Tuple])
    val outputFieldsDeclarer: OutputFieldsDeclarer = mock(classOf[OutputFieldsDeclarer])
    val collector: OutputCollector = mock(classOf[OutputCollector])

    val config = new Config()
    config.put("key", new java.lang.Integer(1))
    testBolt.prepare(config, null, collector)
    testBolt.declareOutputFields(outputFieldsDeclarer)
    testBolt.execute(tuple)
    true
  }
}
