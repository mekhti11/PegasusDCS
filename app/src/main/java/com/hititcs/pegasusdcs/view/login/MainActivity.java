package com.hititcs.pegasusdcs.view.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.hititcs.pegasusdcs.R;
import com.hititcs.pegasusdcs.domain.interactor.login.LoginUseCase;
import com.hititcs.pegasusdcs.domain.model.AuthModel;
import com.hititcs.pegasusdcs.domain.model.LoginRequest;
import com.hititcs.pegasusdcs.util.AppUtils;
import com.hititcs.pegasusdcs.util.DialogUtil;
import com.hititcs.pegasusdcs.util.FontUtils;
import com.hititcs.pegasusdcs.util.StringUtils;
import com.hititcs.pegasusdcs.view.BaseActivity;
import com.hititcs.pegasusdcs.view.home.view.HomeActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class MainActivity extends BaseActivity<MainActivity> {

    public static final String TOKEN_ERROR_ACTION = "tokenErrorAction";

    @BindView(R.id.btn_login)
    AppCompatButton loginButton;
    @BindView(R.id.edt_username)
    TextInputEditText twUsername;
    @BindView(R.id.edt_password)
    TextInputEditText twPassword;
    @BindView(R.id.txt_input_username)
    TextInputLayout tilInputUsername;
    @BindView(R.id.txt_input_password)
    TextInputLayout tilInputPassword;

    @Inject
    LoginUseCase loginUseCase;

    private CompositeDisposable compositeDisposable;
    private FirebaseStorage firebaseStorage;
    private StorageReference firebaseStorageRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (getIntent().getAction() != null && getIntent().getAction().equals(TOKEN_ERROR_ACTION)) {
            getAuthManager().clear();
            showTokenErrorDialog();
        }
        if (getAuthManager().isContain()) {
            navigateToHomeActivity();
        } else {
            getAuthManager().clear();
        }
        firebaseStorage = FirebaseStorage.getInstance();
        firebaseStorageRef = firebaseStorage.getReference();
        ButterKnife.bind(this);
        setupTextInputLayoutsTitles();
    }

    private void showTokenErrorDialog() {
        DialogUtil.showNativeAlertDialog(context(), R.string.general_token_error_popup_title,
                R.string.general_token_error_popup_message, R.string.general_popup_ok,
                (DialogInterface.OnClickListener) (dialog, which) -> {
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                }, R.string.general_popup_cancel, null);
    }

    private boolean validate() {
        return !StringUtils.isEmpty(twUsername.getText().toString())
                && !StringUtils.isEmpty(twPassword.getText().toString());
    }

    @OnClick(R.id.btn_login)
    public void onClickLoginButton() {
        if (!validate()) {
            return;
        }
        this.showProgressDialog();
        LoginRequest request = new LoginRequest();
        request.setUsername(twUsername.getText().toString());
        request.setPassword(twPassword.getText().toString());
        loginUseCase.execute(new SingleObserver<AuthModel>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onSuccess(AuthModel authModel) {
                hideProgressDialog();
                final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) findViewById(android.R.id.content))
                        .getChildAt(0);
                AppUtils.hideKeyboardFrom(context(), viewGroup);
                jump();
//                downloadCompanyLogoFromStorage();
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(MainActivity.this, "INVALID USERNAME OR PASSWORD", Toast.LENGTH_LONG)
                        .show();
                hideProgressDialog();
            }
        }, request);
    }

    private void setupTextInputLayoutsTitles() {
        if (context()!=null) {
            FontUtils.setTextInputLayoutHintBold(
                    context(),
                    R.font.poppins_bold,
                    tilInputUsername,
                    tilInputPassword
            );
        }
    }

    @Override
    protected MainActivity getActivity() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }

    private void jump() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        if (isTaskRoot()) {
            moveTaskToBack(true);
        } else {
            super.onBackPressed();
        }
    }
}