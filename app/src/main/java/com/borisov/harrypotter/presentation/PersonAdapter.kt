package com.borisov.harrypotter.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.borisov.harrypotter.R

/**
 * @author Borisov Andrey on 04.04.2022
 **/
class PersonAdapter(private val retry: Retry) :
    RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    private val persons = ArrayList<PersonUi>()

    fun update(new: List<PersonUi>) {
        persons.clear()
        persons.addAll(new)
        notifyDataSetChanged()
    }

    abstract class PersonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        open fun bind(person: PersonUi) {
        }

        class FullScreenProgress(view: View) : PersonViewHolder(view)

        class Base(view: View) : PersonViewHolder(view) {
            private val name = itemView.findViewById<TextView>(R.id.namePerson)
            override fun bind(person: PersonUi) {
                person.map(object : PersonUi.StringMapper {
                    override fun map(text: String) {
                        name.text = text
                    }
                })
            }
        }

        class Fail(view: View, private val retry: Retry) : PersonViewHolder(view) {
            private val message = itemView.findViewById<TextView>(R.id.messageTextView)
            private val button = itemView.findViewById<Button>(R.id.tryAgainButton)
            override fun bind(person: PersonUi) {
                person.map(object : PersonUi.StringMapper {
                    override fun map(text: String) {
                        message.text = text
                    }
                })
            }
        }
    }

    override fun getItemViewType(position: Int) = when (persons[position]) {
        is PersonUi.Base -> 0
        is PersonUi.Fail -> 1
        is PersonUi.Progress -> 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder =
        when (viewType) {
            0 -> PersonViewHolder.Base(R.layout.person_layout.makeView(parent))
            1 -> PersonViewHolder.Fail(R.layout.fail_fullscreen.makeView(parent), retry)
            else -> PersonViewHolder.FullScreenProgress(R.layout.progress_fullscreen.makeView(parent))
        }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) =
        holder.bind(persons[position])

    override fun getItemCount() = persons.size

    interface Retry {
        fun tryAgain()
    }

}

private fun Int.makeView(parent: ViewGroup) =
    LayoutInflater.from(parent.context).inflate(this, parent, false)