package tanmay.com.githubapis.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import tanmay.com.githubapis.R;

/**
 * Created by tanmay on 07/07/19.
 */

public class UserAdapter extends RecyclerView.Adapter<RecyclerViewHolder> implements Filterable {
    private final RecyclerPresenter presenter;

    public UserAdapter(RecyclerPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_user, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        presenter.onBindRepositoryRowViewAtPosition(position, holder, this);
    }

    @Override
    public int getItemCount() {
        return presenter.getRepositoriesRowsCount();
    }

    @Override
    public Filter getFilter() {
        return presenter.getFilter(this);
    }
}
