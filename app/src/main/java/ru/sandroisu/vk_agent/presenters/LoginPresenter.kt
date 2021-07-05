package ru.sandroisu.vk_agent.presenters

import android.os.Handler
import android.os.Looper
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.sandroisu.vk_agent.views.LoginView

@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>(){
    fun login(isSuccess:Boolean) {
        viewState.startLoading()
        Handler(Looper.getMainLooper()).postDelayed({
            viewState.endLoading()
            if (isSuccess){
                viewState.openFriends()
            }else{
                viewState.showError("Incorrect")
            }
        }, 2000)
    }
}