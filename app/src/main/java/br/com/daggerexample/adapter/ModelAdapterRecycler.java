package br.com.daggerexample.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.daggerexample.R;
import br.com.daggerexample.model.Model;

public class ModelAdapterRecycler extends RecyclerView.Adapter<ModelAdapterRecycler.ModelViewHolder> {

    private List<Model> itens;

    public ModelAdapterRecycler(List<Model> itens){
        this.itens = itens;
    }

    @NonNull
    @Override
    public ModelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_layout_model, null);

        return new ModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelViewHolder modelViewHolder, int i) {

        Model model = itens.get(i);

        modelViewHolder.setModel(model);
        modelViewHolder.bind();

    }

    @Override
    public int getItemCount() {
        return itens.size();
    }

    class ModelViewHolder extends RecyclerView.ViewHolder{

        private ImageView image;
        private TextView title;
        private TextView description;

        private Model model;

        public Model getModel() {
            return model;
        }

        public void setModel(Model model){
            this.model = model;
        }

        public ModelViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.descripion);

        }

        public void bind(){

            image.setImageResource(model.getImage());
            title.setText(model.getTitle());
            description.setText(model.getDescription());

        }
    }

}
