package ivan.diaz.dominguez.castingapp.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.actor_list_item.view.*
import ivan.diaz.dominguez.castingapp.R

class ActorsAdapter : RecyclerView.Adapter<ActorsAdapter.ActorViewHolder>() {
    private var actors: List<Actor> = emptyList()

    fun setNamesList(actors: List<Actor>){
        this.actors = actors
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        return ActorViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.actor_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return actors.size
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        val actor = actors[position]
        holder.itemView.idTextView.text = actor.id.toString()
        holder.itemView.nameTextView.text = actor.name
    }

    class ActorViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}