package ru.sandroisu.vk_agent.views

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface LoginView:MvpView {

    fun startLoading()
    fun openFriends()
    fun endLoading()
    fun showError(text:String)
}