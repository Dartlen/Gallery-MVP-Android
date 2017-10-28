package by.test.dartlen.gallery.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.test.dartlen.gallery.R;
import by.test.dartlen.gallery.data.remote.retrofit.LoginData;
import by.test.dartlen.gallery.gallery.MainPageActivity;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/*** Created by Dartlen on 26.10.2017.
 */

public class LoginFragment extends Fragment implements LoginContract.View, View.OnClickListener {

    private LoginContract.Presenter mPresenter;

    @BindView(R.id.login)
    EditText mLogin;

    @BindView(R.id.password)
    EditText mPassword;

    @BindView(R.id.button)
    Button mButton;

    public LoginFragment() {
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.login_fragment, container, false);
        ButterKnife.bind(this, root);
        mButton.setOnClickListener(this);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void showLogin() {

    }

    @Override
    public void showLoginError() {

    }

    @Override
    public void showRegister() {

    }

    @Override
    public void setPresenter(@NonNull LoginContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public LoginData getLoginPassword() {
        return new LoginData(mLogin.getText().toString(), mPassword.getText().toString());
    }

    @Override
    public void onClick(View v) {
        mPresenter.login();
    }

    public void showMain(){
        Intent intent = new Intent(getContext(), MainPageActivity.class);
        startActivity(intent);
    }
}
