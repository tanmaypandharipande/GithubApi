package tanmay.com.githubapis.adapter;

import android.content.Context;
import android.util.Log;
import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

import tanmay.com.githubapis.contract.UserContract;
import tanmay.com.githubapis.model.pojo.Users;

/**
 * Created by tanmay on 07/07/19.
 */

public class RecyclerPresenter {

    private List<Users> usersList;
    private List<Users> usersListFiltered = new ArrayList<>();
    private Context context;

    public RecyclerPresenter(Context context, List<Users> usersList) {
        this.usersList = usersList;
        this.context = context;
        this.usersListFiltered = usersList;
    }

    public void onBindRepositoryRowViewAtPosition(int position, UserContract.RowView rowView, UserAdapter userAdapter) {
        rowView.setName(usersListFiltered.get(position).getLogin());
        rowView.setId(String.valueOf(usersListFiltered.get(position).getId()));
        rowView.setImage(context, usersListFiltered.get(position).getAvatar_url());

    }

    public int getRepositoriesRowsCount() {
        return usersListFiltered.size();
    }

    public Filter getFilter(final UserAdapter userAdapter) {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                Log.e("charString ", charString);
                if (charString.isEmpty()) {
                    usersListFiltered = usersList;
                } else {

                    List<Users> filteredList = new ArrayList<>();
                    for (Users row : usersList) {

                        // script_name match condition. this might differ depending on your requirement
                        // here we are looking for script_name or company_name number match
                        if (row.getLogin().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }
                    Log.e("filteredList ", filteredList.toString());
                    usersListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = usersListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                Log.e("VAULES", String.valueOf(filterResults.values));
                usersListFiltered = (ArrayList<Users>) filterResults.values;
                userAdapter.notifyDataSetChanged();
            }
        };
    }
}
