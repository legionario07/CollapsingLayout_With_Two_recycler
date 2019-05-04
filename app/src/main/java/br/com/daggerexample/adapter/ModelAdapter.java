package br.com.daggerexample.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import br.com.daggerexample.R;
import br.com.daggerexample.model.Model;

public class ModelAdapter extends BaseAdapter {

    private List<Model> itens;

    public ModelAdapter(List<Model> itens){
        this.itens = itens;
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Object getItem(int position) {
        return itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout_model, null);

        ImageView image = view.findViewById(R.id.image);
        TextView title = view.findViewById(R.id.title);
        TextView description = view.findViewById(R.id.descripion);

        Model model = itens.get(position);

        image.setImageResource(model.getImage());
        title.setText(model.getTitle());
        description.setText(model.getDescription());

        return view;
    }
}
