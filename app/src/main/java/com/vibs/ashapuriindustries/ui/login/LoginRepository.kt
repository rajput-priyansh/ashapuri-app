package com.vibs.ashapuriindustries.ui.login

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vibs.ashapuriindustries.API_ERROR_MSG
import com.vibs.ashapuriindustries.api.APIClient
import com.vibs.ashapuriindustries.api.APIInterface
import com.vibs.ashapuriindustries.data.ResponseManager
import com.vibs.ashapuriindustries.data.model.ResponseLogin
import com.vibs.ashapuriindustries.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginRepository(application: Application) {

    private val apiClient: APIInterface = APIClient.getClientWithoutToken(application)

    suspend fun userLogin(userName: User): LiveData<ResponseManager<ResponseLogin>> {

        val liveData = MutableLiveData<ResponseManager<ResponseLogin>>()

        try {
            val response =
                withContext(Dispatchers.IO) { apiClient.userLogin(userName) }

            withContext(Dispatchers.Main) {
                if (response.password.isNullOrEmpty() && response.username.isNullOrEmpty()) {
                    liveData.value =
                        ResponseManager.Success(
                            response
                        )
                } else {
                    liveData.value =
                        ResponseManager.Error(
                            if (!response.password.isNullOrEmpty()) response.password[0] else if (!response.username.isNullOrEmpty()) response.username[0] else API_ERROR_MSG
                        )
                }
            }

        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                ResponseManager.manageException(
                    liveData,
                    e
                )
            }
        }

        return liveData
    }

}