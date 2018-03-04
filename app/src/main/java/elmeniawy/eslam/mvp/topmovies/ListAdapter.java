package elmeniawy.eslam.mvp.topmovies;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import elmeniawy.eslam.mvp.R;

/**
 * ListAdapter
 * <p>
 * Created by Eslam El-Meniawy on 04-Mar-2018.
 * CITC - Mansoura University
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListItemViewHolder> {
    private List<ViewModel> list;

    ListAdapter(List<ViewModel> list) {
        this.list = list;
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row, parent, false);
        return new ListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {
        holder.movieTitle.setText(list.get(position).getTitle());
        holder.movieCountry.setText(list.get(position).getCountry());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ListItemViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView movieTitle;
        AppCompatTextView movieCountry;

        ListItemViewHolder(View itemView) {
            super(itemView);
            movieTitle = itemView.findViewById(R.id.movie_title);
            movieCountry = itemView.findViewById(R.id.movie_country);
        }
    }
}
