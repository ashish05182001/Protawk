package sddtu.org.protawk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Dell on 3/16/2017.
 */

public class SearchList extends AppCompatActivity {
    int p;
    String[][] datas={{"Doctor1","Doctor2","Doctor3","Doctor4","Doctor5","Doctor6","Doctor7","Doctor8","Doctor9"},
            {"Lawyers2","Lawyers3","Lawyers4","Lawyers5","Lawyers6","Lawyers7","Lawyers8","Lawyers","Lawyers10"},
            {"Doctor1","Doctor2","Doctor3","Doctor4","Doctor5","Doctor6","Doctor7","Doctor8","Doctor9"},
            {"Doctor1","Doctor2","Doctor3","Doctor4","Doctor5","Doctor6","Doctor7","Doctor8","Doctor9"},
            {"Doctor1","Doctor2","Doctor3","Doctor4","Doctor5","Doctor6","Doctor7","Doctor8","Doctor9"},
            {"Doctor1","Doctor2","Doctor3","Doctor4","Doctor5","Doctor6","Doctor7","Doctor8","Doctor9"}};
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitysearchlist);
        p=getIntent().getIntExtra("ArrayChoose",0);
        recyclerView=(RecyclerView)findViewById(R.id.searchrecycler);
        layoutManager=new LinearLayoutManager(SearchList.this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new RecyclerInnerAdapter(getDataaSet());
        recyclerView.setAdapter(adapter);



    }

    private ArrayList<CardList> getDataaSet(){
        ArrayList results=new ArrayList<CardList>();
        for(int i=0;i<datas[p].length;i++){
                CardList cardList=new CardList(datas[p][i]);
                results.add(i,cardList);

        }
        return results;
    }
}
