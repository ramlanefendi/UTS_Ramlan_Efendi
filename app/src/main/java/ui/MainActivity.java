package ui;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_ramlan_efendi.R;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;

import data.retrofit.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view_users);
        userList = new ArrayList<>();
        userAdapter = new UserAdapter(this, userList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userAdapter);

        fetchDataFromApi();
    }

    private <ApiClient> void fetchDataFromApi() {
        ApiClient ApiClient = null;
        ApiService apiService = (ApiService) ApiClient.getClass().cast(ApiService.class);
        Call<ArrayList<User>> call = apiService.getUsers();

        call.enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                if (response.isSuccessful()) {
                    userList.addAll(response.body());
                    userAdapter.notifyDataSetChanged();
                } else {
                    Log.e("MainActivity", "Failed to fetch data: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                Log.e("MainActivity", "Error fetching data", t);
            }
        });
    }

    private class UserAdapter extends RecyclerView.Adapter {
        public <mainActivity> UserAdapter( MainActivity mainActivity, ArrayList<User> userList) {
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }
}
