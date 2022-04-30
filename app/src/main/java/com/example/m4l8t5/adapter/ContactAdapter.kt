package com.example.m4l8t5.adapter



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.m4l8t5.R
import com.example.m4l8t5.activity.MainActivity
import com.example.m4l8t5.model.Contact


class ContactAdapter(private val contactList: List<Contact>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mainActivity = MainActivity()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ContactViewHolder(view)
    }

    class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val photo: ImageView = view.findViewById(R.id.iv_contact)
        val name: TextView = view.findViewById(R.id.tv_contact_name)
        val number: TextView = view.findViewById(R.id.tv_contact_number)
        val call: ImageView = view.findViewById(R.id.iv_call_cantact)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val contact = contactList[position]

        if (holder is ContactViewHolder) {
            holder.apply {
                photo.setImageResource(contact.photo)
                name.text = contact.name
                number.text = contact.number

                call.setOnClickListener {
                    mainActivity.call(number.text.toString())
                }
            }
        }
    }

    override fun getItemCount() = contactList.size
}