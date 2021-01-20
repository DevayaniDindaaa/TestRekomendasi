package com.devayanidinda.testlagi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
//import org.neo4j.driver.AuthTokens;
//import org.neo4j.driver.Driver;
//import org.neo4j.driver.GraphDatabase;
//import org.neo4j.driver.*;
//import org.neo4j.driver.v1.AuthTokens;
//import org.neo4j.driver.v1.Driver;
//import org.neo4j.driver.v1.GraphDatabase;
//import org.neo4j.driver.v1.Session;
//import org.neo4j.driver.v1.Statement;
//import static org.neo4j.driver.v1.Values.parameters;

public class InputFragment extends Fragment {
    private TextInputEditText namaApotek, namaProduk, namaKategori;
    private Button inputNode;

    public InputFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        namaApotek = view.findViewById(R.id.apotek);
        namaProduk = view.findViewById(R.id.produk);
        namaKategori = view.findViewById(R.id.kategori);
        inputNode = view.findViewById(R.id.insertnode);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inputNode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nApotek = namaApotek.getText().toString();
                String nProduk = namaProduk.getText().toString();
                String nKategori = namaKategori.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //AddNode(nApotek, nProduk, nKategori);
                    }
                }).start();
            }
        });
    }

//    public void AddNode(String nApotek, String nProduk, String nKategori){
//        try (Connection con = DriverManager.getConnection("jdbc:neo4j:bolt://localhost", "neo4j", "password")) {
//
//            // Querying
//            String query = "CREATE (apt:Apotek {name:$nApotek}), (pr:Produk {name:$nProduk}), (ktg:Kategori {name:$nKategori}), (apt)-[b:BUYS]->(pr)-[:HAS_CATEGORY]->(ktg)";
//            try (PreparedStatement stmt = ((java.sql.Connection) con).prepareStatement(query)) {
//                stmt.setString(1,"John");
//
//                try (ResultSet rs = stmt.executeQuery()) {
//                    while (rs.next()) {
//                        System.out.println("Friend: "+rs.getString("f.name")+" is "+rs.getInt("f.age"));
//                    }
//                }
//                catch (Exception e){
//                    System.out.println(e);
//                }
//            } catch (SQLException e) {
//                System.out.println(e);
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        driver = null;
//        try {
//            driver = GraphDatabase.driver("bolt://10.163.236.1:7687", AuthTokens.basic("neo4j", "abcde"));
//            try ( Session session = driver.session() ) {
//                String greeting = session.writeTransaction(new TransactionWork<String>() {
//                    @Override
//                    public String execute(Transaction tx) {
//                        Result result = tx.run("CREATE (apt:Apotek {name:$nApotek}), (pr:Produk {name:$nProduk}), (ktg:Kategori {name:$nKategori})," +
//                                        "(apt)-[b:BUYS]->(pr)-[:HAS_CATEGORY]->(ktg)",
//                                parameters("$nApotek", nApotek, "$nProduk", nProduk, "$nKategori", nKategori));
//                        return result.single().get(0).asString();
//                    }
//                });
//                System.out.println(greeting);
//            }
//        }
//        catch (Exception e){
//            System.out.println(e);
//            //Toast.makeText(getActivity().getApplicationContext(), "Gagal, Coba Lagi", Toast.LENGTH_SHORT).show();
//        }finally {
//            if (driver != null) {
//                //Toast.makeText(getActivity().getApplicationContext(), "Berhasil Input Node", Toast.LENGTH_SHORT).show();
//                System.out.println("RUN TEST");
//                driver.close();
//            }
//        }
//    }
}

