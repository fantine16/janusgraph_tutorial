package marcelocf.janusgraph;

import org.janusgraph.core.JanusGraph;
import org.janusgraph.core.JanusGraphFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Prints out the timeline to stdout
 * <br/>
 * Created by marcelo on 17/06/21.
 */
public class Timeline {

  private static final Logger LOGGER = LoggerFactory.getLogger(Timeline.class);
  public static void main(String argv[]) throws Exception {
    JanusGraph graph = JanusGraphFactory.open(Schema.CONFIG_FILE);
    HadoopQueryRunner q = new HadoopQueryRunner(graph.traversal(), "testUser1");
    int runs = 10;

    for(int i =0; i < runs; i++) {
      LOGGER.info("Previous Timeline (run {} of {})", i+1, runs);
      LOGGER.info("New Timeline");
      q.printTimeline(q.getTimeline3(10));
    }
    q.close();
    graph.close();
  }
}
