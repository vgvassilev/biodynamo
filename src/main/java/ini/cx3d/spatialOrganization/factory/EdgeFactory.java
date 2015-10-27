package ini.cx3d.spatialOrganization.factory;

import ini.cx3d.spatialOrganization.interfaces.Edge;
import ini.cx3d.swig.spatialOrganization.spatialOrganization;

/**
 * Factory that generates Edge objects and enables quick switching between Java and native CPP implementation
 */
public class EdgeFactory<T> {

    private static final boolean NATIVE = spatialOrganization.useNativeEdge;
    public static final boolean DEBUG = spatialOrganization.debugEdge;

    public Edge create(ini.cx3d.spatialOrganization.interfaces.SpaceNode<T> a, ini.cx3d.spatialOrganization.interfaces.SpaceNode<T> b) {
        if (NATIVE) {
            return  ini.cx3d.swig.spatialOrganization.EdgeT_PhysicalNode.create(a, b);
        } else if(!DEBUG) {
            return new ini.cx3d.spatialOrganization.Edge(a, b);
        } else {
            throw new UnsupportedOperationException("EdgeDebug has not been implemented yet");
        }
    }
}
