package ru.sandroisu.vk_agent.views

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.sandroisu.vk_agent.models.FriendModel

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface FriendsView :MvpView{

    fun showError(text:String)
    fun setupEmptyList()
    fun startLoading()
    fun stopLoading()
    fun setupFriendsList(friendsList:ArrayList<FriendModel>)
}