package ru.sandroisu.vk_agent.adapters

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import ru.sandroisu.vk_agent.R
import ru.sandroisu.vk_agent.models.FriendModel

class FriendsAdapter : RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder>() {
    private var mSourceList: ArrayList<FriendModel> = ArrayList()
    private var friendsList: ArrayList<FriendModel> = ArrayList()

    fun setFriendList(friendsList: ArrayList<FriendModel>){
        mSourceList.clear()
        mSourceList.addAll(friendsList)
        filter("")

    }

    fun filter(query: String) {
        friendsList.clear()
        mSourceList.forEach {
            if (it.name.contains(query) || it.surname.contains(query)) {
                friendsList.add(it)
            }
        }
        notifyDataSetChanged()
    }

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

    class FriendsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var image: CircleImageView
        private lateinit var name: TextView


        fun bind(model: FriendModel) {
            if (model.avatar is Int) {
                itemView.findViewById<CircleImageView>(R.id.friend_image)
                    .setImageResource(model.avatar as Int)
            }
            if (model.avatar is String) {
                Picasso.get().load(model.avatar as String)
                    .resize(getDp(itemView.context, 100f), getDp(itemView.context, 100f))
                    .centerCrop()
                    .into(itemView.findViewById<CircleImageView>(R.id.friend_image))
            }
            val name = "${model.name} wow ${model.surname}"
            itemView.findViewById<TextView>(R.id.friend_name).text = name

        }


        private fun getDp(context: Context, requiredDip: Float): Int {
            val r: Resources = context.resources
            return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                requiredDip,
                r.displayMetrics
            ).toInt()
        }
    }

}