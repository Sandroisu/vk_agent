package ru.sandroisu.vk_agent.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView
import ru.sandroisu.vk_agent.R
import ru.sandroisu.vk_agent.models.FriendModel

class FriendsAdapter(private var friendsList: ArrayList<FriendModel>) : RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.cell_friend, parent, false)
        return FriendsViewHolder(itemView = itemView);
    }

    override fun onBindViewHolder(holder: FriendsViewHolder, position: Int) {
        holder.bind(friendsList[position])
    }

    override fun getItemCount(): Int {
        return friendsList.count()
    }

    class FriendsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        private lateinit var image: CircleImageView
        private lateinit var name: TextView


        fun bind(model:FriendModel){
            itemView.findViewById<CircleImageView>(R.id.friend_image).setImageResource(model.avatar!!)
            itemView.findViewById<TextView>(R.id.friend_name).text = model.name + " " + model.surname
        }
    }

}