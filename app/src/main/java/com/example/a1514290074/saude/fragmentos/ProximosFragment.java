package com.example.a1514290074.saude.fragmentos;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.a1514290074.saude.atividades.DetalhesActivity;
import com.example.a1514290074.saude.modelos.Estabelecimento;
import com.example.a1514290074.saude.adaptadores.EstabelecimentosAdapter;
import com.example.a1514290074.saude.R;

import java.util.ArrayList;
import java.util.List;

public class ProximosFragment extends Fragment{

    private List<Estabelecimento> mEstabelecimentoList = new ArrayList<>();
    private RecyclerView recyclerView;
    private EstabelecimentosAdapter mAdapter;

    public ProximosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_proximos, container, false);


        recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

        mAdapter = new EstabelecimentosAdapter(mEstabelecimentoList);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        DividerItemDecoration separador = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            separador.setDrawable(getContext().getDrawable(R.drawable.separador_lista));
        }
        recyclerView.addItemDecoration(separador);

        prepareMovieData();

        return view;
    }

    private void prepareMovieData() {
        Estabelecimento estabelecimento = new Estabelecimento("Mad Max: Fury Road", "Action & Adventure", "2015", -15.6197972, -47.6512968);
        mEstabelecimentoList.add(estabelecimento);

        estabelecimento = new Estabelecimento("Inside Out", "Animation, Kids & Family", "2015", -15.6197972, -47.6512968);
        mEstabelecimentoList.add(estabelecimento);

        estabelecimento = new Estabelecimento("Star Wars: Episode VII - The Force Awakens", "Action", "2015", -15.6197972, -47.6512968);
        mEstabelecimentoList.add(estabelecimento);

        estabelecimento = new Estabelecimento("Shaun the Sheep", "Animation", "2015", -15.6197972, -47.6512968);
        mEstabelecimentoList.add(estabelecimento);

        estabelecimento = new Estabelecimento("The Martian", "Science Fiction & Fantasy", "2015", -15.6197972, -47.6512968);
        mEstabelecimentoList.add(estabelecimento);

        estabelecimento = new Estabelecimento("Mission: Impossible Rogue Nation", "Action", "2015", -15.6197972, -47.6512968);
        mEstabelecimentoList.add(estabelecimento);

        estabelecimento = new Estabelecimento("Up", "Animation", "2009", -15.6197972, -47.6512968);
        mEstabelecimentoList.add(estabelecimento);

        estabelecimento = new Estabelecimento("Star Trek", "Science Fiction", "2009", -15.6197972, -47.6512968);
        mEstabelecimentoList.add(estabelecimento);

        estabelecimento = new Estabelecimento("The LEGO Estabelecimento", "Animation", "2014", -15.6197972, -47.6512968);
        mEstabelecimentoList.add(estabelecimento);

        estabelecimento = new Estabelecimento("Iron Man", "Action & Adventure", "2008", -15.6197972, -47.6512968);
        mEstabelecimentoList.add(estabelecimento);

        estabelecimento = new Estabelecimento("Aliens", "Science Fiction", "1986", -15.6197972, -47.6512968);
        mEstabelecimentoList.add(estabelecimento);

        estabelecimento = new Estabelecimento("Chicken Run", "Animation", "2000", -15.6197972, -47.6512968);
        mEstabelecimentoList.add(estabelecimento);

        estabelecimento = new Estabelecimento("Back to the Future", "Science Fiction", "1985", -15.6197972, -47.6512968);
        mEstabelecimentoList.add(estabelecimento);

        estabelecimento = new Estabelecimento("Raiders of the Lost Ark", "Action & Adventure", "1981", -15.6197972, -47.6512968);
        mEstabelecimentoList.add(estabelecimento);

        estabelecimento = new Estabelecimento("Goldfinger", "Action & Adventure", "1965", -15.6197972, -47.6512968);
        mEstabelecimentoList.add(estabelecimento);

        estabelecimento = new Estabelecimento("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014", -15.6197972, -47.6512968);
        mEstabelecimentoList.add(estabelecimento);

        mAdapter.notifyDataSetChanged();
    }
}