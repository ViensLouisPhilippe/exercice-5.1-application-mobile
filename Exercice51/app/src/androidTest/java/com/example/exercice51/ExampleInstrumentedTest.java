package com.example.exercice51;

import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.exercice51.Http.Service;
import com.example.exercice51.Http.retrofitUtil;
import com.example.exercice51.transfert.Repo;
import com.example.exercice51.transfert.utilisateur;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void testSimple() throws IOException {
        Service service = retrofitUtil.get();
        Call<String> call = service.listReposString("jorisdeguet");
        Response<String> response = call.execute();
        String resultat = response.body();
        Log.i("RETROFIT", resultat);
    }
    @Test
    public void testSimpleUtilisateur() throws IOException {
        Service service = retrofitUtil.get();
        Call<String> call = service.utilisateurString("jorisdeguet");
        Response<String> response = call.execute();
        String resultat = response.body();
        Log.i("RETROFIT", resultat);
    }

    @Test
    public void testSimpleUtilisateurStructurer() throws IOException {
        Service service = retrofitUtil.get();
        Call<utilisateur> call = service.utilisateur("jorisdeguet");
        Response<utilisateur> response = call.execute();
        utilisateur resultat = response.body();
        Log.i("RETROFIT", resultat.toString());
    }

    @Test
    public void testListReposStructurer() throws IOException {
        Service service = retrofitUtil.get();
        Call<List<Repo>> call = service.listRepos("jorisdeguet");
        Response<List<Repo>> response = call.execute();
        List<Repo> resultat = response.body();
        Log.i("RETROFIT", resultat.toString());
    }
}