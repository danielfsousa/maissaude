package com.danisousa.maissaude.adaptadores;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.danisousa.maissaude.R;
import com.danisousa.maissaude.atividades.DetalhesActivity;
import com.danisousa.maissaude.modelos.Estabelecimento;
import com.danisousa.maissaude.servicos.ApiEstabelecimentosInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EstabelecimentosAdapter extends RecyclerView.Adapter<EstabelecimentosAdapter.MyViewHolder> {

    public static final String EXTRA_ESTABELECIMENTO = "Estabelecimento";

    private Context mContext;
    private ApiEstabelecimentosInterface mServico;
    private List<Estabelecimento> mEstabelecimentos;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title, genre, distancia;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.nomeFantasia);
            genre = (TextView) view.findViewById(R.id.tipoUnidade);
            distancia = (TextView) view.findViewById(R.id.distancia);
        }
    }

    public EstabelecimentosAdapter(Context context) {

        mContext = context;
        mEstabelecimentos = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiEstabelecimentosInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mServico = retrofit.create(ApiEstabelecimentosInterface.class);

        Call<List<Estabelecimento>> call = mServico.getTodosEstabelecimentos(0);
        call.enqueue(new Callback<List<Estabelecimento>>() {
            @Override
            public void onResponse(Call<List<Estabelecimento>> call, Response<List<Estabelecimento>> response) {
                EstabelecimentosAdapter.this.mEstabelecimentos = response.body();
                Log.i("EstAdapter", Integer.toString(response.body().size()));
                notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Estabelecimento>> call, Throwable t) {
                Toast.makeText(EstabelecimentosAdapter.this.mContext, "erro", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final int index = position;

        Estabelecimento estabelecimento = mEstabelecimentos.get(position);
        holder.title.setText(estabelecimento.getNomeFantasia());
        holder.genre.setText(estabelecimento.getTipoUnidade());
        holder.distancia.setText("25km");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickViewHolder(v, index);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return onLongClickViewHolder(v, index);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mEstabelecimentos.size();
    }

    public Estabelecimento getItem(int position) {
        return mEstabelecimentos.get(position);
    }

    private void onClickViewHolder(View view, int position) {
        Context context = view.getContext();

        Estabelecimento estabelecimento = getItem(position);
        Intent it = new Intent(context, DetalhesActivity.class);
        it.putExtra(EXTRA_ESTABELECIMENTO, estabelecimento);
        context.startActivity(it);
    }

    private boolean onLongClickViewHolder(View view, int position) {
        final Context context = view.getContext();

        final int LIGAR = 0;
        final int ABRIR_NO_GMAPS = 1;
        final int COMPARTILHAR = 2;
        final int COPIAR_TELEFONE = 3;
        final int COPIAR_ENDEREÇO = 4;
        final int ADICIONAR_AOS_FAVORITOS = 5;

        final CharSequence[] items = {
                "Ligar",
                "Abrir no Google Maps",
                "Compartilhar",
                "Copiar Telefone",
                "Copiar Endereço",
                "Adicionar aos Favoritos"
        };

        Estabelecimento filme = getItem(position);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle(filme.getNomeFantasia());
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                switch (item) {
                    case LIGAR:
                        Toast.makeText(context, "Ligar", Toast.LENGTH_SHORT).show();
                        return;
                    case ABRIR_NO_GMAPS:
                        Toast.makeText(context, "Abrir no Google Maps", Toast.LENGTH_SHORT).show();
                        return;
                    case COMPARTILHAR:
                        Toast.makeText(context, "Compartilhar", Toast.LENGTH_SHORT).show();
                        return;
                    case COPIAR_TELEFONE:
                        Toast.makeText(context, "Copiar Telefone", Toast.LENGTH_SHORT).show();
                        return;
                    case COPIAR_ENDEREÇO:
                        Toast.makeText(context, "Copiar Endereço", Toast.LENGTH_SHORT).show();
                        return;
                    case ADICIONAR_AOS_FAVORITOS:
                        Toast.makeText(context, "Adicionar aos Favoritos", Toast.LENGTH_SHORT).show();
                        return;
                    default:
                        Toast.makeText(context, "Nenhum", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.show();
        return true;
    }

}