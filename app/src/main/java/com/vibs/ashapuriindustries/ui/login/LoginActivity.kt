package com.vibs.ashapuriindustries.ui.login

import android.content.Intent
import androidx.lifecycle.Observer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.kaopiz.kprogresshud.KProgressHUD
import com.shreejipackaging.utils.AppUtil
import com.shreejipackaging.utils.LibFile
import com.vibs.ashapuriindustries.BuildConfig
import com.vibs.ashapuriindustries.MainActivity
import com.vibs.ashapuriindustries.R
import com.vibs.ashapuriindustries.data.ResponseManager
import com.vibs.ashapuriindustries.data.model.User

class LoginActivity : AppCompatActivity() {

    private lateinit var loading: ProgressBar

    private val loginViewModel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }
    private lateinit var progressHUD: KProgressHUD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val login = findViewById<Button>(R.id.login)
        loading = findViewById(R.id.loading)

        loginViewModel.loginFormState.observe(this@LoginActivity, Observer {
            val loginState = it ?: return@Observer

            // disable login button unless both username / password is valid
            login.isEnabled = loginState.isDataValid

            if (loginState.usernameError != null) {
                username.error = getString(loginState.usernameError)
            }
            if (loginState.passwordError != null) {
                password.error = getString(loginState.passwordError)
            }
        })

        username.afterTextChanged {
            loginViewModel.loginDataChanged(
                username.text.toString(),
                password.text.toString()
            )
        }

        password.apply {
            afterTextChanged {
                loginViewModel.loginDataChanged(
                    username.text.toString(),
                    password.text.toString()
                )
            }

            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        userLogin(
                            User(
                                userName = username.text.toString(),
                                password = password.text.toString()
                            )
                        )
                }
                false
            }

            login.setOnClickListener {
                userLogin(
                    User(
                        userName = username.text.toString(),
                        password = password.text.toString()
                    )
                )
            }
        }

        progressHUD = KProgressHUD.create(this@LoginActivity)
            .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
            .setLabel("Please wait")
//            .setDetailsLabel("Downloading data")
            .setCancellable(false)
            .setAnimationSpeed(2)
            .setDimAmount(0.5f)
//            .show()

        loginViewModel.isLoading.observe(this@LoginActivity, Observer {
            if (it) {
                progressHUD.show()
            } else {
                progressHUD.dismiss()
            }
        })
    }

    /**
     * Create API call for get doctor profile.
     */
    private fun userLogin(userName: User) {
        loginViewModel.isLoadingDisplay(true)
        loginViewModel.userLogin(userName).observe(this@LoginActivity, Observer { it ->
            loginViewModel.isLoadingDisplay(false)

            when (it) {
                is ResponseManager.Success -> {
                    if (it.data.token != null) {

                        LibFile.getInstance(this@LoginActivity)
                            .setString(LibFile.KEY_TOKEN, it.data.token)

                        LibFile.getInstance(this@LoginActivity)
                            .setString(LibFile.KEY_LOGIN_USER, Gson().toJson(it.data.user))

                        //Goto to main Activity
                        startActivity(
                            Intent(this@LoginActivity, MainActivity::class.java).apply {
                                flags =
                                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            })
                    } else {
                        AppUtil.displayInfoDialog(
                            this@LoginActivity,
                            BuildConfig.API_PARSE_ERROR_MSG
                        )
                    }
                }
                is ResponseManager.Unauthenticated -> {
                    if (it.message.isNotEmpty()) {
                        AppUtil.displayInfoDialog(
                            this@LoginActivity,
                            it.message
                        )
                    }
                }
                is ResponseManager.Error -> {
                    AppUtil.displayInfoDialog(this@LoginActivity, it.message)
                }
            }
        })
    }
}

/**
 * Extension function to simplify setting an afterTextChanged action to EditText components.
 */
fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}