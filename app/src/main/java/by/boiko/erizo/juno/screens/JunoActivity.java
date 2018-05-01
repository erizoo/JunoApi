package by.boiko.erizo.juno.screens;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;

import by.boiko.erizo.juno.R;
import by.boiko.erizo.juno.base.BaseMvvmActivity;
import by.boiko.erizo.juno.databinding.ActivityMainBinding;

public class JunoActivity extends BaseMvvmActivity<ActivityMainBinding, JunoViewModel> {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public JunoViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(JunoViewModel.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(viewModel.getAdapter());
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                search(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                search(newText);
                return false;
            }
        });
    }

    private void search(String key) {
        binding.getViewModel().search(key);
    }

}
