package org.springframework.data.orientdb.graph;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.blueprints.impls.orient.OrientGraphFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrepareGraphDatabase {

    private static final Logger logger = LoggerFactory.getLogger(PrepareGraphDatabase.class);

    public static void main(String[] args) {
        
        OrientGraphFactory factory = new OrientGraphFactory("remote:localhost/testgremlin","root","Vibfam@321");

        OrientGraph graph = factory.getTx();
        
        try {
            //graph.createVertexType("Person");
//            Vertex person = graph.addVertex("Person", "Person");
//            person.setProperty("name", "Dzmitry");
//            graph.commit();

            for (Vertex vertex : graph.getVertices()) {
                System.out.println("Vertex: {}"+ vertex);
                for (Edge edge : vertex.getEdges(Direction.BOTH)) {
                    System.out.println("Edge: {}"+ edge);
                }

                System.out.println("Property keys: {}"+vertex.getPropertyKeys());
            }

            for (Edge edge : graph.getEdges()) {
                System.out.println("Edge: {}"+ edge);
            }
            
            //graph.addEdge(null, graph.getVertex("#13:0"), graph.getVertex("#13:0"), "link");
        } finally {
            graph.shutdown();
        }
    }
}
