package com.devayanidinda.testlagi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

import org.apache.tinkerpop.gremlin.driver.Cluster;
import org.apache.tinkerpop.gremlin.driver.Client;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import static org.apache.tinkerpop.gremlin.process.traversal.AnonymousTraversalSource.traversal;
import org.apache.tinkerpop.gremlin.driver.remote.DriverRemoteConnection;
import org.apache.tinkerpop.gremlin.structure.T;

public class RecoFragment extends Fragment {
    private TextInputEditText namaApotek;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reco, container, false);
        namaApotek = view.findViewById(R.id.apotek);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    Cluster.Builder builder = Cluster.build();
                    builder.addContactPoint("databaserecommendation-demo1.cluster-ro-cmdzqixfko2p.ap-southeast-1.neptune.amazonaws.com");
                    builder.port(8182);
                    builder.enableSsl(true);
                    builder.keyCertChainFile("SFSRootCAG2.pem");
                    Cluster cluster = builder.create();
                    GraphTraversalSource g = traversal().withRemote(DriverRemoteConnection.using(cluster));

                    // This gets the vertices, only.
                    GraphTraversal t = g.V().limit(5).valueMap();

                    t.forEachRemaining(
                            e ->  System.out.println(e)
                    );

                    cluster.close();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
        super.onViewCreated(view, savedInstanceState);
    }
}