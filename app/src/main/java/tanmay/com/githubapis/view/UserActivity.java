package tanmay.com.githubapis.view;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import tanmay.com.githubapis.R;
import tanmay.com.githubapis.adapter.RecyclerPresenter;
import tanmay.com.githubapis.adapter.UserAdapter;
import tanmay.com.githubapis.contract.UserContract;
import tanmay.com.githubapis.helper.Utilities;
import tanmay.com.githubapis.model.pojo.Users;
import tanmay.com.githubapis.presenter.UserPresenter;

/**
 * Created by tanmay on 07/07/19.
 */

public class UserActivity extends AppCompatActivity implements UserContract.View {
    private UserPresenter mPresenter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerPresenter recyclerPresenter;
    private UserAdapter userAdapter;
    private SearchView searchView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        mPresenter = new UserPresenter(this);
        mPresenter.getData(UserActivity.this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onGetDataSuccess(String message, List<Users> usersList) {
        recyclerPresenter = new RecyclerPresenter(UserActivity.this, usersList);
        userAdapter = new UserAdapter(recyclerPresenter);
        recyclerView.setAdapter(userAdapter);
    }

    @Override
    public void onGetDataFailure(String message) {
        Utilities.toast(message, UserActivity.this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        // listening to search query text change
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.e("QUERYonQueryTextSubmit",query);
                // filter recycler view when query submitted
                userAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                Log.e("QUERYonQueryTextChange",query);
                userAdapter.getFilter().filter(query);
                return false;
            }
        });
        return true;
    }

}
